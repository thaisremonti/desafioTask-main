package com.task.desafio.Controller;

import java.time.LocalDateTime;

import com.task.desafio.Model.Task;
import com.task.desafio.Repository.TaskRespository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path="/desafio")
public class TaskController {

    @Autowired TaskRespository taskRepository;

    TaskController(TaskRespository repository) {
        this.taskRepository = repository;
    }

    @GetMapping(path="/")
	public ModelAndView form(){
		return new ModelAndView("index");
	}

    @PostMapping(path="/novaTask/", consumes = MediaType.APPLICATION_JSON_VALUE) 
    public @ResponseBody Task novaTask (@RequestBody Task task) {
        task.setDataCadastro(LocalDateTime.now());
        task.setExcluido('f');

        if (task.getStatus().equalsIgnoreCase("concluido")) {
            task.setConcluido('t');
        } else {
            task.setConcluido('f');
        }
        taskRepository.save(task);

        return task;
    }
    
    @GetMapping(path="/lista")
    public @ResponseBody Iterable<Task> lista() {
        return taskRepository.findAll();
    }

    @PutMapping(path ={"removeTask/{id}"})
    public ResponseEntity <Object> delete(@PathVariable Long id) {
        return taskRepository.findById(id)
                .map(task -> {
                    task.setDataRemovido(LocalDateTime.now());
                    task.setExcluido('t');
                    task.setDataAtualizacao(LocalDateTime.now());
                    taskRepository.save(task);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(value="atualizaTask/{id}")
    public ResponseEntity update(@RequestParam Long id, @RequestBody Task task) {
        return taskRepository.findById(id)
                .map(tasks -> {
                    tasks.setTitulo(task.getTitulo());
                    tasks.setStatus(task.getStatus());
                    tasks.setDataAtualizacao(LocalDateTime.now());
                    tasks.setConcluido(task.getConcluido());
                    tasks.setDescricao(task.getDescricao());
                    Task updated = taskRepository.save(tasks);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }
}
