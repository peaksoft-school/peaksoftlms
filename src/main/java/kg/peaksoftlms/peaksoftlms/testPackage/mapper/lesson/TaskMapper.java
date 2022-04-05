package kg.peaksoftlms.peaksoftlms.testPackage.mapper.lesson;

import kg.peaksoftlms.peaksoftlms.testPackage.dto.lesson.TaskRequest;
import kg.peaksoftlms.peaksoftlms.testPackage.dto.lesson.TaskResponse;
import kg.peaksoftlms.peaksoftlms.testPackage.model.lesson.Task;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class TaskMapper {
    private final ModelMapper modelMapper;

    public Task taskRequestToTask(TaskRequest taskRequest) {
        return modelMapper.map(taskRequest, Task.class);
    }

    public TaskResponse taskToTaskResponse(Task task) {
        return modelMapper.map(task, TaskResponse.class);
    }

    public List<TaskResponse> taskListToTaskResponseList(List<Task> taskList) {
        List<TaskResponse> taskResponseList = new ArrayList<>();
        for (Task task : taskList) {
            taskResponseList.add(taskToTaskResponse(task));
        }
        return taskResponseList;
    }

    public Task update(Task task, TaskRequest taskrequest) {
        task.setTaskName(taskrequest.getTaskName());
        task.setTask(taskrequest.getTask());
        task.setImg(taskrequest.getImg());
        return task;
    }

}
