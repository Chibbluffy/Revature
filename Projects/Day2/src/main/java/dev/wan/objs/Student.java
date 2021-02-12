package dev.wan.objs;

public class Student {
    String name;
    int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }


    // Common overrides
    // toString, equals
    @Override
    public String toString(){
        return "Hi this is " + this.name;
    }
    @Override
    public boolean equals(Object o){
        Student s = (Student) o; // called a downcast: turning broad class to narrower child class
        // Dangerous though,
        // If cannot change to Student, will throw an exception.

        return this.grade == s.grade;

        // safer to do this
        /*
        if (o instanceof Student) {
            Student t = (Student) o;
            return this.grade == t.grade;
        }
        return false;

         */
    }
}
