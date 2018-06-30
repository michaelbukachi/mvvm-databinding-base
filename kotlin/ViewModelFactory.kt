package dev.dita.maziwapp.ui.base.v2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class ViewModelFactory<VM : ViewModel> constructor(var viewModel: Lazy<VM>) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return viewModel.value as T
    }
}