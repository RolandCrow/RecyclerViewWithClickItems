package com.example.recyclerviewwithclickitems

import android.os.Parcel
import android.os.Parcelable

data class Food(
    val name: String,
    val image: Int,
    val recipe: String
    ): Parcelable {
        constructor(parcel: Parcel): this(
            parcel.readString()!!,
            parcel.readInt(),
            parcel.readString()!!
        )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(image)
        parcel.writeString(recipe)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Food> {
        override fun createFromParcel(parcel: Parcel): Food {
            return Food(parcel)
        }

        override fun newArray(size: Int): Array<Food?> {
            return arrayOfNulls(size)
        }
    }
}


