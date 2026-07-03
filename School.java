import java.util.ArrayList;

public class School {
    private String schoolName;
    private ArrayList<Student> studentsList = new ArrayList<>();
    private ArrayList<Teacher> teachersList = new ArrayList<>();
    private ArrayList<Course> coursesList = new ArrayList<>();
    private ArrayList<Department> departmentsList = new ArrayList<>();
    private ArrayList<Timetable> timetablesList = new ArrayList<>();

    private static int studentCounter = 1;
    private static int teacherCounter = 1;

    public School(String schoolName) { this.schoolName = schoolName; }

    public String getNextStudentId() { return "STU-" + studentCounter++; }
    public String getNextTeacherId() { return "TCH-" + teacherCounter++; }

    public void addStudent(Student s) { studentsList.add(s); }
    public void addTeacher(Teacher t) { teachersList.add(t); }
    public void addCourse(Course c) { coursesList.add(c); }
    public void addDepartment(Department d) { departmentsList.add(d); }
    public void addTimetable(Timetable t) { timetablesList.add(t); }

    public Student searchStudentById(String id) {
        for (Student s : studentsList) { if (s.getId().equalsIgnoreCase(id)) return s; }
        return null;
    }

    public Teacher searchTeacherById(String id) {
        for (Teacher t : teachersList) { if (t.getId().equalsIgnoreCase(id)) return t; }
        return null;
    }

    public Course searchCourseByCode(String code) {
        for (Course c : coursesList) { if (c.getCourseCode().equalsIgnoreCase(code)) return c; }
        return null;
    }

    public Department searchDepartmentById(String id) {
        for (Department d : departmentsList) { if (d.getDepartmentId().equalsIgnoreCase(id)) return d; }
        return null;
    }

    public void displayAllStudents() {
        if (studentsList.isEmpty()) { System.out.println("No registered students found."); return; }
        for (Student s : studentsList) s.displayDetails();
    }

    public void displayAllTeachers() {
        if (teachersList.isEmpty()) { System.out.println("No registered teachers found."); return; }
        for (Teacher t : teachersList) t.displayDetails();
    }

    public void displayAllTimetables() {
        if (timetablesList.isEmpty()) { System.out.println("No schedule mappings found."); return; }
        System.out.println("\n=== CAMPUS TIMETABLE SCHEDULE ===");
        for (Timetable t : timetablesList) t.printSchedule();
    }
}