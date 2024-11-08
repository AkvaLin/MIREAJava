package Pr3.T3;

public class ClinicApp {    
    public static void main(String[] args) throws InterruptedException {
        Clinic clinic = new Clinic();
        int totalPatients = 10;

        for (int i = 0; i < totalPatients; i++) {
            Patient patient = new Patient(clinic);
            patient.start();
            Thread.sleep(300);
        }

        Thread.sleep(10000);

        System.out.println("Maximum queue size was: " + clinic.getMaxQueueSize());
    }
}
