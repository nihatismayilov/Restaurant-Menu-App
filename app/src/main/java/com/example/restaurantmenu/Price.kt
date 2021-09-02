package com.example.restaurantmenu

class Price {
    var name:String? = null
    var price:String? = null
    var image:Int? = null

    constructor(name:String, price: String, image: Int) {
        this.name = name
        this.price = price
        this.image = image
    }
}