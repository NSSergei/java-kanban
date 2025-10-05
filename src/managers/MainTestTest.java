package managers;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import tasks.Status;
import tasks.*;


import java.util.ArrayList;



public class MainTestTest {

    Task task = new Task("Сон", Status.NEW);
    Task task2 = new Task("Сон", Status.NEW);

    Epic epic = new Epic("Спортзал", Status.NEW, new ArrayList<>());
    Epic epic2 = new Epic("Спортзал", Status.NEW, new ArrayList<>());

    Subtask subtask = new Subtask("Купить витамины", Status.NEW, 1);
    Subtask subtask2 = new Subtask("Купить витамины", Status.NEW, 1);


    @Test
    public  void testEqualsTest() {
        assertEquals(task,task2);
    }
    @Test
    public void testEqualsEpic() {
        assertTrue(epic.equals(epic2));
    }
    @Test
    public void testEqualsSubTask() {
        assertTrue(subtask.equals(subtask2));
    }
    @Test
    public void managerIsInitializedCorrectly(){
        HistoryManager manager = Managers.getDefaultHistory();
        assertNotNull(manager);
    }
    @Test
    public void taskManagerAddsAndFindsTasksCorrectly() {
        InMemoryTaskManager manager = new InMemoryTaskManager();
        Task task = new Task("Задача", Status.NEW);
        Epic epic = new Epic("Эпик", Status.NEW, new ArrayList<>());
        Subtask subtask = new Subtask("Подзадача", Status.NEW, epic.getId());

        manager.createTask(task);
        manager.createSubTask(subtask);
        manager.createEpic(epic);

        assertNotNull(manager.printTaskById(task.getId()));
        assertNotNull(manager.printEpicById(epic.getId()));
        assertNotNull(manager.printSubTaskById(subtask.getId()));
    }

    @Test
    public void testUniqueIds() {
        TaskManager taskManager = new InMemoryTaskManager();

        // Создаём первую задачу
        Task task1 = new Task("Сон", Status.NEW);
        taskManager.createTask(task1);

        Task task2 = new Task("Обед", Status.NEW);
        taskManager.createTask(task2);

        assertNotEquals(task1.getId(), task2.getId());
        //System.out.println(task1.getId()+ " " + task2.getId());
    }

}