package dev.dita.maziwapp.ui.base.v2

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer


class Event : SingleLiveEvent<Void>() {
    open fun observe(owner: LifecycleOwner, observer: EventObserver) {
        super.observe(owner, Observer {
            observer.onEvent()
        })
    }

    open interface EventObserver {
        fun onEvent()
    }
}