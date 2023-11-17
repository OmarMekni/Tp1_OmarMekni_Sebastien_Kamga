package com.example.tp1_omarmekni_sebastien_kamga


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class MainActivity : AppCompatActivity() {


    private lateinit var recyclerView: RecyclerView
    private val viewModel: ProduitViewModel by viewModels()
    private lateinit var adapter: ProduitAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view_cart)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Inizializza l'adapter con una MutableList vuota.
        adapter = ProduitAdapter(mutableListOf()) { produit ->
            aggiungiProdotto(produit)

        }
        recyclerView.adapter = adapter

        // Osserva i cambiamenti nella lista dei prodotti e aggiorna l'adapter quando cambiano.
        viewModel.listeProduits.observe(this, Observer { produits ->
            // Assicurati che l'adapter accetti una MutableList e abbia un metodo per aggiornare i dati.
            adapter.updateItems(produits ?: emptyList())
        })

        val pannier = findViewById<ImageView>(R.id.pannier)

        // Carica il layout dell'altro layout
        val altroLayout = LayoutInflater.from(this).inflate(R.layout.produit_item, null)

        // Trova il bottone nel layout dell'altro layout
        val bottoneAjouter = altroLayout.findViewById<Button>(R.id.ajouter)

        bottoneAjouter.setOnClickListener {
            // Crea un oggetto Prodotto con i dati appropriati (foto, nome, prezzo)
            val prodottoSelezionato = Produit(R.drawable.img_1, "Nome Prodotto", 9.99)
            // Aggiungi il prodotto alla lista
            aggiungiProdotto(prodottoSelezionato)

            val intent = Intent(this, CartActivity::class.java)
            startActivity(intent)

        }

        // OnClickListener per l'icona del carrello.
        pannier.setOnClickListener {
            val intent = Intent(this, CartActivity::class.java)
            startActivity(intent)
        }
    }

    // Funzione per aggiungere un prodotto alla lista
    private fun aggiungiProdotto(prodotto: Produit) {
        viewModel.addToCart(prodotto)
        Toast.makeText(this, "${prodotto.nom} aggiunto al carrello", Toast.LENGTH_SHORT).show()
    }

}











//    private lateinit var recyclerView: RecyclerView
//    private val viewModel: ProduitViewModel by viewModels()
//    private lateinit var adapter: ProduitAdapter
//
//    private val listaProdottiSelezionati = mutableListOf<Produit>()
//
//    // Funzione per aggiungere un prodotto alla lista
//    private fun aggiungiProdotto(prodotto: Produit) {
//        listaProdottiSelezionati.add(prodotto)
//        Toast.makeText(this, "${prodotto.nom} aggiunto al carrello", Toast.LENGTH_SHORT).show()
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        recyclerView = findViewById(R.id.recycler_view_cart)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//
//
//        // Inizializza l'adapter con una MutableList vuota.
//        adapter = ProduitAdapter(mutableListOf()) { produit ->
//            viewModel.addToCart(produit)
//            Toast.makeText(this, "${produit.nom} aggiunto al carrello", Toast.LENGTH_SHORT).show()
//        }
//        recyclerView.adapter = adapter
//
//        // Osserva i cambiamenti nella lista dei prodotti e aggiorna l'adapter quando cambiano.
//        viewModel.listeProduits.observe(this, Observer { produits ->
//            // Assicurati che l'adapter accetti una MutableList e abbia un metodo per aggiornare i dati.
//            adapter.updateItems(produits ?: emptyList())
//        })
//
//
//
//        val pannier = findViewById<ImageView>(R.id.pannier)
//
//        // Carica il layout dell'altro layout
//        val altroLayout = LayoutInflater.from(this).inflate(R.layout.item_produit, null)
//
//        // Trova il bottone nel layout dell'altro layout
//        val bottoneAjouter = altroLayout.findViewById<Button>(R.id.ajouter)
//
//
//        bottoneAjouter.setOnClickListener{
////            val intentToCartActivity = Intent(this,CartActivity::class.java)
////            intentToCartActivity.putExtra("listaProdotti",liste)
////            startActivity(intentToCartActivity)
//            // Crea un oggetto Prodotto con i dati appropriati (foto, nome, prezzo)
//            val prodottoSelezionato = Produit(R.drawable.img_1, "Nome Prodotto", 9.99)
//            // Aggiungi il prodotto alla lista
//            aggiungiProdotto(prodottoSelezionato)
//
//            val intent = Intent(this,CartActivity::class.java).apply {
//                putExtra("listaProdotti",ArrayList(listaProdottiSelezionati))
//
//            }
//            startActivity(intent)
//
//
//        }
//
//
//
//        // OnClickListener per l'icona del carrello.
//        findViewById<ImageView>(R.id.pannier).setOnClickListener {
//            val intent = Intent(this, CartActivity::class.java)
//            startActivity(intent)
//        }
//
//    }
//}