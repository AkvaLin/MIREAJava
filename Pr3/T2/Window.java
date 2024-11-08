package Pr3.T2;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Window {
    private final int category;
    private final Lock lock = new ReentrantLock();
    private boolean isBusy = false;

    public Window(int category) {
        this.category = category;
    }

    public boolean service(Person person) {
        lock.lock();
        try {
            if (isBusy || (category != 0 && person.getCategory() != category)) {
                return false;
            }
            isBusy = true;
            System.out.println("Person of category " + person.getCategory() + " is being served at window " + category);
            Thread.sleep(1000);
            isBusy = false;
            return true;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        } finally {
            lock.unlock();
        }
    }
}
