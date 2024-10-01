package main;
import java.util.Scanner;

public class AppointmentManagementSystem {

    static class Appointment {
        int no;
        String name;
        String doctor;
        String type;
        String date;
        String status;

        public Appointment(int no, String name, String doctor, String type, String date, String status) {
            this.no = no;
            this.name = name;
            this.doctor = doctor;
            this.type = type;
            this.date = date;
            this.status = status;
        }
    }

    public  void run() {
        final int MAX_APPOINTMENTS = 100;
        Appointment[] appointments = new Appointment[MAX_APPOINTMENTS];
        int numAppointments = 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Create appointment\n2. Update appointment\n3. Delete/Archive Appointment\n4. Retrieve patient records\n5. Exit\n");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    if (numAppointments >= MAX_APPOINTMENTS) {
                        System.out.println("Maximum number of appointments reached.\n");
                        break;
                    }

                    System.out.println("\nCreating a new appointment\n");

                    System.out.print("Enter appointment no: ");
                    int no = scanner.nextInt();
                    scanner.nextLine(); // Consume newline left-over

                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter doctor's name: ");
                    String doctor = scanner.nextLine();

                    System.out.print("Enter appointment type: ");
                    String type = scanner.nextLine();

                    System.out.print("Enter date: ");
                    String date = scanner.nextLine();

                    System.out.print("Enter patient status (cancelled or active): ");
                    String status = scanner.nextLine();

                    appointments[numAppointments] = new Appointment(no, name, doctor, type, date, status);
                    numAppointments++;

                    System.out.println("Appointment created successfully!\n");
                    break;
                case 2:
                    if (numAppointments == 0) {
                        System.out.println("No appointment records found.\n");
                        break;
                    }

                    System.out.println("\nUpdating a appointments\n");

                    System.out.print("Enter the no of the appointment to update: ");
                    int appointmentNoToUpdate = scanner.nextInt();
                    scanner.nextLine(); // Consume newline left-over

                    int appointmentIndexToUpdate = -1;
                    for (int i = 0; i < numAppointments; i++) {
                        if (appointments[i].no == appointmentNoToUpdate) {
                            appointmentIndexToUpdate = i;
                            break;
                        }
                    }

                    if (appointmentIndexToUpdate == -1) {
                        System.out.println("Appointment not found.\n");
                        break;
                    }

                    System.out.print("Enter updated name: ");
                    appointments[appointmentIndexToUpdate].name = scanner.nextLine();

                    System.out.print("Enter updated doctor's name: ");
                    appointments[appointmentIndexToUpdate].doctor = scanner.nextLine();

                    System.out.print("Enter updated appointment type: ");
                    appointments[appointmentIndexToUpdate].type = scanner.nextLine();

                    System.out.print("Enter updated date: ");
                    appointments[appointmentIndexToUpdate].date = scanner.nextLine();

                    System.out.print("Enter updated appointment status (cancelled or not): ");
                    appointments[appointmentIndexToUpdate].status = scanner.nextLine();

                    System.out.println("Appointment updated successfully!\n");
                    break;
                case 3:
                    if (numAppointments == 0) {
                        System.out.println("No appointment records found.\n");
                        break;
                    }

                    System.out.println("\nDeleting/Archiving a appointment\n");

                    System.out.print("Enter the no of the appointment to delete/archive: ");
                    int appointmentNoToDelete = scanner.nextInt();
                    scanner.nextLine(); // Consume newline left-over

                    int appointmentIndexToDelete = -1;
                    for (int i = 0; i < numAppointments; i++) {
                        if (appointments[i].no == appointmentNoToDelete) {
                            appointmentIndexToDelete = i;
                            break;
                        }
                    }

                    if (appointmentIndexToDelete == -1) {
                        System.out.println("Appointment not found.\n");
                        break;
                    }

                    for (int i = appointmentIndexToDelete; i < numAppointments - 1; i++) {
                        appointments[i] = appointments[i + 1];
                    }

                    numAppointments--;

                    System.out.println("Appointment deleted/archived successfully!\n");
                    break;
                case 4:
                    if (numAppointments == 0) {
                        System.out.println("No appointment records found.\n");
                        break;
                    }

                    System.out.println("\nAppointment Records\n");
                    System.out.println("-----------------------------------------------------------\n");
                    System.out.println("no\tName\t\tDoctor\t);");
                    System.out.println("type\tDate\t\tStatus\n");
                    System.out.println("-----------------------------------------------------------\n");
                    for (int i = 0; i < numAppointments; i++) {
                        System.out.println(appointments[i].no + "\t" + appointments[i].name + "\t\t" + appointments[i].doctor + "\t\t" + appointments[i].type + "\t\t" + appointments[i].date + "\t\t" + appointments[i].status);
                    }
                    System.out.println("-----------------------------------------------------------\n");
                    System.out.println("Total Appointments Count: " + numAppointments);
                    System.out.println("-----------------------------------------------------------\n");
                    break;
                case 5:
                    System.out.println("Exiting...\n");
                    return;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.\n");
            }
        }
    }
}
 
    

            
        
