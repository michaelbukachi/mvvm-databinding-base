package dita.dev.myportal.ui.base.v2;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

public class BaseAndroidViewModel extends AndroidViewModel {
    private final SnackbarMessage snackbarMessage = new SnackbarMessage();

    private final Finish finishEvent = new Finish();

    public BaseAndroidViewModel(@NonNull Application application) {
        super(application);
    }

    public SnackbarMessage getSnackbarMessage() {
        return snackbarMessage;
    }

    public Finish getFinishEvent() {
        return finishEvent;
    }

    protected void showSnackbar(String message) {
        snackbarMessage.setValue(message);
    }

    protected void showSnackbarBackground(String message) {
        snackbarMessage.postValue(message);
    }

    protected void finish(Class clazz) {
        finishEvent.setValue(clazz);
    }

}
