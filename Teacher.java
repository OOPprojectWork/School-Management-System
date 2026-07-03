import java.util.ArrayList;

public class Teacher extends Person implements Assessable {
    private String employeeId;
    private double salary; 
    private String subjectSpecialty;
    private ArrayList<Course> assignedCourses; 

    public Teacher(String id, String name, String email, String employeeId, double salary, String subjectSpecialty) {
        super(id, name, email);
        this.employeeId = employeeId;
        this.salary = salary;
        this.subjectSpecialty = subjectSpecialty;
        this.assignedCourses = new ArrayList<>();
    }

    public void assignCourse(Course course) {
        assignedCourses.add(course); 
    }

    @Override
    public void displayDetails() {
        System.out.println("\n--- Teacher Profile ---");
        System.out.println("System ID  : " + id + " | Emp ID: " + employeeId);
        System.out.println("Name       : " + name + " | Email: " + email);
        System.out.println("Specialty  : " + subjectSpecialty + " | Salary: Rs." + salary);
        System.out.println("-----------------------");
    }

    @Override
    public void evaluatePerformance() {
        System.out.println("Evaluation Rule for " + name + ": Highly Recommended based on current KPI scores.");
    }
}