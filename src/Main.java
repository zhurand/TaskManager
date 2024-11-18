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
        System.out.print(
                        "1 - Создать список задач\n" +
                        "2 - Напечатать список(и) задач\n" +
                        "3 - Выйти из программы\n");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\nВведите команду: ");
            String option = scanner.nextLine();
            if (option.equals("3")) {
                break;
            }
            switch (option) {
                case "1": {
                    System.out.print("Введите название для списка задач: ");
                    String nameList = scanner.nextLine();
                    tasks = new TaskList(nameList);
                    while (true) {
                        System.out.print("Введите задачу: ");
                        String[] line = scanner.nextLine().split(" ");
                        String priorityTask = line[0];
                        if (priorityTask.isEmpty()) {
                            break;
                        }
                        String nameTask = line[1];
                        Task task = new Task(priorityTask, nameTask);
                        tasks.addTask(task);
                    }
                    break;
                }
                case "2": {
                    if (tasks != null) {
                        tasks.printTaskList();
                        break;
                    } else {
                        System.out.println("Нет созданных списков");
                        break;
                    }
                }
            }
        }
    }
}
