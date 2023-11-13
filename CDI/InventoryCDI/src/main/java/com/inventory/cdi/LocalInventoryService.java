package com.inventory.cdi;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped // bean is scoped over the entire app
public class LocalInventoryService implements IInventoryService{
	
	private static final long serialVersionUID = 1L;
	
	Map<Integer, InventoryItem> items = new HashMap<Integer, InventoryItem>();

	@Override
	public int createItem(int catalogItemId, int quantity) {
		
		for(InventoryItem item: this.items.values()) {
			if(item.getCatalogItemId()==catalogItemId) {
				item.setQuantity(item.getQuantity()+1);
				this.printInventory();
				return item.getQuantity();
			}
		}
		
		int inventoryItemId = items.size()+1;
		InventoryItem inventoryItem = new InventoryItem(inventoryItemId, catalogItemId, quantity);
		items.put(inventoryItemId, inventoryItem );
		this.printInventory();
		return inventoryItem.getQuantity();
	}

	private void printInventory() {
		System.out.println("Local inventory contains : ");
		for (Entry<Integer, InventoryItem> item : this.items.entrySet()) {
			System.out.println(item);
		}
	}

	@Override
	public int getInventory(int catalogItemId) {
		
		for(InventoryItem item: this.items.values()) {
			if(item.getCatalogItemId()==catalogItemId) {
				return item.getQuantity();
			}
		}
		return 0;
	}
}
