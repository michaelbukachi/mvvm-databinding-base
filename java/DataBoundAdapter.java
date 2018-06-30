package dita.dev.myportal.ui.base.v2;

import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;

import java.util.ArrayList;
import java.util.List;

public abstract class DataBoundAdapter<S extends BaseListItem, T extends ViewDataBinding> extends BaseDataBoundAdapter<T> {

    protected ArrayList<S> data;

    @LayoutRes
    private final int layoutId;


    public DataBoundAdapter(@LayoutRes int layoutId, ArrayList<S> data) {
        this.layoutId = layoutId;
        this.data = data;
    }

    @Override
    public int getItemLayoutId(int position) {
        return layoutId;
    }

    @Override
    public int getItemCount() {
        if (data != null) {
            return data.size();
        }
        return 0;
    }

    public void updateData(List<S> data) {
        if (data == null && this.data != null) {
            this.data.clear();
        } else if (data != null && this.data == null) {
            this.data = new ArrayList<>(data);
        } else if (data != null) {
            this.data.clear();
            this.data.addAll(data);
        }

        notifyDataSetChanged();
    }
}
