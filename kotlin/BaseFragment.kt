import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment

abstract class BaseFragment<V : BaseViewModel> : DaggerFragment() {

    protected lateinit var viewModel: V

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(getLayoutId(), container, false)
        init(view, savedInstanceState)
        activity!!.setTitle(getTitle())
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.snackbarMessage.observe(this,
                { message: String -> Snackbar.make(view!!, message, Snackbar.LENGTH_SHORT).show() } as SnackbarMessage.SnackbarObserver)
    }

    abstract fun getLayoutId(): Int

    abstract fun getTitle(): Int

    abstract fun init(view: View, savedInstanceState: Bundle?)

    protected fun showMessage(message: String) {
        Snackbar.make(view!!, message, Snackbar.LENGTH_SHORT).show()
    }
}
