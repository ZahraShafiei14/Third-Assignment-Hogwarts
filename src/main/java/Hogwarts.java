import java.util.ArrayList;
import java.util.List;

public class Hogwarts {

    private static List<Student> studentList = new ArrayList<>();
    private static List<Teacher> teacherList = new ArrayList<>();
    private static List<Assistant> assistantList = new ArrayList<>();
    private static List<Course> courseList = new ArrayList<>();
    public static void viewAllTeachers() {
        String allTeachers = "";

        allTeachers += "Hogwarts has these following teachers:" +"\n";

        if(teacherList.isEmpty()) {
            allTeachers = "No teacher has been hired yet";
        }else {
            for(int i = 0; i <= teacherList.size(); i++)
                allTeachers += i + ") "+ teacherList.get(i).getUsername() +"\n";
                allTeachers += "------------------------------";
        }
        System.out.println(allTeachers);
    }

    public static void viewAllStudents() {
        String allStudents = "";

        allStudents += "Hogwarts has these following students:" +"\n";

        if(studentList.isEmpty()) {
            allStudents = "No student has been registered yet";
        }else {
            for(int i = 0; i <= studentList.size(); i++)
                allStudents += i + ") "+ studentList.get(i).getUsername() + "is in" + studentList.get(i).getHouse() +"\n";
                allStudents += "------------------------------";
        }
        System.out.println(allStudents);
    }

    public static void viewAllCourses() {
        String allCourses = "";

        allCourses += "Hogwarts has these following students:" +"\n";

        if(courseList.isEmpty()) {
            allCourses = "No student has been registered yet";
        }else {
            for(int i = 0; i <= courseList.size(); i++)
                allCourses += i + ") "+ courseList.get(i) +"\n";
                allCourses += "------------------------------";
        }
        System.out.println(allCourses);
    }

    public static void addTeacher(String username, String password) {
        Teacher teacher = new Teacher(username, password);
        teacherList.add(teacher);
    }

    public static void addStudent(String username, String password) {
        Student student = new Student(username, password);
        studentList.add(student);
    }

    public static void addAssistant(String username, String password) {
        Assistant assistant = new Assistant(username, password);
        assistantList.add(assistant);
    }

    public static void addCourse(String title) {
        Course course = new Course(title);
        courseList.add(course);
    }
    //getters
    public static List<Student> getStudentList() {
        return studentList;
    }
    public static List<Teacher> getTeacherList() {
        return teacherList;
    }
    public static List<Assistant> getAssistantList() {
        return assistantList;
    }
    public static List<Course> getCourseList() {
        return courseList;
    }
    //getters
}
