import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

import javax.inject.Inject;

@Suppress("UNCHECKED_CAST")
class ViewModelFactory<VM : ViewModel> @Inject constructor(var viewModel: Lazy<VM>) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return viewModel.value as T
    }
}
