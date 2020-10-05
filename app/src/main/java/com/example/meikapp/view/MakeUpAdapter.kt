package com.example.meikapp.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.meikapp.R
import com.example.meikapp.model.api.Product
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_main.view.*

class MakeUpAdapter(private var productDataSet: MutableList<Product>) :
    RecyclerView.Adapter<MakeUpAdapter.MakeUpViewHolder>() {

    val selectedItem = MutableLiveData<Product>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MakeUpViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.fragment_main, parent, false)
        return MakeUpViewHolder(view)
    }

    override fun getItemCount(): Int {
        return productDataSet.size
    }

    fun updateItems(lista: List<Product>?) {
        if (lista != null) {
            productDataSet.clear()
            productDataSet.addAll(lista)
            notifyDataSetChanged()
        }
    }
    class MakeUpViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textProduct = itemView.textView
    }

    override fun onBindViewHolder(holder: MakeUpViewHolder, position: Int) {
        holder.textProduct.text = productDataSet.get(position).name

     //   Picasso.get().load(productDataSet.get(position).api_featured_image).into(holder.imageProduct)

        holder.itemView.setOnClickListener() {
            Log.d("Click", "$productDataSet.get(position)}")
        }
    }

}

