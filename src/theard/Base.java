package theard;

public class Base {

    public static void main(String[] args) {
        RunnableTest rt = new RunnableTest();
        Thread th = new Thread(rt);
        th.start();
    }

    static class RunnableTest implements Runnable{

        @Override
        public void run() {
            System.out.println("");
        }
    }
}
