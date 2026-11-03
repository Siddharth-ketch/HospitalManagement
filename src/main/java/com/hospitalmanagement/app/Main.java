package com.hospitalmanagement.app;

import java.util.Scanner;

import com.hospitalmanagement.model.Patient;
import com.hospitalmanagement.model.Doctor;
import com.hospitalmanagement.model.Appointment;
import com.hospitalmanagement.model.Treatment;

import com.hospitalmanagement.service.PatientService;
import com.hospitalmanagement.service.DoctorService;
import com.hospitalmanagement.service.AppointmentService;
import com.hospitalmanagement.service.JsonFileService;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        PatientService patientService = new PatientService();
        DoctorService doctorService = new DoctorService();
        AppointmentService appointmentService = new AppointmentService();
        JsonFileService jsonService = new JsonFileService();

        int choice;

        do {

            System.out.println("\n======================================");
            System.out.println("   HOSPITAL MANAGEMENT SYSTEM");
            System.out.println("======================================");
            System.out.println("1. Add Patient");
            System.out.println("2. Display Patients");
            System.out.println("3. Search Patient");
            System.out.println("4. Add Doctor");
            System.out.println("5. Display Doctors");
            System.out.println("6. Add Appointment");
            System.out.println("7. Display Appointments");
            System.out.println("8. Add Treatment");
            System.out.println("9. Display Treatments");
            System.out.println("10. Save Patient Data");
            System.out.println("11. Load Patient Data");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                // ==============================
                // 1. ADD PATIENT
                // ==============================
                case 1:

                    System.out.print("Enter patient ID: ");
                    int patientId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter patient name: ");
                    String patientName = sc.nextLine();

                    System.out.print("Enter age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter gender: ");
                    String gender = sc.nextLine();

                    System.out.print("Enter phone: ");
                    String phone = sc.nextLine();

                    System.out.print("Enter disease: ");
                    String disease = sc.nextLine();

                    Patient patient = new Patient(
                            patientId,
                            patientName,
                            age,
                            gender,
                            phone,
                            disease
                    );

                    patientService.addPatient(patient);

                    break;


                // ==============================
                // 2. DISPLAY PATIENTS
                // ==============================
                case 2:

                    patientService.displayPatients();

                    break;


                // ==============================
                // 3. SEARCH PATIENT
                // ==============================
                case 3:

                    System.out.print("Enter patient ID: ");
                    int searchId = sc.nextInt();

                    Patient foundPatient =
                            patientService.findPatient(searchId);

                    if (foundPatient != null) {

                        System.out.println(foundPatient);

                    } else {

                        System.out.println("Patient not found.");
                    }

                    break;


                // ==============================
                // 4. ADD DOCTOR
                // ==============================
                case 4:

                    System.out.print("Enter doctor ID: ");
                    int doctorId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter doctor name: ");
                    String doctorName = sc.nextLine();

                    System.out.print("Enter specialization: ");
                    String specialization = sc.nextLine();

                    System.out.print("Enter phone: ");
                    String doctorPhone = sc.nextLine();

                    Doctor doctor = new Doctor(
                            doctorId,
                            doctorName,
                            specialization,
                            doctorPhone
                    );

                    doctorService.addDoctor(doctor);

                    break;


                // ==============================
                // 5. DISPLAY DOCTORS
                // ==============================
                case 5:

                    doctorService.displayDoctors();

                    break;


                // ==============================
                // 6. ADD APPOINTMENT
                // ==============================
                case 6:

                    System.out.print("Enter appointment ID: ");
                    int appointmentId = sc.nextInt();

                    System.out.print("Enter patient ID: ");
                    int appointmentPatientId = sc.nextInt();

                    System.out.print("Enter doctor ID: ");
                    int appointmentDoctorId = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter date: ");
                    String date = sc.nextLine();

                    System.out.print("Enter time: ");
                    String time = sc.nextLine();

                    System.out.print("Enter status: ");
                    String status = sc.nextLine();

                    Appointment appointment = new Appointment(
                            appointmentId,
                            appointmentPatientId,
                            appointmentDoctorId,
                            date,
                            time,
                            status
                    );

                    appointmentService.addAppointment(appointment);

                    break;


                // ==============================
                // 7. DISPLAY APPOINTMENTS
                // ==============================
                case 7:

                    appointmentService.displayAppointments();

                    break;


                // ==============================
                // 8. ADD TREATMENT
                // ==============================
                case 8:

                    System.out.print("Enter treatment ID: ");
                    int treatmentId = sc.nextInt();

                    System.out.print("Enter patient ID: ");
                    int treatmentPatientId = sc.nextInt();

                    System.out.print("Enter doctor ID: ");
                    int treatmentDoctorId = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter treatment description: ");
                    String description = sc.nextLine();

                    System.out.print("Enter cost: ");
                    double cost = sc.nextDouble();

                    Treatment treatment = new Treatment(
                            treatmentId,
                            treatmentPatientId,
                            treatmentDoctorId,
                            description,
                            cost
                    );

                    // If your TreatmentService has addTreatment()
                    // use this:
                    //
                    // treatmentService.addTreatment(treatment);

                    System.out.println("Treatment object created.");

                    break;


                // ==============================
                // 9. DISPLAY TREATMENTS
                // ==============================
                case 9:

                    System.out.println("Treatment display depends on your TreatmentService.");

                    break;


                // ==============================
                // 10. SAVE DATA
                // ==============================
                case 10:

                    System.out.println(
                            "Save function requires deciding how all four services will be stored."
                    );

                    break;


                // ==============================
                // 11. LOAD DATA
                // ==============================
                case 11:

                    System.out.println(
                            "Load function requires deciding how all four services will be loaded."
                    );

                    break;


                // ==============================
                // 0. EXIT
                // ==============================
                case 0:

                    System.out.println("Thank you!");

                    break;


                default:

                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        sc.close();
    }
}