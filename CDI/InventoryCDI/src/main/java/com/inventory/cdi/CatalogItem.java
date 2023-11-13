package com.inventory.cdi;

import java.io.Serializable;

import jakarta.enterprise.context.SessionScoped;

@SessionScoped // bean is scoped over a session
public class CatalogItem implements Serializable{

	private int itemId;

	private String name;

	private String manufacturer;

	public CatalogItem() {

	}

	public CatalogItem(int itemId, String name, String manufacturer) {
		super();
		this.itemId = itemId;
		this.name = name;
		this.manufacturer = manufacturer;

	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	@Override
	public String toString() {
		return "CatalogItem [itemId=" + itemId + ", name=" + name + ", manufacturer=" + manufacturer + "]";
	}

}
