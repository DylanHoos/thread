package src.main.java.dylan.hu.java.thread.base;

import javax.swing.plaf.synth.SynthOptionPaneUI;

/**
 * @program: thread
 * @ClassName: Demo
 * @description: TODO
 * @author: huxuef@zjhcsoft.com
 * @create: 2018/8/6 0006 下午 7:31
 */
public class Demo {
    public static void main(String[] args) {
        Thread demoThread = new DemoThread("demoThread");
        System.out.println(Thread.currentThread().getName()+ " call demoThread.run()");
        demoThread.run();
    
        System.out.println(Thread.currentThread().getName() + "call demoThread.start()");
        demoThread.start();
    }
}

class DemoThread extends Thread {
    
    public DemoThread(String name) {
        super(name);
    }
    
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+ " is running......");
    }
}
