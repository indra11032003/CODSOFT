import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Course {
    private String code;
    private String title;
    private String description;
    private int capacity;
    private String schedule;

    public Course(String code, String title, String description, int capacity, String schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getSchedule() {
        return schedule;
    }

    public void decreaseCapacity() {
        if (capacity > 0) {
            capacity--;
        } else {
            System.out.println("Error: Course capacity is already at its minimum.");
        }
    }

    @Override
    public String toString() {
        return "Course Code: " + code + "\nTitle: " + title + "\nDescription: " + description +
                "\nCapacity: " + capacity + "\nSchedule: " + schedule + "\n";
    }
}

class Student {
    private int studentID;
    private String name;
    private List<Course> registeredCourses;

    public Student(int studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerCourse(Course course) {
        registeredCourses.add(course);
    }

    public void dropCourse(Course course) {
        registeredCourses.remove(course);
    }

    @Override
    public String toString() {
        return "Student ID: " + studentID + "\nName: " + name + "\nRegistered Courses: " + registeredCourses + "\n";
    }
}

public class CourseRegistrationSystem {
    public static void main(String[] args) {
        List<Course> courses = new ArrayList<>();
        courses.add(new Course("CS101", "Introduction to Programming", "Learn the basics of programming", 30, "Mon/Wed 10:00 AM"));
        courses.add(new Course("ENG201", "English Composition", "Improve writing skills", 25, "Tue/Thu 2:00 PM"));

        List<Student> students = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Display Course Listing");
            System.out.println("2. Register for a Course");
            System.out.println("3. Drop a Course");
            System.out.println("4. Register as a New Student");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayCourseListing(courses);
                    break;
                case 2:
                    registerForCourse(students, courses);
                    break;
                case 3:
                    dropCourse(students, courses);
                    break;
                case 4:
                    registerNewStudent(students);
                    break;
                case 5:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void displayCourseListing(List<Course> courses) {
        System.out.println("\nCourse Listing:\n");
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    private static void registerForCourse(List<Student> students, List<Course> courses) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student ID: ");
        int studentID = scanner.nextInt();

        Student student = findStudentById(students, studentID);

        if (student == null) {
            System.out.println("Student not found. Please register as a new student first.");
            return;
        }

        System.out.print("Enter course code to register: ");
        String courseCode = scanner.next();

        Course course = findCourseByCode(courses, courseCode);

        if (course == null) {
            System.out.println("Course not found. Please enter a valid course code.");
            return;
        }

        if (student.getRegisteredCourses().size() >= 3) {
            System.out.println("You have reached the maximum course limit (3 courses).");
        } else if (course.getCapacity() > 0) {
            student.registerCourse(course);
            course.decreaseCapacity();
            System.out.println("Registration successful.");
        } else {
            System.out.println("Course is full. Cannot register.");
        }
    }

    private static void dropCourse(List<Student> students, List<Course> courses) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student ID: ");
        int studentID = scanner.nextInt();

        Student student = findStudentById(students, studentID);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter course code to drop: ");
        String courseCode = scanner.next();

        Course course = findCourseByCode(courses, courseCode);

        if (course == null) {
            System.out.println("Course not found.");
            return;
        }

        student.dropCourse(course);
        course.decreaseCapacity();
        System.out.println("Course dropped successfully.");
    }

    private static void registerNewStudent(List<Student> students) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter new student ID: ");
        int newStudentID = scanner.nextInt();

        if (findStudentById(students, newStudentID) != null) {
            System.out.println("Error: Student ID already exists. Please choose a different ID.");
            return;
        }

        System.out.print("Enter new student name: ");
        String newStudentName = scanner.next();

        students.add(new Student(newStudentID, newStudentName));
        System.out.println("New student registered successfully.");
    }

    private static Student findStudentById(List<Student> students, int studentID) {
        for (Student student : students) {
            if (student.getStudentID() == studentID) {
                return student;
            }
        }
        return null;
    }

    private static Course findCourseByCode(List<Course> courses, String courseCode) {
        for (Course course : courses) {
            if (course.getCode().equals(courseCode)) {
                return course;
            }
        }
        return null;
    }
}
