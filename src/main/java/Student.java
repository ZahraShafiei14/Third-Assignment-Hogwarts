import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Student extends Account {
    private List<Course> courses = new ArrayList<>();
    private static String house = "";

    private ArrayList<Double> studentScores = new ArrayList<>();
    //for showing student's teacher use the function course teachers Info

    public void takeCourse(Course course){
        this.courses.add(course);
        course.enrolledByStudent(this);
        System.out.println(course.getTitle() + "enrolled successfully!");
    }

    public static void viewCoursesAndTeachers(Student student){
        System.out.println("Student '" + student.getUsername() + "' enrolled these courses: ");
        if (student.getCourses().isEmpty()){
            System.out.println(student.getUsername()+ "has not enrolled any courses yet.");
        }else for (Course course: student.getCourses()){
            System.out.println("*Course title: " + course.getTitle() + "\n*Teachers: " +course.getTeachers());
        }
    }
    public void scoreTeacher(Course course, double score){
        for(Teacher teacher: course.getTeachers()){
            teacher.getTeacherScores().add(score);
        }
    }
    public static void sortingQuiz(Student student) {
        if(student.getHouse().isEmpty()) {
            Random random = new Random();
            int num = random.nextInt(4);
            switch (num) {
                case 0 -> house = ("Ravenclaw");
                case 1 -> house =("Gryffindor");
                case 2 -> house =("Hufflepuff");
                case 3 -> house =("Slytherin");
            }
            System.out.println("You got: '"+ getHouse() +"'. Welcome to the house!");
        } else {
            System.out.println("You are already in " + getHouse());
        }
    }
    public static void leaveComment(String comment, Teacher teacher){
        teacher.getComment().add(comment);
        System.out.println("comment sent successfully!");
    }

    public Student(String username, String password) {
        super("student",username, password);
    }

    // Getter and Setter
    public List<Course> getCourses() { return courses; }

    public void setCourses(List<Course> courses) { this.courses = courses; }

    public ArrayList<Double> getStudentScores() {
        return studentScores;
    }

    public void setStudentScores(ArrayList<Double> studentScores) {
        this.studentScores = studentScores;
    }

    public static String getHouse() { return house; }
    public  void setHouse(String house) { this.house = house; }
    // Getter and Setter
}
