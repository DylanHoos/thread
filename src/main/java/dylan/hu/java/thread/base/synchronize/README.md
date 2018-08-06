##synchronized关键字
   * synchronized原理
       1. 每个对象有且仅有一个对象锁，同步锁依赖于对象存在,当调用对象的synchronized方法时，就获取了该对象的同步锁
       2. 不通线程的同步锁是互斥的。
   * synchronized基本原则
        1. 当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，
            其他线程对“该对象”的该“synchronized方法”或者“synchronized代码块”的访问将被阻塞
            > excemple:Demo1_1.java
        2. 当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，
            其他线程仍然可以访问“该对象”的非同步代码块
            > excemple:Demo2.java
        3. 当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，
            其他线程对“该对象”的其他的“synchronized方法”或者“synchronized代码块”的访问将被阻塞
            > excemple:Demo3.java
   * synchronized代码块和方法
        1. “synchronized方法”是用synchronized修饰方法，“synchronized代码块”则是用synchronized修饰代码块,
            synchronized代码块中的this是指当前对象。也可以将this替换成其他对象，例如将this替换成obj
        2. synchronized代码块可以更精确的控制冲突限制访问区域，有时候表现更高效率
   * synchronized实例锁和全局锁
        1. 实例锁 -- 锁在某一个实例对象上。如果该类是单例，那么该锁也具有全局锁的概念。
                          实例锁对应的就是synchronized关键字。
        2.  全局锁 -- 该锁针对的是类，无论实例多少个对象，那么线程都共享该锁。
                          全局锁对应的就是static synchronized（或者是锁在该类的class或者classloader对象上）。
   * 关于“实例锁”和“全局锁”有一个很形象的例子
        - public synchronized void isSyncA(){}
        - public synchronized void isSyncB(){}
        - public static synchronized void cSyncA(){}
        - public static synchronized void cSyncB(){}
   * 假设，Something有两个实例x和y。分析下面4组表达式获取的锁的情况
        - (01) x.isSyncA()与x.isSyncB()
           > 不能被同时访问。因为isSyncA()和isSyncB()都是访问同一个对象(对象x)的同步锁！
        - (02) x.isSyncA()与y.isSyncA()
            > 可以同时被访问。因为访问的不是同一个对象的同步锁，x.isSyncA()访问的是x的同步锁，而y.isSyncA()访问的是y的同步锁
        - (03) x.cSyncA()与y.cSyncB()
            > 不能被同时访问。因为cSyncA()和cSyncB()都是static类型，x.cSyncA()相当于Something.isSyncA()，y.cSyncB()相当于Something.isSyncB()，因此它们共用一个同步锁，不能被同时访问
        - (04) x.isSyncA()与Something.cSyncA()
            > 可以被同时访问。因为isSyncA()是实例方法，x.isSyncA()使用的是对象x的锁；而cSyncA()是静态方法，Something.cSyncA()可以理解对使用的是“类的锁”。因此，它们是可以被同时访问的11
   