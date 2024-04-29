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

    @Override
    public String toString() {
        return code + " - " + title + " (" + schedule + "): " + description + " [Capacity: " + capacity + "]";
    }
}

class Student {
    private int id;
    private String name;
    private List<Course> registeredCourses;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public int getId() {
        return id;
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
}

class CourseManager {
    private List<Course> courses;

    public CourseManager() {
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void removeCourse(Course course) {
        courses.remove(course);
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void displayCourses() {
        System.out.println("Available Courses:");
        for (Course course : courses) {
            System.out.println(course);
        }
    }
}

public class UniversitySystem {
    public static void main(String[] args) {
        CourseManager courseManager = new CourseManager();

        courseManager.addCourse(new Course("CSE101", "Introduction to Computer Science", "Basic concepts of programming", 30, "Mon-Wed 9:00-10:30"));
        courseManager.addCourse(new Course("MAT201", "Calculus I", "Limits, derivatives, and integrals", 25, "Tue-Thu 11:00-12:30"));
        courseManager.addCourse(new Course("ENG101", "English Composition", "Writing skills development", 40, "Mon-Wed-Fri 13:00-14:30"));

        Scanner scanner = new Scanner(System.in);

        courseManager.displayCourses();

        Student student = new Student(123456, "John Doe");
        Course selectedCourse = courseManager.getCourses().get(0);
        student.registerCourse(selectedCourse);
        System.out.println("Student " + student.getName() + " registered for " + selectedCourse.getTitle());

        student.dropCourse(selectedCourse);
        System.out.println("Student " + student.getName() + " dropped " + selectedCourse.getTitle());

        scanner.close();
    }
}
    