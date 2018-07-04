import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dagger.android.support.DaggerFragment;

public abstract class BaseFragment<V extends BaseViewModel> extends DaggerFragment {

    protected V viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        init(view, savedInstanceState);
        getActivity().setTitle(getTitle());
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        viewModel.getSnackbarMessage().observe(this,
                (SnackbarMessage.SnackbarObserver) message -> Snackbar.make(getView(), message, Snackbar.LENGTH_SHORT).show());
    }

    public abstract int getLayoutId();

    public abstract int getTitle();

    public abstract void init(View view, Bundle savedInstanceState);

    protected void showMessage(String message) {
        Snackbar.make(getView(), message, Snackbar.LENGTH_SHORT).show();
    }

}
