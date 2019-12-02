package com.yh.bean;

public class patient_treatment {

	private String tdate;
	
	private int tfreq;
	
	private String tstatus;
	
	private int pid;
	
	private int tid;
	
	private int phid;

	public String getTdate() {
		return tdate;
	}

	public void setTdate(String tdate) {
		this.tdate = tdate;
	}

	public int getTfreq() {
		return tfreq;
	}

	public void setTfreq(int tfreq) {
		this.tfreq = tfreq;
	}

	public String getTstatus() {
		return tstatus;
	}

	public void setTstatus(String tstatus) {
		this.tstatus = tstatus;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public int getPhid() {
		return phid;
	}

	public void setPhid(int phid) {
		this.phid = phid;
	}
}
