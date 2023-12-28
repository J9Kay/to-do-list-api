package com.example.todolist.service;

import com.example.todolist.repository.TaskRepository;
import com.example.todolist.model.Task;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;


@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @Test
    public void whenSaveTask_thenTaskShouldBeSaved() {
        Task task = new Task();
        task.setDescription("New Task");
        when(taskRepository.save(any(Task.class))).thenReturn(task);

        Task savedTask = taskService.saveTask(task);

        verify(taskRepository).save(task);
        assertEquals("New Task", savedTask.getDescription());
    }
}
