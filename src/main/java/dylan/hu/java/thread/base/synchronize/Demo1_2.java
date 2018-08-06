package src.main.java.dylan.hu.java.thread.base.synchronize;

/**
 * @program: thread
 * @ClassName: Demo1_2
 * @description: TODO
 * @author: huxuef@zjhcsoft.com
 * @create: 2018/8/6 0006 下午 8:10
 */
public class Demo1_2 {
    public static void main(String[] args) {
        MyThread t1 = new MyThread("t1");
        MyThread t2 = new MyThread("t2");
        t1.start();
        t2.start();
    }
}

class MyThread extends Thread {
    
    public MyThread(String name) {
        super(name);
    }
    
    @Override
    public void run() {
        synchronized (this) {
            try {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + " loop " + i);
                }
            } catch ( InterruptedException e ) {
                e.printStackTrace();
            }
        }
    }
}
