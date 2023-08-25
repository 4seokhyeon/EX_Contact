package com.example.ex_contact.contacter


import com.example.ex_contact.R
import com.example.ex_contact.model.Contact
import com.example.ex_contact.model.ContactB


class Contactpl private constructor() : ContactManager {


    companion object{
        private val instance = Contactpl()
        fun getInstance(): Contactpl{
            return instance
        }
    }
    override fun getContacts(): Pair<List<Contact>, List<ContactB>> {
        val contactList = mutableListOf<Contact>().apply {
            add(Contact(R.drawable.per1, "이름 1", "010-2021-3331", true))
            add(Contact(R.drawable.per2, "이름 2", "010-2022-3332", false))
            add(Contact(R.drawable.per3,"이름 3","010-2020-4040",true))
            add(Contact(R.drawable.per4, "이름 4", "010-2022-3332", true))
            add(Contact(R.drawable.per5, "이름 5", "010-2022-3332", false))
            add(Contact(R.drawable.per6, "이름 6", "010-2022-3332", true))
            add(Contact(R.drawable.per7, "이름 7", "010-2022-3332", false))
            add(Contact(R.drawable.per8, "이름 8", "010-2022-3332", false))
            add(Contact(R.drawable.per9, "이름 9", "010-2022-3332", true))
            add(Contact(R.drawable.per10, "이름 10", "010-2022-3332", true))
        }

        val contactBList = mutableListOf<ContactB>().apply {
            add(ContactB(R.drawable.per1, "이름 1", "010-2021-3331", true))
            add(ContactB(R.drawable.per2, "이름 2", "010-2022-3332", false))
            add(ContactB(R.drawable.per3,"이름 3","010-2020-4040",true))
            add(ContactB(R.drawable.per4, "이름 4", "010-2022-3332", true))
            add(ContactB(R.drawable.per5, "이름 5", "010-2022-3332", false))
            add(ContactB(R.drawable.per6, "이름 6", "010-2022-3332", true))
            add(ContactB(R.drawable.per7, "이름 7", "010-2022-3332", false))
            add(ContactB(R.drawable.per8, "이름 8", "010-2022-3332", false))
            add(ContactB(R.drawable.per9, "이름 9", "010-2022-3332", true))
            add(ContactB(R.drawable.per10, "이름 10", "010-2022-3332", true))
        }

        return Pair(contactList, contactBList)
    }
}

