package com.jfsd.funfit.model;

public class Batch {
	private int batchId;
	private String typeOfBatch;
	private String time;
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getBatchId() {
		return batchId;
	}
	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}
	public String getTypeOfBatch() {
		return typeOfBatch;
	}
	public void setTypeOfBatch(String typeOfBatch) {
		this.typeOfBatch = typeOfBatch;
	}
	
	public Batch() {}
	
	public Batch(int batchId, String typeOfBatch, String time) {
		this.batchId = batchId;
		this.typeOfBatch = typeOfBatch;
		this.time = time;
	}
	
	@Override
	public String toString() {
		return "Batch [batchId=" + batchId + ", typeOfBatch=" + typeOfBatch + ", time=" + time + "]";
	}
}
