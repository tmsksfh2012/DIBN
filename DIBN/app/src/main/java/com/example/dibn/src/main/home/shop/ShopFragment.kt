package com.example.dibn.src.main.home.shop

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.GridLayoutManager
import com.example.dibn.R
import com.example.dibn.config.BaseFragment
import com.example.dibn.databinding.FragmentShopBinding
import com.example.dibn.src.main.MainActivity
import com.example.dibn.src.main.home.ItemFragment
import com.example.dibn.src.main.home.recycler.ShopRecyclerViewAdapter
import com.example.dibn.src.main.home.retrofit.ItemData
import com.example.dibn.src.main.home.search.recycler.Item
import net.daum.mf.map.api.MapView

class ShopFragment: BaseFragment<FragmentShopBinding>(FragmentShopBinding::bind, R.layout.fragment_shop){

    lateinit var shopRecyclerViewAdapter : ShopRecyclerViewAdapter

    inner class itemListAdapterToList {
        fun getItemId(item: ItemData) {
            openItem(item)
        }
    }

    fun openItem(item: ItemData) {
        val itemFragment = ItemFragment(item)

        val fm = requireActivity().supportFragmentManager

        fm.popBackStack()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val items = itemListAdapterToList()

        val shopLayoutManager = GridLayoutManager(context, 2)

        val itemList = ArrayList<ItemData>()

        binding.shopBack.setOnClickListener{
            val mainAtc = activity as MainActivity
            mainAtc.onBackPressed()
        }

        itemList.add(
            ItemData(1, "금목걸이1", "김진훈", 151, "좋아요", 3, 50, "leather", "우리가게")
        )
        itemList.add(
            ItemData(5, "금목걸이5", "김택현", 1550, "좋아요", 3, 10, "wood", "너네가게")
        )
        itemList.add(
            ItemData(7, "금목걸이8", "정수현", 15000000, "좋아요", 3, 20, "etc", "내일가게")
        )
        itemList.add(
            ItemData(6, "은목걸이7", "고유진", 150, "완전 좋아요", 3, 30, "metal", "이제가게")
        )
        itemList.add(
            ItemData(8, "동목걸이9", "김택현", 15000, "ㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏ좋아요", 3, 304, "wood", "안녕가게")
        )
        itemList.add(
            ItemData(1, "천", "김택현", 15050, "ㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜ좋아요", 3, 300, "leather", "우리가게")
        )
        itemList.add(
            ItemData(1, "금목걸이8", "김진훈", 151, "ㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣ좋아요", 3, 310, "leather", "우리가게")
        )
        itemList.add(
            ItemData(5, "금목걸이6", "김택현", 1550, "좋아요", 3, 30, "wood", "너네가게")
        )
        itemList.add(
            ItemData(7, "금목걸이5", "정수현", 15000000, "좋아요", 3, 30, "etc", "내일가게")
        )
        itemList.add(
            ItemData(6, "은목걸이2", "고유진", 150, "좋아요", 3, 30, "metal", "이제가게")
        )
        itemList.add(
            ItemData(8, "동목걸이1", "김택현", 15000, "좋아요", 3, 80, "wood", "안녕가게")
        )
        itemList.add(
            ItemData(1, "천", "김택현", 15050, "좋아요", 3, 30, "leather", "우리가게")
        )
        itemList.add(
            ItemData(1, "금목걸이1", "김진훈", 151, "좋아요", 3, 50, "leather", "우리가게")
        )
        itemList.add(
            ItemData(5, "금목걸이5", "김택현", 1550, "좋아요", 3, 10, "wood", "너네가게")
        )
        itemList.add(
            ItemData(7, "금목걸이8", "정수현", 15000000, "좋아요", 3, 20, "etc", "내일가게")
        )
        itemList.add(
            ItemData(6, "은목걸이7", "고유진", 150, "완전 좋아요", 3, 30, "metal", "이제가게")
        )
        itemList.add(
            ItemData(8, "동목걸이9", "김택현", 15000, "ㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏ좋아요", 3, 304, "wood", "안녕가게")
        )
        itemList.add(
            ItemData(1, "천", "김택현", 15050, "ㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜ좋아요", 3, 300, "leather", "우리가게")
        )
        itemList.add(
            ItemData(1, "금목걸이8", "김진훈", 151, "ㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣ좋아요", 3, 310, "leather", "우리가게")
        )
        itemList.add(
            ItemData(5, "금목걸이6", "김택현", 1550, "좋아요", 3, 30, "wood", "너네가게")
        )
        itemList.add(
            ItemData(7, "금목걸이5", "정수현", 15000000, "좋아요", 3, 30, "etc", "내일가게")
        )
        itemList.add(
            ItemData(6, "은목걸이2", "고유진", 150, "좋아요", 3, 30, "metal", "이제가게")
        )
        itemList.add(
            ItemData(8, "동목걸이1", "김택현", 15000, "좋아요", 3, 80, "wood", "안녕가게")
        )
        itemList.add(
            ItemData(1, "천", "김택현", 15050, "좋아요", 3, 30, "leather", "우리가게")
        )
        itemList.add(
            ItemData(1, "금목걸이1", "김진훈", 151, "좋아요", 3, 50, "leather", "우리가게")
        )
        itemList.add(
            ItemData(5, "금목걸이5", "김택현", 1550, "좋아요", 3, 10, "wood", "너네가게")
        )
        itemList.add(
            ItemData(7, "금목걸이8", "정수현", 15000000, "좋아요", 3, 20, "etc", "내일가게")
        )
        itemList.add(
            ItemData(6, "은목걸이7", "고유진", 150, "완전 좋아요", 3, 30, "metal", "이제가게")
        )
        itemList.add(
            ItemData(8, "동목걸이9", "김택현", 15000, "ㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏ좋아요", 3, 304, "wood", "안녕가게")
        )
        itemList.add(
            ItemData(1, "천", "김택현", 15050, "ㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜ좋아요", 3, 300, "leather", "우리가게")
        )
        itemList.add(
            ItemData(1, "금목걸이8", "김진훈", 151, "ㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣ좋아요", 3, 310, "leather", "우리가게")
        )
        itemList.add(
            ItemData(5, "금목걸이6", "김택현", 1550, "좋아요", 3, 30, "wood", "너네가게")
        )
        itemList.add(
            ItemData(7, "금목걸이5", "정수현", 15000000, "좋아요", 3, 30, "etc", "내일가게")
        )
        itemList.add(
            ItemData(6, "은목걸이2", "고유진", 150, "좋아요", 3, 30, "metal", "이제가게")
        )
        itemList.add(
            ItemData(8, "동목걸이1", "김택현", 15000, "좋아요", 3, 80, "wood", "안녕가게")
        )
        itemList.add(
            ItemData(1, "천", "김택현", 15050, "좋아요", 3, 30, "leather", "우리가게")
        )
        shopRecyclerViewAdapter = ShopRecyclerViewAdapter(items, itemList)

        binding.shopRecycler.apply {
            layoutManager = shopLayoutManager
            adapter = shopRecyclerViewAdapter
            shopRecyclerViewAdapter.filter.filter("wood")
        }

/*
        val mainAct = requireActivity()
        val mView = MapView(mainAct)*/
/*
        binding.shopMapView.addView(mView)*/
    }

}