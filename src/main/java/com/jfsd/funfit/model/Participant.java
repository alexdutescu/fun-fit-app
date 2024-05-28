package com.jfsd.funfit.model;

public class Participant {
	
	private int participantId;
	private String firstName;
	private int age;
	private String phoneNumber;
	private int batchId;
	
	public int getParticipantId() {
		return participantId;
	}
	public void setParticipantId(int participantId) {
		this.participantId = participantId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getBatchId() {
		return batchId;
	}
	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}
	public Participant() {}
	
	public Participant(int participantId, String firstName, int age, String phoneNumber, int batchId) {
		this.participantId = participantId;
		this.firstName = firstName;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.batchId = batchId;
	}
	
	@Override
	public String toString() {
		return "Participants [participantId=" + participantId + ", firstName=" + firstName + ", age=" + age
				+ ", phoneNumber=" + phoneNumber + ", batchId=" + batchId + "]";
	}
}
