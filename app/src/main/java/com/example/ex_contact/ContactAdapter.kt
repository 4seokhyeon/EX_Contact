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

class ContactAdapter(private val context: Context, private val contactList: List<Contact>) :
    RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val currentContact = contactList[position]
        holder.bind(currentContact)
    }

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
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse("tel:$phoneNum")
                context.startActivity(intent)
                (context as? Activity)?.slideRight()
            }
        }


    }
}