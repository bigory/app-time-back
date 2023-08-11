package com.example.demo.repository;

import com.example.demo.entity.Time;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeRepository extends CrudRepository<Time, Integer> {

}
