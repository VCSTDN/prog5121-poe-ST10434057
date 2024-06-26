/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.st10434057_project_part_1;

import javax.swing.JOptionPane;

public class Menu {

    public enum Items {
        Add_Task,
        Completed_Tasks,
        Highest_Duration_Task,
        Search_For_Task_By_Name,
        Search_For_Developers_Task,
        Show_Report,
        Delete_Task,
        Quit,
    }

    public static void promptMenu() {

        Object[] options = {Items.Add_Task,Items.Completed_Tasks,Items.Highest_Duration_Task, Items.Search_For_Task_By_Name,Items.Search_For_Developers_Task, Items.Show_Report, Items.Delete_Task, Items.Quit};

        Object selectedItem = JOptionPane.showInputDialog(
                null,
                "Welcome to EasyKanban! Select an option:",
                "Menu",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        if (selectedItem != null) {
            Items item = (Items) selectedItem;
            switch (item) {
                case Add_Task:
                    AddTask.promptAddTask();
                    break;
                case Completed_Tasks:
                    CompletedTasks.displayCompletedTasks();
                    break;
                case Highest_Duration_Task:
                    HighestDuration.displayHighestDurationTask();
                    break;
                case Search_For_Task_By_Name:
                    searchTaskName.searchTaskByNameAndDisplay();
                    break;
                case Search_For_Developers_Task:
                    searchDevelopersTasks.searchTasksByDeveloperAndDisplay();
                    break;
                case Show_Report:
                    TaskArray.displayReport();
                    promptMenu();
                    break;
                case Delete_Task:
                    DeleteTasks.promptDeleteTask();
                case Quit:
                    System.exit(0);
                    break;
            }
        } else {
            System.out.println("No item selected.");
            MainPage.displayOptions();
        }
    }
}


