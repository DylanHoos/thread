package src.main.java.dylan.hu.java.thread.base.synchronize;

/**
 * @program: thread
 * @ClassName: Demo1_1
 * @description: TODO
 * @author: huxuef@zjhcsoft.com
 * @create: 2018/8/6 0006 下午 7:49
 */
public class Demo1_1 {
    public static void main(String[] args) {
        Runnable demo = new MyRunnable();
    
        Thread t1 = new Thread(demo, "t1");
        Thread t2 = new Thread(demo, "t2");
        
        t1.start();
        t2.start();
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        synchronized (this) {
            try {
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + " loop " + i);
                }
            } catch ( InterruptedException e ) {
                e.printStackTrace();
            }
        }
    }
}
