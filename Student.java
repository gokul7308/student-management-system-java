class Student {
    int id;
    String name;
    int age;
    String course;
    double marks;

    Student(int id, String name, int age, String course, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return id + " | " + name + " | " + age + " | " + course + " | " + marks;
    }
}