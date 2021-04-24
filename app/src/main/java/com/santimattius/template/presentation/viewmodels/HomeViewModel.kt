package com.santimattius.template.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.santimattius.template.domain.usecases.GetPictures
import com.santimattius.template.presentation.models.PictureUiModel
import com.santimattius.template.presentation.models.mapping.asUiModels
import kotlinx.coroutines.launch

class HomeViewModel(private val getPictures: GetPictures) : ViewModel() {

    private val _pictures = MutableLiveData<List<PictureUiModel>>()
    val pictures: LiveData<List<PictureUiModel>>
        get() = _pictures

    init {
        pictures()
    }

    private fun pictures() = viewModelScope.launch {
        val pictures = getPictures().asUiModels()
        _pictures.postValue(pictures)
    }
}

