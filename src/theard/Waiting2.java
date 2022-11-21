package theard;

import java.util.concurrent.locks.LockSupport;

public class Waiting2 {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + ", i = " + i);
                if (i == 5) {
                    System.out.println(Thread.currentThread().getName() + "开始等待...");
                    //开始等待
                    LockSupport.park();
                }
            }
        });
        Thread t2 = new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "运行中...");
            System.out.println(Thread.currentThread().getName()+ ",发送解锁通知...");
            LockSupport.unpark(t1);
        });

        t1.start();
        double d = 0;
        for (int i = 1; i < 1000000; i++){
            d += (Math.PI + Math.E)/(double)i;
        }
        System.out.println(t1.getName() + "状态：" + t1.getState());
        t2.start();
    }
}
