package com.example.ahmedrazaidrees.viewmodel_retrofit

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.LiveData
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HeroViewModel : ViewModel() {

    private var heroList: MutableLiveData<List<Hero>>? = null

    fun getHeroes(): LiveData<List<Hero>> {
        //if the list is null
        if (heroList == null) {
            heroList = MutableLiveData()
            //we will load it asynchronously from server in this method
            loadHeroes()
        }

        //finally we will return the list
        return heroList as MutableLiveData<List<Hero>>
    }


    private fun loadHeroes(){
        val retrofit = Retrofit.Builder()
                .baseUrl("https://simplifiedcoding.net/demos/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val api = retrofit.create(Api::class.java)
        val call = api.getHeroes()

        call.enqueue(object : Callback<List<Hero>> {
            override fun onFailure(call: Call<List<Hero>>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<List<Hero>>?, response: Response<List<Hero>>?) {

                heroList!!.value=response!!.body()
            }

        })


    }
}


private fun <T> Call<T>.enqueue(callback: Callback<List<Hero>>) {

}




