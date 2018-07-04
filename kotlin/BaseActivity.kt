import android.content.Intent
import android.support.design.widget.Snackbar
import android.view.View

import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity<V : BaseAndroidViewModel> : DaggerAppCompatActivity() {
    protected lateinit var viewModel: V


    protected abstract val root: View


    override fun onStart() {
        super.onStart()
        viewModel.snackbarMessage.observe(this,
                { message: String -> Snackbar.make(root, message, Snackbar.LENGTH_SHORT).show() } as SnackbarMessage.SnackbarObserver)
        viewModel.finishEvent.observe(this, { clazz: Class<Any> ->
            startActivity(Intent(this@BaseActivity, clazz))
            finish()
        } as Finish.FinishObserver)
    }
}

