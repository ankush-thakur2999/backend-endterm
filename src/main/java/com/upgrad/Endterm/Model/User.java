package com.upgrad.Endterm.Model;

import javax.persistence.*;

@Entity
@Table(name ="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "Name",nullable = false)
    private  String Name;
    @Column(name="Age",nullable = false)
    private int Age;
    @Column(name = "Email",nullable = false)
    private  String Email;
    @Column (name="Address",nullable = false)
    private  String Address;
    @Column(name="Number",nullable = false)
    private int Number;

    public User() {
    }

    public User(String name, int age, String email, String address, int number) {
        Name = name;
        Age = age;
        Email = email;
        Address = address;
        Number = number;
    }

    public Long getId() {
        return Id;
    }

    public void setID(Long ID) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }


}
