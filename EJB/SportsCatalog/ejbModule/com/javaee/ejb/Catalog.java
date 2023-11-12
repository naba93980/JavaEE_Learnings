package com.javaee.ejb;

import java.util.ArrayList;
import java.util.List;

import jakarta.ejb.Singleton;

@Singleton
public class Catalog implements CatalogLocal {

	private List<CatalogItem> items = new ArrayList<CatalogItem>();

	public Catalog() {
		this.items.add(new CatalogItem((long) 2367, "jeans", "toshima"));
	}

	@Override
	public List<CatalogItem> getItems() {
		return this.items;
	}

	@Override
	public void addItem(CatalogItem item) {
		this.items.add(item);
	}

}
