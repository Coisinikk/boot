package com.zjy.dao;

import com.zjy.entity.Task;


import java.util.List;

public interface TaskDao {

    //添加任务
    int taskAdd(Task task);

    //查询任务
    List taskFindAll();

    //删除任务
    int taskDelete(Integer task_id);
}