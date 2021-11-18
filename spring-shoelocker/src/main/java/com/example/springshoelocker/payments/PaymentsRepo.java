package com.example.springshoelocker.payments;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface PaymentsRepo extends CrudRepository<PaymentsCommand, Long> {
}