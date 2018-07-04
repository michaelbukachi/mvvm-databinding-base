import android.arch.lifecycle.LifecycleOwner;


public class SnackbarMessage extends SingleLiveEvent<String> {

    public void observe(LifecycleOwner owner, final SnackbarObserver observer) {
        super.observe(owner, s -> {
            if (s == null) {
                return;
            }

            observer.onNewMessage(s);
        });
    }

    public interface SnackbarObserver {

        void onNewMessage(String message);
    }
}
