package com.example.dibn.src.main.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentTransaction
import com.example.dibn.R
import com.example.dibn.config.ApplicationClass
import com.example.dibn.config.ApplicationClass.Companion.X_ACCESS_TOKEN
import com.example.dibn.config.BaseFragment
import com.example.dibn.databinding.FragmentLoginBinding
import com.example.dibn.src.main.MainActivity
import com.example.dibn.src.main.home.HomeFragment
import com.example.dibn.src.main.home.retrofit.ItemService
import com.example.dibn.src.main.login.retrofit.*
import com.example.dibn.src.main.signUp.SignUpFragment
import java.lang.Exception

class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::bind, R.layout.fragment_login){
    lateinit var email :String
    lateinit var password : String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginBack.setOnClickListener {
            val mainact = activity as MainActivity
            mainact.onBackPressed()
        }

        binding.btnLogin.setOnClickListener {
                email = binding.editId.text.toString()
                password = binding.editPw.text.toString()
                val editor = ApplicationClass.sSharedPreferences.edit()
                editor.putString("email", email)
                editor.putString("password", password)
                editor.apply()
                val fm = requireActivity().supportFragmentManager
                val transaction: FragmentTransaction = fm.beginTransaction()
                transaction
                    .replace(R.id.main_frm, HomeFragment())
                    .commit()
                transaction.isAddToBackStackAllowed
//            try {
//                val getLogin = GetLoginRequest(email = email, password = password)
//                LoginService(this).tryGetLogin(getLogin)
//            }
//            catch (e: Exception) {
//                showCustomToast("입력을 모두 완료해주세요.")
//            }
        }
        binding.Signup.setOnClickListener {
            val fm = requireActivity().supportFragmentManager
            val transaction: FragmentTransaction = fm.beginTransaction()

            val state = 1
            transaction
                .replace(R.id.main_frm, SignUpFragment(state))
                .addToBackStack(null)
                .commit()
            transaction.isAddToBackStackAllowed
        }
        binding.masterSignup.setOnClickListener {
            val fm = requireActivity().supportFragmentManager
            val transaction: FragmentTransaction = fm.beginTransaction()

            val state = 2
            transaction
                .replace(R.id.main_frm, SignUpFragment(state))
                .addToBackStack(null)
                .commit()
            transaction.isAddToBackStackAllowed
        }
    }

//    override fun onGetLoginSuccess(response: GetLoginResponse) {
//        val editor = ApplicationClass.sSharedPreferences.edit()
//        editor.putString("email", email)
//        editor.putString("password", password)
//        editor.putString(X_ACCESS_TOKEN, response.x_auth_token)
//        editor.apply()
//
//        val fm = requireActivity().supportFragmentManager
//
//        fm.popBackStack()
//
//    }
//
//    override fun onGetLoginFailure(message: String) {
//        showCustomToast("등록되어 있지 않은 정보입니다. 다시 시도해주세요.")
//    }
}