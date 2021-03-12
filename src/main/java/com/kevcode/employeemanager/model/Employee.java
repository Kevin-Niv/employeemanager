package com.kevcode.employeemanager.model;


import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

@Entity
//@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"employeeCode" })})
@SequenceGenerator(name="seq", initialValue=1, allocationSize=100)
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String email;
    private String jobTitle;
    private String phone;
    private String imageUrl;
    @Column( unique = true,nullable = false, updatable = false)
    private Long employeeCode;

    public Employee(){}

    public Employee(String name, String email, String jobTitle, String phone, String imageUrl, Long employeeCode) {
        this.name = name;
        this.email = email;
        this.jobTitle = jobTitle;
        this.phone = phone;
        this.imageUrl = imageUrl;
        this.employeeCode = employeeCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getEmployeeCode(String s) {
        return employeeCode;
    }

    public void setEmployeeCode(Long employeeCode) {
        this.employeeCode = employeeCode;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", phone='" + phone + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", employeeCode='" + employeeCode + '\'' +
                '}';
    }
    private final static AtomicLong subIdCounter = new AtomicLong(System.nanoTime());

    @PrePersist
    void sub_id() {
        this.employeeCode = subIdCounter.incrementAndGet();
    }
}
