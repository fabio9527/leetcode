package cfx20190717;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Foo {

    volatile int count=0;
    Lock lock=new ReentrantLock();
    Condition condition1=lock.newCondition();
    Condition condition2=lock.newCondition();
    Condition condition3=lock.newCondition();

    public void first(Runnable printFirst) throws InterruptedException {
        try{
            lock.lock();
            printFirst.run();
            count++;
            condition2.signal();
        }finally {
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        try{
            lock.lock();
            if(count==0)
                condition2.await();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            count++;
            condition3.signal();
        }finally {
            lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        try {
            lock.lock();
            if(count<=1)
                condition3.await();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            count++;
        }finally {
            lock.unlock();
        }
    }

}
