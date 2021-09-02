package com.example.restaurantmenu

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.restaurantmenu.Price
import com.example.restaurantmenu.R
import kotlinx.android.synthetic.main.activity_drink.*
import kotlinx.android.synthetic.main.price_ticket.view.*


class Drink : AppCompatActivity() {
    private var listOfDrinks = ArrayList<Price>()
    private var drinkAdapter: DrinkAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drink)

        listOfDrinks.add(Price("Water","1.00$",R.drawable.drink_water))
        listOfDrinks.add(Price("Tea","3.00$",R.drawable.drink_tea))
        listOfDrinks.add(Price("Coffee","5.50$",R.drawable.drink_coffee))
        listOfDrinks.add(Price("Espresso","6.00$",R.drawable.drink_expresso))
        listOfDrinks.add(Price("Coca Cola","4.00$",R.drawable.drink_cola))
        listOfDrinks.add(Price("Fanta","4.00$",R.drawable.drink_fanta))
        listOfDrinks.add(Price("Sprite","4.00$",R.drawable.drink_sprite))
        listOfDrinks.add(Price("Limonade","2.50$",R.drawable.drink_limonade))
        listOfDrinks.add(Price("Mohito","24.00$",R.drawable.drink_moxito))
        listOfDrinks.add(Price("Red Wine Green",  "18.00$",R.drawable.drink_redwine))
        listOfDrinks.add(Price("White Wine","18.00$",R.drawable.drink_whitewine))
        drinkAdapter = DrinkAdapter(this, listOfDrinks)
        gv_Drink.adapter = drinkAdapter
    }

    class DrinkAdapter(): BaseAdapter() {
        var listOfDrink = ArrayList<Price>()
        var context: Context? = null

        constructor(context: Context, listOfDrink: ArrayList<Price>): this() {
            this.context = context
            this.listOfDrink = listOfDrink
        }

        override fun getCount(): Int {
            return listOfDrink.size
        }

        override fun getItem(position: Int): Any {
            return listOfDrink[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var drink = listOfDrink[position]
            var drinkinflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var drinkView = drinkinflater.inflate(R.layout.price_ticket, null)

            drinkView.ivPriceImage.setImageResource(drink.image!!)
            drinkView.tvPriceName.text = drink.name
            drinkView.tvPrice.text = drink.price

            return drinkView
        }
    }
}