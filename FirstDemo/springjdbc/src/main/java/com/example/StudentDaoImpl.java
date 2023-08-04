package com.example;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class StudentDaoImpl implements StudentDao {
    public JdbcTemplate jdbcTemplate;
    @Override
    public int insert(Student student){
        String query="insert into student(id,name,address) values(?,?,?)";
        int r=this.jdbcTemplate.update(query, student.getId(),student.getName(),student.getAddress());
        return r;
    }
    @Override
    public int change(Student student) {
        // TODO Auto-generated method stub
        String query="update student set name=?, address=? where id=?";
        int r=this.jdbcTemplate.update(query,student.getName(),student.getAddress(),student.getId());
        return r;
    }
    @Override
    public int changeId(Student student) {
        // TODO Auto-generated method stub
        String query="update student set id=? where name=? and address=?";
        int r=this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getAddress());
        return r;
    }
    @Override
    public int changeName(Student student) {
        // TODO Auto-generated method stub
        String query="update student set name=? where id=?";
        int r=this.jdbcTemplate.update(query,student.getName(),student.getId());
        return r;
    }
    @Override
    public int changeAddress(Student student) {
        // TODO Auto-generated method stub
        String query="update student set address=? where id=?";
        int r=this.jdbcTemplate.update(query,student.getAddress(),student.getId());
        return r;
    }
    @Override
    public int deleteTouple(Student student){
        String query="Delete from student where id=?";
        int r=this.jdbcTemplate.update(query, student.getId());
        return r;
    }
    @Override
    public Student getStudent(Student student) {
        // TODO Auto-generated method stub
        String query="Select * from student where id=?";
        Student student2=this.jdbcTemplate.queryForObject(query,new RowMapper<Student>(){
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException{
                Student student=new Student();
                student.setId(rs.getInt(1));
                student.setName(rs.getString(2));
                student.setAddress(rs.getString(3));
                return student;
            }
        },student.getId());
        return student2;
    }
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
