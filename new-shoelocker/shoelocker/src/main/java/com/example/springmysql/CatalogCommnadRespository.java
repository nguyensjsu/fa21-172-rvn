package com.example.springmysql;

import org.springframework.data.jpa.repository.JpaRepository;

interface CatalogCommandRepository extends JpaRepository<Catalog, Long> {
    
}