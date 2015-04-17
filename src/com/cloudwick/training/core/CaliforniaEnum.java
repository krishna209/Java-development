package com.cloudwick.training.core;


public enum CaliforniaEnum {

	WINTER(11, "2000"), SUMMER(22, "3000"), FALL(13, "6000");
	private int id;
	private String pay;

	private CaliforniaEnum(int id, String pay) {
		this.id = id;
		this.pay = pay;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the pay
	 */
	public String getPay() {
		return pay;
	}

	/**
	 * @param pay the pay to set
	 */
	public void setPay(String pay) {
		this.pay = pay;
	}

}
