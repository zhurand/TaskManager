/**
 * --СПИСОК ЗАДАЧ--
 * Список задач хранит в себе:
 * -Название списка
 * -Список задач
 * Задача хранит в себе:
 * -Номер который показывает в каком порядке отображать задачу от 1 до N
 * -Название задачи
 * -Статус о выполнении (да или нет)
 * Функционал:
 * -Создание списка задач
 * -Удаление списка задач
 * -Редактирование списка задач
 * -Создание задачи с добавлением в список
 * -Удаление задачи
 * -Редактирование задачи
 * -Вывод в консоль всех списков и задач
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskList tasks = null;
        Task task = null;
        System.out.print(
                        "1 - Создать список задач\n" +
                        "2 - Редактировать список задач\n" +
                        "3 - Удалить список задач\n" +
                        "4 - Напечатать список(и) задач\n" +
                        "5 - Выйти из программы\n");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\nВведите команду: ");
            String option = scanner.nextLine();
            if (option.equals("5")) {
                break;
            }
            switch (option) {
                case "1": {
                    System.out.print("Введите название для списка задач: ");
                    String nameTaskList = scanner.nextLine();
                    if (tasks == null) {
                        tasks = new TaskList(nameTaskList);
                    }
                    else if (tasks.existsTaskList(nameTaskList)) {
                        System.out.println("\nСписок с таким именем уже создан!");
                        break;
                    }
                    else if (nameTaskList.isEmpty()) {
                        System.out.println("\nОшибка! Название списка не может быть пустым");
                        break;
                    }
                    else if (nameTaskList.isBlank()) {
                        System.out.println("\nОшибка! Название списка не может состоять из одних лишь пробелов");
                        break;
                    }
                    else {
                        tasks.setNameTaskList(nameTaskList);
                    }
                    while (true) {
                        System.out.print("Введите задачу: ");
                        String taskDescription = scanner.nextLine();
                        if (taskDescription.isEmpty()) {
                            break;
                        }
                        task = new Task(nameTaskList, taskDescription, option);
                        tasks.addTask(task);
                    }
                    break;
                }
                case "2": {
                    if (tasks == null) {
                        System.out.println("Нет созданных списков");
                        break;
                    }
                    else {
                        System.out.print("Введите имя списка, которое хотите редактировать: ");
                        String nameTaskList = scanner.nextLine();
                        if (!tasks.existsTaskList(nameTaskList)) {
                            System.out.println("Список задач с таким именем не найден");
                        }
                        else {
                            System.out.print(
                                    "1 - Редактировать описание задачи\n" +
                                    "2 - Изменить статус задачи (да - задача выполнена, нет - не выполнена)\n" +
                                    "3 - Добавить задачу\n" +
                                    "4 - Удалить задачу\n");
                            System.out.print("Введите номер опции: ");
                            String optionEditTaskList = scanner.nextLine();
                            switch (optionEditTaskList) {
                                case "1": {
                                    System.out.print("Введите номер задачи: ");
                                    try {
                                        int taskID = Integer.parseInt(scanner.nextLine());
                                        if (tasks.getTaskDescription(nameTaskList, taskID) == null) {
                                            System.out.println("\nОшибка! Не найден номер задачи");
                                            break;
                                        }
                                        System.out.print(
                                                "Вы хотите изменить задачу: " +
                                                        tasks.getTaskDescription(nameTaskList, taskID) + "\n");
                                        System.out.print("Введите новое описание задачи: ");
                                        String newTaskDescription = scanner.nextLine();
                                        tasks.editTaskDescription(nameTaskList, taskID, newTaskDescription);
                                    }
                                    catch (NumberFormatException e) {
                                        System.out.println("\nОшибка! Номер задачи должен быть числом");
                                    }
                                    finally {
                                        break;
                                    }
                                }
                                case "2": {
                                    System.out.print("Введите номер задачи: ");
                                    int taskID = Integer.parseInt(scanner.nextLine());
                                    System.out.print("Введите новый статус для задачи: ");
                                    String newStatus = scanner.nextLine();
                                    tasks.editStatusTask(nameTaskList, taskID, newStatus);
                                    break;
                                }
                                case "3": {
                                    System.out.print("Введите задачу: ");
                                    String taskDescription = scanner.nextLine();
                                    task = new Task(nameTaskList, taskDescription, option);
                                    tasks.addTask(task);
                                    break;
                                }
                                case "4": {
                                    System.out.print("Введите номер задачи, чтобы удалить ее: ");
                                    int taskID = Integer.parseInt(scanner.nextLine());
                                    tasks.deleteTask(nameTaskList, taskID);
                                    break;
                                }
                            }
                        }
                        break;
                    }
                }
                case "3": {
                    if (tasks == null) {
                        System.out.println("Нет созданных списков");
                        break;
                    }
                    System.out.print("Введите название списка, чтобы его удалить: ");
                    String nameTaskList = scanner.nextLine();
                    if (!tasks.existsTaskList(nameTaskList)) {
                        System.out.print("Список задач с таким именем не найден");
                    }
                    else {
                        System.out.print("Список задач " + "\"" + nameTaskList + "\"" + " будет удален.\n" +
                                "Вы уверены? (1 - подтверждаю/ 0 - отмена)\n");
                        String answer = scanner.nextLine();
                        if (answer.equals("1")) {
                            tasks.deleteTaskList(nameTaskList);
                            System.out.print("Список " + "\"" + nameTaskList + "\"" + " был удален.");
                        }
                        else if (answer.equals("0")) {
                            break;
                        }
                        else {
                            System.out.print("Некорректный ввод");
                            break;
                        }
                    }
                    break;
                }
                case "4": {
                    if (tasks != null) {
                        tasks.printTaskList();
                        break;
                    }
                    else {
                        System.out.println("Нет созданных списков");
                        break;
                    }
                }
            }
        }
    }
}
