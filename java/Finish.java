import android.arch.lifecycle.LifecycleOwner;

public class Finish extends SingleLiveEvent<Class> {

    public void observe(LifecycleOwner owner, final FinishObserver observer) {
        super.observe(owner, s -> {
            if (s == null) {
                return;
            }

            observer.onFinish(s);
        });
    }

    public interface FinishObserver {

        void onFinish(Class clazz);
    }
}
