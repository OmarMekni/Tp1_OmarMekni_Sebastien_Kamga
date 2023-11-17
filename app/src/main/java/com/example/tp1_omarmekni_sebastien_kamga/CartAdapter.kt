package com.example.tp1_omarmekni_sebastien_kamga

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CartAdapter(private val items: MutableList<Produit>) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    // Questa funzione aggiorna l'elenco degli elementi e notifica all'adapter che i dati sono cambiati.
    fun updateItems(newItems: List<Produit>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_produit, parent, false)
        return CartViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val produit = items[position]
        holder.bind(produit)
    }

    override fun getItemCount() = items.size

    class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val photo: ImageView = itemView.findViewById(R.id.photo)
        private val nom: TextView = itemView.findViewById(R.id.nom)
        private val prix: TextView = itemView.findViewById(R.id.prix)

        fun bind(produit: Produit) {
            photo.setImageResource(produit.photo)
            nom.text = produit.nom
            prix.text = itemView.context.getString(R.string.price_format, produit.prix)
        }
    }
}