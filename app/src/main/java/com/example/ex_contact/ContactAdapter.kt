package com.example.ex_contact

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.ex_contact.alima.slideRight
import com.example.ex_contact.databinding.ItemListBinding
import com.example.ex_contact.model.Contact

class ContactAdapter(private val context: Context, private val contactList: List<Contact>) ://어댑터 클래스를 정의
    RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() { //생성자는 context, contactList를 받는다

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContactViewHolder(binding)
    }// 각 아이템 뷰를 생성하는 역할

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val currentContact = contactList[position]
        holder.bind(currentContact) //뷰 홀더에 데이터를 바인딩함
    }//position 현쟈 아이템의 위치를 나타냄

    override fun getItemCount(): Int {
        return contactList.size
    }

    inner class ContactViewHolder(private val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(contact: Contact) {
            binding.iconItem.setImageResource(contact.profile)
            binding.textItem1.text = contact.name
            binding.textItem2.text = contact.tel
            binding.textItem3.text = if (contact.Bookmark) "⭐️" else "❌"

            binding.root.setOnClickListener{
                val phoneNum = contact.tel
                val intent = Intent(Intent.ACTION_CALL)
                intent.data = Uri.parse("tel:$phoneNum")
                context.startActivity(intent)
                (context as? Activity)?.slideRight()
            }
        }


    }
}