package com.example.tictactoe;

import java.util.HashMap;

public class HashMapInJava {

    // HashMaps implements the Map surface, it has key-value pairs. It stores objects so we need to use wrapper classes
   HashMap<String, Integer> studentInfo = new HashMap<>();

   void addStudent(String name, int rollNum) {
       studentInfo.put(name, rollNum);
       System.out.println("Student added successfully!");
   }

   int searchStudent(String name) {

       int rollNum;
       rollNum = studentInfo.get(name);
       return rollNum;
   }

   void removeStudent(String name) {
       studentInfo.remove(name);
       System.out.println("Student record removed successfully.");
   }
   void displayStudents() {
       System.out.println(studentInfo);
   }

    public static void main(String[] args) {
        HashMapInJava hashMaps = new HashMapInJava();
        hashMaps.addStudent("Someone", 24);
        hashMaps.addStudent("Someone2", 69);
        hashMaps.displayStudents();
        System.out.println(hashMaps.searchStudent("Someone"));
        hashMaps.removeStudent("Someone2");
        hashMaps.displayStudents();
    }

}
