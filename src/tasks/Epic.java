package  tasks;
import  java.util.List;
public class Epic extends Task {
    private List<Long> subtaskIds;

    public Epic(long id, String description, Status status, List<Long> subtaskIds) {
        super(id, description, status);
        this.subtaskIds = subtaskIds;
    }
    public void addSubtask(Long subtaskId){
        subtaskIds.add(subtaskId);
    }
    public List<Long> getSubtaskIds(){
        return subtaskIds;
    }

}
