package src.main.java.dylan.hu.java.thread.base.synchronize;

/**
 * @program: thread
 * @ClassName: Demo2
 * @description: TODO
 * @author: huxuef@zjhcsoft.com
 * @create: 2018/8/6 0006 下午 8:14
 */
public class Demo2 {
    public static void main(String[] args) {
        final Seconde seconde = new Seconde();
        
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                seconde.synMethod();
            }
        },"t1");
        
        
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                seconde.unSynMethod();
            }
        },"t2");
    
        t1.start();
        t2.start();
    }
}

class Seconde {
    public void synMethod() {
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
    
    public void unSynMethod() {
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
