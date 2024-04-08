import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Course {
    private String title;
    private UUID courseID;
    private List<Student> students;
    private List<Teacher> teachers;

    public Course(String title) {
        this.title = title;
        this.courseID = UUID.randomUUID();
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
    }

    public void enrolledByStudent(Student student){
        students.add(student);
    }

    public void enrolledByTeacher(Teacher teacher){
        teachers.add(teacher);
    }

    //which students enrolled this course
    public void courseStudentsInfo(Course course) {
        String details = "";

        details += ":: Course name: '"+ course.getTitle() + "' has the following students:" +"\n";

        if(course.getStudents().isEmpty()) {
            details = "This course has no students enrolled!";
        }else {
            for(Student student: course.getStudents())
                details += student +"\n";
            details += "------------------------------";
        }
        System.out.println(details);
    }

    //which teacher taught this course
    public void courseTeachersInfo(Course course) {
        String details = "";

        details += ":: Course name: '"+ course.getTitle() + "' has the following teachers:" +"\n";

        if(course.getTeachers().isEmpty()) {
            details = "No teacher has taught this course";
        }else {
            for(Teacher teacher: course.getTeachers())
                details += teacher +"\n";
                details += "------------------------------";
        }
        System.out.println(details);
    }

    // Getter and Setter
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UUID getCourseID() {
        return courseID;
    }

    public void setCourseID(UUID courseID) {
        this.courseID = courseID;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }
    // Getter and Setter
}
