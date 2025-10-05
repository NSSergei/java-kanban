package  tasks;

public class Task {
    private long id = 0;
    private String description;
    private Status status;

    public Task(String description,Status status) {
        this.description = description;
        this.status = status;
    }

    public void setId(long id) {
        this.id = id;
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
                /*"id='" + id + '\'' +*/
                "description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task task = (Task) o;
        return  getId() == task.getId() &&
                getDescription().equals(task.getDescription()) &&
                getStatus().equals(task.getStatus());

    }
}

