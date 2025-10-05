package  tasks;
import  java.util.List;
public class Epic extends Task {
    private List<Long> subtaskIds;

    public Epic(String description, Status status, List<Long> subtaskIds) {
        super(description, status);
        this.subtaskIds = subtaskIds;
    }
    public void addSubtask(Long subtaskId){
        subtaskIds.add(subtaskId);
    }
    public List<Long> getSubtaskIds(){
        return subtaskIds;
    }
    @Override
    public String toString() {
        return "Epic{" +
                /*"id=" + getId() +*/
                "description='" + getDescription() + '\'' +
                ", status=" + getStatus() +
                ", subtaskIds=" + subtaskIds +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Epic)) return false;
        Epic epic = (Epic) o;
            return getId() == epic.getId() &&
                    getDescription().equals((epic.getDescription())) &&
                    getStatus().equals((epic.getStatus()));/*&&
                    getSubtaskIds() == epic.getSubtaskIds();*/ //не сработает так как без данных ссылка будет на разные лбъекты
    }
}
