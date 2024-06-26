/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.st10434057_project_part_1;
import javax.swing.*;

public class Login {
    
    public static void promptLogin() {
    int option = JOptionPane.showConfirmDialog(null, "Login:", "Login", JOptionPane.OK_CANCEL_OPTION);
    
    if (option == JOptionPane.CANCEL_OPTION || option == JOptionPane.CLOSED_OPTION) {
        MainPage.displayOptions();
        return;
    }
    
    String returnLoginStatus = null;
    while (returnLoginStatus == null) {
        String username = JOptionPane.showInputDialog("Enter Username:");
        if (username == null) {
            MainPage.displayOptions(); // Return to MainPage if cancelled
            return;
        }
        String password = JOptionPane.showInputDialog("Enter Password:");
        if (password == null) {
            MainPage.displayOptions(); // Return to MainPage if cancelled
            return;
        }
        
        if (loginUser(username, password)) {
            returnLoginStatus = username;
            User loggedInUser = findUserByUsername(username);
            if (loggedInUser != null) {
                JOptionPane.showMessageDialog(null, "Welcome " + loggedInUser._name + ", " + loggedInUser._surname + ". It's great to see you again.");
                Menu.promptMenu();
            } else {
                JOptionPane.showMessageDialog(null, "An error occurred while logging in. Please try again.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Username or password incorrect. Please try again.");
        }
    }
}


    static boolean loginUser(String username, String password){
        for (int i = 0; i < User.userCount; i++){
            if (User.user[i]._userName.equals(username) && User.user[i]._password.equals(password) ) {
                return true;
            }
        }
        return false;
    }
    
    static User findUserByUsername(String username) {
        for (int i = 0; i < User.userCount; i++) {
            if (User.user[i]._userName.equals(username)) {
                return User.user[i];
            }
        }
        return null;
    }
}

