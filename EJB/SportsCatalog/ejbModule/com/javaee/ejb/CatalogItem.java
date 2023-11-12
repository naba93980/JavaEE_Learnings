package com.javaee.ejb;

public class CatalogItem {

	private Long itemId;

	private String name;

	private String manufacturer;

	public CatalogItem() {

	}

	public CatalogItem(Long itemId, String name, String manufacturer) {
		super();
		this.itemId = itemId;
		this.name = name;
		this.manufacturer = manufacturer;

	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
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
