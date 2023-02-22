package com.example.learningspring.repository;

import com.example.learningspring.model.TacoOrder;
import org.springframework.data.repository.CrudRepository;


public interface OrderRepository extends CrudRepository<TacoOrder,Long> {


}
