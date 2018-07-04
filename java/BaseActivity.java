import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.view.View;

import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseActivity<V extends BaseAndroidViewModel> extends DaggerAppCompatActivity {

    protected V viewModel;


    @Override
    protected void onStart() {
        super.onStart();
        viewModel.getSnackbarMessage().observe(this,
                (SnackbarMessage.SnackbarObserver) message -> Snackbar.make(getRoot(), message, Snackbar.LENGTH_SHORT).show());
        viewModel.getFinishEvent().observe(this, (Finish.FinishObserver) clazz -> {
            startActivity(new Intent(BaseActivity.this, clazz));
            finish();
        });
    }


    protected abstract View getRoot();
}
