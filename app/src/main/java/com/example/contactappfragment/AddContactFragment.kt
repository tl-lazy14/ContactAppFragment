package com.example.contactappfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class AddContactFragment: Fragment() {
    lateinit var name: EditText
    private lateinit var phone: EditText
    private lateinit var email: EditText
    private lateinit var btn: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.add_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val onClickItem: OnClickItem = activity as OnClickItem
        this.email = view.findViewById(R.id.editEmail)
        this.name = view.findViewById(R.id.editName)
        this.phone = view.findViewById(R.id.editTextPhone)
        this.btn = view.findViewById(R.id.addBTN)
        val toast = Toast.makeText(view.context, "Thiếu thông tin!", Toast.LENGTH_SHORT)

        this.btn.setOnClickListener{
            if(this.phone.text.isEmpty() || this.phone.text.isBlank()){
                toast.show()
            }
            else if(this.name.text.isEmpty()|| this.name.text.isBlank()){
                toast.show()
            }
            else if(this.email.text.isBlank() || this.email.text.isEmpty()){
                toast.show()
            }
            else{
                val ID = (1000000..9999999).random()
                val contact = Contacts(this.name.text.toString(), ID.toString(), this.email.text.toString(), this.phone.text.toString())
                onClickItem.OnCliCkAddContact(contact)
            }
        }
    }
}