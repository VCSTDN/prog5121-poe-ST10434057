/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.st10434057_project_part_1;
import javax.swing.JOptionPane;
/**
 *
 * @author lab_services_student
 */
public class MainPage {
    public static void main(String[] args) {
        displayOptions();
    }
    
    public static void displayOptions() {
        Object[] options = {"Login", "Register", "Cancel"};
        int choice = JOptionPane.showOptionDialog(null, "Welcome!\nPlease select an option:", "Main Page", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        
        switch (choice) {
            case 0: // Login
                Login.promptLogin();
                break;
            case 1: // Register
                Register.promptRegister();
                break;
            case 2: // Cancel
                JOptionPane.showMessageDialog(null, "Thank you for visiting!");
                displayOptions();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Thank you for visiting!");
                System.exit(0);
                break;
        }
    }
}

