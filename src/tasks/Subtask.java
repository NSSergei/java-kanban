package tasks;

public class Subtask extends Task {
    private long epicId;
    public Subtask(String description,Status status,long epicId){
        super(description, status);
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
                /*"id=" + getId() +*/
                "description='" + getDescription() + '\'' +
                ", epicId=" + epicId +
                ", status=" + getStatus() +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subtask)) return false;
        Subtask subtask = (Subtask) o;
        return getId() == subtask.getId() &&
                getEpicId() == subtask.getEpicId() &&
                getDescription().equals(subtask.getDescription());
    }
}
