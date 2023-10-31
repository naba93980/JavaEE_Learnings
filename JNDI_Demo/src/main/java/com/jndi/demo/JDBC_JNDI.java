package com.jndi.demo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/")
public class JDBC_JNDI extends HttpServlet {

	private static final long serialVersionUID = 1657675675637576L;
	private Connection connection;
	public static DataSource dataSource;
	public static String JNDI_LOOKUP_SERVICE = "java:comp/env/jdbc/MyDBPool";

	public static DataSource getDataSource() {
		return dataSource;
	}

	@Override
	public void init() throws ServletException {
		try {
			InitialContext context = new InitialContext();
			Object lookup = context.lookup(JNDI_LOOKUP_SERVICE);
			if (lookup != null) {
				dataSource = (DataSource) lookup;
			}
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			connection = JDBC_JNDI.getDataSource().getConnection();
			Statement statement = connection.createStatement();
			String command = String.format("SELECT * FROM user");
			ResultSet result = statement.executeQuery(command);

			while (result.next()) {
				String firstName = result.getString(1);
				String secondName = result.getString(2);
				String email = result.getString(3);
				String password = result.getString(4);
				response.getWriter().println(firstName + " " + secondName + " " + " " + email + " " + password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void destroy() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
