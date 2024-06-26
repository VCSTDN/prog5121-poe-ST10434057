package com.mycompany.st10434057_project_part_1;

import javax.swing.JOptionPane;

public class HighestDuration {

    public static void displayHighestDurationTask() {
        double maxDuration = -1;
        String developer = "";

        for (int i = 0; i < TaskArray.taskArrayCount; i++) {
            if (TaskArray.taskDurationArray[i] > maxDuration) {
                maxDuration = TaskArray.taskDurationArray[i];
                developer = TaskArray.developerArray[i];
            }
        }

        if (maxDuration > 0) {
            StringBuilder message = new StringBuilder();
            message.append("Developer: ").append(developer).append("\n")
                    .append("Task Duration: ").append(maxDuration).append(" hours");

            JOptionPane.showMessageDialog(null, message.toString(), "Task with Highest Duration", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No tasks found.", "Task with Highest Duration", JOptionPane.INFORMATION_MESSAGE);
        }

        Menu.promptMenu();
    }
}
