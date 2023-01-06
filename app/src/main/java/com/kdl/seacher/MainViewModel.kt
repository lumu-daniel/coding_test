package com.kdl.seacher

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
//Given an array ["telephone", "telescope", "television", "ball", "basket ball", "volley ball"], write an algorithm that would allow a look ahead. For example: if the input is "tele", the lookahead should results in “telephone”, “telescope”, “television”.

class MainViewModel:ViewModel() {

    private val list_items = listOf<String>("telephone", "telescope", "television", "ball", "basket ball", "volley ball")

    private val _displayList = MutableLiveData<List<String>>()
    val displayList: LiveData<List<String>> = _displayList

    fun generateSearch(input:String){
        val temp_list = mutableListOf<String>()
        for(i in list_items){
            if(i.contains(input)){
                temp_list.add(i)
            }
        }
        _displayList.postValue(temp_list)
    }


}