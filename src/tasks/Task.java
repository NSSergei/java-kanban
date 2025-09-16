package  tasks;

public class Task {
    private long id;
    private String description;
    private Status status;

    Task(long id, String description,Status status) {
        this.id = id;
        this.description = description;
        this.status = status;
    }

    public long getId(){
        return id;
    }

    public String getDescription(){
        return  description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}

