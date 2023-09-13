package com.example.listmoviereal.domain.model

import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.RequiresApi
import com.example.listmoviereal.data.database.entities.MoviesEntity
import com.example.listmoviereal.data.model.MoviesModel

data class Movies(
    val id:Long,
    val titulo:String,
    val fecha:String,
    val duracion:String,
    val genero:String,
    val portada:String,
    var corazon: Boolean
                   ): Parcelable {

    @RequiresApi(Build.VERSION_CODES.Q)
    constructor(parcel: Parcel) : this(
        (parcel.readLong() ?:"") as Long,
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        (parcel.readBoolean() ?: "") as Boolean
    )

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(titulo)
        parcel.writeString(fecha)
        parcel.writeString(duracion)
        parcel.writeString(genero)
        parcel.writeString(portada)
        parcel.writeBoolean(corazon)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Movies> {
        @RequiresApi(Build.VERSION_CODES.Q)
        override fun createFromParcel(parcel: Parcel): Movies {
            return Movies(parcel)
        }

        override fun newArray(size: Int): Array<Movies?> {
            return arrayOfNulls(size)
        }
    }
}

fun MoviesModel.toDomain() = Movies(id,titulo,fecha,duracion,genero,portada,corazon)
fun MoviesEntity.toDomain() = Movies(id,titulo,fecha,duracion,genero,portada,corazon)
