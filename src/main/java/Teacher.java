import java.util.ArrayList;
import java.util.List;

public class Teacher extends Account{
    private ArrayList<Double> teacherScores = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();
    private List<String> comment = new ArrayList<>();
    private double score;

    public void takeCourse(Course course){
        this.courses.add(course);
        course.enrolledByTeacher(this);
        System.out.println(course.getTitle() + "added successfully!");
    }
    public static void viewCoursesAndStudents(Teacher t){
        System.out.println("Teacher '" + t.getUsername() + "' taught these courses: ");
        if (t.getCourses().isEmpty()){
            System.out.println(t.getUsername()+ "has not taught any courses yet.");
        }else for (Course course: t.getCourses()){
            System.out.println("* Course title: " + course.getTitle() + "\n*Students: " +course.getStudents());
        }
    }
    public void viewComment(){
        System.out.println("The received comments are: ");
        if (this.comment.isEmpty()){
            System.out.println("No comments received");
        }else for (int i = 0; i <= comment.size(); i++){
            System.out.println(i + ") " + comment.get(i));
        }
    }
    public void scoreStudents(Course course, double score){
        for(Student student: course.getStudents()){
            student.getStudentScores().add(score);
        }
    }
    public double averageScore(){
        double sum = 0;
        for (double num:teacherScores) {
            sum += num;
        }
        return sum / teacherScores.size();
    }

    public Teacher(String username, String password) {
        super("teacher", username, password);
    }

    // Getter and Setter
    public ArrayList<Double> getTeacherScores() {
        return teacherScores;
    }

    public void setTeacherScores(ArrayList<Double> scores) {
        this.teacherScores = scores;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<String> getComment() {
        return comment;
    }

    public void setComment(List<String> comment) {
        this.comment = comment;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
    // Getter and Setter
}
