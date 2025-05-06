package com.example.bookservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository  // 👈 Optional but safe to force detection
public interface BookRepository extends JpaRepository<Book, Long> {}

