package managers;
import tasks.*;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    HashMap<Long, Task> tasks = new HashMap<>();  // id /Task info
    HashMap<Long, Subtask> subTask = new HashMap<>(); // id /subTask info
    private HashMap<Long, Epic> epicHash = new HashMap<>(); // id / Epic info

    private static long taskIdCounter = 0;

    public long taskGenerationId(){
        return  taskIdCounter++;
    }

    public void clearTasks(){
        tasks.clear();
    }

    public void clearSubTasks(){
        subTask.clear();
        for (Epic ep : epicHash.values()){
            ep.getSubtaskIds().clear();
            updateEpicStatus(ep);
        }

    }

    public void clearEpics(){
        epicHash.clear();
        subTask.clear();
    }


    public Task printTaskById (long id) {
        return tasks.get(id);
    }

    public Subtask printSubTaskById (long id) {
        return subTask.get(id);
    }
    public Epic printEpicById (long id) {
        return epicHash.get(id);
    }


    public void createTask(Task task){
        tasks.put(taskGenerationId(),task);
    }
    public void createSubTask(Subtask subtask){
        subTask.put(taskGenerationId(),subtask);

    }
    public void createEpic(Epic epic){
        epicHash.put(taskGenerationId(),epic);
    }


    public void updateTask (Task task){
        tasks.put(task.getId(), task);

    }
    public void updateSubTask (Subtask subtask){
        subTask.put(subtask.getId(), subtask);
        updateEpicStatus(epicHash.get(subtask.getEpicId()));
    }
    public void updateEpic (Epic epic){
        epicHash.put(epic.getId(), epic);
    }

    public void remTask(long id){
        tasks.remove(id);
    }

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


    public ArrayList<Subtask> getSubtasksForEpic(long epicId) {
        ArrayList<Subtask> subTasks = new ArrayList<>();
        for (Subtask sbt : subTask.values()) {
            if (sbt.getEpicId() == epicId) {
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