package tasks;

public class Subtask extends Task {
    private long epicId;
    Subtask(long id, String description,Status status,long epicId){
        super(id,description, status);
        this.epicId = epicId;
    }

    public void setEpicId(long epicId){
        this.epicId = epicId;
    }
    public long getEpicId(){
        return epicId;
    }

    @Override
    public String toString() {
        return "Subtask{" +
                "id=" + getId() +
                ", description=" + getDescription() +
                ", epicId=" + epicId +
                ", status=" + getStatus() +
                "}";
    }
}
