package com.task.desafio.Repository;
import com.task.desafio.Model.Task;

import org.springframework.data.repository.CrudRepository;

public interface TaskRespository extends CrudRepository<Task, Long>{
    
}
