package com.example.restaurantmenu

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.restaurantmenu.Dessert
import com.example.restaurantmenu.Pizza
import com.example.restaurantmenu.Salad
import kotlinx.android.synthetic.main.activity_foods.*
import kotlinx.android.synthetic.main.ticket.view.*

class Foods : AppCompatActivity() {
    private var listOfFoods = ArrayList<Category>()
    private var foodAdapter: FoodAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foods)

        listOfFoods.add(Category("Burgers", R.drawable.category_burger))
        listOfFoods.add(Category("Pizza", R.drawable.category_pizza))
        listOfFoods.add(Category("Salads", R.drawable.category_salats))
        listOfFoods.add(Category("Drinks", R.drawable.category_drinks))
        listOfFoods.add(Category("Desserts", R.drawable.category_icecream))
        foodAdapter = FoodAdapter(this, listOfFoods)
        gv_Foods.adapter = foodAdapter
    }

    class FoodAdapter() : BaseAdapter() {
        var listOfFood = ArrayList<Category>()
        var context: Context? = null

        constructor(context: Context, listOfFood: ArrayList<Category>) : this() {
            this.context = context
            this.listOfFood = listOfFood
        }

        override fun getCount(): Int {
            return listOfFood.size
        }

        override fun getItem(position: Int): Any {
            return listOfFood[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var food = listOfFood[position]
            var foodinflater =
                context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var foodView = foodinflater.inflate(R.layout.ticket, null)

            foodView.ticket_Picture.setImageResource(food.image!!)
            foodView.ticket_Name.text = food.name

            foodView.ticket_Picture.setOnClickListener {
                if (food.image == R.drawable.category_burger) {
                    var burgerintent = Intent(context, Burgers::class.java)
                    context!!.startActivity(burgerintent)
                } else if (food.image == R.drawable.category_pizza) {
                    var pizzaintent = Intent(context, Pizza::class.java)
                    context!!.startActivity(pizzaintent)
                } else if (food.image == R.drawable.category_salats) {
                    var saladintent = Intent(context, Salad::class.java)
                    context!!.startActivity(saladintent)
                } else if (food.image == R.drawable.category_icecream) {
                    var dessertintent = Intent(context, Dessert::class.java)
                    context!!.startActivity(dessertintent)
                } else if (food.image == R.drawable.category_drinks) {
                    var drinkintent = Intent(context, Drink::class.java)
                    context!!.startActivity(drinkintent)
                }
            }

            return foodView
        }

    }
}