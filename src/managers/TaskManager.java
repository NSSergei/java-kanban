package managers;

import tasks.Epic;
import tasks.Subtask;
import tasks.Task;

import java.util.ArrayList;

    interface TaskManager {

    void clearTasks();

    void clearSubTasks();

    void clearEpics();

    Task printTaskById(long id);

    Subtask printSubTaskById(long id);

    Epic printEpicById(long id);

    void createTask(Task task);

    void createSubTask(Subtask subtask);

    void createEpic(Epic epic);

    void updateTask(Task task);

    void updateSubTask(Subtask subtask);

    void updateEpic(Epic epic);

    void remTask(long id);

    void remSubTask(long id);

    void remEpic(long id);

    ArrayList<Subtask> getSubtasksForEpic(long epicId);

    void updateEpicStatus(Epic epic);

    public ArrayList<Task> lastTenTasks();


}
