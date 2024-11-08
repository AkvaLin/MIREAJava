package Pr3.T3;
import java.util.LinkedList;
import java.util.Queue;

public class Clinic {
    private final Queue<Patient> queue = new LinkedList<>();
    private final Object therapistLock = new Object();
    private final Object mriLock = new Object();
    private int maxQueueSize = 0;

    public void enterQueue(Patient patient) {
        queue.add(patient);
        maxQueueSize = Math.max(maxQueueSize, queue.size());
        System.out.println("Patient " + patient.getId() + " entered the queue. Queue size: " + queue.size());
    }

    public void servicePatient(Patient patient) throws InterruptedException {
        synchronized (queue) {
            synchronized (therapistLock) {
                queue.remove();
                System.out.println("Patient " + patient.getId() + " left the queue and is being serviced by therapist.");
                Thread.sleep(1000);
                queue.notifyAll();
            }
        }

        synchronized (mriLock) {
            System.out.println("Patient " + patient.getId() + " is being serviced by MRI.");
            Thread.sleep(1000);
        }
    }

    public int getMaxQueueSize() {
        return maxQueueSize;
    }
}
