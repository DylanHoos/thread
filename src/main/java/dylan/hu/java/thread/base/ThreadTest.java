package src.main.java.dylan.hu.java.thread.base;

/**
 * @program: thread
 * @ClassName: ThreadTest
 * @description: 继承Thread类实现run()方法实现多线程
 * @author: huxuef@zjhcsoft.com
 * @create: 2018/8/6 0006 下午 7:12
 */
public class ThreadTest {
    public static void main(String[] args) {
        // 启动3个线程t1,t2,t3；每个线程各消费10次！
        MyThread t1 = new MyThread("t1");
        MyThread t2 = new MyThread("t2");
        MyThread t3 = new MyThread("t3");
        t1.start();
        t2.start();
        t3.start();
    }
}

class MyThread extends Thread {
    
    private int consumer = 10;
    public MyThread(String name) {
        super(name);
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (this.consumer > 0) {
                System.out.println(Thread.currentThread().getName()+" consumer "+this.consumer--);
            }
        }
    }
}
