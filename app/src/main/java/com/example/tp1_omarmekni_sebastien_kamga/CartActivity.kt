package com.example.tp1_omarmekni_sebastien_kamga

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class CartActivity : AppCompatActivity() {



    private lateinit var recyclerView: RecyclerView
    private lateinit var cartAdapter: CartAdapter
    private val viewModel: ProduitViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        recyclerView = findViewById(R.id.recycler_view_cart)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Recupera la lista dei prodotti passati come extra dall'intent
        val listaProdotti = viewModel.cartItems.value


        // Inizializza l'adapter con la lista dei prodotti
        if (listaProdotti != null) {
            cartAdapter = CartAdapter(listaProdotti.toMutableList())
            recyclerView.adapter = cartAdapter
        }
    }


}

//    private lateinit var recyclerView: RecyclerView
//    private val viewModel: ProduitViewModel by viewModels()


//    private lateinit var recyclerView: RecyclerView
//    private lateinit var cartAdapter: CartAdapter

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_cart)





//        recyclerView = findViewById(R.id.recycler_view_cart)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        val cartAdapter = CartAdapter(mutableListOf()) // Usa la variabile corretta qui
////
//        recyclerView.adapter = cartAdapter // Assicurati di usare la variabile cartAdapter
////
//        // Osserva i cambiamenti nella lista del carrello.
//        // Nota: questa parte del codice funzionerà solo se cartItems è una LiveData.
//        viewModel.cartItems.observe(this, Observer { cartItems ->
//            // Aggiorna l'adapter con la lista aggiornata di prodotti nel carrello.
//            cartAdapter.updateItems(cartItems)
//        })

//        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view_cart)
//        val listaProdotti = intent.getStringExtra("listaProdotti")
//        println(listaProdotti)


//        val listaProdotti: ArrayList<Produit>? = intent.getParcelableArrayListExtra("listaProdotti")
//
//        if (listaProdotti != null) {
//            val cartAdapter = CartAdapter(listaProdotti)
//            recyclerView.adapter = cartAdapter
//            recyclerView.layoutManager = LinearLayoutManager(this)
//        } else {
//            // Gestisci il caso in cui l'extra dell'intent sia nullo o la lista dei prodotti sia vuota.
//        }

//        recyclerView = findViewById(R.id.recycler_view_cart)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//
//        // Recupera la lista dei prodotti passati come extra dall'intent
//        val listaProdotti: ArrayList<Produit>? = intent.getParcelableArrayListExtra("listaProdotti")
//
//        // Inizializza l'adapter con la lista dei prodotti
//        if (listaProdotti != null) {
//            cartAdapter = CartAdapter(listaProdotti)
//            recyclerView.adapter = cartAdapter
//        }
//    }





//}
