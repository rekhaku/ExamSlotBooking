package com.exam.booking.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.booking.model.ExamSlot;
import com.exam.booking.repository.ExamSlotRepository;


@Service
public class ExamSlotDAOService  {
	private static List<ExamSlot> examSlots = new ArrayList<>();
	
	@Autowired
	private ExamSlotRepository examSlotRepository;
	
	
	public List<ExamSlot> findAll()
	{
		examSlotRepository.findAll().forEach(examSlots::add);
		return examSlots;
	}


	public List<ExamSlot> findByDate(String date) {
		
		return examSlotRepository.findByDate(date);
	}


	public List<ExamSlot> findByDateAndTime(String date,String time) {
		return examSlotRepository.findByDateAndTime(date,time);
	}


	public List<ExamSlot> getSlotsAvailableForDate(String date) {
		return examSlotRepository.findByDateAndIsSlotAvailable(date,true);
	}


	public List<ExamSlot> getSlotsAvailableForSubject(String subject) {
		return examSlotRepository.findBySubjectCodeAndIsSlotAvailable(subject,true);
	}


	@SuppressWarnings("finally")
	public ExamSlot addSlots(ExamSlot examSlot) {
		try {
			examSlot = examSlotRepository.save(examSlot);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			return examSlot;
		}
	}


	public List <ExamSlot> updateSlotsForDate( ExamSlot examSlot,String date) {
			List <ExamSlot> examSlotsForDate = examSlotRepository.findByDate(date);
			examSlotsForDate.forEach(s-> updateSlot(s,examSlot));
			examSlotRepository.saveAll(examSlotsForDate);
			return examSlotsForDate;
		
	}
	
	private void updateSlot(ExamSlot slot , ExamSlot slotUpdated)
	{
		slot.setDate(slotUpdated.getDate());
		slot.setTime(slotUpdated.getTime());
		slot.setSubjectCode(slotUpdated.getSubjectCode());
		slot.setSlotCounter(slotUpdated.getSlotCounter());
		slot.setProgramme(slotUpdated.getProgramme());
	}


	public ExamSlot updateSlots(ExamSlot examSlot) {
		ExamSlot examSlotRetrieved = examSlotRepository.findBySlotId(examSlot.getSlotId());
		updateSlot(examSlotRetrieved,examSlot );
		examSlotRepository.save(examSlotRetrieved);
		return examSlotRetrieved;
	}


	
}
