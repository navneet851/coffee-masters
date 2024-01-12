package com.orderapp.coffeemasters

data class Product(var id : Int, var name : String, var price : Double, var image : String) {
    val imageUrl get() = "https://firtman.github.io/coffeemasters/api/images/${this.image}"
}

data class Category(var name : String, var products : MutableList<Product>)

data class ItemInCart(var product: Product, var quantity : Int)