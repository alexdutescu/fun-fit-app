package com.jfsd.funfit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jfsd.funfit.model.Batch;
import static com.jfsd.funfit.resource.DbResource.*;


public class BatchDao {

	public static int addBatch(Batch batch) {
		try {
			Connection con = GetResource().getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("insert into batch(type_of_batch,time) values(?,?)");
			pstmt.setString(1, batch.getTypeOfBatch());
			pstmt.setString(2, batch.getTime());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}

	public static List<Batch> viewAllBatches() {
		List<Batch> listOfBatch = new ArrayList<>();
		try {
			Connection con = GetResource().getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from batch");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Batch b = new Batch();
				b.setBatchId(rs.getInt(1));
				b.setTypeOfBatch(rs.getString(2));
				b.setTime(rs.getString(3));
				listOfBatch.add(b);
			}
		} catch (Exception e) {
			System.err.println(e);
		}	
		return listOfBatch;
	}

	public static boolean deleteBatch(int batchid) {
		try {
			Connection con = GetResource().getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("delete from batch where batch_id = ?");
			pstmt.setInt(1,  batchid);
			return pstmt.execute();
		} catch (Exception e) {
			System.err.println(e);
			return false;
		}
	}

	public static Batch getBatch(int batchid) {
		Batch result = new Batch();
		try {
			Connection con = GetResource().getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from batch where batch_id = ?");
			pstmt.setInt(1,  batchid);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				result.setBatchId(rs.getInt(1));
				result.setTypeOfBatch(rs.getString(2));
				result.setTime(rs.getString(3));
			}
		} catch (Exception e) {
			System.err.println(e);
		}	
		return result;
	}
}