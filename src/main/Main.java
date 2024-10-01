
package main;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
             final int MAX_APPOINTMENTS = 100;
        Appointment[] appointments = new Appointment[MAX_APPOINTMENTS];
        int numAppointments = 0;

        Scanner scanner = new Scanner(System.in);
        
        AppointmentManagementSystem app = new AppointmentManagementSystem();
        app.run();
    }
    
}
