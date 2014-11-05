package com.zli.todo.repository;

import com.zli.todo.model.Task;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "task", path = "task")
public interface TaskRepository extends UserOwnedRepository<Task, String> {

   public List<Task> findByComplete(@Param("complete") boolean complete);
}
