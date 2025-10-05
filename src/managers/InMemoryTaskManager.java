package managers;
import tasks.*;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class InMemoryTaskManager implements TaskManager {

    HashMap<Long, Task> tasks = new HashMap<>();  // id /Task info
    HashMap<Long, Subtask> subTask = new HashMap<>(); // id /subTask info
    private HashMap<Long, Epic> epicHash = new HashMap<>(); // id / Epic info

    ArrayList<Task> storyInfo = new ArrayList<>();

    private long taskIdCounter = 0; //сделать private
    private long epicIdCounter = 0;

     private  long taskGenerationId() { //сделать private
        return taskIdCounter++;
    }

    private  long epicGenerationId() { //сделать private
        return epicIdCounter++;
    }



    @Override
    public void clearTasks(){
        tasks.clear();
    }

    @Override
    public void clearSubTasks(){
        subTask.clear();
        for (Epic ep : epicHash.values()){
            ep.getSubtaskIds().clear();
            updateEpicStatus(ep);
        }

    }

    @Override
    public void clearEpics(){
        epicHash.clear();
        subTask.clear();
    }


    @Override
    public Task printTaskById(long id) {
        Task task = tasks.get(id);
        storyInfo.add(task);
        return tasks.get(id);
    }

    @Override
    public Subtask printSubTaskById(long id) {
        Subtask subtask = subTask.get(id);
        storyInfo.add(subtask);
        return subTask.get(id);
    }
    @Override
    public Epic printEpicById(long id) {
        Epic epic = epicHash.get(id);
        storyInfo.add(epic);
        return epicHash.get(id);
    }


    @Override
    public void createTask(Task task){
        task.setId(taskGenerationId());
        tasks.put(task.getId(), task);
    }
    @Override
    public void createSubTask(Subtask subtask){
        subtask.setId(taskGenerationId());
        subtask.setEpicId(epicIdCounter);
        subTask.put(subtask.getId(), subtask);
    }

    /*public Task getTaskById(long id) {
        return tasks.get(id);
    }*/

    @Override
    public void createEpic(Epic epic){
        epic.setId(taskGenerationId());
        epicGenerationId();
        epicHash.put(epic.getId(), epic);
    }


    @Override
    public void updateTask(Task task){
        tasks.put(task.getId(), task);

    }
    @Override
    public void updateSubTask(Subtask subtask){
        if (subtask.getEpicId() != subtask.getId()) {
            subTask.put(subtask.getId(), subtask);
            updateEpicStatus(epicHash.get(subtask.getEpicId()));
        }else{
            System.out.println("Subtask нельзя сделать своим эпиком");
        }
    }
    @Override
    public void updateEpic(Epic epic){
        for(Long subId : epic.getSubtaskIds()){
            if (subId.equals(epic.getId())){
                System.out.println("Epic нельзя добавить в самого себя в виде подзадачи");
            }
        }
        epicHash.put(epic.getId(), epic);
    }

    @Override
    public void remTask(long id){
        tasks.remove(id);
    }

    @Override
    public void remSubTask(long id){
        Subtask removedSubTask = subTask.get(id);
        if (removedSubTask != null){
            Epic epic = epicHash.get(removedSubTask.getEpicId());
            if (epic != null){
                updateEpicStatus(epic);
            }
        subTask.remove(id);
        }
    }

    @Override
    public void remEpic(long id){
        Epic epic = epicHash.get(id);
        if (epic != null){
            List<Long> subtaskIds = epic.getSubtaskIds();
            for(Long subId : subtaskIds){
                remSubTask(subId);
            }
        epicHash.remove(id);
        }
    }


    @Override
    public ArrayList<Subtask> getSubtasksForEpic(long epicId) {
        ArrayList<Subtask> subTasks = new ArrayList<>();
        for (Subtask sbt : subTask.values()) {
            if (sbt.getEpicId() == epicId) {
                subTasks.add(sbt);
            }
        }
        return subTasks;
    }


    @Override
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

    @Override
    public ArrayList<Task> lastTenTasks() {
        while (storyInfo.size() > 10){
            storyInfo.remove(0);

        }
        return new ArrayList<>(storyInfo);
    }
}