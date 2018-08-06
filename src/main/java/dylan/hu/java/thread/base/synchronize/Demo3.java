package src.main.java.dylan.hu.java.thread.base.synchronize;

/**
 * @program: thread
 * @ClassName: Demo3
 * @description: TODO
 * @author: huxuef@zjhcsoft.com
 * @create: 2018/8/6 0006 下午 8:20
 */
public class Demo3 {
    public static void main(String[] args) {
        final Third third = new Third();
        
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                third.synMethodA();
            }
        },"t1");
    
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                third.synMethodB();
            }
        },"t2");
        
        t1.start();
        t2.start();
    }
}

class Third {
    
    public void synMethodA() {
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
    
    public void synMethodB() {
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
