package com.inventory.cdi;


public class InventoryItem {
	
	private int itemId;

	private int catalogItemId;
	
	private int quantity;

	public InventoryItem() {

	}

	public InventoryItem(int itemId, int catalogItemId, int quantity ) {
		super();
		this.itemId = itemId;
		this.catalogItemId = catalogItemId;
		this.quantity = quantity;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getCatalogItemId() {
		return catalogItemId;
	}

	public void setCatalogItemId(int catalogItemId) {
		this.catalogItemId = catalogItemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "CatalogItem [itemId=" + itemId + ", quanity=" + quantity + ", catalogItemId=" + catalogItemId + "]";
	}

}
