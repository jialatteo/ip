package duke;

import java.util.List;
import java.util.Scanner;

/**
 * Ui class allows Duke to interact/print messages
 * to the user when changes are made to the user's task list
 *
 * @author  Gerald Teo Jin Wei
 * @version 0.1
 * @since   2022-08-28
 */
public class Ui {
    /**
     * This method prints out the greeting message
     * when the user starts the Duke program
     */
    public String greet() {
        return "Hello I'm duke.Duke\nWhat can I do for you?\n";
    }

    /**
     * This method prints out the quitting message
     * when the user exits the Duke program
     */
    public String quit() {
        return "Bye. Hope to see you again soon!";
    }

    /**
     * This method starts the Duke program
     * and start accepting String input from the user
     * @param sc Scanner that scans the user's String input
     * @param storage Storage to load and save the user's todo task list
     * @param taskList TaskList to update the user's task list
     */
    public void start(Scanner sc, Storage storage, TaskList taskList) {
        while (true) {
            String command = sc.nextLine();
            if (command.equals("bye")) {
                break;
            }
            Parser.parseCommand(command, taskList, this);
            storage.save(taskList.getList());
        }
    }

    /**
     * This method lists out the tasks
     * in the user's task list
     * @param tasks List of tasks to be printed out
     */
    public String listOutTasks(TaskList tasks) {
        return tasks.printList();
    }

    /**
     * This method marks the task and
     * prints out a message
     * @param taskToMark The task from the list to be marked
     */
    public String markTask(Task taskToMark) {
        taskToMark.mark();
        return "Nice! I've marked this task as done:\n  " + taskToMark;
    }

    /**
     * This method unmarks the task and
     * prints out a message
     * @param taskToMark The task from the list to be unmarked
     */
    public String unmarkTask(Task taskToMark) {
        taskToMark.unmark();
        return "OK, I've marked this task as not done yet:\n  " + taskToMark;
    }

    /**
     * This method adds the new task to
     * the user's task list and prints out
     * a message
     * @param taskList TaskList of the user
     * @param taskToAdd The new task to be added to user's task list
     */
    public String addTask(TaskList taskList, Task taskToAdd) {
        taskList.addTask(taskToAdd);
        return "Got it. I've added this task:\n  " + taskToAdd + "\nNow you have "
                + taskList.getSize() + " tasks in the list.";
    }

    /**
     * This method deletes the task
     * from the user's task list and prints
     * out a message
     * @param taskList TaskList of the user
     * @param taskToDelete The task from the user's task list to be deleted
     */
    public String deleteTask(TaskList taskList, Task taskToDelete) {
        taskList.deleteTask(taskToDelete);
        return "Noted. I've removed this task:\n  " + taskToDelete + "\nNow you have "
                + taskList.getSize() + " tasks in the list";
    }

    /**
     * This method prints out all the tasks
     * with the user's search keyword
     * @param taskListWithKeyword List of tasks containing user's search keyword
     */
    public String printTasksWithKeyword(List<Task> taskListWithKeyword) {
        String str = "Here are the matching tasks in your list:\n";
        for (int i = 1; i <= taskListWithKeyword.size(); i++) {
            str += i + "." + taskListWithKeyword.get(i - 1) + "\n";
        }
        return str;
    }
}
