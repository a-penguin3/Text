package proxy;

/**
 * 静态代理
 * 实现接口 IPrinter
 */
public class PrinterProxy implements IPrinter{
    private IPrinter printer;
    public PrinterProxy(){
        this.printer = new Printer();
    }
    @Override
    public void print(String content){
        System.out.println("记录日志");
        printer.print(content);
    }
    @Override
    public void copy(){

    }
}
