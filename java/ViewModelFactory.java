package dita.dev.myportal.ui.base.v2;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import javax.inject.Inject;

import dagger.Lazy;

public class ViewModelFactory<VM extends ViewModel> implements ViewModelProvider.Factory {

    private Lazy<VM> viewModel;

    @Inject
    ViewModelFactory(Lazy<VM> viewModel) {
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) viewModel.get();
    }
}
