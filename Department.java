import java.util.ArrayList;

public class Department {
    private String departmentId;
    private String departmentName;
    private ArrayList<Teacher> staff; 

    public Department(String departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.staff = new ArrayList<>();
    }

    public void addTeacher(Teacher t) { staff.add(t); }
    public String getDepartmentId() { return departmentId; }
    public String getDepartmentName() { return departmentName; }
}