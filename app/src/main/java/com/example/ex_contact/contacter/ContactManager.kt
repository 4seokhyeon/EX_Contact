package com.example.ex_contact.contacter

import com.example.ex_contact.model.Contact

interface ContactManager {
    fun getContacts(): List<Contact>
}