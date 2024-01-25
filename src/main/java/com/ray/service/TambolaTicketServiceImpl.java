package com.ray.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.ray.model.TambolaTicket;
import com.ray.repository.TambolaTicketRepository;

@Service
public class TambolaTicketServiceImpl implements TambolaTicketService {
	private final TambolaTicketRepository ticketRepository;

	public TambolaTicketServiceImpl(TambolaTicketRepository ticketRepository) {
		this.ticketRepository = ticketRepository;
	}

	@Override
	public List<TambolaTicket> generateTickets(int numberOfSets) {
		List<TambolaTicket> generatedTickets = new ArrayList<>();

		for (int set = 0; set < numberOfSets; set++) {
			for (int ticketInSet = 0; ticketInSet < 6; ticketInSet++) {
				TambolaTicket ticket = new TambolaTicket();
				int[][] ticketNumbers = generateTicketNumbers();
				ticket.setNumbers(ticketNumbers);
				generatedTickets.add(ticket);
				ticketRepository.save(ticket);
			}
		}

		return generatedTickets;
	}

	@Override
	public List<TambolaTicket> getAllTickets(int page, int size) {
		// Implement pagination logic using Spring Data JPA
		// For simplicity, we'll use findAll() for now
		return ticketRepository.findAll();
	}

	private int[][] generateTicketNumbers() {
		int[][] ticketNumbers = new int[3][9];
		Random random = new Random();

		// Generate unique numbers for each column
		for (int col = 0; col < 9; col++) {
			List<Integer> columnNumbers = new ArrayList<>();
			for (int row = 0; row < 3; row++) {
				int number;
				do {
					number = (col * 10) + random.nextInt(10) + 1;
				} while (columnNumbers.contains(number));

				columnNumbers.add(number);
				ticketNumbers[row][col] = number;
			}
		}

		return ticketNumbers;
	}
}
