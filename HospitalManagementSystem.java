import java.util.*;

class Patient {
    String id, name, contact, ailment, medicalHistory;
    
    Patient(String id, String name, String contact, String ailment, String medicalHistory) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.ailment = ailment;
        this.medicalHistory = medicalHistory;
    }
}

class Doctor {
    String id, name, specialization;
    
    Doctor(String id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }
}

class Appointment {
    String patientId, doctorId, date;
    
    Appointment(String patientId, String doctorId, String date) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
    }
}

class Billing {
    String patientId;
    double amount;
    
    Billing(String patientId, double amount) {
        this.patientId = patientId;
        this.amount = amount;
    }
}

class Inventory {
    String itemName;
    int quantity;
    
    Inventory(String itemName, int quantity) {
        this.itemName = itemName;
        this.quantity = quantity;
    }
}

class Staff {
    String id, name, role;
    
    Staff(String id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }
}

public class HospitalManagementSystem {
    static List<Patient> patients = new ArrayList<>();
    static List<Doctor> doctors = new ArrayList<>();
    static List<Appointment> appointments = new ArrayList<>();
    static List<Billing> bills = new ArrayList<>();
    static List<Inventory> inventory = new ArrayList<>();
    static List<Staff> staffList = new ArrayList<>();

    static void registerPatient() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Patient ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Contact: ");
        String contact = scanner.nextLine();
        System.out.print("Enter Ailment: ");
        String ailment = scanner.nextLine();
        System.out.print("Enter Medical History: ");
        String medicalHistory = scanner.nextLine();
        patients.add(new Patient(id, name, contact, ailment, medicalHistory));
        System.out.println("Patient Registered Successfully!");
    }
    
    static void scheduleAppointment() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Patient ID: ");
        String patientId = scanner.nextLine();
        System.out.print("Enter Doctor ID: ");
        String doctorId = scanner.nextLine();
        System.out.print("Enter Date (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        appointments.add(new Appointment(patientId, doctorId, date));
        System.out.println("Appointment Scheduled Successfully!");
    }
    
    static void generateBill() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Patient ID: ");
        String patientId = scanner.nextLine();
        System.out.print("Enter Bill Amount: ");
        double amount = scanner.nextDouble();
        bills.add(new Billing(patientId, amount));
        System.out.println("Bill Generated Successfully!");
    }
    
    static void manageInventory() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Item Name: ");
        String itemName = scanner.nextLine();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        inventory.add(new Inventory(itemName, quantity));
        System.out.println("Inventory Updated Successfully!");
    }
    
    static void addStaff() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Staff ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Role: ");
        String role = scanner.nextLine();
        staffList.add(new Staff(id, name, role));
        System.out.println("Staff Added Successfully!");
    }
    
    static void displayPatients() {
        for (Patient p : patients) {
            System.out.println("ID: " + p.id + ", Name: " + p.name + ", Contact: " + p.contact + ", Ailment: " + p.ailment + ", Medical History: " + p.medicalHistory);
        }
    }
    
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nHospital Management System");
            System.out.println("1. Register Patient");
            System.out.println("2. Schedule Appointment");
            System.out.println("3. Generate Bill");
            System.out.println("4. Manage Inventory");
            System.out.println("5. Add Staff");
            System.out.println("6. Display Patients");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (choice) {
                case 1: registerPatient(); break;
                case 2: scheduleAppointment(); break;
                case 3: generateBill(); break;
                case 4: manageInventory(); break;
                case 5: addStaff(); break;
                case 6: displayPatients(); break;
                case 7: System.exit(0);
                default: System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
