package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Address;
import model.ListDetails;
import model.User;

/**
 * Servlet implementation class EditListDetailsServlet
 */
@WebServlet("/editListDetailsServlet")
public class EditListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditListDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ListDetailsHelper dao = new ListDetailsHelper();
		AddressHelper lih = new AddressHelper();
		UserHelper sh = new UserHelper();
		
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		ListDetails listToUpdate = dao.searchForListDetailsById(tempId);

		String newListName = request.getParameter("listName");

		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		
		String userName = request.getParameter("userName");
		//find our add the new shopper
		User newUser = sh.findUser(userName);

		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}

		try {
			//items are selected in list to add
			String[] selectedAddresses = request.getParameterValues("allAddressesToAdd");
			List<Address> selectedAddressesInList = new ArrayList<Address>();

			for (int i = 0; i < selectedAddresses.length; i++) {
				System.out.println(selectedAddresses[i]);
				Address c = lih.searchForAddressById(Integer.parseInt(selectedAddresses[i]));
				selectedAddressesInList.add(c);

			}
			listToUpdate.setListOfAddresses(selectedAddressesInList);
		} catch (NullPointerException ex) {
			// no items selected in list - set to an empty list
			List<Address> selectedAddressesInList = new ArrayList<Address>();
			listToUpdate.setListOfAddresses(selectedAddressesInList);
		}

		listToUpdate.setListName(newListName);
		listToUpdate.setDateCreated(ld);
		listToUpdate.setUser(newUser);

		dao.updateList(listToUpdate);

		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

}
