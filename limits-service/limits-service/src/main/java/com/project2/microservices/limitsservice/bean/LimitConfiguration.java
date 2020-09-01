package com.project2.microservices.limitsservice.bean;

public class LimitConfiguration {
	private int maximun;
	private int minimum;
	
	protected LimitConfiguration() {
		
	}
	
	public LimitConfiguration(int maximun, int minimum) {
		super();
		this.maximun = maximun;
		this.minimum = minimum;
	}
	
	public int getMaximun() {
		return maximun;
	}
	public void setMaximun(int maximun) {
		this.maximun = maximun;
	}
	public int getMinimum() {
		return minimum;
	}
	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}
	
}
