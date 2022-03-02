import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.ListDetailsHelper;
import model.Address;
import model.ListDetails;
import model.User;

/**
 * @author dynob - tjmendenhall2@dmacc.edu
 * CIS175 - Fall 2021
 * Mar 1, 2022
 */
public class ListDetailsTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User michael = new User("Michael");

		Address address1 = new Address("Bill", "303", "S Roche", "Knoxville", "IA", "50138");
		Address address2 = new Address("Work", "1650", "Washington", "Pella", "IA", "50219");

		List<Address> michaelsAddresses = new ArrayList<Address>();
		michaelsAddresses.add(address1);
		michaelsAddresses.add(address2);

		ListDetailsHelper ldh = new ListDetailsHelper();
		ListDetails michaelList = new ListDetails("Michael's List", LocalDate.now(), michael);
		michaelList.setListOfAddresses(michaelsAddresses);

		ldh.insertNewListDetails(michaelList);

		List<ListDetails> allLists = ldh.getLists();

		for (ListDetails a : allLists) {
			System.out.println(a.toString());
		}
	}

}
