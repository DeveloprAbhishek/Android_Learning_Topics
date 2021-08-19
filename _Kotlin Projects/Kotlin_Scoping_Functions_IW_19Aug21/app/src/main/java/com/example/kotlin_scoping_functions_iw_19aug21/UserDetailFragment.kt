package com.example.kotlin_scoping_functions_iw_19aug21

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_user_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserDetailFragment : Fragment(R.layout.fragment_user_detail) {


    private lateinit var responseUser: ResponseUser
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnFetchData.setOnClickListener{
            callApi()
        }
    }

    private fun callApi() {
        var apiService = Network.getInstance().create(ApiService::class.java)
        apiService.getUserData(2)
            .enqueue(object : Callback<ResponseUser> {
                override fun onResponse(
                    call: Call<ResponseUser>,
                    response: Response<ResponseUser>
                ) {
                    response.body()?.run {
                        responseUser = this

                        responseUser.data?.apply {
                            tvFirstName.text = firstName
                            tvLastName.text = lastName
                            Glide.with(ivUserImage).load(avatar).into(ivUserImage)
                        }
                    }
                }

                override fun onFailure(call: Call<ResponseUser>, t: Throwable) {
                }

            })
    }

}