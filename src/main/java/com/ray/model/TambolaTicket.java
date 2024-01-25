package com.ray.model;

import java.util.Arrays;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tambola_tickets")
public class TambolaTicket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// Represents a 3x9 matrix for Tambola Ticket
	private int[][] numbers;

	public TambolaTicket(Long id, int[][] numbers) {
		super();
		this.id = id;
		this.numbers = numbers;
	}

	@Override
	public String toString() {
		return "TambolaTicket [id=" + id + ", numbers=" + Arrays.toString(numbers) + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TambolaTicket() {
		super();
	}

	public int[][] getNumbers() {
		return numbers;
	}

	public void setNumbers(int[][] numbers) {
		this.numbers = numbers;
	}
}
