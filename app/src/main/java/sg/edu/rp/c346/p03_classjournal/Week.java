package sg.edu.rp.c346.p03_classjournal;

public class Week {

    private int week;
    private String dailyGrade;
    private String grade;

    public Week(int week, String dailyGrade, String grade) {
        this.week = week;
        this.dailyGrade = dailyGrade;
        this.grade = grade;
    }

    public int getWeek() {
        return week;
    }

    public String getDailyGrade() {
        return dailyGrade;
    }

    public String getGrade() {
        return grade;
    }
}
