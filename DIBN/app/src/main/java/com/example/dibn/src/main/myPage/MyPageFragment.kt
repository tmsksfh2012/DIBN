package com.example.dibn.src.main.myPage

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentTransaction
import com.example.dibn.R
import com.example.dibn.config.ApplicationClass
import com.example.dibn.config.BaseFragment
import com.example.dibn.databinding.FragmentMyPageBinding
import com.example.dibn.src.main.home.HomeFragment
import com.example.dibn.src.main.signUp.SignUpFragment

class MyPageFragment :
    BaseFragment<FragmentMyPageBinding>(FragmentMyPageBinding::bind, R.layout.fragment_my_page) {
    private var mCount = 0
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.logout.setOnClickListener {
            val editor = ApplicationClass.sSharedPreferences.edit()
            editor.putString("email", "NO")
            editor.apply()

            val fm = requireActivity().supportFragmentManager
            val transaction: FragmentTransaction = fm.beginTransaction()

            transaction
                .replace(R.id.main_frm, HomeFragment())
                .commit()
            transaction.isAddToBackStackAllowed
        }
    }
}