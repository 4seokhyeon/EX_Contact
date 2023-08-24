package com.example.ex_contact.contacter


import com.example.ex_contact.R
import com.example.ex_contact.model.Contact


class Contactpl private constructor() : ContactManager {


    companion object{
        private val instance = Contactpl()
        fun getInstance(): Contactpl{
            return instance
        }
    }
    override fun getContacts(): List<Contact> {
        val memberList = mutableListOf<Contact>()
        for(i in 1..10){
            val profile = when(i % 9){
                0 -> R.drawable.per1
                1 -> R.drawable.per2
                2 -> R.drawable.per3
                3 -> R.drawable.per4
                4 -> R.drawable.per5
                5 -> R.drawable.per6
                6 -> R.drawable.per7
                7 -> R.drawable.per8
                8 -> R.drawable.per9
                else -> R.drawable.per10
            }
            val contact = Contact(profile, "이름 : $i", "010-202$i-333$i",i % 2 == 0)
            memberList.add(contact)
        }
        return memberList
    }

}

