package com.storepoints.dto;

import java.io.Serializable;
import java.util.List;

public class Stores  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3321195266926483375L;

	private String _rev;
	private String title;
	private List<Store> storeList;

	public String get_rev() {
		return _rev;
	}
	public void set_rev(String _rev) {
		this._rev = _rev;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Store> getStoreList() {
		return storeList;
	}
	public void setStoreList(List<Store> storeList) {
		this.storeList = storeList;
	}

}
