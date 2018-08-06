##synchronized关键字
   * synchronized原理
       1. 每个对象有且仅有一个对象锁，同步锁依赖于对象存在,当调用对象的synchronized方法时，就获取了该对象的同步锁
       2. 不通线程的同步锁是互斥的。
   * synchronized基本原则
        1. 当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，
            其他线程对“该对象”的该“synchronized方法”或者“synchronized代码块”的访问将被阻塞
            > excemple:Demo1_1.java
        2. 当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，其他线程仍然可以访问“该对象”的非同步代码块
        3. 当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，其他线程对“该对象”的其他的“synchronized方法”或者“synchronized代码块”的访问将被阻塞
   * synchronized代码块和方法
   * synchronized实例锁和全局锁