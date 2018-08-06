package src.main.java.dylan.hu.java.thread.base.synchronize;

/**
 * @program: thread
 * @ClassName: LockTest1
 * @description: TODO
 * @author: huxuef@zjhcsoft.com
 * @create: 2018/8/6 0006 下午 8:50
 */
public class LockTest1 {
    Somthing x = new Somthing();
    Somthing y = new Somthing();
    
    private void test1() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                x.isSyncA();
            }
        },"t1");
        
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                y.isSyncA();
            }
        },"t2");
        
        t1.start();
        t2.start();
    }
    
    
    public static void main(String[] args) {
        LockTest1 demo = new LockTest1();
        demo.test1();
    }
}

class Somthing {
    public synchronized void isSyncA() {
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + " loop " + i);
            }
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }
    }
    
    public synchronized void isSyncB() {
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + " loop " + i);
            }
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }
    }
    
    public static synchronized void cSyncA() {
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + " loop " + i);
            }
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }
    }
    
    public static synchronized void cSyncB() {
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

