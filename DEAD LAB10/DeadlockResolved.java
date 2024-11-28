import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class SafeResource1 {
    private final Lock lock = new ReentrantLock();

    public boolean tryLockBoth(SafeResource1 otherResource) {
        while (true) {
            boolean gotFirstLock = lock.tryLock();
            boolean gotSecondLock = otherResource.tryLock();
            if (gotFirstLock && gotSecondLock) {
                System.out.println(Thread.currentThread().getName() + " acquired both locks");
                return true;
            }
            
            if (gotFirstLock) lock.unlock(); 
            if (gotSecondLock) otherResource.unlock();
        }
    }

    public boolean tryLock() {
        return lock.tryLock();
    }

    public void unlock() {
        lock.unlock();
    }
}

public class DeadlockResolved {
    public static void main(String[] args) {
        SafeResource1 res1 = new SafeResource1();
        SafeResource1 res2 = new SafeResource1();

        Thread t1 = new Thread(() -> {
            if (res1.tryLockBoth(res2)) {
                System.out.println("Thread-1 completed safely");
                res1.unlock();
                res2.unlock();
            }
        }, "Thread-1");

        Thread t2 = new Thread(() -> {
            if (res2.tryLockBoth(res1)) {
                System.out.println("Thread-2 completed safely");
                res2.unlock();
                res1.unlock();
            }
        }, "Thread-2");

        t1.start();
        t2.start();
    }
}