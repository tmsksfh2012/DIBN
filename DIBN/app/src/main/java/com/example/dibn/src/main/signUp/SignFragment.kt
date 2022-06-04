package com.example.dibn.src.main.signUp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.dibn.R
import com.example.dibn.config.BaseFragment
import com.example.dibn.databinding.FragmentSignBinding
import com.example.dibn.src.main.home.HomeFragment

class SignFragment  : BaseFragment<FragmentSignBinding>(FragmentSignBinding::bind, R.layout.fragment_sign) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {
            val fm = requireActivity().supportFragmentManager
            val transaction: FragmentTransaction = fm.beginTransaction()


            transaction
                .replace(R.id.main_frm, HomeFragment())
                .commit()
            transaction.isAddToBackStackAllowed
        }
    }
}