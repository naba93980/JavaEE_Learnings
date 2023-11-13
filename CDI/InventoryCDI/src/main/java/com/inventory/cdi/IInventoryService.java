package com.inventory.cdi;

import java.io.Serializable;

public interface IInventoryService extends Serializable {
	
	public int createItem(int catalogItemId, int quantity );
	
	public int getInventory(int catalogItemId);
}
