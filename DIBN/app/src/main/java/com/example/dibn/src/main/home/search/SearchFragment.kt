package com.example.dibn.src.main.home.search

import android.os.Bundle
import android.view.KeyEvent
import android.view.KeyEvent.KEYCODE_ENTER
import android.view.View
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.GridLayoutManager
import com.example.dibn.R
import com.example.dibn.config.ApplicationClass
import com.example.dibn.config.ApplicationClass.Companion.X_ACCESS_TOKEN
import com.example.dibn.config.BaseFragment
import com.example.dibn.databinding.FragmentSearchBinding
import com.example.dibn.src.main.MainActivity
import com.example.dibn.src.main.home.HomeFragment
import com.example.dibn.src.main.home.ItemFragment
import com.example.dibn.src.main.home.recycler.HomeRecyclerViewAdapter
import com.example.dibn.src.main.home.retrofit.GetItemRequest
import com.example.dibn.src.main.home.retrofit.ItemData
import com.example.dibn.src.main.home.retrofit.ItemService
import com.example.dibn.src.main.home.search.recycler.Item
import com.example.dibn.src.main.home.search.recycler.SearchRecyclerViewAdapter
import com.example.dibn.src.main.home.search.retrofit.GetItemKeywordRequest
import com.example.dibn.src.main.home.search.retrofit.GetItemKeywordResponse
import com.example.dibn.src.main.home.search.retrofit.IKeywordView
import com.example.dibn.src.main.home.search.retrofit.KeywordService
import com.example.dibn.src.main.login.LoginFragment

class SearchFragment : BaseFragment<FragmentSearchBinding>(FragmentSearchBinding::bind, R.layout.fragment_search)
, IKeywordView{

    lateinit var searchRecyclerViewAdapter : SearchRecyclerViewAdapter

    inner class itemListAdapterToList {
        fun getItemId(item: ItemData) {
            openItem(item)
        }
    }

    fun openItem(item: ItemData) {
        val itemFragment = ItemFragment(item)

        val fm = requireActivity().supportFragmentManager
        val transaction: FragmentTransaction = fm.beginTransaction()


        val email = ApplicationClass.sSharedPreferences.getString("email", "")
        if(email == "NO") {
            transaction
                .replace(R.id.main_frm, LoginFragment())
                .addToBackStack(null)
                .commit()
            transaction.isAddToBackStackAllowed
        }
        else {
            transaction
                .replace(R.id.main_frm, itemFragment)
                .addToBackStack(null)
                .commit()
            transaction.isAddToBackStackAllowed
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val itemList = ArrayList<ItemData>()

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

        val mainact = activity as MainActivity

        val items = itemListAdapterToList()

        val homeLayoutManager = GridLayoutManager(context, 2)

        searchRecyclerViewAdapter = SearchRecyclerViewAdapter(items, itemList)

        binding.searchRecycler.apply {
            layoutManager = homeLayoutManager
            adapter = searchRecyclerViewAdapter
            searchRecyclerViewAdapter.filter.filter("wood")
        }

        binding.edittextSearch.setOnKeyListener { view, i, event ->
            if (event.action == KeyEvent.ACTION_DOWN && i == KEYCODE_ENTER) {
                val keyword = binding.edittextSearch.text.toString()
                searchRecyclerViewAdapter.filter.filter(keyword)
//                val token = ApplicationClass.sSharedPreferences.getString(ApplicationClass.X_ACCESS_TOKEN, "")!!
//                val getItem = GetItemKeywordRequest(keyword = keyword)
//                KeywordService(this).tryGetItem(token, getItem)
            }
            true
        }

        binding.searchBack.setOnClickListener {
            mainact.onBackPressed()
        }
    }

    override fun onGetKeywordSuccess(response: GetItemKeywordResponse) {
        val mainact = activity as MainActivity
        val searchLayoutManager = GridLayoutManager(context, 2)


        val util = itemListAdapterToList()
        searchRecyclerViewAdapter = SearchRecyclerViewAdapter(util, response.item)

        binding.searchRecycler.apply {
            layoutManager = searchLayoutManager
            adapter = searchRecyclerViewAdapter
        }
    }

    override fun onGetKeywordFailure(message: String) {
    }
}