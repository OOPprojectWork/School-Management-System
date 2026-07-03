public class ReportCard {
    private String semester;
    private double gpa;
    private String remarks;

    public ReportCard(String semester, double gpa, String remarks) {
        this.semester = semester;
        this.gpa = gpa;
        this.remarks = remarks;
    }

    public double getGpa() { return gpa; }
    public String getRemarks() { return remarks; }
}