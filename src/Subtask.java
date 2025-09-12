public class Subtask extends Task{
    private String epicId;
    Subtask(String id, String description,Status status,String epicId){
        super(id,description, status);
        this.epicId = epicId;
    }

    public void setEpicId(String epicId){
        this.epicId = epicId;
    }
    public String getEpicId(){
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
