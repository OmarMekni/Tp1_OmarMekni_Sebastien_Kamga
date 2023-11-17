package com.example.tp1_omarmekni_sebastien_kamga

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProduitAdapter(
    private val listeProduits: MutableList<Produit>, // Cambia in MutableList
    private val onAddToCart: (Produit) -> Unit
) : RecyclerView.Adapter<ProduitAdapter.ProduitViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProduitViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.produit_item, parent, false)
        return ProduitViewHolder(view, onAddToCart)
    }

    override fun onBindViewHolder(holder: ProduitViewHolder, position: Int) {
        val produit = listeProduits[position]
        holder.bind(produit)
    }

    override fun getItemCount() = listeProduits.size

    // Aggiorna la lista di prodotti e notifica l'adapter
    fun updateItems(newItems: List<Produit>) {
        listeProduits.clear()
        listeProduits.addAll(newItems)
        notifyDataSetChanged()
    }

    class ProduitViewHolder(
        itemView: View,
        private val onAddToCart: (Produit) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {
        private val photo: ImageView = itemView.findViewById(R.id.photo)
        private val nom: TextView = itemView.findViewById(R.id.nom)
        private val prix: TextView = itemView.findViewById(R.id.prix)
        val addToCartButton: Button = itemView.findViewById(R.id.ajouter)

        fun bind(produit: Produit) {
            photo.setImageResource(produit.photo)
            nom.text = produit.nom
            prix.text = itemView.context.getString(R.string.price_format, produit.prix)
            addToCartButton.setOnClickListener { onAddToCart(produit) }
        }
    }
}

