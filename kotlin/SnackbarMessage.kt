package dev.dita.maziwapp.ui.base.v2

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer

class SnackbarMessage : SingleLiveEvent<String>() {

    open fun observe(owner: LifecycleOwner, observer: SnackbarObserver) {
        super.observe(owner, Observer {
            if (it == null) {
                return@Observer
            }

            observer.onNewMessage(it)
        })
    }

    open interface SnackbarObserver {
        fun onNewMessage(message: String?)
    }
}