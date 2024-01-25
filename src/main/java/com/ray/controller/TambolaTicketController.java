package com.ray.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ray.model.TambolaTicket;
import com.ray.service.TambolaTicketService;

@RestController
@RequestMapping("/api/tickets")
public class TambolaTicketController {
	private final TambolaTicketService ticketService;

	public TambolaTicketController(TambolaTicketService ticketService) {
		this.ticketService = ticketService;
	}

	@PostMapping("/generate/{numberOfSets}")
	public void generateTickets(@PathVariable int numberOfSets) {
		ticketService.generateTickets(numberOfSets);
	}

	@GetMapping
	public List<TambolaTicket> getAllTickets(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		return ticketService.getAllTickets(page, size);
	}
}
