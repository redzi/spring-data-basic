package com.example.spring.test.demo.repository;

import com.example.spring.test.demo.model.User;
import com.example.spring.test.demo.model.UserId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, UserId>
{
}
