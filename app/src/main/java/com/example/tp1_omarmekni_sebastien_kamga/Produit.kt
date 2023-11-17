package com.example.tp1_omarmekni_sebastien_kamga

import android.os.Parcel
import android.os.Parcelable

//data class Produit(var photo: Int, var nom: String, var prix: Double) {
//
//}

data class Produit(var photo: Int, var nom: String, var prix: Double) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readDouble()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(photo)
        parcel.writeString(nom)
        parcel.writeDouble(prix)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Produit> {
        override fun createFromParcel(parcel: Parcel): Produit {
            return Produit(parcel)
        }

        override fun newArray(size: Int): Array<Produit?> {
            return arrayOfNulls(size)
        }
    }
}