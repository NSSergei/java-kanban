import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    Task task = new Task(taskGenerationId(), "Поспать", Status.NEW);
    Subtask subtask = new Subtask(subTaskGenerationId(), "Храпеть", Status.NEW,"1");
    Epic epic = new Epic(epicGenerationId(), "ныкрыться одеялом", Status.NEW);

    HashMap<String, Task> tasks = new HashMap<>();  //Task info
    HashMap<String, Subtask> subTask = new HashMap<>(); // subTask info
    HashMap<String, Epic> epic_h = new HashMap<>(); // id / Epic info

    private static int taskIdCounter = 0;
    private static int subtaskIdCounter = 0;
    private static int epicIdCounter = 0;


    public String taskGenerationId(){
        return  String.valueOf(taskIdCounter++);
    }

    public String subTaskGenerationId(){
        return  String.valueOf(subtaskIdCounter++);
    }

    public String epicGenerationId(){
        return  String.valueOf(epicIdCounter++);
    }

    public void toSeeAllTask() {
        for (Task des : tasks.values()) {
            System.out.println(des);
        }

        for (Subtask sub : subTask.values()){
            System.out.println(sub);
        }

        for (Epic ep : epic_h.values()){
            System.out.println(ep);
        }
    }
    public void clearTheList(){
        tasks.clear();
        subTask.clear();
        epic_h.clear();
    }


    public void printTaskById (String id) {
        System.out.println(tasks.get(id));
    }
    public void printSubTaskById (String id) {
        System.out.println(subTask.get(id));
    }
    public void printEpicById (String id) {
        System.out.println(epic_h.get(id));
    }


    public void putToTask(String id, Task task){
        tasks.put(task.getId(),task);
    }
    public void putToSubTask(String id, Subtask subtask){
        subTask.put(subtask.getId(),subtask);

    }
    public void putToEpic(String id, Epic epic){
        epic_h.put(epic.getId(),epic);
    }


    public void updateTask (String id,Task task){
        tasks.put(task.getId(), task);

    }
    public void updateSubTask (String id,Subtask subtask){
        subTask.put(subtask.getId(), subtask);
    }
    public void updateEpic (Epic epic){
        epic_h.put(epic.getId(), epic);
    }

    public void remTask(String id){
        tasks.remove(id);
    }

    public void remSubTask(String id){
        subTask.remove(id);
    }

    public void remEpic(String id){
        epic_h.remove(id);
    }


    public ArrayList<Subtask> getSubtasksForEpic(String epicId) {
        ArrayList<Subtask> subTasks = new ArrayList<>();
        for (Subtask sbt : subTask.values()) {
            if (sbt.getEpicId().equals(epicId)) {
                subTasks.add(sbt);
            }
        }
        return subTasks;
    }

    public void updateEpicStatus(Epic epic) {
        List<Subtask> subtasks = getSubtasksForEpic(epic.getId());

        if (subtasks.isEmpty()) {
            epic.setStatus(Status.NEW);
            return;
        }
        boolean allNew = true;
        boolean allDone = true;

        for (Subtask subtask : subtasks) {
            if (subtask.getStatus() != Status.NEW) {
                allNew = false;
            }
            if (subtask.getStatus() != Status.DONE) {
                allDone = false;
            }
        }

        if (allNew) {
            epic.setStatus(Status.NEW);
        } else if (allDone) {
            epic.setStatus(Status.DONE);
        } else {
            epic.setStatus(Status.IN_PROGRESS);
        }
    }

}