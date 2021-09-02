package com.example.restaurantmenu

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.restaurantmenu.Price
import com.example.restaurantmenu.R
import kotlinx.android.synthetic.main.activity_pizza.*
import kotlinx.android.synthetic.main.price_ticket.view.*

class Pizza : AppCompatActivity() {
    private var listOfPizzas = ArrayList<Price>()
    private var pizzaAdapter: PizzaAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pizza)

        listOfPizzas.add(Price("BBQ Pizza","9.00$",R.drawable.pizza_bbq))
        listOfPizzas.add(Price("Chicken Pizza","8.00$",R.drawable.pizza_chicken))
        listOfPizzas.add(Price("Margarita Pizza","8.50$",R.drawable.pizza_margherite))
        listOfPizzas.add(Price("Veggie Pizza","11.50$",R.drawable.pizza_veggie))
        listOfPizzas.add(Price("Buffalo Pizza","13.30$",R.drawable.pizza_buffalo))
        pizzaAdapter = PizzaAdapter(this, listOfPizzas)
        gv_Pizza.adapter = pizzaAdapter
    }

    class PizzaAdapter(): BaseAdapter() {
        var listOfPizza = ArrayList<Price>()
        var context: Context? = null

        constructor(context: Context, listOfPizza: ArrayList<Price>) : this() {
            this.context = context
            this.listOfPizza = listOfPizza
        }
        override fun getCount(): Int {
            return listOfPizza.size
        }

        override fun getItem(position: Int): Any {
            return listOfPizza[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var pizza = listOfPizza[position]
            var pizzainflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var pizzaView = pizzainflater.inflate(R.layout.price_ticket, null)

            pizzaView.ivPriceImage.setImageResource(pizza.image!!)
            pizzaView.tvPriceName.text = pizza.name
            pizzaView.tvPrice.text = pizza.price

            return pizzaView
        }

    }
}