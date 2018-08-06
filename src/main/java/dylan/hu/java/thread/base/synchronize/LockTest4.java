package src.main.java.dylan.hu.java.thread.base.synchronize;

/**
 * @program: thread
 * @ClassName: LockTest4
 * @description: TODO
 * @author: huxuef@zjhcsoft.com
 * @create: 2018/8/6 0006 下午 9:05
 */
public class LockTest4 {
    Somthing x = new Somthing();
    
    public static void main(String[] args) {
        LockTest4 demo = new LockTest4();
        demo.test4();
        
    }
    
    private void test4() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                x.isSyncA();
            }
        },"t1");
        
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Somthing.cSyncA();
            }
        },"t2");
        
        t1.start();
        t2.start();
    }
}
