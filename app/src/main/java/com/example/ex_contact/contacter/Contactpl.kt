package com.example.ex_contact.contacter

import com.example.ex_contact.model.Contact


class Contactpl private constructor() : ContactManager {
    private val memberList = mutableListOf<Contact>()

    init {
        memberList.add(Contact("per1", "사석현", "010-1233-1233","Ok"))

        memberList.add(Contact("per2", "홍길동", "010-2020-1010","OK"))

        memberList.add(Contact("per3", "홍길동", "010-2020-1010","No"))

        memberList.add(Contact("per4", "홍길동", "010-2020-1010","No"))

        memberList.add(Contact("per5", "홍길동", "010-2020-1010","Ok"))

        memberList.add(Contact("per6", "홍길동", "010-2020-1010","No"))

        memberList.add(Contact("per7", "홍길동", "010-2020-1010","No"))

        memberList.add(Contact("per8", "홍길동", "010-2020-1010","Ok"))

        memberList.add(Contact("per9", "홍길동", "010-2020-1010","No"))

        memberList.add(Contact("per10", "홍길동", "010-2020-1010","Ok"))
    }

    override fun addmember(profile: String, name: String, tel: String, Bookmark: String) {

    }

}
