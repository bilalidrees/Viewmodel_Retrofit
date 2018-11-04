package com.example.ahmedrazaidrees.viewmodel_retrofit

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide


data class HeroAdapter(var context: Context, var resource: Int, var heroList: List<Hero>) : RecyclerView.Adapter<HeroAdapter.HeroViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder
            =HeroViewHolder( LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_layout, parent, false))



    override fun getItemCount(): Int {
        return if (this.heroList!= null) {
            this.heroList.size

        } else {
            0
        }
    }



    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {

        var hero=heroList[position]

        Glide.with(context)
                .load(hero.imageurl)
                .into(holder.imageView);

        holder.textView.setText(hero.name);



    }









    class HeroViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Holds the TextView that will add each animal to

        var imageView =view.findViewById<ImageView>(R.id.imageView);
        var textView =view.findViewById<TextView>(R.id.textView)


    }


}