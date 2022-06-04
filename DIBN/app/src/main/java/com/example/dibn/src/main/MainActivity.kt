package com.example.dibn.src.main

import android.os.Bundle
import android.view.View
import com.example.dibn.R
import com.example.dibn.config.ApplicationClass
import com.example.dibn.config.BaseActivity
import com.example.dibn.databinding.ActivityMainBinding
import com.example.dibn.src.main.home.HomeFragment
import com.example.dibn.src.main.myPage.MyPageFragment
import com.example.dibn.src.main.owner.OwnerUploadFragment

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val editor = ApplicationClass.sSharedPreferences.edit()
        editor.putString("email", "NO")
        editor.apply()

        supportFragmentManager.beginTransaction().replace(R.id.main_frm, HomeFragment()).commitAllowingStateLoss()

        binding.mainBtmNav.run {
            setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.menu_main_btm_nav_home -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, HomeFragment())
                            .commitAllowingStateLoss()
                    }
                    R.id.menu_edit -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, OwnerUploadFragment())
                            .commitAllowingStateLoss()
                    }
                    R.id.menu_main_btm_nav_my_page -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, MyPageFragment())
                            .commitAllowingStateLoss()
                    }
                }
                true
            }
            selectedItemId = R.id.menu_main_btm_nav_home
        }
    }
}