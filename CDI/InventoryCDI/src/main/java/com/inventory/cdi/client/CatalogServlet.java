package com.inventory.cdi.client;

import java.io.IOException;

import com.inventory.cdi.CatalogItem;
import com.inventory.cdi.IInventoryService;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CatalogServlet extends HttpServlet {

	private static final long serialVersionUID = 8094765542176555872L;

	
	// CDI
	
	@Inject
	private IInventoryService inventoryService;

	@Inject
	private CatalogItem item;

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int inventory = this.inventoryService.getInventory(Integer.valueOf(request.getParameter("id")));
		response.getWriter().println(inventory);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.valueOf(request.getParameter("itemId"));
		String name = request.getParameter("name");
		String manufacturer = request.getParameter("manufacturer");
		
		item.setItemId(id);
		item.setName(name);
		item.setManufacturer(manufacturer);
		
		int number = this.inventoryService.createItem(this.item.getItemId(), 4);
		response.getWriter().println(number);

	}
}


// for every new session a item bean is injected, and that bean is used to add to inventory which is a bean scoped over the app
