package src.main.java.dylan.hu.java.thread.base;

/**
 * @program: thread
 * @ClassName: RunnableTest
 * @description: 实现Runnable接口,通过new Thread(new Runnable())
 * @author: huxuef@zjhcsoft.com
 * @create: 2018/8/6 0006 下午 7:17
 */
public class RunnableTest {
    public static void main(String[] args) {
        MyRunnable mr = new MyRunnable();
    
        // 启动3个线程t1,t2,t3(它们共用一个Runnable对象)， 这三个线程一共消费10次
        Thread t1 = new Thread(mr,"t1");
        Thread t2 = new Thread(mr,"t2");
        Thread t3 = new Thread(mr,"t3");
        t1.start();
        t2.start();
        t3.start();
    }
}

class MyRunnable implements Runnable {
    private int consumer = 10;
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (this.consumer > 0) {
                System.out.println(Thread.currentThread().getName()+" consumer " + this.consumer--);
            }
        }
    }
}
