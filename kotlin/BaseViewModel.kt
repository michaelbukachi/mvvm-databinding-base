

import android.arch.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {

    open val snackbarMessage = SnackbarMessage()


    fun showSnackbar(message: String) {
        snackbarMessage.value = message
    }

    fun showSnackbarBackground(message: String) {
        snackbarMessage.postValue(message)
    }
}
