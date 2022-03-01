package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Address;

/**
 * Servlet implementation class AddAddressServlet
 */
@WebServlet("/addAddressServlet")
public class AddAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAddressServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String owner = request.getParameter("owner");
		String bn = request.getParameter("bn");
		String an = request.getParameter("an");
		String sn = request.getParameter("sn");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zip = request.getParameter("zip");
		
		if (owner.isEmpty() || bn.isEmpty() || sn.isEmpty() || city.isEmpty() || state.isEmpty() || zip.isEmpty() ||owner == null || bn == null || sn == null || city == null || state == null || zip == null) {
			getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		} else {
			if (an.isEmpty() || an == null) {
				Address a = new Address(owner, bn, sn, city, state, zip);
				AddressHelper dao = new AddressHelper();
				dao.insertAddress(a);
				
				getServletContext().getRequestDispatcher("/index.html").forward(request, response);
			} else {
				Address a = new Address(owner, bn, an, sn, city, state, zip);
				AddressHelper dao = new AddressHelper();
				dao.insertAddress(a);
				
				getServletContext().getRequestDispatcher("/index.html").forward(request, response);
			}
		}
	}
}
