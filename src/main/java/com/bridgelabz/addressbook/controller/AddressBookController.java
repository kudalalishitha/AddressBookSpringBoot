package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.dto.ResponseDTO;
import com.bridgelabz.addressbook.model.AddressBook;
import com.bridgelabz.addressbook.service.IAddressBookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private IAddressBookService addressBookService;

    // UC1
    @GetMapping("/welcome")
    public ResponseEntity<ResponseDTO> getWelcomeMessage() {
        ResponseDTO responseDTO = new ResponseDTO("Welcome Message", addressBookService.getWelcomeMessage());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // UC2 + UC3 - GET ALL
    @GetMapping("/get")
    public ResponseEntity<ResponseDTO> getAllContacts() {
        List<AddressBook> contacts = addressBookService.getAllContacts();
        ResponseDTO responseDTO = new ResponseDTO("Get Call Successful", contacts);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // UC2 + UC3 - GET BY ID
    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDTO> getContactById(@PathVariable int id) {
        AddressBook contact = addressBookService.getContactById(id);
        ResponseDTO responseDTO = new ResponseDTO("Get Call Successful", contact);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // UC2 + UC3 - POST
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createContact(@Valid @RequestBody AddressBookDTO dto) {
        AddressBook contact = addressBookService.createContact(dto);
        ResponseDTO responseDTO = new ResponseDTO("Created Contact Successfully", contact);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    // UC2 + UC3 - PUT
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateContact(@PathVariable int id,
                                                     @Valid @RequestBody AddressBookDTO dto) {
        AddressBook contact = addressBookService.updateContact(id, dto);
        ResponseDTO responseDTO = new ResponseDTO("Updated Contact Successfully", contact);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // UC2 + UC3 - DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteContact(@PathVariable int id) {
        String message = addressBookService.deleteContact(id);
        ResponseDTO responseDTO = new ResponseDTO("Deleted Contact Successfully", message);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
