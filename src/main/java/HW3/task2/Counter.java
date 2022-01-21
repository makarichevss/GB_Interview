package HW3.task2;

import java.util.concurrent.locks.ReentrantLock;

class Counter implements Runnable {
    private ReentrantLock lock;
    private static int count = 0;

    public Counter(ReentrantLock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        while (count < 1000) {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getId() + " : " + count);
                count++;
            } finally {
                lock.unlock();
            }
        }
    }
}
