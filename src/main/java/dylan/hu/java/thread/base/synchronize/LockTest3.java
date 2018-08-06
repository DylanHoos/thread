package src.main.java.dylan.hu.java.thread.base.synchronize;

import sun.rmi.runtime.Log;

/**
 * @program: thread
 * @ClassName: LockTest3
 * @description: TODO
 * @author: huxuef@zjhcsoft.com
 * @create: 2018/8/6 0006 下午 9:02
 */
public class LockTest3 {
    
    Somthing x = new Somthing();
    Somthing y = new Somthing();
    
    public static void main(String[] args) {
        LockTest3 demo = new LockTest3();
        demo.test3();
        
    }
    
    private void test3() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                x.cSyncA();
            }
        },"t1");
    
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                y.cSyncA();
            }
        },"t2");
        
        t1.start();
        t2.start();
    }
}
