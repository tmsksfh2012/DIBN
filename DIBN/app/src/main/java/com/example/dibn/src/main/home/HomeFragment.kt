package com.example.dibn.src.main.home

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.GridLayoutManager
import com.example.dibn.R
import com.example.dibn.config.ApplicationClass
import com.example.dibn.config.ApplicationClass.Companion.sSharedPreferences
import com.example.dibn.config.BaseFragment
import com.example.dibn.databinding.FragmentHomeBinding
import com.example.dibn.databinding.FragmentSearchBinding
import com.example.dibn.src.main.home.models.PostSignUpRequest
import com.example.dibn.src.main.home.models.SignUpResponse
import com.example.dibn.src.main.home.models.UserResponse
import com.example.dibn.src.main.home.recycler.HomeRecyclerViewAdapter
import com.example.dibn.src.main.home.retrofit.GetItemRequest
import com.example.dibn.src.main.home.retrofit.GetItemResponse
import com.example.dibn.src.main.home.retrofit.ItemData
import com.example.dibn.src.main.home.retrofit.ItemService
import com.example.dibn.src.main.home.search.SearchFragment
import com.example.dibn.src.main.home.search.recycler.Item
import com.example.dibn.src.main.login.LoginFragment
import com.example.dibn.src.main.login.retrofit.GetLoginRequest
import com.example.dibn.src.main.login.retrofit.IItemView
import com.example.dibn.src.main.login.retrofit.LoginService
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::bind, R.layout.fragment_home) {

    lateinit var itemList : ArrayList<ItemData>
    inner class itemListAdapterToList {
        fun getItemId(item: ItemData) {
            openItem(item)
        }
    }

    fun openItem(item: ItemData) {
        val itemFragment = ItemFragment(item)

        val fm = requireActivity().supportFragmentManager
        val transaction: FragmentTransaction = fm.beginTransaction()

        val email = sSharedPreferences.getString("email", "")
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

    lateinit var homeRecyclerViewAdapter : HomeRecyclerViewAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val itemList = ArrayList<ItemData>()

        itemList.add(
            ItemData(1,"금목걸이", "김진훈", 151, "좋아요", 3,30,"leather","우리가게")
        )
        itemList.add(
            ItemData(5,"금목걸이", "김택현", 1550, "좋아요", 3,30,"wood","너네가게")
        )
        itemList.add(
            ItemData(7,"금목걸이", "정수현", 15000000, "좋아요", 3,30,"etc","내일가게")
        )
        itemList.add(
            ItemData(6,"은목걸이", "고유진", 150, "좋아요", 3,30,"metal","이제가게")
        )
        itemList.add(
            ItemData(8,"동목걸이", "김택현", 15000, "좋아요", 3,30,"wood","안녕가게")
        )
        itemList.add(
            ItemData(1,"천", "김택현", 15050, "좋아요", 3,30,"leather","우리가게")
        )
        itemList.add(
            ItemData(1,"금목걸이", "김진훈", 151, "좋아요", 3,30,"leather","우리가게")
        )
        itemList.add(
            ItemData(5,"금목걸이", "김택현", 1550, "좋아요", 3,30,"wood","너네가게")
        )
        itemList.add(
            ItemData(7,"금목걸이", "정수현", 15000000, "좋아요", 3,30,"etc","내일가게")
        )
        itemList.add(
            ItemData(6,"은목걸이", "고유진", 150, "좋아요", 3,30,"metal","이제가게")
        )
        itemList.add(
            ItemData(8,"동목걸이", "김택현", 15000, "좋아요", 3,30,"wood","안녕가게")
        )
        itemList.add(
            ItemData(1,"천", "김택현", 15050, "좋아요", 3,30,"leather","우리가게")
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

        val items = itemListAdapterToList()

        val homeLayoutManager = GridLayoutManager(context, 2)

        homeRecyclerViewAdapter = HomeRecyclerViewAdapter(items, itemList)

        binding.homeRecycler.apply {
            layoutManager = homeLayoutManager
            adapter = homeRecyclerViewAdapter
            homeRecyclerViewAdapter.filter.filter("wood")
        }


        binding.homeWood.setOnClickListener {
            binding.homeWood.setTextColor(ContextCompat.getColor(requireContext(), R.color.colorPrimary))
            binding.homeMetal.setTextColor(ContextCompat.getColor(requireContext(), R.color.blackForText))
            binding.homeLeather.setTextColor(ContextCompat.getColor(requireContext(), R.color.blackForText))
            binding.homeEtc.setTextColor(ContextCompat.getColor(requireContext(), R.color.blackForText))
            homeRecyclerViewAdapter.filter.filter("wood")
        }
        binding.homeMetal.setOnClickListener {
            binding.homeMetal.setTextColor(ContextCompat.getColor(requireContext(), R.color.colorPrimary))
            binding.homeWood.setTextColor(ContextCompat.getColor(requireContext(), R.color.blackForText))
            binding.homeLeather.setTextColor(ContextCompat.getColor(requireContext(), R.color.blackForText))
            binding.homeEtc.setTextColor(ContextCompat.getColor(requireContext(), R.color.blackForText))
            homeRecyclerViewAdapter.filter.filter("metal")
        }
        binding.homeLeather.setOnClickListener {
            binding.homeLeather.setTextColor(ContextCompat.getColor(requireContext(), R.color.colorPrimary))
            binding.homeWood.setTextColor(ContextCompat.getColor(requireContext(), R.color.blackForText))
            binding.homeMetal.setTextColor(ContextCompat.getColor(requireContext(), R.color.blackForText))
            binding.homeEtc.setTextColor(ContextCompat.getColor(requireContext(), R.color.blackForText))
            homeRecyclerViewAdapter.filter.filter("leather")
        }
        binding.homeEtc.setOnClickListener {
            binding.homeEtc.setTextColor(ContextCompat.getColor(requireContext(), R.color.colorPrimary))
            binding.homeWood.setTextColor(ContextCompat.getColor(requireContext(), R.color.blackForText))
            binding.homeLeather.setTextColor(ContextCompat.getColor(requireContext(), R.color.blackForText))
            binding.homeMetal.setTextColor(ContextCompat.getColor(requireContext(), R.color.blackForText))
            homeRecyclerViewAdapter.filter.filter("etc")
        }

//        val token = sSharedPreferences.getString(ApplicationClass.X_ACCESS_TOKEN, "")
//        if (token == null) {
//            Log.e("TAG", "HERE")
//        }

//        if (token != null) {
//            if(token.isNotEmpty()) {
//                val getItem = GetItemRequest(token)
//                ItemService(this).tryGetItem(getItem)
//            }
//            else {
//                Log.e("TAG", token)
//                val fm = requireActivity().supportFragmentManager
//                val transaction: FragmentTransaction = fm.beginTransaction()
//
//                transaction
//                    .replace(R.id.main_frm, LoginFragment())
//                    .addToBackStack(null)
//                    .commit()
//                transaction.isAddToBackStackAllowed
//            }
//        }


        binding.edittextHome.setOnClickListener {
            val fm = requireActivity().supportFragmentManager
            val transaction: FragmentTransaction = fm.beginTransaction()

            transaction
                .replace(R.id.main_frm, SearchFragment())
                .addToBackStack(null)
                .commit()
            transaction.isAddToBackStackAllowed
        }

//        binding.homeButtonTryGetJwt.setOnClickListener {
//            showLoadingDialog(requireContext())
//            HomeService(this).tryGetUsers()
//        }
//
//        binding.homeBtnTryPostHttpMethod.setOnClickListener {
//            val email = binding.homeEtId.text.toString()
//            val password = binding.homeEtPw.text.toString()
//            val postRequest = PostSignUpRequest(email = email, password = password,
//                    confirmPassword = password, nickname = "test", phoneNumber = "010-0000-0000")
//            showLoadingDialog(requireContext())
//            HomeService(this).tryPostSignUp(postRequest)
//        }
    }

//
//    override fun onGetItemSuccess(response: GetItemResponse) {
//        val items = itemListAdapterToList()
//
//        val homeLayoutManager = GridLayoutManager(context, 2)
//
//        itemList = response.item
//
//        homeRecyclerViewAdapter = HomeRecyclerViewAdapter(items, itemList)
//
//        binding.homeRecycler.apply {
//            layoutManager = homeLayoutManager
//            adapter = homeRecyclerViewAdapter
//            homeRecyclerViewAdapter.filter.filter("wood")
//        }
//
//
//        // state = 0 -> 목공예 wood
//        // state = 1 -> 금속공예 metal
//        // state = 2 -> 가죽공예 leather
//        // state = 3 -> 기타 etc
//
//    }
//
//    override fun onGetItemFailure(message: String) {
//        TODO("Not yet implemented")
//    }

}