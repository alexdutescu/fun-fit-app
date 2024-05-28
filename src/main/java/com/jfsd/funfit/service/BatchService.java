package com.jfsd.funfit.service;

import java.util.List;

import com.jfsd.funfit.dao.BatchDao;
import com.jfsd.funfit.model.Batch;

public class BatchService {
	
	public BatchService() {}
	
	public String addBatch(Batch batch) {
		return BatchDao.addBatch(batch) > 0 ? "Batch details added" : "Batch details didn't add"; 
	}

	public List<Batch> viewAllBatch(){
		return BatchDao.viewAllBatches();
	}

	public boolean deleteBatch(int batchid){
		return BatchDao.deleteBatch(batchid);
	}

	public Batch getBatch(int batchid){
		return BatchDao.getBatch(batchid);
	}
}
