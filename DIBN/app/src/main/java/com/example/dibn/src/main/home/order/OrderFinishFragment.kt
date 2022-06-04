package com.example.dibn.src.main.home.order

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.dibn.R
import com.example.dibn.config.BaseFragment
import com.example.dibn.databinding.FragmentOrderFinBinding
import com.example.dibn.src.main.home.HomeFragment
import com.example.dibn.src.main.home.retrofit.ItemData
import com.example.dibn.src.main.home.search.recycler.Item
import com.example.dibn.src.main.home.shop.ShopFragment

class OrderFinishFragment(val item : ItemData): BaseFragment<FragmentOrderFinBinding>(FragmentOrderFinBinding::bind, R.layout.fragment_order_fin) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fm = requireActivity().supportFragmentManager
        val transaction: FragmentTransaction = fm.beginTransaction()

        binding.backToMain.setOnClickListener {
            transaction
                .replace(R.id.main_frm, HomeFragment())
                .commit()
        }

        binding.backToReceipt.setOnClickListener {
            transaction
                .replace(R.id.main_frm, OrderListFragment(item))
                .commit()
            transaction.isAddToBackStackAllowed
        }
    }
}