package dev.dita.maziwapp.ui.base.v2

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer

class Finish : SingleLiveEvent<Class<Any>>() {
    open fun observe(owner: LifecycleOwner, observer: FinishObserver) {
        super.observe(owner, Observer {
            if (it == null) {
                return@Observer
            }

            observer.onFinish(it)
        })
    }

    open interface FinishObserver {
        fun onFinish(clazz: Class<Any>)
    }
}