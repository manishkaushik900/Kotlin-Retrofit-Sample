package com.demo.rks.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.demo.rks.R
import com.demo.rks.model.User

class CustomAdapter(private val dataset: MutableList<User>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val textViewUsername: TextView
        val textViewAddress: TextView
        val cardView: CardView

        init {
            textViewUsername = view.findViewById(R.id.textViewUsername)
            textViewAddress = view.findViewById(R.id.textViewAddress)
            cardView = view.findViewById(R.id.cardView)
        }

        fun bind(user: User) {
            textViewUsername.text = user?.name.plus(" | ").plus(user.email)
            textViewAddress.text = user.address.city.plus(" ,").plus(user.address.zipcode)
            cardView.setOnClickListener {
                Toast.makeText(it.context, "You Clicked ${user.name}", Toast.LENGTH_SHORT).show()
            }
        }


    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {

        val view =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.row_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataset.get(position))
//        holder.textViewUsername.setText(dataset.get(position).name)
//        holder.textViewAddress.setText(dataset.get(position).address)
//        holder.cardView.setOnClickListener{
//            Toast.makeText(it.context,"You Clicked ${dataset.get(position).name}", Toast.LENGTH_SHORT).show()
//        }
    }

    override fun getItemCount() = dataset.size

}