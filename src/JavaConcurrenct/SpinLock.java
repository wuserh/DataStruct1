package JavaConcurrenct;

import java.util.concurrent.atomic.AtomicReference;

import static java.lang.Thread.sleep;

public class SpinLock {

    AtomicReference<Thread> atomicReference = new AtomicReference<>();


    public void myLock() {
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "myLock");
        while (!atomicReference.compareAndSet(null, thread)) ;
        {
        }

    }

    public void myUnLock() {
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread, null);
        System.out.println(Thread.currentThread().getName() + "myUnLock");
    }

    public static void main(String[] args) {
        SpinLock spinLock = new SpinLock();
        new Thread(() -> {
            spinLock.myLock();
            try {
                sleep(50000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLock.myUnLock();
        }, "t1").start();

        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            spinLock.myLock();

            spinLock.myUnLock();
        }, "t2").start();

    }


}
