package com.mycompany.st10434057_project_part_1;

import javax.swing.JOptionPane;

public class TaskArray {
    public static int taskArrayCount = 0;
    public static int taskNumberCounter = 1;
    public static TaskArray[] taskarray = new TaskArray[225];

    public static String[] developerArray = new String[225];
    public static String[] taskNamesArray = new String[225];
    public static String[] taskIDArray = new String[225];
    public static double[] taskDurationArray = new double[225];
    public static String[] taskStatusArray = new String[225];

    public String _taskName;
    public int _taskNumber;
    public String _taskDescription;
    public String _developerDetails;
    public double _taskDuration;
    public String _taskId;
    public String _taskStatus;

    public TaskArray(String taskName, int taskNumber, String taskDescription, String developerDetails, double taskDuration, String taskId, String taskStatus) {
        this._taskName = taskName;
        this._taskNumber = taskNumber;
        this._taskDescription = taskDescription;
        this._developerDetails = developerDetails;
        this._taskDuration = taskDuration;
        this._taskId = taskId;
        this._taskStatus = taskStatus;
    }

    public static void addNewTask(TaskArray task) {
        if (taskArrayCount < taskarray.length) {
            taskarray[taskArrayCount] = task;
            developerArray[taskArrayCount] = task._developerDetails;
            taskNamesArray[taskArrayCount] = task._taskName;
            taskIDArray[taskArrayCount] = task._taskId;
            taskDurationArray[taskArrayCount] = task._taskDuration;
            taskStatusArray[taskArrayCount] = task._taskStatus;
            taskArrayCount++;
        } else {
            JOptionPane.showMessageDialog(null, "Task array is full!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void populateArrays() {
        taskArrayCount = 0;
        taskNumberCounter = 1;
        addNewTask(new TaskArray("Create Login", taskNumberCounter++, "Create Login to authenticate users", "Mike Smith", 5, "CL:1:MS", "To Do"));
        addNewTask(new TaskArray("Create Add Features", taskNumberCounter++, "Create Add Features to extend functionality", "Edward Harrison", 8, "CAF:2:EH", "Doing"));
        addNewTask(new TaskArray("Create Reports", taskNumberCounter++, "Create Reports for data analysis", "Samantha Paulson", 2, "CR:3:SP", "Done"));
        addNewTask(new TaskArray("Add Arrays", taskNumberCounter++, "Add Arrays to the application", "Glenda Oberholzer", 11, "AA:4:GO", "To Do"));
    }


    public static void displayTasksWithStatusDone() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < taskArrayCount; i++) {
            if ("Done".equals(taskStatusArray[i])) {
                result.append("Task Name: ").append(taskNamesArray[i])
                        .append(", Developer: ").append(developerArray[i])
                        .append(", Duration: ").append(taskDurationArray[i]).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, result.length() > 0 ? result.toString() : "No tasks with status 'Done'", "Tasks with Status Done", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void displayLongestTaskDuration() {
        double maxDuration = -1;
        String developer = "";
        for (int i = 0; i < taskArrayCount; i++) {
            if (taskDurationArray[i] > maxDuration) {
                maxDuration = taskDurationArray[i];
                developer = developerArray[i];
            }
        }
        JOptionPane.showMessageDialog(null, "Developer with longest task duration: " + developer + ", Duration: " + maxDuration, "Longest Task Duration", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void searchTaskByName(String taskName) {
        for (int i = 0; i < taskArrayCount; i++) {
            if (taskNamesArray[i].equalsIgnoreCase(taskName)) {
                JOptionPane.showMessageDialog(null, "Task Name: " + taskNamesArray[i] + ", Developer: " + developerArray[i] + ", Status: " + taskStatusArray[i], "Task Search Result", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Task not found", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void searchTasksByDeveloper(String developer) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < taskArrayCount; i++) {
            if (developerArray[i].equalsIgnoreCase(developer)) {
                result.append("Task Name: ").append(taskNamesArray[i]).append(", Status: ").append(taskStatusArray[i]).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, result.length() > 0 ? result.toString() : "No tasks found for developer: " + developer, "Tasks by Developer", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void deleteTaskByName(String taskName) {
        for (int i = 0; i < taskArrayCount; i++) {
            if (taskNamesArray[i].equalsIgnoreCase(taskName)) {
                for (int j = i; j < taskArrayCount - 1; j++) {
                    taskarray[j] = taskarray[j + 1];
                    developerArray[j] = developerArray[j + 1];
                    taskNamesArray[j] = taskNamesArray[j + 1];
                    taskIDArray[j] = taskIDArray[j + 1];
                    taskDurationArray[j] = taskDurationArray[j + 1];
                    taskStatusArray[j] = taskStatusArray[j + 1];
                }
                taskarray[taskArrayCount - 1] = null;
                developerArray[taskArrayCount - 1] = null;
                taskNamesArray[taskArrayCount - 1] = null;
                taskIDArray[taskArrayCount - 1] = null;
                taskDurationArray[taskArrayCount - 1] = 0;
                taskStatusArray[taskArrayCount - 1] = null;
                taskArrayCount--;
                JOptionPane.showMessageDialog(null, "Task '" + taskName + "' successfully deleted", "Task Deleted", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Task not found", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void displayReport() {
        StringBuilder report = new StringBuilder();
        for (int i = 0; i < taskArrayCount; i++) {
            report.append("Task Name: ").append(taskNamesArray[i]+"\n")
                    .append("  Developer: ").append(developerArray[i]+"\n")
                    .append("  Task ID: ").append(taskIDArray[i]+"\n")
                    .append("  Duration: ").append(taskDurationArray[i]+"\n")
                    .append("  Status: ").append(taskStatusArray[i]+"\n")
                    .append("\n");
        }
        JOptionPane.showMessageDialog(null, report.length() > 0 ? report.toString() : "No tasks available", "Task Report", JOptionPane.INFORMATION_MESSAGE);
    }
}
