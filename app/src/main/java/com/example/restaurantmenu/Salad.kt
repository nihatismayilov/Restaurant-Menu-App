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
import kotlinx.android.synthetic.main.activity_salad.*
import kotlinx.android.synthetic.main.price_ticket.view.*

class Salad : AppCompatActivity() {
    private var listOfSalads = ArrayList<Price>()
    private var saladAdapter: SaladAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_salad)

        listOfSalads.add(Price("Greek Salad", "4.30$", R.drawable.salad_greek))
        listOfSalads.add(Price("Chicken Salad", "6.50$", R.drawable.salad_chicken))
        listOfSalads.add(Price("Cobb Salad", "7.00$", R.drawable.salad_cobb))
        listOfSalads.add(Price("Fattoush Salad", "5.00$", R.drawable.salad_fattoush))
        listOfSalads.add(Price("Niçoise Salad", "10.00$", R.drawable.salad_nicoise))
        listOfSalads.add(Price("Slaw Salad", "7.70$", R.drawable.salad_slaw))
        listOfSalads.add(Price("Wedge Salad", "11.30$", R.drawable.salad_wedge))
        listOfSalads.add(Price("Caesar Salad", "15.00$", R.drawable.salad_caesar))
        saladAdapter = SaladAdapter(this, listOfSalads)
        gv_Salad.adapter = saladAdapter
    }

    class SaladAdapter(): BaseAdapter() {
        var listOfPizza = ArrayList<Price>()
        var context: Context? = null

        constructor(context: Context, listOfPizza: ArrayList<Price>): this() {
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
            var salad = listOfPizza[position]
            var saladifnlater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var saladView = saladifnlater.inflate(R.layout.price_ticket, null)

            saladView.ivPriceImage.setImageResource(salad.image!!)
            saladView.tvPriceName.text = salad.name
            saladView.tvPrice.text = salad.price

            return saladView
        }

    }
}