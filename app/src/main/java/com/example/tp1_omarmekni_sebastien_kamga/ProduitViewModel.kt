package com.example.tp1_omarmekni_sebastien_kamga

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProduitViewModel : ViewModel() {


    // La lista dei prodotti disponibili.
    val listeProduits: MutableLiveData<List<Produit>> = MutableLiveData()

    init {
        loadProduits() // Carica i prodotti quando il ViewModel è creato
    }

    // La lista dei prodotti aggiunti al carrello.
    private val _cartItems = MutableLiveData<List<Produit>>(listOf())
    val cartItems: LiveData<List<Produit>> = _cartItems

    // Metodo per aggiungere un prodotto al carrello.
    fun addToCart(produit: Produit) {
        val currentItems = _cartItems.value ?: listOf()
        _cartItems.value = currentItems + produit
    }

//    fun loadProduits() {
//        listeProduits.value = listOf(
//            Produit(R.drawable.img_1, "Iphone 15 pro",1400.99),
//            Produit(R.drawable.img_2, "Samsung S23",1235.99),
//            Produit(R.drawable.img_3, "Motorola razr",900.99),
//            Produit(R.drawable.img_4, "Hp EliteBook 860",1900.99),
//            Produit(R.drawable.img_5, "LG UltraWide 34",460.99),
//            Produit(R.drawable.img_6, "Ipad pro",1499.99),
//            Produit(R.drawable.img_7, "Apple Watch serie 9",879.99)
//
//        )
//    }


    private fun loadProduits() {
        listeProduits.value = listOf(
            Produit(R.drawable.img_1, "Iphone 15 pro",1400.99),
            Produit(R.drawable.img_2, "Samsung S23",1235.99),
            Produit(R.drawable.img_3, "Motorola razr",900.99),
            Produit(R.drawable.img_4, "Hp EliteBook 860",1900.99),
            Produit(R.drawable.img_5, "LG UltraWide 34",460.99),
            Produit(R.drawable.img_6, "Ipad pro",1499.99),
            Produit(R.drawable.img_7, "Apple Watch serie 9",879.99)
        )
    }

}


