package com.example.ahmedrazaidrees.viewmodel_retrofit

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.arch.lifecycle.ViewModelProviders



class MainActivity : AppCompatActivity() {

    private lateinit var  mMessageRecyclerview: RecyclerView

    private lateinit var  mMessageAdapter: RecyclerView.Adapter<*>


    private lateinit var layoutManager: RecyclerView.LayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mMessageRecyclerview = findViewById(R.id.recyclerview) as RecyclerView
        mMessageRecyclerview.setHasFixedSize(true);

        mMessageRecyclerview.setLayoutManager( LinearLayoutManager(this));

        var model = ViewModelProviders.of(this).get(HeroViewModel::class.java!!)
        model.getHeroes().observe(this, Observer {

            mMessageAdapter = HeroAdapter(this@MainActivity,R.layout.recyclerview_layout,it!! )

            mMessageRecyclerview.adapter=mMessageAdapter
        })

    }









}
