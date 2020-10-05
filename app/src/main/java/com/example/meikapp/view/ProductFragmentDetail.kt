package com.example.meikapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.meikapp.R
import com.example.meikapp.model.api.Product
import com.example.meikapp.viewmodel.MakeUpViewModel
import kotlinx.android.synthetic.main.fragment_main.*
import java.nio.channels.Selector

class ProductFragmentDetail : Fragment() {

    companion object {
        fun newInstance() = ProductFragmentDetail()
    }

    private var adapter = MakeUpAdapter(mutableListOf())
    private val viewModel: MakeUpViewModel by activityViewModels()
    private lateinit var itemSelector: Selector

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_ir_detalles.setOnClickListener{
            findNavController().navigate(R.id.productFragmentDetail)
        }

        var mRecycler = makeUpRecycler
        mRecycler.adapter = adapter

        viewModel.allProduct.observe(viewLifecycleOwner, androidx.lifecycle.Observer { products ->
           val p = products.map { Product(it.id, it.brand, it.name, it.price, it.price_sign, it.currency, it.link, it.description, it.rating, it.product_type, it.category, it.tag_list, it.created_at, it.updated_at, it.product_api_url, it.api_featured_image, it.product_colors) }
            adapter.updateItems(p)
        })
    }
}