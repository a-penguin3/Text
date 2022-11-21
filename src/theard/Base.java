package theard;

public class Base {

    public static void main(String[] args) {
        Thread th = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ":状态：" + Thread.currentThread().getState());
            System.out.println(Thread.currentThread().getName() + "-我的任务开始执行");
            System.out.println(Thread.currentThread().getName() + ":状态：" + Thread.currentThread().getState());
        });
        System.out.println(th.getName() + ":状态：" + th.getState());
        th.start();
        System.out.println("主线程：" + Thread.currentThread().getId() + th.getName() + ":状态：" + th.getState());
    }
}
