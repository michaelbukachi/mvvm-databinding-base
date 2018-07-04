import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

public class ViewModelUtil {

    public static <T extends ViewModel> ViewModelProvider.Factory createFor(T model) {
        return new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <S extends ViewModel> S create(@NonNull Class<S> modelClass) {
                if (modelClass.isAssignableFrom(model.getClass())) {
                    return (S) model;
                }
                throw new IllegalArgumentException("Unexpected model class");
            }
        };
    }
}
