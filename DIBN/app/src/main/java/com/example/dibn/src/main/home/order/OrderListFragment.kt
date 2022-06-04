package com.example.dibn.src.main.home.order

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.bumptech.glide.Glide
import com.example.dibn.R
import com.example.dibn.config.BaseFragment
import com.example.dibn.databinding.FragmentOrderListBinding
import com.example.dibn.src.main.MainActivity
import com.example.dibn.src.main.home.retrofit.ItemData
import com.example.dibn.src.main.home.search.recycler.Item
import com.example.dibn.src.main.home.shop.ShopFragment

class OrderListFragment(val item : ItemData) : BaseFragment<FragmentOrderListBinding>(FragmentOrderListBinding::bind, R.layout.fragment_order_list) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fm = requireActivity().supportFragmentManager
        val transaction: FragmentTransaction = fm.beginTransaction()



        val mainact = activity as MainActivity
        Glide.with(view).load("https://s3-alpha-sig.figma.com/img/9eaa/3523/b72e89689756d61764d40e5bd8fd131c?Expires=1653264000&Signature=DJniLR-QbDjVZv-mQE0Vizn4EAy3TrgzJmcGm~NADl3duEOqzTXhOWrQ9dVSMiMG5WOPMKrxW31LVpk1GOG6AHI5o3T7p7K7Llb8bh2d3-s9qpfsOsweBc4z8JhaZPFJ0dzxLljbLWwprJVSlLhMZ7cAQHKoOB4POZ2yIERag9dZ1bhaBKA9zKLC~Y1d79e0kVElYvZusHDkzfSd1ky0ljByq8jMfGRWT0rcyGnDQN4xX7DaYU6-TwdWNMHWhS1pQG-ut8Sz7egpq4oa8ZoER2m8j7Q05j6WDRhOHpfbjBjvEyhOV7v1xARLjUkkMbOB9XbT3xJvf73Tiwdvo2XH5w__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA").into(binding.receiptImg)
        binding.receiptName.text = item.name
        binding.receiptShop.text = item.name
        binding.priceReceipt.text = item.price.toString() + " 원"

    }
}