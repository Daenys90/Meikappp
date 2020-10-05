package com.example.meikapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.meikapp.R
import com.example.meikapp.model.api.Product
import com.example.meikapp.model.db.ProductEntity
import com.example.meikapp.viewmodel.MakeUpViewModel
import kotlinx.android.synthetic.main.fragment_bienvenida.*
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment(R.layout.fragment_main) {
    private var productList = ArrayList<Product>()

    //    private val viewModel by activityViewModels<MakeUpViewModel()
    private lateinit var makeUpAdapter: MakeUpAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        makeUpAdapter = MakeUpAdapter(
            productList
        )

        ir_a_detalles.setOnClickListener {
            findNavController().navigate(R.id.productFragmentDetail)

        }

        fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            return inflater.inflate(R.layout.fragment_bienvenida, container, false)
        }

        fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            /*     val binding = FragmentMainBinding.bind(view)

        binding.searchView.onQueryTextChanged {
            viewModel.setProduct(it)
        }
*/
        }
    }
}
