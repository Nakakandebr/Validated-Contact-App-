package com.assignment.contact_app_validated

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.assignment.contact_app_validated.databinding.ContactListItemBinding
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation


class ContactsAdapter(var contactList:List<contactData>): RecyclerView.Adapter< ContactViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ContactViewHolder {
        val binding=
            ContactListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ContactViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val currentContact=contactList.get(position)
        val binding=holder.binding
        binding.tvDisplayName.text=currentContact.displayName
        binding.tvPhoneNumber.text =currentContact.phoneNumber
        binding.tvEmail.text=currentContact.email
        Picasso
            .get()
            .load(currentContact.avatar)
//            .resize(100,80)
//            .centerCrop()

            .transform(CropCircleTransformation())
            .into(binding.imageView)


    }

    override fun getItemCount(): Int {
        return contactList.size
    }
}

class ContactViewHolder(var binding:ContactListItemBinding): RecyclerView.ViewHolder(binding.root)