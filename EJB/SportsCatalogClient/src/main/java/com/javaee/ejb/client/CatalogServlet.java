package com.javaee.ejb.client;

import java.io.IOException;
import java.util.List;

import com.javaee.ejb.CatalogItem;
import com.javaee.ejb.CatalogLocal;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/catalogServlet")
public class CatalogServlet extends HttpServlet {

	private static final long serialVersionUID = 8094765542176555872L;

	@EJB
	private CatalogLocal catalogBean;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<CatalogItem> items = this.catalogBean.getItems();
		for (CatalogItem catalogItem : items) {
			response.getWriter().println(catalogItem);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long id = Long.valueOf(request.getParameter("itemId"));
		String name = request.getParameter("name");
		String manufacturer = request.getParameter("manufacturer");

		this.catalogBean.addItem(new CatalogItem(id, name, manufacturer));
	}
}
