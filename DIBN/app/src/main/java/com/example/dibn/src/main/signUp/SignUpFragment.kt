package com.example.dibn.src.main.signUp

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.dibn.R
import com.example.dibn.config.BaseFragment
import com.example.dibn.databinding.FragmentSignUpBinding
import com.example.dibn.src.main.home.HomeFragment
import com.example.dibn.src.main.signUp.retrofit.consumer.PostSignConsumerRequest
import com.example.dibn.src.main.signUp.retrofit.consumer.PostSignConsumerResponse
import com.example.dibn.src.main.signUp.retrofit.consumer.ISignConsumerView
import com.example.dibn.src.main.signUp.retrofit.consumer.SignConsumerService
import com.example.dibn.src.main.signUp.retrofit.owner.ISignOwnerView
import com.example.dibn.src.main.signUp.retrofit.owner.PostSignOwnerRequest
import com.example.dibn.src.main.signUp.retrofit.owner.PostSignOwnerResponse
import com.example.dibn.src.main.signUp.retrofit.owner.SignOwnerService

class SignUpFragment(val state: Int)  : BaseFragment<FragmentSignUpBinding>(FragmentSignUpBinding::bind, R.layout.fragment_sign_up)
{
    lateinit var email : String
    lateinit var password : String
    lateinit var address : String
    lateinit var nickname : String
    lateinit var phone : String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        when(state) {
            2 -> {
                binding.signShopName.visibility = View.VISIBLE
            }
        }
        binding.btnSignUp.setOnClickListener {
            email = binding.signEmail.text.toString()
            password = binding.signPassword.text.toString()
            nickname = binding.signName.text.toString()
            phone = binding.signCall.text.toString()

            val fm = requireActivity().supportFragmentManager
            val transaction: FragmentTransaction = fm.beginTransaction()

            transaction
                .replace(R.id.main_frm, SignFragment())
                .commit()
            transaction.isAddToBackStackAllowed
        }
//            when(state) {
//                1 -> {
//                    address = binding.signConsumerAddress.toString()
//                    try {
//                        val postSignReq = PostSignConsumerRequest(
//                            email = email,
//                            password = password,
//                            address = address,
//                            nickname = nickname,
//                            phone = phone,
//                            role = "USER"
//                        )
//                        SignConsumerService(this).tryPostSign(postSignReq)
//                    }
//                    catch (e : Exception) {
//                        Log.e("TAG", e.toString())
//                    }
//                }
//                2 -> {
//                    try {
//                        val marketName = binding.signShopName.text.toString()
//                        val postSignReq = PostSignOwnerRequest(
//                            email = email,
//                            password = password,
//                            address = address,
//                            nickname = nickname,
//                            phone = phone,
//                            marketName = marketName,
//                            role = "MARKET"
//                        )
//                        SignOwnerService(this).tryPostSign(postSignReq)
//                    }
//                    catch (e : Exception) {
//                        showCustomToast("입력을 모두 완료해주세요.")
//                    }
//                }
//            }
    }

//    override fun onPostSignConsumerSuccess(consumerResponse: PostSignConsumerResponse) {
//        val fm = requireActivity().supportFragmentManager
//        val transaction: FragmentTransaction = fm.beginTransaction()
//
//        fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
//
//        transaction
//            .add(R.id.main_frm, SignFragment())
//            .addToBackStack(null)
//            .commit()
//        transaction.isAddToBackStackAllowed
//    }
//    override fun onPostSignConsumerFailure(message: String) {
//        showCustomToast("회원가입 실패했습니다. 다시 시도해주세요.")
//    }
//
//    override fun onPostSignOwnerSuccess(ownerResponse: PostSignOwnerResponse) {
//        val fm = requireActivity().supportFragmentManager
//        val transaction: FragmentTransaction = fm.beginTransaction()
//
//        fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
//
//        transaction
//            .add(R.id.main_frm, SignFragment())
//            .addToBackStack(null)
//            .commit()
//        transaction.isAddToBackStackAllowed
//    }
//
//    override fun onPostSignOwnerFailure(message: String) {
//        showCustomToast("회원가입 실패했습니다. 다시 시도해주세요.")
//    }

}