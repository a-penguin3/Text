package theard;

public class Waiting {
    public static void main(String[] args) {
        Object obj = new Object();
        //线程1 主要负责运行
        Thread t1 = new Thread(() ->{
            for (int i = 0; i < 10; i++){
                System.out.println(Thread.currentThread().getName() + ", i = " + i);
                if (i == 5){
                    synchronized (obj){
                        try{
                            System.out.println(Thread.currentThread().getName() + "开始等待...");
                            //开始等待
                            obj.wait();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        Thread t2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "运行中...");
            synchronized (obj){
                try {
                    System.out.println(Thread.currentThread().getName()+ ",发送notify通知...");
                    //重获资源
                    obj.notify();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
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
