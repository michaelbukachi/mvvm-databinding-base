package dita.dev.myportal.ui.base.v2;

import android.arch.lifecycle.ViewModel;

public class BaseViewModel extends ViewModel {

    private final SnackbarMessage snackbarMessage = new SnackbarMessage();

    public SnackbarMessage getSnackbarMessage() {
        return snackbarMessage;
    }

    protected void showSnackbar(String message) {
        snackbarMessage.setValue(message);
    }

    protected void showSnackbarBackground(String message) {
        snackbarMessage.postValue(message);
    }
}
