package JavaConcurrenct;

import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Thread.sleep;

class Student {
    volatile int num = 0;

    public void getNum() {
        this.num = 60;
    }

    public void addPlusPlus() {
        num++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();

    public void addAtomicPlusPlus() {


        atomicInteger.getAndIncrement();//加1
    }

}

class Phone {

    public  void sendMgs() {
        System.out.println(Thread.currentThread().getName() + "发送信息");
        sendEmail();
    }

    public void sendEmail() {
        System.out.println(Thread.currentThread().getName() + "发送邮件");
    }

}


public class volatileTest {
    public static void main(String[] args) {

        Phone phone = new Phone();
        new Thread(() -> {
            phone.sendMgs();
        }, "t1").start();
        new Thread(() -> {
            phone.sendMgs();
        }, "t2").start();

//        Student student = new Student();
//        for (int i = 1; i <= 20; i++) {
//            new Thread(() -> {
//                for (int j = 1; j <= 1000; j++) {
//                    student.addPlusPlus();
//                    student.addAtomicPlusPlus();
//                }
//            }, String.valueOf(i)).start();
//        }
//
//        //需要等待上面的线程执行完毕
//        while (Thread.activeCount() > 2) {
//            Thread.yield();
//        }
//        System.out.println(Thread.currentThread().getName() + "非原子结果为：" + student.num);//Thread.currentThread().getName()是main线程
//        System.out.println(Thread.currentThread().getName() + "原子结果为：" + student.atomicInteger);

        //seeOkByVolatile();
    }


    //验证volatile的可见性
    private static void seeOkByVolatile() {
        Student student = new Student();
        new Thread(() -> {
            System.out.println("进入线程1");
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            student.getNum();

        }, "线程1").start();

        while (student.num == 0) {
        }

        System.out.println("测试完成" + student.num);
    }
}

class Singletion {


    private Singletion() {

    }

    private static class SingletionInstance {
        private static final Singletion sin = new Singletion();
    }

    public static Singletion getInstance() {
        return SingletionInstance.sin;
    }

}