package dev.dita.maziwapp.ui.base.v2

import android.app.Application
import androidx.lifecycle.AndroidViewModel

open class BaseAndroidViewModel constructor(application: Application) : AndroidViewModel(application) {
    open val snackbarMessage = SnackbarMessage()
    open val finishEvent = Finish()

    fun showSnackbar(message: String) {
        snackbarMessage.value = message
    }

    fun showSnackbarBackground(message: String) {
        snackbarMessage.postValue(message)
    }

    fun finish(clazz: Class<Any>) {
        finishEvent.value = clazz
    }
}