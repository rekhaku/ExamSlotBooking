package com.exam.booking.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.booking.model.ExamSlot;
import com.exam.booking.repository.ExamSlotRepository;
import com.exam.booking.service.ExamSlotDAOService;

@RestController
public class ExamSlotController {

	@Autowired
	private ExamSlotDAOService examSlotDAOService;

	/**
	 * Fetches all exam slots available
	 * 
	 * @return List of Examslot
	 */
	@GetMapping("/examSlots/")
	public List<ExamSlot> getAllSlots() {
		return examSlotDAOService.findAll();
	}

	/**
	 * Accepts date and fetches all exam slots available for the date
	 * 
	 * @param date
	 * @return List of ExamSlot
	 */
	@GetMapping("/examSlots/{date}")
	public List<ExamSlot> getAllSlotsForDate(@PathVariable String date) {
		return examSlotDAOService.findByDate(date);
	}

	/**
	 * Accepts date and time and fetches all exam slots available for the date and
	 * time
	 * 
	 * @param date
	 * @param time
	 * @return List of ExamSlot
	 */
	@GetMapping("/examSlots/{date}/{time}")
	public List<ExamSlot> getAllSlotsForDateAndTime(@PathVariable String date, @PathVariable String time) {
		return examSlotDAOService.findByDateAndTime(date, time);
	}

	@GetMapping("/examSlotsAvailable/{date}")
	public List<ExamSlot> getAllAvailableSlotsForDate(@PathVariable String date) {
		return examSlotDAOService.getSlotsAvailableForDate(date);
	}

	@GetMapping("/examSlotsAvailable/{subject}")
	public List<ExamSlot> getAllAvailableSlotsForSubject(@PathVariable String subject) {
		return examSlotDAOService.getSlotsAvailableForSubject(subject);
	}

	@PostMapping("/examSlots")
	public ResponseEntity<ExamSlot> addSlots(@RequestBody ExamSlot examSlot) {
		examSlot = examSlotDAOService.addSlots(examSlot);
		return ResponseEntity.ok().body(examSlot);
	}

	@PutMapping("/examSlots/{date}")
	public List<ExamSlot> updateSlotsForDate(@RequestBody ExamSlot examSlot, @PathVariable String date) {
		return examSlotDAOService.updateSlotsForDate(examSlot, date);
	}

	@PutMapping("/examSlots")
	public ExamSlot updateSlot(@RequestBody ExamSlot examSlot) {
		return examSlotDAOService.updateSlots(examSlot);
	}

}
