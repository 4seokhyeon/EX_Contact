package com.example.ex_contact

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ex_contact.contacter.ContactManager
import com.example.ex_contact.contacter.Contactpl

import com.example.ex_contact.databinding.ActivityMainBinding
import com.example.ex_contact.model.Contact

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var contactAdapter: ContactAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 더미 데이터 가져오기
        val contactManager = Contactpl.getInstance()
        val contacts = contactManager.getContacts()

        // 어댑터 초기화 및 연결
        contactAdapter = ContactAdapter(this, contacts)
        binding.listview.layoutManager = LinearLayoutManager(this)
        binding.listview.adapter = contactAdapter



    }


}