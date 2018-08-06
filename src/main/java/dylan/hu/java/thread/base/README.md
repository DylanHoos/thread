#线程状态图
-
![Image text](/E:/ideaspace/thread/src/main/resources/image/thread_status.png)

####说明
   ######线程共包括以下5种状态
    1. 新建状态(New): 线程对象被创建后，就进入了新建状态。例如，Thread thread = new Thread()。
    2. 就绪状态(Runnable): 也被称为“可执行状态”。线程对象被创建后，其它线程调用了该对象的start()方法，从而来启动该线程。例如，thread.start()。处于就绪状态的线程，随时可能被CPU调度执行。
    3. 运行状态(Running): 线程获取CPU使用权进行执行。需要注意的是，线程只能从就绪状态进入到运行状态。
    4. 阻塞状态(Blocked): 阻塞状态是线程因为某种原因放弃CPU使用权，暂时停止运行。直到线程进入就绪状态，才有机会转到运行状态。阻塞的情况分三种：
        (01). 等待阻塞 -- 通过调用线程的wait()方法，让线程等待某工作的完成。
        (02). 同步阻塞 -- 线程在获取synchronized同步锁失败(因为锁被其它线程所占用)，它会进入同步阻塞状态。
        (03). 其他阻塞 -- 通过调用线程的sleep()或join()或发出了I/O请求时，线程会进入到阻塞状态。当sleep()状态超时、join()等待线程终止或者超时、或者I/O处理完毕时，线程重新转入就绪状态。
    5. 死亡状态(Dead)    : 线程执行完了或者因异常退出了run()方法，该线程结束生命周期。
####实现多线程的两种方式
   * Runnable:定一个一个类MyRunnable实现Runnable接口,通过new Thread(new Runnable())等方式新建线程。
   * Thread:定义一个类MyThread继承Thread类,通过new MyThread()等方式新建线程
   * Runnable和Thread的差异
        1. Thread 和 Runnable 的相同点：都是“多线程的实现方式”
        2. Thread 和 Runnable 的不同点：
            Thread是类,Runnable是接口;Thread类实现了Runnable接口,Runnable扩展性优于Thread,
            Runnable还有可以用于“资源的共享”,即，多个线程都是基于一个Runnable对象建立的，共享Runnable对象上的资源
   * Thread和Runnable多线程示例：
        - example: dylan.hu.java.thread.base.ThreadTest
        - example: dylan.hu.java.thread.base.RunnableTest
#####start()和run()区别
        1. start()它的作用是启动一个新线程，新线程会执行相应的run()方法。start()不能被重复调用。
        2. run()就和普通的成员方法一样，可以被重复调用。单独调用run()的话，会在当前线程中执行run()，而并不会启动新线程！
        3. example:
            - dylan.hu.java.thread.base.Demo
        4.源码
        > public synchronized void start() {
                  /**
                   * This method is not invoked for the main method thread or "system"
                   * group threads created/set up by the VM. Any new functionality added
                   * to this method in the future may have to also be added to the VM.
                   *
                   * A zero status value corresponds to state "NEW".
                   */
                  if (threadStatus != 0)
                      throw new IllegalThreadStateException();
          
                  /* Notify the group that this thread is about to be started
                   * so that it can be added to the group's list of threads
                   * and the group's unstarted count can be decremented. */
                  group.add(this);
          
                  boolean started = false;
                  try {
                      start0();
                      started = true;
                  } finally {
                      try {
                          if (!started) {
                              group.threadStartFailed(this);
                          }
                      } catch (Throwable ignore) {
                          /* do nothing. If start0 threw a Throwable then
                            it will be passed up the call stack */
                      }
                  }
              }
        
     