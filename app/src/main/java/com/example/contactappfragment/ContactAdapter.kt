package com.example.contactappfragment

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnLongClickListener
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.Locale

class ContactAdapter(val list: ArrayList<Contacts>, val context: Context): RecyclerView.Adapter<ContactAdapter.ViewHolder>() {
    private var onClickListener: OnClickListener? = null

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view), OnLongClickListener{
        var name: TextView
        var image: TextView
        init{
            name = view.findViewById(R.id.name)
            image = view.findViewById(R.id.image)
        }

        override fun onLongClick(v: View?): Boolean {
            val menu = PopupMenu(context, v)
            menu.inflate(R.menu.sub_menu)

            // Show the popup menu
            menu.show()

            // Handle popup menu clicks
            menu.setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.call -> {
                        // Call the contact
                        val intent = Intent(Intent.ACTION_DIAL)
                        intent.data = Uri.parse("tel:${list[position].phone}")
                        context.startActivity(intent)
                    }
                    R.id.send_sms -> {
                        // Send an SMS to the contact
                        val intent = Intent(Intent.ACTION_SENDTO)
                        intent.data = Uri.parse("smsto:${list[position].phone}")
                        context.startActivity(intent)
                    }
                    R.id.send_email ->{
                        val intent = Intent(Intent.ACTION_SENDTO)
                        intent.data = Uri.parse("mailto:${list[position].email}")
                        intent.putExtra(Intent.EXTRA_SUBJECT, "Subject")
                        intent.putExtra(Intent.EXTRA_TEXT, "Body of the email")
                        context.startActivity(intent)
                    }
                }
                true
            }

            return true
        }
    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.image.text = list[position].name.uppercase(Locale.ROOT).first().toString()
        holder.name.text = list[position].name
        holder.itemView.setOnClickListener {
            if (onClickListener != null) {
                onClickListener!!.onClick(position, list[position] )
            }
        }
        holder.itemView.setOnLongClickListener(holder)

    }

    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }

    // onClickListener Interface
    interface OnClickListener {
        fun onClick(position: Int, model: Contacts)
    }


}