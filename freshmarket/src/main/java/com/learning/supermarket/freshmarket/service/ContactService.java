package com.learning.supermarket.freshmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.supermarket.freshmarket.entity.Contact;
import com.learning.supermarket.freshmarket.entity.Contact;
import com.learning.supermarket.freshmarket.repository.ContactRepository;

@Service
public class ContactService {

	@Autowired
	ContactRepository contactRepository;
	
	public Contact addContact(Contact contact) {
		Contact newContact = contactRepository.save(contact);
		return newContact;
	}
}
