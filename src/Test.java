import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 功能：生成maven批量安装jar的语句
 * @author pactera
 *
 */
public class Test {

    //批量安装jar所在目录
    public static String filePath = "D:\\data\\maven\\repository";

    public static List<GroupInfo> jarList=new ArrayList<>();

    public static List<String> jarNameList = new ArrayList<>();

    public static void main(String[] args) {
        File f = new File(filePath);
        getJarList(f);
//        jarList.forEach(System.out::println);
        printFile();
        System.out.println(jarNameList);
    }

    /**
     *   <groupId>com.alibaba.cloud</groupId>
     *   <artifactId>spring-cloud-alibaba-dependencies</artifactId>
     * @param file
     */
    private static void getJarList(File file) {
        if(file.isDirectory()){
            for (File listFile : file.listFiles()) {
                jarNameList.add(listFile.getName());
                getJarList(listFile);
            }
        }else if(file.getName().endsWith(".jar")){
            GroupInfo groupInfo = new GroupInfo();
            groupInfo.version=file.getParentFile().getName();
            groupInfo.artifactId=file.getParentFile().getParentFile().getName();
            groupInfo.groupId=getGroupId(file);
            groupInfo.file=file;
            jarList.add(groupInfo);
        }else if(file.getName().endsWith(".pom")){
            if(ifPomDir(file.getParentFile())){
                GroupInfo groupInfo = new GroupInfo();
                groupInfo.version=file.getParentFile().getName();
                groupInfo.artifactId=file.getParentFile().getParentFile().getName();
                groupInfo.groupId=getGroupId(file);
                groupInfo.isPom=true;
                groupInfo.file=file;
                jarList.add(groupInfo);
            }
        }
    }

    private static boolean ifPomDir(File parentFile) {
        return !Arrays.stream(parentFile.listFiles()).anyMatch(f->f.getName().endsWith(".jar"));
    }

    private static String getGroupId(File file) {
        String replace = file.getAbsolutePath().replace(filePath, "");
        String artifactId = file.getParentFile().getParentFile().getName();
        if (replace.indexOf(artifactId) <= 1) return artifactId;
        try{
            String substring = replace.substring(1, replace.indexOf(artifactId) - 1);
            return substring.replaceAll("\\\\",".");
        }catch (StringIndexOutOfBoundsException e){
            System.out.println(replace.indexOf(artifactId) + "  " + artifactId);
            throw e;
        }
    }

    /**
     * 功能：批量安装maven的本地的jar
     */
    public static void printFile() {
        //D:\git\ips-fj\libs>mvn install:install-file -Dfile=ips-data-core-0.0.1-SNAPSHOT.jar -DgroupId=boco -DartifactId=ips-data-core  -Dversion=0.0.1-SNAPSHOT  -Dpackaging=pom
        //mvn install:install-file -DgroupId=com.xxx -DartifactId=xxx -Dversion=1.1.1 -Dpackaging=pom -Dfile=xxx-1.1.1.pom
        jarList.forEach(jar->{
            System.out.println("导入jar到本地仓库"+jar);
            String sb = "mvn install:install-file -Dfile="+jar.file.getAbsolutePath()
                    +" -DgroupId="+jar.groupId
                    +" -DartifactId="+jar.artifactId
                    +" -Dversion="+jar.version
                    +" -Dpackaging="+(jar.isPom?"pom":"jar");
            System.out.println(sb);
            execCommandAndGetOutput(sb);
        });
    }

//    public static void printFile() {
//        //D:\git\ips-fj\libs>mvn install:install-file -Dfile=ips-data-core-0.0.1-SNAPSHOT.jar -DgroupId=boco -DartifactId=ips-data-core  -Dversion=0.0.1-SNAPSHOT  -Dpackaging=pom
//        //mvn install:install-file -DgroupId=com.xxx -DartifactId=xxx -Dversion=1.1.1 -Dpackaging=pom -Dfile=xxx-1.1.1.pom
//        jarList.forEach(jar->{
//            System.out.println("导入jar到本地仓库"+jar);
//            String sb = "mvn deploy:deploy-file -Dfile="+jar.file.getAbsolutePath()
//                    +" -DgroupId="+jar.groupId
//                    +" -DartifactId="+jar.artifactId
//                    +" -Dversion="+jar.version
//                    +" -Dpackaging="+(jar.isPom?"pom":"jar");
//            System.out.println(sb);
//            execCommandAndGetOutput(sb);
//        });
//    }


    public static void execCommandAndGetOutput(String comond) {
        try {
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec("cmd.exe /c "+comond);
            // 输出结果，必须写在 waitFor 之前
            String outStr = getStreamStr(process.getInputStream());
            // 错误结果，必须写在 waitFor 之前
            String errStr = getStreamStr(process.getErrorStream());
            int exitValue = process.waitFor(); // 退出值 0 为正常，其他为异常
            System.out.println("exitValue: " + exitValue);
            System.out.println("outStr: " + outStr);
            System.out.println("errStr: " + errStr);
            process.destroy();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String getStreamStr(InputStream is) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is, "GBK"));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
            sb.append("\n");
        }
        br.close();
        return sb.toString();
    }

    static class GroupInfo{
        String artifactId;
        String version;
        String groupId;
        Boolean isPom=false;
        File file;

        @Override
        public String toString() {
            return "GroupInfo{" +
                    "artifactId='" + artifactId + '\'' +
                    ", version='" + version + '\'' +
                    ", groupId='" + groupId + '\'' +
                    ", filename='" + file.getName() + '\'' +
                    '}';
        }
    }
}