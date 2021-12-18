package com.example.springmysql;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springmysql.PaymentsCommand;

interface PaymentsCommandRepository extends JpaRepository<PaymentsCommand,Long> {

}