/*
    TODO: Import all the classes that you have defined and make use of them to build the program.
 */


import java.util.Scanner;

public class Main {
    static Scanner command = new Scanner(System.in);
    public static void main(String[] args) {
        Hogwarts.addAssistant("dumbledore", "albus");
        Hogwarts.addTeacher("severus", "snape");
        Hogwarts.addStudent("harry","potter");
        Hogwarts.addStudent("draco","malfoy");
       runMenu();
    }

    public static void runMenu() {
        while (true) {
            clearScreen();
            System.out.println("Welcome to Hogwarts!");
            System.out.println("(1) Login \n(2) Sign Up \n(3) Exit \nEnter your choice: ");
            String choice = command.nextLine();
            if (choice.toLowerCase().equals("login") || choice.equals("1")) {
                System.out.println("Choose your role by their number: ");
                System.out.println("(1) Assistant \n(2) Teacher\n(3) Student\n(4) Back");
                switch (command.nextLine()) {
                    case "1": {
                        System.out.println("Enter your username: ");
                        String username = command.nextLine();
                        System.out.println("Enter your password: ");
                        String password = command.nextLine();
                        boolean in = false;
                        for (Assistant assistant : Hogwarts.getAssistantList()) {
                            if (assistant.getUsername().equals(username)) {
                                in = true;
                                if (assistant.getPassword().equals((password))) {
                                    System.out.println(assistant.getUsername() + " logged in successfully!");
                                    assistantMenu(assistant);
                                } else {
                                    System.out.println("password was wrong!");
                                }
                                break;
                            }
                        }
                        if (!in) {
                            System.out.println("username not found!");
                        }
                    }
                    break;
                    case "2": {
                        System.out.println("Enter your username: ");
                        String username = command.nextLine();
                        System.out.println("Enter your password: ");
                        String password = command.nextLine();
                        boolean in = false;
                        for (Teacher teacher : Hogwarts.getTeacherList()) {
                            if (teacher.getUsername().equals(username)) {
                                in = true;
                                if (teacher.getPassword().equals((password))) {
                                    System.out.println(teacher.getUsername() + "logged in successfully!");
                                    teacherMenu(teacher);
                                } else {
                                    System.out.println("password was wrong!");
                                }
                                break;
                            }
                        }
                        if (!in) {
                            System.out.println("username not found!");
                        }
                    }
                    break;
                    case "3": {
                        System.out.println("Enter your username: ");
                        String username = command.nextLine();
                        System.out.println("Enter your password: ");
                        String password = command.nextLine();
                        boolean in = false;
                        for (Student student : Hogwarts.getStudentList()) {
                            if (student.getUsername().equals(username)) {
                                in = true;
                                if (student.getPassword().equals((password))) {
                                    System.out.println(student.getUsername() + "logged in successfully!");
                                    studentMenu(student);
                                } else {
                                    System.out.println("password was wrong!");
                                }
                                break;
                            }
                        }
                        if (!in) {
                            System.out.println("username not found!");
                        }
                    }
                    break;
                    case "4":
                        clearScreen();
                        runMenu();
                        break;
                    default:
                        System.out.println("Invalid input\nEnter a key to return to the main menu...");
                        command.nextLine();
                        runMenu();
                }
            } else if (choice.toLowerCase().equals("sign up") || choice.equals("2")) {
                System.out.println("Choose your role by their number: ");
                System.out.println("(1) Assistant \n(2) Teacher\n(3) Student\n(4) Back");
                switch (command.nextLine()) {
                    case "1": {
                        System.out.println("Enter your username: ");
                        String username = command.nextLine();
                        System.out.println("Enter your password: ");
                        String password = command.nextLine();
                        Assistant a = new Assistant(username, password);
                        Hogwarts.addAssistant(username, password);
                    }
                    break;
                    case "2": {
                        System.out.println("Enter your username: ");
                        String username = command.nextLine();
                        System.out.println("Enter your password: ");
                        String password = command.nextLine();
                        Teacher t = new Teacher(username, password);
                        Hogwarts.addTeacher(username,password);
                    }
                    break;
                    case "3": {
                        System.out.println("Enter your username: ");
                        String username = command.nextLine();
                        System.out.println("Enter your password: ");
                        String password = command.nextLine();
                        Student s = new Student(username, password);
                        Hogwarts.addStudent(username,password);
                    }
                    break;
                    case "4":
                        clearScreen();
                        runMenu();
                        break;
                    default:
                        System.out.println("Invalid input\nEnter a key to return to the main menu...");
                        command.nextLine();
                        runMenu();
                }
            }else {
                return ;
            }
        }
    }
    private static void studentMenu(Student student) {
        while (true){
            System.out.println("Student Menu");
            System.out.println("(1) view Courses and teachers list");
            System.out.println("(2) take course");
            System.out.println("(3) leave comment");
            System.out.println("(4) score teacher");
            System.out.println("(5) Sorting quiz");
            System.out.println("\n Enter your choice: ");
            switch (command.nextLine()){
                case "1":{
                    Student.viewCoursesAndTeachers(student);
                }
                break;
                case "2":{
                    Hogwarts.viewAllCourses();
                    String course = command.nextLine();
                    boolean in = false;
                    for (Course c : Hogwarts.getCourseList()) {
                        if (c.getTitle().equals(course)) {
                            in = true;
                            if (!(student.getCourses().contains(c))) {
                                student.takeCourse(c);
                            } else {
                                System.out.println("you already have this course");
                            }
                            break;
                        }
                    }
                    if (!(in)) {
                        System.out.println("Course not found!");
                    }
                }
                break;
                case"3":{
                    System.out.println("which teacher do you want to send comment?");
                    String name = command.nextLine();
                    Teacher teacher = Assistant.findTeacherViaUsername(name);
                    if(teacher != null){
                        System.out.println("write your comment: ");
                        String comment = command.nextLine();
                        Student.leaveComment(comment,teacher);
                    }else {
                        System.out.println("teacher not found!");
                    }
                }
                break;
                case "4":{
                    System.out.print("choose the course: ");
                    String course = command.nextLine();
                    boolean in = false;
                    for (Course c : Hogwarts.getCourseList()) {
                        if (c.getTitle().equals(course)) {
                            System.out.print("Enter the score between 0 - 100: ");
                            try {
                                int score = command.nextInt();
                                command.nextLine();
                                while (score < 0 || score > 100) {
                                    System.out.print("enter valid score: ");
                                    score = command.nextInt();
                                    command.nextLine();
                                }
                                student.scoreTeacher(c, score);
                                in = true;
                                break;
                            } catch (Exception e) {
                                System.out.println("Invalid input!");
                            }
                        }
                    }
                    if (!(in)) {
                        System.out.println("Course not found!");
                    }
                    break;
                }
                case "5":
                    Student.sortingQuiz(student);
                    break;
                default:
                    System.out.println("Invalid input");
                    clearScreen();
                    studentMenu(student);
            }

        }
    }

    private static void assistantMenu(Assistant assistant) {
    }
    private static void teacherMenu(Teacher teacher) {
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}


