import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        School system = new School("GIFT Advanced Management Portal");
        Scanner sc = new Scanner(System.in);

        Course c1 = new Course("CS210", "Object-Oriented Programming", 4);
        Course c2 = new Course("DS301", "Intro to Data Science", 3);
        system.addCourse(c1);
        system.addCourse(c2);

        Department d1 = new Department("CS-DEPT", "Computer Science Division");
        system.addDepartment(d1);

        System.out.println("=============================================");
        System.out.println("     INITIALIZING CAMPUS SECURITY TERMINAL   ");
        System.out.println("=============================================");
        
        while (true) {
            System.out.print("Enter Admin Username: ");
            String username = sc.nextLine();
            System.out.print("Enter Admin Password: ");
            String password = sc.nextLine();

            if (username.equals("admin") && password.equals("admin123")) {
                System.out.println("Authentication Verified! Access Granted.\n");
                break;
            } else {
                System.out.println("SECURITY ALERT: Invalid credentials. Access Denied.\n");
            }
        }

        int choice = -1;
        while (choice != 0) {
            System.out.println("\n===== CAMPUS OPERATIONS MANAGEMENT MENU =====");
            System.out.println("1. Register New Student");
            System.out.println("2. Register New Faculty Member (Teacher)");
            System.out.println("3. Define Academic Department");
            System.out.println("4. Map Teacher to Department");
            System.out.println("5. Enroll Student into Course");
            System.out.println("6. Setup Timetable Slot Allocation");
            System.out.println("7. View All Registered Students");
            System.out.println("8. View All Registered Faculty Members");
            System.out.println("9. View Global Campus Schedules");
            System.out.println("10. Trigger Performance Audit Evaluations");
            System.out.println("0. Safe System Shutdown & Exit");
            System.out.print("Select Operational Option: ");

            choice = sc.nextInt();
            sc.nextLine(); 

            if (choice == 1) {
                System.out.println("\n--- Student Processing Node ---");
                System.out.print("Enter Legal Full Name: ");
                String sName = sc.nextLine();
                
                String sEmail = "";
                while (true) {
                    System.out.print("Enter Institutional Email Address: ");
                    sEmail = sc.nextLine();
                    if (sEmail.contains("@") && sEmail.contains(".")) { break; } 
                    else { System.out.println("VALIDATION ERROR: Malformed email structure. Must contain '@' and '.'"); }
                }

                int sSemester = 0;
                while (true) {
                    System.out.print("Enter Current Semester Level [1 - 8]: ");
                    sSemester = sc.nextInt();
                    sc.nextLine(); 
                    if (sSemester >= 1 && sSemester <= 8) { break; } 
                    else { System.out.println("VALIDATION ERROR: Semester must be between 1 and 8!"); }
                }
                String sGrade = sSemester + "th Semester";

                int sRollInt = 0;
                while (true) {
                    System.out.print("Enter Registered University Roll Number (Exact 8 Digits): ");
                    sRollInt = sc.nextInt();
                    sc.nextLine(); 
                    if (sRollInt >= 10000000 && sRollInt <= 99999999) { break; } 
                    else { System.out.println("VALIDATION ERROR: Roll Number must be an integer of exactly 8 digits!"); }
                }
                String sRoll = String.valueOf(sRollInt);
                
                double sGpa = 0.0;
                while (true) {
                    System.out.print("Enter Cumulative GPA Score [0.0 - 4.0]: ");
                    sGpa = sc.nextDouble();
                    sc.nextLine(); 
                    if (sGpa >= 0.0 && sGpa <= 4.0) { break; } 
                    else { System.out.println("VALIDATION ERROR: GPA must be between 0.0 and 4.0!"); }
                }
                
                System.out.print("Enter Evaluation Remarks: ");
                String sRemarks = sc.nextLine();

                String sId = system.getNextStudentId();
                Student student = new Student(sId, sName, sEmail, sRoll, sGrade, sGrade, sGpa, sRemarks);
                system.addStudent(student);
                System.out.println("SUCCESS: Registration completed. Student ID: " + sId);

            } else if (choice == 2) {
                System.out.println("\n--- Faculty Registration Node ---");
                System.out.print("Enter Teacher Legal Name: ");
                String tName = sc.nextLine();
                System.out.print("Enter Corporate Email: ");
                String tEmail = sc.nextLine();
                System.out.print("Enter Assigned Employee Identification Code: ");
                String tEmpCode = sc.nextLine();
                System.out.print("Enter Subject Specialty Expertise: ");
                String tSpec = sc.nextLine();
                
                double tSalary = 0.0;
                while (true) {
                    System.out.print("Enter Base Structural Salary: Rs. ");
                    tSalary = sc.nextDouble();
                    sc.nextLine(); 
                    if (tSalary > 0) { break; } 
                    else { System.out.println("VALIDATION ERROR: Salary must be a positive number greater than 0!"); }
                }

                String tId = system.getNextTeacherId();
                Teacher teacher = new Teacher(tId, tName, tEmail, tEmpCode, tSalary, tSpec);
                system.addTeacher(teacher);
                System.out.println("SUCCESS: Faculty Added. Teacher ID: " + tId);

            } else if (choice == 3) {
                System.out.print("Enter New Unique Department Code (e.g., CS-DEPT): ");
                String dId = sc.nextLine();
                System.out.print("Enter Department Identity Name: ");
                String dName = sc.nextLine();
                system.addDepartment(new Department(dId, dName));
                System.out.println("SUCCESS: Department infrastructure mapped successfully.");

            } else if (choice == 4) {
                System.out.print("Enter Department Key Token: ");
                String dKey = sc.nextLine();
                Department dept = system.searchDepartmentById(dKey);
                
                if (dept == null) { System.out.println("ERROR: Target department not found."); } 
                else {
                    System.out.print("Enter Instructor Unique System ID (e.g., TCH-1): ");
                    String tKey = sc.nextLine();
                    Teacher teach = system.searchTeacherById(tKey);
                    
                    if (teach == null) { System.out.println("ERROR: Instructor missing from register."); } 
                    else {
                        dept.addTeacher(teach);
                        System.out.println("SUCCESS: " + teach.getName() + " assigned to " + dept.getDepartmentName());
                    }
                }

            } else if (choice == 5) {
                System.out.print("Enter Student Unique System ID (e.g., STU-1): ");
                String targetStu = sc.nextLine();
                Student activeStudent = system.searchStudentById(targetStu);
                
                if (activeStudent == null) { System.out.println("ERROR: Student record not found."); } 
                else {
                    System.out.print("Enter Course Catalog Code (e.g., CS210 / DS301): ");
                    String targetCrs = sc.nextLine();
                    Course activeCourse = system.searchCourseByCode(targetCrs);
                    
                    if (activeCourse == null) { System.out.println("ERROR: Course code matching failed."); } 
                    else {
                        activeStudent.enrollInCourse(activeCourse);
                        System.out.println("SUCCESS: Student enrolled successfully.");
                    }
                }

            } else if (choice == 6) {
                System.out.println("\n--- Timetable Mapping Allocation Engine ---");
                System.out.print("Enter Slot Catalog Target Course Code: ");
                Course cSlot = system.searchCourseByCode(sc.nextLine());
                System.out.print("Enter Assignee Instructor Teacher System ID: ");
                Teacher tSlot = system.searchTeacherById(sc.nextLine());

                if (cSlot == null || tSlot == null) {
                    System.out.println("ERROR: Mapping aborted due to invalid references.");
                } else {
                    System.out.print("Enter Allocation Day Slot: ");
                    String day = sc.nextLine();
                    System.out.print("Enter Hourly Interval Frame Duration: ");
                    String time = sc.nextLine();
                    System.out.print("Enter Room Allocation Sector Number: ");
                    String room = sc.nextLine();

                    system.addTimetable(new Timetable(day, time, room, cSlot, tSlot));
                    tSlot.assignCourse(cSlot); 
                    System.out.println("SUCCESS: Timetable object mapped seamlessly.");
                }

            } else if (choice == 7) { system.displayAllStudents(); } 
            else if (choice == 8) { system.displayAllTeachers(); } 
            else if (choice == 9) { system.displayAllTimetables(); } 
            else if (choice == 10) {
                System.out.print("Enter Target Entity Key (Student ID / Teacher ID): ");
                String queryId = sc.nextLine();
                Person target = system.searchStudentById(queryId);
                if (target == null) target = system.searchTeacherById(queryId);

                if (target == null) { System.out.println("ERROR: Identification token not found."); } 
                else {
                    System.out.println("\nExecuting Performance Audit Evaluations:");
                    if (target instanceof Student) { ((Student) target).evaluatePerformance(); } 
                    else if (target instanceof Teacher) { ((Teacher) target).evaluatePerformance(); }
                }
            } else if (choice == 0) { System.out.println("System connection terminated safely. Exiting..."); } 
            else { System.out.println("VALIDATION ERROR: Option out of range. Try again."); }
        }
        sc.close();
    }
}