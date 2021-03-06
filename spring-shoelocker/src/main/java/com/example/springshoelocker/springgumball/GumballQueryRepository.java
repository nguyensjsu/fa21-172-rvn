package com.example.springshoelocker.springgumball;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface GumballQueryRepository extends JpaRepository<GumballModel, Integer>{
  
}
