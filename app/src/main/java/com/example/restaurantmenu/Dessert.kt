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
import kotlinx.android.synthetic.main.activity_dessert.*
import kotlinx.android.synthetic.main.price_ticket.view.*

class Dessert : AppCompatActivity() {
    private var listOfDesserts = ArrayList<Price>()
    private var dessertAdapter: DessertAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dessert)

        listOfDesserts.add(Price("Biscuit","1.50$",R.drawable.dessert_biscuit))
        listOfDesserts.add(Price("Cookie","2.00$",R.drawable.dessert_cookie))
        listOfDesserts.add(Price("Fruit Cake","7.50$",R.drawable.dessert_fruitcake))
        listOfDesserts.add(Price("Chocolate Cake","9.50$",R.drawable.dessert_chocolatecake))
        listOfDesserts.add(Price("Ice Cream","2.30$",R.drawable.dessert_icecream))
        listOfDesserts.add(Price("Pudding","1.80$",R.drawable.dessert_pudding))
        listOfDesserts.add(Price("Chocolate Cheesecake","9.50$",R.drawable.dessert_cheesecake_chocolate))
        listOfDesserts.add(Price("Key Lime Cheesecake","5.30$",R.drawable.dessert_cheesecake_keylime))
        listOfDesserts.add(Price("NewYork-Style Cheesecake","11.00$",R.drawable.dessert_cheesecake_newyork))
        listOfDesserts.add(Price("Pumpkin Cheesecake","5.00$",R.drawable.dessert_cheesecake_pumpkin))
        listOfDesserts.add(Price("Strawberry Cheesecake","9.00$",R.drawable.dessert_cheesecake_strawberry))
        listOfDesserts.add(Price("White Chocolate Cheesecake","13.00$",R.drawable.dessert_cheesecake_whitechocolate))
        listOfDesserts.add(Price("Apple Pie","7.70$",R.drawable.dessert_pie_apple))
        listOfDesserts.add(Price("Cherry Pie","8.00$",R.drawable.dessert_pie_cherry))
        listOfDesserts.add(Price("Pecan Pie","9.50$",R.drawable.dessert_pie_pecan))
        listOfDesserts.add(Price("Sugar Cream Pie","7.70$",R.drawable.dessert_pie_sugarcream))
        dessertAdapter = DessertAdapter(this, listOfDesserts)
        gv_Dessert.adapter = dessertAdapter
    }

    class DessertAdapter(): BaseAdapter() {
        var listOfDessert = ArrayList<Price>()
        var context: Context? = null

        constructor(context: Context, listOfDessert: ArrayList<Price>): this() {
            this.context = context
            this.listOfDessert = listOfDessert
        }
        override fun getCount(): Int {
            return listOfDessert.size
        }

        override fun getItem(position: Int): Any {
            return listOfDessert[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var dessert = listOfDessert[position]
            var dessertinflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var dessertView = dessertinflater.inflate(R.layout.price_ticket, null)

            dessertView.ivPriceImage.setImageResource(dessert.image!!)
            dessertView.tvPriceName.text = dessert.name
            dessertView.tvPrice.text = dessert.price

            return dessertView
        }

    }
}