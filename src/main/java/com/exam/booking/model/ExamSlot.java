package com.exam.booking.model;

import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.Size;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "exam_slot")
public class ExamSlot {
	
	@Id
	@GeneratedValue
	@Column(name = "SLT_ID")
	int slotId;
	
	@Column(name = "EX_DATE")
	String date;
	
	@Column(name = "EX_TIME")
	String time;
	
	@Size(min=2)
	@Column(name = "EX_PGM")
	String programme;
	
	@Column(name = "IS_AVL")
	boolean isSlotAvailable;
	
	@Column(name = "SLT_CTR")
	int slotCounter;

	@Column(name = "SUB_CD")
	String subjectCode;
	public int getSlotId() {
		return slotId;
	}



	public void setSlotId(int slotId) {
		this.slotId = slotId;
	}
	
	
	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public String getTime() {
		return time;
	}



	public void setTime(String time) {
		this.time = time;
	}



	public String getProgramme() {
		return programme;
	}



	public void setProgramme(String programme) {
		this.programme = programme;
	}



	public boolean isSlotAvailable() {
		return isSlotAvailable;
	}



	public void setSlotAvailable(boolean isSlotAvailable) {
		this.isSlotAvailable = isSlotAvailable;
	}



	public int getSlotCounter() {
		return slotCounter;
	}



	public void setSlotCounter(int slotCounter) {
		this.slotCounter = slotCounter;
	}





	public String getSubjectCode() {
		return subjectCode;
	}



	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}



	public ExamSlot(int slotId, @Future String date, String time, @Size(min = 2) String programme,
			boolean isSlotAvailable, int slotCounter, String subjectCode) {
		super();
		this.slotId = slotId;
		this.date = date;
		this.time = time;
		this.programme = programme;
		this.isSlotAvailable = isSlotAvailable;
		this.slotCounter = slotCounter;
		this.subjectCode = subjectCode;
	}



	public ExamSlot(int slotId , String date) {
		super();
		this.slotId = slotId;
		this.date = date;
	}
	
	public ExamSlot() {
		super();
		
	}



	@Override
	public String toString() {
		return "ExamSlot [slotId=" + slotId + ", date=" + date + ", time=" + time + ", programme=" + programme
				+ ", isSlotAvailable=" + isSlotAvailable + ", slotCounter=" + slotCounter + ", subjectCode="
				+ subjectCode + "]";
	}


	
}
