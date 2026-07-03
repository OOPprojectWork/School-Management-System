public class Timetable {
    private String day;
    private String slotTime;
    private String roomNumber;
    private Course course;   
    private Teacher teacher; 

    public Timetable(String day, String slotTime, String roomNumber, Course course, Teacher teacher) {
        this.day = day;
        this.slotTime = slotTime;
        this.roomNumber = roomNumber;
        this.course = course;
        this.teacher = teacher;
    }

    public void printSchedule() {
        System.out.println("Slot Configuration: " + day + " [" + slotTime + "] Room: " + roomNumber + 
                           " -> Class: " + course.getCourseName() + " (Instructor: " + teacher.getName() + ")");
    }
}