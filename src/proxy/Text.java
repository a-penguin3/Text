package proxy;

public class Text {

    public static void main(String[] args) {
        ProxyHandler proxyHandler = new ProxyHandler();
        IPrinter printer = (IPrinter) proxyHandler.newProxyInstance(new Printer());
        String content = "dddd";
        printer.print(content);
        printer.copy();
    }
}
