package com.zli.todo.repository;

import com.zli.todo.model.UserOwned;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
public interface UserOwnedRepository<T extends UserOwned, ID extends Serializable> extends MongoRepository<T, ID> {

   public List<T> findByUserId(@Param("userId") String userId);
}
