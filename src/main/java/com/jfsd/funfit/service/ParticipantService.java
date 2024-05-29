package com.jfsd.funfit.service;

import java.util.List;
import com.jfsd.funfit.model.Participant;
import com.jfsd.funfit.dao.ParticipantDao;

public class ParticipantService {

	public String addParticipant(Participant participant) {
		return ParticipantDao.addParticipant(participant) > 0 ? "Participants details added successfully" : "Participants details didn't add";
	}

	public List<Participant> viewAllParticipants() {
		return ParticipantDao.viewAllParticipants();
	}

	public boolean deleteParticipant(int participantid) {
		return ParticipantDao.deleteParticipant(participantid);
	}

	public Participant getParticipant(int participantid) {
		return ParticipantDao.getParticipant(participantid);
	}

	public int updateParticipant(Participant participant) {
		return ParticipantDao.updateParticipant(participant);
	}
}
