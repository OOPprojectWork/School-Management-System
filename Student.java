import java.util.ArrayList;

public class Student extends Person implements Assessable {
    private String rollNumber;
    private String grade;
    private ReportCard reportCard; 
    private ArrayList<Attendance> attendanceRecord; 
    private ArrayList<Course> enrolledCourses; 

    public Student(String id, String name, String email, String rollNumber, String grade, String semester, double gpa, String remarks) {
        super(id, name, email); 
        this.rollNumber = rollNumber;
        this.grade = grade;
        this.reportCard = new ReportCard(semester, gpa, remarks); 
        this.attendanceRecord = new ArrayList<>();
        this.enrolledCourses = new ArrayList<>();
    }

    public void enrollInCourse(Course course) {
        enrolledCourses.add(course);
    }

    @Override
    public void displayDetails() {
        System.out.println("\n--- Student Profile ---");
        System.out.println("System ID : " + id + " | Roll No: " + rollNumber);
        System.out.println("Name      : " + name + " | Email: " + email);
        System.out.println("Semester  : " + grade + " | GPA: " + reportCard.getGpa() + " (" + reportCard.getRemarks() + ")");
        System.out.print("Courses   : ");
        if (enrolledCourses.isEmpty()) {
            System.out.print("No courses enrolled yet.");
        } else {
            for (Course c : enrolledCourses) {
                System.out.print("[" + c.getCourseCode() + "] " + c.getCourseName() + "  ");
            }
        }
        System.out.println("\n-----------------------");
    }

    @Override
    public void evaluatePerformance() {
        if (reportCard.getGpa() >= 3.5) {
            System.out.println("Academic Standing for " + name + ": Excellent! (Dean's List honors).");
        } else if (reportCard.getGpa() >= 2.0) {
            System.out.println("Academic Standing for " + name + ": Satisfactory status.");
        } else {
            System.out.println("Academic Standing for " + name + ": Academic Probation.");
        }
    }
}