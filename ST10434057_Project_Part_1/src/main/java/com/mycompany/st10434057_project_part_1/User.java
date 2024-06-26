/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.st10434057_project_part_1;

/**
 *
 * @author Vivi
 */
public class User {
    public static int userCount = 0;
    static User[] user = new User[100];
    String _userName;
    String _password;
    String _name;
    String _surname;
    
    public User(String userName, String password, String name, String surname){
    this._surname = surname;
    this._name = name;    
    this._userName = userName;
    this._password = password;
}
    public static void addNewUser(User user){
        User.user[User.userCount] = user;
        User.userCount++;
    }
}
