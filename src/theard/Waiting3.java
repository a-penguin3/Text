package theard;

public class Waiting3 {

    public static void delay(){
        double d = 0;
        for (int i = 1; i < 1000000; i++){
            d += (Math.PI + Math.E)/(double)i;
        }
    }

    static Thread t1 = null;
    static Thread t2 = null;
    public static void main(String[] args) {
        t1 = new Thread(() ->{
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + ", i = " + i);
                delay();
            }
            System.out.println("t2线程状态：" + t2.getState());
            System.out.println("t1结束运行...");
        });
        t2 = new Thread(()->{
            for (int j = 0; j < 10; j++){
                System.out.println(Thread.currentThread().getName() + ", j = " + j);
                delay();
                if (j == 3){
                    try {
                        System.out.println("t1 加入 t2...");
                        //t1 加入 t2 线程
                        t1.join();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }
}
