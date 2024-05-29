package com.jfsd.funfit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jfsd.funfit.model.Participant;
import static com.jfsd.funfit.resource.DbResource.*;

public class ParticipantDao {

	public static int addParticipant(Participant participant) {
		try {
			Connection con = GetResource().getDbConnection();

			PreparedStatement pstmt = con.prepareStatement("insert into participants(first_name,age,phone_number,batch_id) values(?,?,?,?);");
			pstmt.setString(1, participant.getFirstName());
			pstmt.setInt(2, participant.getAge());
			pstmt.setString(3, participant.getPhoneNumber());
			pstmt.setInt(4, participant.getBatchId());

			return pstmt.executeUpdate();
		} catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}

	public static List<Participant> viewAllParticipants() {
		List<Participant> listOfParticipats = new ArrayList<>();
		try {
			Connection con = GetResource().getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from participants");
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				Participant p = new Participant();
				p.setParticipantId(rs.getInt(1));
				p.setFirstName(rs.getString(2));
				p.setAge(rs.getInt(3));
				p.setPhoneNumber(rs.getString(4));
				p.setBatchId(rs.getInt(5));
				listOfParticipats.add(p);
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return listOfParticipats;
	}

	public static boolean deleteParticipant(int participantId) {
		try {
			Connection con = GetResource().getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("delete from participants where participant_id = ?");
			pstmt.setInt(1,  participantId);
			return pstmt.execute();
		} catch (Exception e) {
			System.err.println(e);
			return false;
		}
	}

	public static Participant getParticipant(int participantid) {
		Participant participant = new Participant();
		try {
			Connection con = GetResource().getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from participants where participant_id = ?");
			pstmt.setInt(1,  participantid);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				participant.setParticipantId(rs.getInt(1));
				participant.setFirstName(rs.getString(2));
				participant.setAge(rs.getInt(3));
				participant.setPhoneNumber(rs.getString(4));
				participant.setBatchId(rs.getInt(5));

			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return participant;
	}

	public static int updateParticipant(Participant participant) {
		try {
			Connection con = GetResource().getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("update participants set first_name = ?, age = ?, phone_number = ?, batch_id = ? where participant_id = ?");
			pstmt.setString(1,  participant.getFirstName());
			pstmt.setInt(2, participant.getAge());
			pstmt.setString(3, participant.getPhoneNumber());
			pstmt.setInt(4,  participant.getBatchId());
			pstmt.setInt(5, participant.getParticipantId());
			
			return pstmt.executeUpdate();
		} catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}

}