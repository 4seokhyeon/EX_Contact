package com.example.ex_contact.contacter

import com.example.ex_contact.model.Contact
import com.example.ex_contact.model.ContactB

interface ContactManager {
    fun getContacts(): Pair<List<Contact>, List<ContactB>>
}