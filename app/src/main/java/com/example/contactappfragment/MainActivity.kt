package com.example.contactappfragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), OnClickItem {
    private lateinit var fragment: ListFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragment = ListFragment()
        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainerView2, fragment, "MainFragment")
            .addToBackStack("MainFragment")
            .commit()

    }

    override fun ItemClicked(contract: Contacts) {
        val detailFragment = DetailFragment()
        detailFragment.arguments = Bundle().apply {
            putString("name", contract.name)
            putString("ID", contract.ID)
            putString("phone", contract.phone)
            putString("email", contract.email)
        }
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView2, detailFragment, "DetailContactFragment")
            .addToBackStack("DetailContactFragment")
            .commit()
    }

    override fun ButtonClicked() {
        val addContactFragment = AddContactFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView2, addContactFragment, "AddContactFragment")
            .addToBackStack("AddContactFragment")
            .commit()
    }

    override fun OnCliCkAddContact(contacts: Contacts) {
        val fragmentManager = supportFragmentManager
        fragmentManager.popBackStack()
        this.fragment.UpdateContent(contacts)
    }

}