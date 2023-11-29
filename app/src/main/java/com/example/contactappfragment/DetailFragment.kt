package com.example.contactappfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetailFragment: Fragment() {
    private var name: String? = null
    private var phone: String? = null
    private var email: String? = null
    private var ID: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.detail_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            this.name = it.getString("name")
            this.ID = it.getString("ID")
            this.phone = it.getString("phone")
            this.email = it.getString("email")
        }

        view.findViewById<TextView>(R.id.nameDetail).text = this.name
        view.findViewById<TextView>(R.id.idDetail).text = this.ID
        view.findViewById<TextView>(R.id.phoneDetail).text = this.phone
        view.findViewById<TextView>(R.id.emailDetail).text = this.email
    }
}