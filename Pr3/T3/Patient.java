package Pr3.T3;

public class Patient extends Thread {
    private static int idCounter = 1;
    private final long id;
    private final Clinic clinic;

    public Patient(Clinic clinic) {
        this.id = idCounter++;
        this.clinic = clinic;
    }

    @Override
    public void run() {
        try {
            clinic.enterQueue(this);
            clinic.servicePatient(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public long getId() {
        return id;
    }
}
