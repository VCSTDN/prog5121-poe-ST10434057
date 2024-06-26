/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.st10434057_project_part_1;
import javax.swing.JOptionPane;

public class AddTask {

    public static void promptAddTask() {
        String input = JOptionPane.showInputDialog(null, "Enter the number of tasks:", "Number of Tasks", JOptionPane.QUESTION_MESSAGE);

        if (input == null) {
            JOptionPane.showMessageDialog(null, "Operation canceled by user", "Canceled", JOptionPane.INFORMATION_MESSAGE);
            Menu.promptMenu();
        } else if (input.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
            AddTask.promptAddTask();
        } else {
            try {
                int numTasks = Integer.parseInt(input);
                if (numTasks <= 0) {
                    JOptionPane.showMessageDialog(null, "Please enter a number greater than zero", "Error", JOptionPane.ERROR_MESSAGE);
                    AddTask.promptAddTask();
                } else {
                    JOptionPane.showMessageDialog(null, "You entered: " + numTasks, "Number of Tasks", JOptionPane.INFORMATION_MESSAGE);
                    for (int i = 0; i < numTasks; i++) {
                        TaskDetails.promptTaskDetails();
                    }
                    Menu.promptMenu();                 }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
                AddTask.promptAddTask();
            }
        }
    }
}