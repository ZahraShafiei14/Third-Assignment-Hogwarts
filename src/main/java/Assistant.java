public class Assistant extends Account {

    public Assistant(String username, String password) {
        super("assistant", username, password);
    }

    public void createCourse(String string){
        Hogwarts.addCourse(string);
        System.out.println("course added successfully");
    }
    public Student findStudentViaUsername(String username){
        for (Student student: Hogwarts.getStudentList()){
            if(student.getUsername().equals(username)){
                return student;
            }
        }
        return null;
    }
    public static Teacher findTeacherViaUsername(String username){
        for (Teacher teacher: Hogwarts.getTeacherList()){
            if(teacher.getUsername().equals(username)){
                return teacher;
            }
        }
        return null;
    }
    public void removeStudent(String username){
        Hogwarts.viewAllStudents();
        System.out.println("Which one of the students do you want to remove?\nEnter the username: ");
        Hogwarts.getStudentList().remove(findStudentViaUsername(username));
    }
    public void removeTeacher(String username){
        Hogwarts.viewAllTeachers();
        System.out.println("Which one of the teachers do you want to remove?\nEnter the username: ");
        Hogwarts.getTeacherList().remove(findTeacherViaUsername(username));
    }
    public void checkStudentProfile(String username){
        Hogwarts.viewAllStudents();
        System.out.println("Which profile you want to check?\nEnter the username: ");
        Student s = findStudentViaUsername(username);
        System.out.println("Student Profile:\nUsername: " + s.getUsername() + "\nHouse: " + s.getHouse());
        Student.viewCoursesAndTeachers(s);
    }
    public void checkSTeacherProfile(String username){
        Hogwarts.viewAllTeachers();
        System.out.println("Which profile you want to check?\nEnter the username: ");
        Teacher t = findTeacherViaUsername(username);
        System.out.println("Teacher Profile:\nUsername: " + t.getUsername());
        Teacher.viewCoursesAndStudents(t);
    }
    public void signUpTeacher(String username, String password) {
        Hogwarts.addTeacher(username, password);
        System.out.println("Teacher signed up successfully");
    }

    public void signUpStudent(String username, String password) {
        Hogwarts.addStudent(username, password);
        System.out.println("Student signed up successfully");
    }

    public void signUpAssistant(String username, String password) {
        Hogwarts.addAssistant(username, password);
        System.out.println("Assistant signed up successfully");
    }

}
