package src.main.java.dylan.hu.java.thread.base.synchronize;

/**
 * @program: thread
 * @ClassName: Demo4
 * @description: TODO
 * @author: huxuef@zjhcsoft.com
 * @create: 2018/8/6 0006 下午 8:40
 */
public class Demo4 {
    
    
    
    public static void main(String[] args) {
        
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
