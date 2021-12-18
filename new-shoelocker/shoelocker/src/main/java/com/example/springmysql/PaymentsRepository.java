package com.example.springmysql;


import org.springframework.data.jpa.repository.JpaRepository;

interface PaymentsRepository extends JpaRepository<PaymentsCommand, Long> {


}