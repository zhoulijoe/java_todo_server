package com.zli.todo.repository;

import com.zli.todo.model.Task;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends UserOwnedRepository<Task, String> {

   public List<Task> findByComplete(@Param("complete") boolean complete);
}
