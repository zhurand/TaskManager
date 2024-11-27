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
                    String nameList = scanner.nextLine();
                    if (tasks == null) {
                        tasks = new TaskList(nameList);
                    }
                    else {
                        tasks.setName(nameList);
                    }
                    while (true) {
                        System.out.print("Введите задачу: ");
                        String nameTask = scanner.nextLine();
                        if (nameTask.isEmpty()) {
                            break;
                        }
                        task = new Task(nameTask);
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
                        String nameOfList = scanner.nextLine();
                        if (!tasks.existsTaskList(nameOfList)) {
                            System.out.println("Список задач с таким именем не найден");
                        }
                        else {
                            System.out.print(
                                    "1 - Редактировать описание задачи\n" +
                                    "2 - Изменить статус задачи (да - задача выполнена, нет - не выполнена)\n");
                            System.out.print("Введите номер опции: ");
                            String optionEditTaskList = scanner.nextLine();
                            switch (optionEditTaskList) {
                                case "1": {
                                    System.out.print("Введите номер задачи: ");
                                    int idTask = Integer.parseInt(scanner.nextLine());
                                    System.out.print(
                                            "Вы хотите изменить задачу: " +
                                            tasks.getTaskDescription(nameOfList, idTask) + "\n");
                                    System.out.print("Введите новое описание задачи: ");
                                    String newTaskDescription = scanner.nextLine();
                                    tasks.editTaskDescription(nameOfList, idTask, newTaskDescription);
                                    break;
                                }
                                case "2": {
                                    System.out.print("Введите номер задачи: ");
                                    int idTask = Integer.parseInt(scanner.nextLine());
                                    System.out.print("Введите новый статус для задачи: ");
                                    String newStatus = scanner.nextLine();
                                    tasks.editStatusTask(nameOfList, idTask, newStatus);
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
                            tasks.deleteTaskLisk(nameTaskList);
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
