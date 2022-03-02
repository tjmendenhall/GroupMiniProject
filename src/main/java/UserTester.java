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
public class UserTester {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User taylor = new User("Taylor");
		
		ListDetailsHelper ldh = new ListDetailsHelper();
		
		Address dad = new Address("Dad", "303", "S Roche", "Knoxville", "IA", "50138");
		Address michael = new Address("Michael", "434", "10th Ave", "Pella", "IA", "50219");
		
		List<Address> taylorsAddresses = new ArrayList<Address>();
		
		taylorsAddresses.add(dad);
		taylorsAddresses.add(michael);
		
		ListDetails taylorsList = new ListDetails("Taylor's List", LocalDate.now(), taylor);
		taylorsList.setListOfAddresses(taylorsAddresses);
		
		ldh.insertNewListDetails(taylorsList);
		List<ListDetails> allLists = ldh.getLists();
		for (ListDetails a : allLists) {
			System.out.println(a.toString());
		}

	}
}
