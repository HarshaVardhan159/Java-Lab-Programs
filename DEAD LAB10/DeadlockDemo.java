class Resource1 {
    synchronized void lock(Resource2 res2) {
        System.out.println(Thread.currentThread().getName() + " locked Resource1");

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println(Thread.currentThread().getName() + " trying to lock Resource2...");
        res2.method2();
    }

    synchronized void method1() {
        System.out.println(Thread.currentThread().getName() + " is working with Resource1");
    }
}

class Resource2 {
    synchronized void lock(Resource1 res1) {
        System.out.println(Thread.currentThread().getName() + " locked Resource2");

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println(Thread.currentThread().getName() + " trying to lock Resource1...");
        res1.method1();
    }

    synchronized void method2() {
        System.out.println(Thread.currentThread().getName() + " is working with Resource2");
    }
}

public class DeadlockDemo {
    public static void main(String[] args) {
        Resource1 res1 = new Resource1();
        Resource2 res2 = new Resource2();

        Thread t1 = new Thread(() -> res1.lock(res2), "Thread-1");

        
        Thread t2 = new Thread(() -> res2.lock(res1), "Thread-2");

        t1.start();
        t2.start();
    }
}