package otus;

public class Student {
    private int id;
    private String name;
    private int age;
    private Course course;

    public Student(int id, String name, int age, Course course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
