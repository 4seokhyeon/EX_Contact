package com.example.ex_contact

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ex_contact.alima.slideRight
import com.example.ex_contact.databinding.ItemListBinding
import com.example.ex_contact.databinding.ItemViewBBinding
import com.example.ex_contact.model.Contact
import com.example.ex_contact.model.ContactB

class ContactAdapter(private val context: Context, private val contacts: Pair<List<Contact>, List<ContactB>>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val VIEW_TYPE_A = 0
        private const val VIEW_TYPE_B = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            VIEW_TYPE_A -> {
                val binding = ItemListBinding.inflate(inflater, parent, false)
                ContactViewHolder(binding)
            }
            VIEW_TYPE_B -> {
                val binding = ItemViewBBinding.inflate(inflater, parent, false)
                ContactBViewHolder(binding)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentContact = when (holder.itemViewType) {
            VIEW_TYPE_A -> contacts.first[position]
            VIEW_TYPE_B -> contacts.second[position - contacts.first.size]
            else -> throw IllegalArgumentException("Invalid view type")
        }


        when (holder) {
            is ContactViewHolder -> {
                holder.bind(currentContact as Contact)
                if (currentContact.Bookmark) {
                    holder.binding.iconItem.visibility = View.VISIBLE
                    holder.binding.textItem1.visibility = View.VISIBLE
                    holder.binding.textItem2.visibility = View.VISIBLE
                    holder.binding.textItem3.visibility = View.VISIBLE
                } else {
                    holder.binding.iconItem.visibility = View.VISIBLE
                    holder.binding.textItem1.visibility = View.VISIBLE
                    holder.binding.textItem2.visibility = View.VISIBLE
                    holder.binding.textItem3.visibility = View.VISIBLE

                }
            }
            is ContactBViewHolder -> {
                holder.bind(currentContact as ContactB)
                if (currentContact.Bookmark) {
                    holder.binding.itemimg.visibility = View.VISIBLE
                    holder.binding.itemName.visibility = View.VISIBLE
                    holder.binding.itemtel.visibility = View.VISIBLE
                    holder.binding.favor.visibility = View.VISIBLE
                } else {
                    holder.binding.itemimg.visibility = View.GONE
                    holder.binding.itemName.visibility = View.GONE
                    holder.binding.itemtel.visibility = View.GONE
                    holder.binding.favor.visibility = View.GONE
                }
            }
        }
    }


    override fun getItemCount(): Int {
        return contacts.first.size + contacts.second.size
    }

    override fun getItemViewType(position: Int): Int {
        if (position < contacts.first.size) {
            return VIEW_TYPE_A
        }
        return VIEW_TYPE_B
    }

    inner class ContactViewHolder(val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(contact: Contact) {
            binding.iconItem.setImageResource(contact.profile)
            binding.textItem1.text = contact.name
            binding.textItem2.text = contact.tel
            binding.textItem3.text = if (contact.Bookmark) "⭐️" else "❌"

            binding.root.setOnClickListener {
                val phoneNum = contact.tel
                val intent = Intent(Intent.ACTION_CALL)
                intent.data = Uri.parse("tel:$phoneNum")
                context.startActivity(intent)
                (context as? Activity)?.slideRight()
            }
        }
    }

    inner class ContactBViewHolder(val binding: ItemViewBBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(contact: ContactB) {
            binding.itemimg.setImageResource(contact.profile)
            binding.itemName.text = contact.name
            binding.itemtel.text = contact.tel
            binding.favor.text = if (contact.Bookmark) "⭐️" else "❌"

            binding.root.setOnClickListener {
                val phoneNum = contact.tel
                val intent = Intent(Intent.ACTION_CALL)
                intent.data = Uri.parse("tel:$phoneNum")
                context.startActivity(intent)
                (context as? Activity)?.slideRight()
            }
        }
    }
}
