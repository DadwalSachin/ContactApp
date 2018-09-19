package com.sachin.contact;

import com.sachin.contactStorage.ContactStorage;

public class ContactManipulation {

	public boolean addContact(Contact c1) {
	System.out.println("Added");
		return ContactStorage.listofContacts.add(c1);
	}

	public boolean removeContact(Contact c2) {
		System.out.println("Removed");
		return ContactStorage.listofContacts.remove(c2);

	}

	public boolean updateContact(Contact c3) {
		System.out.println("Updated");
		return ContactStorage.listofContacts.add(c3);
	}

	public Contact searchContact(String phno) {
		Contact cnt = null;
		for (Contact ct : ContactStorage.listofContacts) {
			if (ct.getPhNo()==phno ) {
				cnt = ct;
				break;
			}
			else
			{
				return cnt=null;
			}
		}
		//System.out.println("Searched");
		return cnt;
	}

	public void displayAllContacts() {
		System.out.println("-----------------------------------------------------");
		System.out.println("Name" + "\t" + "Mobile" + "\t" + "Email ");

		for (Contact ct : ContactStorage.listofContacts) {
			System.out.println(ct.getName() + "\t" + ct.getPhNo() + "\t" + ct.getEmail());
		}
		System.out.println("-----------------------------------------------------");
	}

}
