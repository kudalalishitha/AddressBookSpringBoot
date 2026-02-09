package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.exception.IdNotFoundException;
import com.bridgelabz.addressbook.model.AddressBook;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class AddressBookService implements IAddressBookService {

    // UC3 -> store data in memory using List
    private final List<AddressBook> addressBookList = new ArrayList<>();
    private final AtomicInteger idCounter = new AtomicInteger(0);

    // UC1
    @Override
    public String getWelcomeMessage() {
        return "Welcome to Address Book App";
    }

    // UC2 - GET all
    @Override
    public List<AddressBook> getAllContacts() {
        return addressBookList;
    }

    // UC2 - GET by ID
    @Override
    public AddressBook getContactById(int id) {
        return addressBookList.stream()
                .filter(contact -> contact.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IdNotFoundException("Contact not found with id: " + id));
    }

    // UC2 - POST
    @Override
    public AddressBook createContact(AddressBookDTO dto) {
        int newId = idCounter.incrementAndGet();
        AddressBook contact = new AddressBook(newId, dto);
        addressBookList.add(contact);
        return contact;
    }

    // UC2 - PUT
    @Override
    public AddressBook updateContact(int id, AddressBookDTO dto) {
        AddressBook existing = getContactById(id);

        existing.setFirstName(dto.getFirstName());
        existing.setLastName(dto.getLastName());
        existing.setCity(dto.getCity());
        existing.setState(dto.getState());
        existing.setPhoneNumber(dto.getPhoneNumber());

        return existing;
    }

    // UC2 - DELETE
    @Override
    public String deleteContact(int id) {
        AddressBook existing = getContactById(id);
        addressBookList.remove(existing);
        return "Contact deleted successfully with id: " + id;
    }
}
