package dev.dita.maziwapp.ui.base.v2

import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {

    open val snackbarMessage = SnackbarMessage()


    fun showSnackbar(message: String) {
        snackbarMessage.value = message
    }

    fun showSnackbarBackground(message: String) {
        snackbarMessage.postValue(message)
    }
}