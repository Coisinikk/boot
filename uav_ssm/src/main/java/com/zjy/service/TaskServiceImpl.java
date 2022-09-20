package com.zjy.service;

import com.zjy.dao.TaskDao;
import com.zjy.entity.Task;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class TaskServiceImpl implements TaskService {
    @Resource
    private TaskDao taskDao;
    @Override
    public int taskAdd(Task task) {
        int num = taskDao.taskAdd(task);
        return num;
    }

    @Override
    public List taskFindAll() {
        List<Task> tasks = taskDao.taskFindAll();
        return tasks;
    }

    @Override
    public int taskDelete(Integer task_id) {
        int num = taskDao.taskDelete(task_id);
        return num;
    }
}
