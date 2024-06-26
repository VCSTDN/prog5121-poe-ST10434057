package com.mycompany.st10434057_project_part_1;

import javax.swing.*;

public class DeleteTasks {

    public static void promptDeleteTask() {
        String[] taskNames = TaskArray.taskNamesArray;
        String selectedTaskName = (String) JOptionPane.showInputDialog(
                null,
                "Select a Task Name to Delete:",
                "Delete Task",
                JOptionPane.QUESTION_MESSAGE,
                null,
                taskNames,
                taskNames.length > 0 ? taskNames[0] : null
        );

        if (selectedTaskName == null) {
            // If the user clicks "Cancel" or "X", return to the menu.
            Menu.promptMenu();
            return;
        }

        int taskIndex = -1;
        for (int i = 0; i < TaskArray.taskArrayCount; i++) {
            if (TaskArray.taskNamesArray[i].equalsIgnoreCase(selectedTaskName)) {
                taskIndex = i;
                break;
            }
        }

        if (taskIndex != -1) {
            StringBuilder taskDetails = new StringBuilder();
            taskDetails.append("Task Name: ").append(TaskArray.taskNamesArray[taskIndex]).append("\n")
                    .append("Task ID: ").append(TaskArray.taskIDArray[taskIndex]).append("\n")
                    .append("Task Description: ").append(TaskArray.taskarray[taskIndex]._taskDescription).append("\n")
                    .append("Developer: ").append(TaskArray.developerArray[taskIndex]).append("\n")
                    .append("Task Duration: ").append(TaskArray.taskDurationArray[taskIndex]).append(" hours\n")
                    .append("Task Status: ").append(TaskArray.taskStatusArray[taskIndex]).append("\n");

            int option = JOptionPane.showConfirmDialog(
                    null,
                    taskDetails.toString() + "\nDo you want to delete this task?",
                    "Confirm Task Deletion",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            if (option == JOptionPane.YES_OPTION) {
                deleteTask(taskIndex);
                promptDeleteTask();
            } else {
                Menu.promptMenu();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Task '" + selectedTaskName + "' not found.", "Task Not Found", JOptionPane.ERROR_MESSAGE);
            Menu.promptMenu();
        }
    }

    private static void deleteTask(int index) {
        for (int j = index; j < TaskArray.taskArrayCount - 1; j++) {
            TaskArray.taskarray[j] = TaskArray.taskarray[j + 1];
            TaskArray.developerArray[j] = TaskArray.developerArray[j + 1];
            TaskArray.taskNamesArray[j] = TaskArray.taskNamesArray[j + 1];
            TaskArray.taskIDArray[j] = TaskArray.taskIDArray[j + 1];
            TaskArray.taskDurationArray[j] = TaskArray.taskDurationArray[j + 1];
            TaskArray.taskStatusArray[j] = TaskArray.taskStatusArray[j + 1];
        }
        TaskArray.taskArrayCount--;

        JOptionPane.showMessageDialog(null, "Task deleted successfully.", "Task Deleted", JOptionPane.INFORMATION_MESSAGE);
    }
}
