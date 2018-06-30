package dita.dev.myportal.ui.base.v2;

import android.databinding.OnRebindCallback;
import android.databinding.ViewDataBinding;
import android.support.annotation.CallSuper;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

public abstract class BaseDataBoundAdapter<T extends ViewDataBinding>
        extends RecyclerView.Adapter<DataBoundViewHolder<T>> {

    private static final Object DB_PAYLOAD = new Object();

    @Nullable
    private RecyclerView recyclerView;

    private final OnRebindCallback onRebindCallback = new OnRebindCallback() {
        @Override
        public boolean onPreBind(ViewDataBinding binding) {
            if (recyclerView == null || recyclerView.isComputingLayout()) {
                return true;
            }

            int childAdapterPosition = recyclerView.getChildAdapterPosition(binding.getRoot());
            if (childAdapterPosition == RecyclerView.NO_POSITION) {
                return true;
            }

            notifyItemChanged(childAdapterPosition, DB_PAYLOAD);
            return false;
        }
    };

    @NonNull
    @Override
    @CallSuper
    public DataBoundViewHolder<T> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        DataBoundViewHolder<T> vh = DataBoundViewHolder.create(parent, viewType);
        vh.binding.addOnRebindCallback(onRebindCallback);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull DataBoundViewHolder<T> holder, int position, @NonNull List<Object> payloads) {
        if (payloads.isEmpty() || hasNonDataBindingInvalidate(payloads)) {
            bindItem(holder, position, payloads);
        }
        holder.binding.executePendingBindings();
    }

    protected abstract void bindItem(DataBoundViewHolder<T> holder, int position,
                                     List<Object> payloads);

    private boolean hasNonDataBindingInvalidate(List<Object> payloads) {
        for (Object payload : payloads) {
            if (payload != DB_PAYLOAD) {
                return true;
            }
        }
        return false;
    }

    @Override
    public final void onBindViewHolder(@NonNull DataBoundViewHolder<T> holder, int position) {
        throw new IllegalArgumentException("just overridden to make final.");
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        this.recyclerView = null;
    }

    @Override
    public final int getItemViewType(int position) {
        return getItemLayoutId(position);
    }

    @LayoutRes
    abstract public int getItemLayoutId(int position);
}
