package managers;

import tasks.*;
import  java.util.ArrayList;


public class MainTest {
    public static void main(String[] args) {

        TaskManager taskManager = new InMemoryTaskManager();

        // Создаем первую задачу
        Task task1 = new Task("Сон", Status.NEW);
        taskManager.createTask(task1);
        taskManager.printTaskById(task1.getId());

        // Создаем вторую задачу
        Task task2 = new Task("Обед", Status.NEW);
        taskManager.createTask(task2);
        taskManager.printTaskById(task2.getId()); //  просетать значение из своего внутреннего счетчика


        // Создаем третью задачу
        Task task3 = new Task("Прогулка", Status.NEW);
        taskManager.createTask(task3);
        taskManager.printTaskById(task3.getId()); //  просетать значение из своего внутреннего счетчика

        // Создаем эпик
        Epic epic = new Epic("Заметки на сегодня", Status.NEW, new ArrayList<>());
        taskManager.createEpic(epic);
        long epicId = epic.getId();
        taskManager.printEpicById(epic.getId()); // просетать значение из своего внутреннего счетчика

        Epic epic1 = new Epic("Заметки на завтра", Status.NEW, new ArrayList<>());
        taskManager.createEpic(epic1);
        long epicId1 = epic1.getId();
        taskManager.printEpicById(epic1.getId()); // просетать значение из своего внутреннего счетчика

        // Создаем подзадачу, привязанную к эпик
        Subtask subtask = new Subtask("Кормить собаку", Status.NEW, epicId);
        taskManager.createSubTask(subtask);
        taskManager.printSubTaskById(subtask.getId()); // просетать значение из своего внутреннего счетчика

        //System.out.println(subtask.getId() + " " +"<---Тут");

        Epic epic2 = new Epic("Заметки на послезавтра", Status.NEW, new ArrayList<>());
        taskManager.createEpic(epic2);
        long epicId2 = epic1.getId();
        taskManager.printEpicById(epic2.getId()); // просетать значение из своего внутреннего счетчика


        Subtask subtask1 = new Subtask("Кормить кота", Status.NEW, epicId);
        taskManager.createSubTask(subtask1);
        taskManager.printSubTaskById(subtask1.getId()); // просетать значение из своего внутреннего счетчика

        //System.out.println(subtask1.getId() + " " +"<---Тут");

        Task task7 = new Task("Полет на шаре", Status.NEW);
        taskManager.createTask(task7);
        taskManager.printTaskById(task7.getId());

        // Создаем вторую задачу
        Task task8 = new Task("Цирк", Status.NEW);
        taskManager.createTask(task8);
        taskManager.printTaskById(task8.getId()); //  просетать значение из своего внутреннего счетчика

        // Создаем третью задачу
        Task task9 = new Task("Поход в театр", Status.NEW);
        taskManager.createTask(task9);
        taskManager.printTaskById(task9.getId());

        Task task10 = new Task("Коникулы", Status.NEW);
        taskManager.createTask(task10);
        taskManager.printTaskById(task10.getId());

        // Создаем вторую задачу
        Task task11 = new Task("Игры", Status.NEW);
        taskManager.createTask(task11);
        taskManager.printTaskById(task11.getId());

        Task task12 = new Task("Игры2222", Status.NEW);
        taskManager.createTask(task12);
        taskManager.printTaskById(task12.getId());

        Task task13 = new Task("Игры333333", Status.NEW);
        taskManager.createTask(task13);
        taskManager.printTaskById(task13.getId());


        // Выводим 10 последних просмотренных задач
        for (Task task : taskManager.lastTenTasks()) {
            System.out.println(task);
        }
        System.out.println(taskManager.lastTenTasks().size());
    }
}
