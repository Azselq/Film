// не было пакета
package com.example.filmprac.response

import com.example.filmprac.model.Films
import com.google.gson.annotations.SerializedName

data class FilmList(

    @SerializedName("films") val films: List<Films>

)