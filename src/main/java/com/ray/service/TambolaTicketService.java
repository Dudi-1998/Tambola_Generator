package com.ray.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ray.model.TambolaTicket;

@Service
public interface TambolaTicketService {
 List<TambolaTicket> generateTickets(int numberOfSets);

 List<TambolaTicket> getAllTickets(int page, int size);
}

