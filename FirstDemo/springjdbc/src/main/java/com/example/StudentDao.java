package com.example;

public interface StudentDao {
    public int insert(Student student);
    public int change(Student student);
    public int changeName(Student student);
    public int changeAddress(Student student);
    public int changeId(Student student);
    public int deleteTouple(Student student);
    public Student getStudent(Student student);
}
