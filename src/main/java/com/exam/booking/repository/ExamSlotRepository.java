package com.exam.booking.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.exam.booking.model.ExamSlot;

@Repository
@Transactional(propagation = Propagation.NEVER)
public interface ExamSlotRepository extends JpaRepository<ExamSlot, Integer> {

	List<ExamSlot> findByDate(String date);

	List<ExamSlot> findByDateAndTime(String date, String time);

	List<ExamSlot> findByDateAndIsSlotAvailable(String date, boolean isSlotAvailable);

	List<ExamSlot> findBySubjectCodeAndIsSlotAvailable(String subjectCode, boolean isSlotAvailable);

	ExamSlot findBySlotId(int slotId);

}
