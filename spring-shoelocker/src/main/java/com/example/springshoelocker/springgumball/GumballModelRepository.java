package com.example.springshoelocker.springgumball;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface GumballModelRepository extends CrudRepository<GumballModel, Integer>{

    List<GumballModel> findBySerialNumber(String serialNumber);

   
}

