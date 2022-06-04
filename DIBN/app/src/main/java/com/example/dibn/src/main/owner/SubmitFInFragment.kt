package com.example.dibn.src.main.owner

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.dibn.R
import com.example.dibn.config.BaseFragment
import com.example.dibn.databinding.FragmentSubmitFinBinding
import com.example.dibn.src.main.MainActivity
import com.example.dibn.src.main.home.HomeFragment

class SubmitFInFragment : BaseFragment<FragmentSubmitFinBinding>(FragmentSubmitFinBinding::bind, R.layout.fragment_submit_fin) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnBackToMain.setOnClickListener {
            val fm = requireActivity().supportFragmentManager
            val transaction: FragmentTransaction = fm.beginTransaction()

            transaction
                .replace(R.id.main_frm, OwnerUploadFragment())
                .commitAllowingStateLoss()
            transaction.isAddToBackStackAllowed

        }
    }
}