package com.acc.lkm.businessbean;

public class StudentBean {
    
    private Integer id;
    private String student_name;
    private String student_branch;
    private Integer year_of_joining;

    // Getters and setters
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_branch() {
        return student_branch;
    }

    public void setStudent_branch(String student_branch) {
        this.student_branch = student_branch;
    }

    public Integer getYear_of_joining() {
        return year_of_joining;
    }

    public void setYear_of_joining(Integer year_of_joining) {
        this.year_of_joining = year_of_joining;
    }
}
