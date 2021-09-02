package com.example.restaurantmenu

class Category {
    var name: String? = null
    var image: Int? = null

    constructor(name: String, image: Int) {
        this.image = image
        this.name = name
    }
}