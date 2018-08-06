package src.main.java.dylan.hu.java.thread.base.synchronize;

/**
 * @program: thread
 * @ClassName: LockTest2
 * @description: TODO
 * @author: huxuef@zjhcsoft.com
 * @create: 2018/8/6 0006 下午 8:59
 */
public class LockTest2 {
    
    public static void main(String[] args) {
        LockTest2 demo = new LockTest2();
        demo.Test2();
    }
    Somthing x = new Somthing();
    Somthing y = new Somthing();
    
    /**比较(02) x.isSyncA()与y.isSyncA()*/
    private void Test2() {
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
}
