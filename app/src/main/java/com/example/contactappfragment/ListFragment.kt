package com.example.contactappfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFragment: Fragment() {
    private lateinit var recyclerView: RecyclerView
    private var listData: ArrayList<Contacts> = dataList()
    private lateinit var myAdapter: ContactAdapter
    private lateinit var addContact: ImageButton
    private lateinit var onClickItem: OnClickItem
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.content_main, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.onClickItem = activity as OnClickItem
        addContact = view.findViewById(R.id.addContact)
        recyclerView = view.findViewById(R.id.recyclerView)
        //listData = dataList()
        myAdapter = ContactAdapter(listData, view.context)
        recyclerView.adapter = myAdapter
        recyclerView.layoutManager = LinearLayoutManager(
            view.context,
            LinearLayoutManager.VERTICAL,
            false
        )
        this.addContact.setOnClickListener{
            onClickItem.ButtonClicked()
        }
        this.myAdapter.setOnClickListener(
            object :
                ContactAdapter.OnClickListener {
                override fun onClick(position: Int, model: Contacts) {
                    onClickItem.ItemClicked(model)
                }
            }
        )
    }


    fun UpdateContent(item: Contacts) {
        this.listData.add(item)
        this.myAdapter.notifyItemInserted(listData.size -1 )
    }
    private fun dataList() : ArrayList<Contacts>{
        val list: ArrayList<Contacts> = ArrayList()
        list.add(Contacts("Alice Johnson", "0123456", "alice.j@gmail.com", "0912345678"))
        list.add(Contacts("Bob Smith", "9876543", "bob.smith@gmail.com", "0987654321"))
        list.add(Contacts("Eleanor Williams", "1122334", "eleanor.w@gmail.com", "0909090909"))
        list.add(Contacts("David Brown", "4455667", "david.b@gmail.com", "0876543210"))
        list.add(Contacts("Grace Miller", "7788990", "grace.m@gmail.com", "0912345678"))
        list.add(Contacts("Samuel Davis", "3344556", "samuel.d@gmail.com", "0923456789"))
        list.add(Contacts("Lily Wilson", "6677889", "lily.w@gmail.com", "0911111111"))
        list.add(Contacts("Henry Moore", "1122334", "henry.m@gmail.com", "0944444444"))
        list.add(Contacts("Olivia White", "5566778", "olivia.w@gmail.com", "0966666666"))
        list.add(Contacts("William Lee", "8899001", "william.l@gmail.com", "0988888888"))
        return list
    }
}