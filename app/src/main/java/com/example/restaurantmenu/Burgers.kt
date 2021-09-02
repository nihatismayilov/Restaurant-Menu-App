package com.example.restaurantmenu

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_burgers.*
import kotlinx.android.synthetic.main.price_ticket.view.*

class Burgers : AppCompatActivity() {
    var listOfBurgers = ArrayList<Price>()
    var burgerAdapter: BurgerAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_burgers)

        listOfBurgers.add(Price("Beef Burger","15$",R.drawable.burger_beefburger))
        listOfBurgers.add(Price("Elk-Burger","25$",R.drawable.burger_elkburger))
        listOfBurgers.add(Price("Turkey Burger","13$",R.drawable.burger_turkeyburger))
        listOfBurgers.add(Price("Veggie-Burger","18$",R.drawable.burger_veggieburger))
        listOfBurgers.add(Price("Double Cheeseburger","28$",R.drawable.burger_doublecheeseburger))
        listOfBurgers.add(Price("Bison Burger","21$",R.drawable.burger_bisonburger))
        listOfBurgers.add(Price("Black Bean Burger","32$",R.drawable.burger_blackbeanburger))
        burgerAdapter = BurgerAdapter(this, listOfBurgers)
        gv_Burgers.adapter = burgerAdapter
    }

    class BurgerAdapter(): BaseAdapter() {
        var listOfBurger = ArrayList<Price>()
        var context: Context? = null

        constructor(context: Context, listOfBurger: ArrayList<Price>): this() {
            this.context = context
            this.listOfBurger = listOfBurger
        }
        override fun getCount(): Int {
            return listOfBurger.size
        }

        override fun getItem(position: Int): Any {
            return listOfBurger[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var burger = listOfBurger[position]
            var burgerinflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var burgerView = burgerinflater.inflate(R.layout.price_ticket, null)

            burgerView.ivPriceImage.setImageResource(burger.image!!)
            burgerView.tvPriceName.text = burger.name
            burgerView.tvPrice.text = burger.price

            return burgerView
        }

    }
}