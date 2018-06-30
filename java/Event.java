package dita.dev.myportal.ui.base.v2;

import android.arch.lifecycle.LifecycleOwner;

public class Event extends SingleLiveEvent<Void> {

    public void observe(LifecycleOwner owner, final EventObserver observer) {
        super.observe(owner, s -> {
            observer.onEvent();
        });
    }

    public interface EventObserver {
        void onEvent();
    }
}
