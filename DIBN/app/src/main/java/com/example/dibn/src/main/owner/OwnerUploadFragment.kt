package com.example.dibn.src.main.owner

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.dibn.R
import com.example.dibn.config.BaseFragment
import com.example.dibn.databinding.FragmentOwnerUploadBinding
import retrofit2.http.Body
import retrofit2.http.POST
import java.io.FileReader
import java.io.IOException
import java.lang.Exception
import java.lang.Integer.parseInt

class OwnerUploadFragment : BaseFragment<FragmentOwnerUploadBinding>(FragmentOwnerUploadBinding::bind, R.layout.fragment_owner_upload)
,InftView{
    lateinit var name:String
    lateinit var artist:String
    lateinit var description:String
    var price = 0
    var period = 0
    lateinit var nft_password:String
    lateinit var category: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var jsonData = getJsonDataFromAsset()

        binding.btnSubmit.setOnClickListener {
            val fm = requireActivity().supportFragmentManager
            val transaction: FragmentTransaction = fm.beginTransaction()

            try {
                name = binding.goodsName.text.toString()
                artist = binding.artist.text.toString()
                description = binding.description.text.toString()
                nft_password = binding.nftPassword.text.toString()
                category = binding.category.text.toString()
                price = parseInt(binding.goodsPrice.text.toString())
                period = parseInt(binding.goodsPeriod.text.toString())

                jsonData = "{\n\"nft\": {\n\"keystore\":{\n" + jsonData

                jsonData += ",\n\"name\": \"$name\","
                jsonData += "\n\"category\": \"$category\","
                jsonData += "\n\"artist\": \"$artist\","
                jsonData += "\n\"price\": \"$price\","
                jsonData += "\n\"period\": \"$period\","
                jsonData += "\n\"description\": \"$description\"\n}"
//
//                NftService(this).tryPostNft(PostNftRequest(json = jsonData!!))

                transaction
                    .replace(R.id.main_frm, SubmitFInFragment())
                    .commitAllowingStateLoss()
                transaction.isAddToBackStackAllowed
            }
            catch (e : Exception) {
                showCustomToast("다시 입력해주세요.")
            }
        }
    }

    fun getJsonDataFromAsset(): String? {
        val jsonString: String
        try{
            jsonString = requireActivity().assets.open("market1.json")
                .bufferedReader()
                .use{it.readText()}
        } catch (e : IOException) {
            e.printStackTrace()
            return null
        }
        return jsonString
    }

    override fun onPostNftSuccess(response: PostNftResponse) {
        val fm = requireActivity().supportFragmentManager
        val transaction: FragmentTransaction = fm.beginTransaction()

        transaction
            .replace(R.id.main_frm, SubmitFInFragment())
            .commitAllowingStateLoss()
        transaction.isAddToBackStackAllowed
    }

    override fun onPostNftFailure(message: String) {
        showCustomToast("다시 시도해주세요")
    }
}