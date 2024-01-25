package com.ray.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ray.model.TambolaTicket;

@Repository
public interface TambolaTicketRepository extends JpaRepository<TambolaTicket, Long> {
	
}
