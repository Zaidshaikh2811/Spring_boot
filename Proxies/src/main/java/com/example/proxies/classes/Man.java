package com.example.proxies.classes;

public class Man implements Person {

    private String name;
    private int age;
    private String city;
    private String country;

    public Man(String name,int age,String city,String country) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.country = country;
    }

    @Override
    public void introduce(String name){
        System.out.println("My name is "+name);
    }

    @Override
    public void sayAge(String age){
        System.out.println("My age is "+age);
    }

    @Override
    public void sayWhereFrom(String city,String country){
        System.out.println("My country is "+country);
    }


    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }
    public String getCity(){
        return city;
    }
    public String getCountry(){
        return country;
    }





}
