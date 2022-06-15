package proxy;

public class Printer implements IPrinter {
    public void print(String content) {
        System.out.println("打印！" + content);
    }

    public void copy(){
        System.out.println("复印！");
    }
}
