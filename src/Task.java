public class Task {
    private String id;
    private String description;
    private Status status;

    Task(String id, String description,Status status) {
        this.id = id;
        this.description = description;
        this.status = status;
    }

    public String getId(){
        return id;
    }

    public String getDescription(){
        return  description;
    }

    public Status getStatus(){
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

