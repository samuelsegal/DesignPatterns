package com.sms.sandbox.generics;

public class Bin<DRY, WET> {
	private DRY dryTrash;
	private WET wetTrash;
	public Bin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bin(DRY dryTrash, WET wetTrash) {
		super();
		this.dryTrash = dryTrash;
		this.wetTrash = wetTrash;
	}
	public DRY getDryTrash() {
		return dryTrash;
	}
	public void setDryTrash(DRY dryTrash) {
		this.dryTrash = dryTrash;
	}
	public WET getWetTrash() {
		return wetTrash;
	}
	public void setWetTrash(WET wetTrash) {
		this.wetTrash = wetTrash;
	}
	
	
}
