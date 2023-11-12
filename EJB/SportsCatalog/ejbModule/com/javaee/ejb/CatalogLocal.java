package com.javaee.ejb;

import java.util.List;

import jakarta.ejb.Local;

@Local
public interface CatalogLocal {

	public List<CatalogItem> getItems();

	public void addItem(CatalogItem item);
}
