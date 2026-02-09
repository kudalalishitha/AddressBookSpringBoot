package com.bridgelabz.addressbook.model;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import lombok.Data;

@Data
public class AddressBook {

    private int id;
    private String firstName;
    private String lastName;
    private String city;
    private String state;
    private String phoneNumber;

    public AddressBook() {
    }

    public AddressBook(int id, AddressBookDTO dto) {
        this.id = id;
        this.firstName = dto.getFirstName();
        this.lastName = dto.getLastName();
        this.city = dto.getCity();
        this.state = dto.getState();
        this.phoneNumber = dto.getPhoneNumber();
    }
}
