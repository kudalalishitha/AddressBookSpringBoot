package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.model.AddressBook;

import java.util.List;

public interface IAddressBookService {

    // UC1
    String getWelcomeMessage();

    // UC2 + UC3
    List<AddressBook> getAllContacts();

    AddressBook getContactById(int id);

    AddressBook createContact(AddressBookDTO dto);

    AddressBook updateContact(int id, AddressBookDTO dto);

    String deleteContact(int id);
}
