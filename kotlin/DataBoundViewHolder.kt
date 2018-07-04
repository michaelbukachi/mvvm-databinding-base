import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class DataBoundViewHolder<T : ViewDataBinding> constructor(open val binding: T) :
        RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun <S : ViewDataBinding> create(parent: ViewGroup, @LayoutRes layoutId: Int): DataBoundViewHolder<S> {
            val binding: S = DataBindingUtil.inflate(LayoutInflater.from(parent.context), layoutId, parent, false)
            return DataBoundViewHolder(binding)
        }
    }
}
