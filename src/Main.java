public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        String epicId = taskManager.epicGenerationId();
        Epic epic = new Epic(epicId, "Тестовый эпик", Status.DONE);
        taskManager.putToEpic(epic.getId(), epic);

        taskManager.updateEpicStatus(epic);
        Epic epic2 = new Epic(epicId, "Тестовый эпик", Status.DONE);


        taskManager.updateEpicStatus(epic2);
        System.out.println("Эпик без подзадач, статус: " + epic2.getStatus() + " iD " + epicId); // Должен быть NEW

        String subtaskId1 = taskManager.subTaskGenerationId();
        Subtask subtask1 = new Subtask(subtaskId1, "Подзадача 1", Status.DONE, epicId);
        taskManager.putToSubTask(subtask1.getId(), subtask1);

        String subtaskId2 = taskManager.subTaskGenerationId();
        Subtask subtask2 = new Subtask(subtaskId2, "Подзадача 2", Status.NEW, epicId);
        taskManager.putToSubTask(subtask2.getId(), subtask2);

        String subtaskId3 = taskManager.subTaskGenerationId();
        Subtask subtask3 = new Subtask(subtaskId3, "Пиво", Status.IN_PROGRESS, epicId);

        taskManager.updateEpicStatus(epic);
        System.out.println("Эпик с подзадачами NEW, статус: " + epic.getStatus() + " iD " + epic.getId()); // Должен быть NEW

        subtask1.setStatus(Status.DONE);
        taskManager.updateSubTask(subtask1.getId(), subtask1);

        subtask2.setStatus(Status.DONE);
        taskManager.updateSubTask(subtask2.getId(), subtask2);

        subtask3.setStatus(Status.DONE);
        taskManager.updateSubTask(subtask3.getId(), subtask3);

        taskManager.updateEpicStatus(epic);
        System.out.println("Эпик с подзадачами DONE, статус: " + epic.getStatus() + " iD " + epic.getId()); // Должен быть DONE


        subtask2.setStatus(Status.IN_PROGRESS);
        taskManager.updateSubTask(subtask2.getId(), subtask2);

        taskManager.updateEpicStatus(epic);
        System.out.println("Эпик со смешанными статусами подзадач, статус: " + epic.getStatus() + " iD " + epic.getId() ); // Должен быть IN_PROGRESS
    }
}