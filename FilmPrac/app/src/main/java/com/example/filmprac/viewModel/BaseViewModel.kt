// не было пакета
package com.example.filmprac.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.filmprac.model.Films
import com.example.filmprac.response.FilmList
import com.example.filmprac.rest.FilmRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BaseViewModel : ViewModel() {

    private val repository = FilmRepository()

    // имена переменых с маленькой буквы что б переименовать все переменые shift + f6
    val filmListLiveData = MutableLiveData<List<Films>>()

    fun printInformation() {
        repository.getInformation().enqueue(object : Callback<FilmList> {
            override fun onResponse(call: Call<FilmList>, response: Response<FilmList>) {
                val currentResponse = response.body()
                if (currentResponse != null) {
                    filmListLiveData.value = currentResponse.films
                    Log.d("test", "не пустой")
                } else {
                    Log.d("test", "Пустой")
                }
            }

            override fun onFailure(call: Call<FilmList>, t: Throwable) {
                Log.d("test", "Ошибка ", t)
            }
        })
    }

}
