package com.sddevops.jenkins_project2.eclipse;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Objects;
import java.util.Random;

public class Student {

    private int id;
    private String name;
    private LocalDate birthday;
    private Student friend; // can be null if don't have any best friend

    public Student(int id, String name, LocalDate birthday, Student friend) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.friend = friend;
    }

    public Student(int id, String name, LocalDate birthday) {
        this(id, name, birthday, null);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Student getFriend() {
        return friend;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setFriend(Student friend) {
        this.friend = friend;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Student student = (Student) o;
        return id == student.id
                && Objects.equals(name, student.name)
                && Objects.equals(birthday, student.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, birthday);
    }

    public static Comparator<Student> compareByName =
            (s1, s2) -> s1.getName().compareToIgnoreCase(s2.getName());

    public static Comparator<Student> compareByBirthday =
            (s1, s2) -> s1.getBirthday().compareTo(s2.getBirthday());

    @Override
    public String toString() {
        return "Student{id = " + id
                + ", name = '" + name + '\''
                + ", birthday = " + birthday
                + ", friend = " + (friend != null ? friend.name : "no best friend")
                + '}';
    }

    public void assignRandomUsername(Random random) {
        int minLength = 5;
        int maxLength = 10;

        int length = random.nextInt(maxLength - minLength + 1) + minLength;

        StringBuilder sb = new StringBuilder();
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_";

        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }

        this.name = sb.toString();
    }
}