package string;

/**
 * 实际考察字符串的拆分、截取、添加、相等等问题。比较简单
 * 注意： contains是前面的包含后面的
 */


public class Demo824 {
    public static String toGoatLatin(String sentence) {
       String[] strArray = sentence.split(" ");
       StringBuilder sb = new StringBuilder();
       for (int i = 0; i < strArray.length; i++){
           String begin = strArray[i].substring(0,1);
           if ("aeiouAEIOU".contains(begin)){
               sb.append(strArray[i]);
           }else{
               sb.append(strArray[i].substring(1) + begin);
           }
           sb.append("ma");
           int j = i + 1;
           while(j > 0){
               sb.append("a");
               j--;
           }
           sb.append(" ");
       }
       return sb.substring(0,sb.length()-1);
    }

    public static void main(String[] args) {
        String sentence = "I speak Goat Latin";
        String goatSentence = toGoatLatin(sentence);
        System.out.println(goatSentence);
    }
}
