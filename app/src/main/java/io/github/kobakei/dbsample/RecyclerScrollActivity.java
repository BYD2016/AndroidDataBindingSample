package io.github.kobakei.dbsample;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableList;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import io.github.kobakei.dbsample.databinding.RecyclerScrollActivityBinding;
import io.github.kobakei.dbsample.databinding.RecyclerScrollItemBinding;


final public class RecyclerScrollActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RecyclerScrollActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.recycler_scroll_activity);

        // Create a view model
        RecyclerScrollActivityViewModel viewModel = new RecyclerScrollActivityViewModel(this);
        binding.setViewModel(viewModel);

        // Set up RecyclerView
        binding.recyclerView.setAdapter(new ObservableRecyclerAdapter(this, viewModel.items));
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private static class ObservableRecyclerAdapter extends RecyclerView.Adapter<BindingViewHolder> {

        private final Context context;
        private final ObservableList<Item> items;

        ObservableRecyclerAdapter(Context context, ObservableList<Item> items) {
            this.context = context;
            this.items = items;

            items.addOnListChangedCallback(
                new ObservableList.OnListChangedCallback<ObservableList<Item>>() {
                @Override
                public void onChanged(ObservableList<Item> items) {
                    notifyDataSetChanged();
                }

                @Override
                public void onItemRangeChanged(ObservableList<Item> items, int positionStart, int itemCount) {
                    notifyItemRangeChanged(positionStart, itemCount);
                }

                @Override
                public void onItemRangeInserted(ObservableList<Item> items, int positionStart, int itemCount) {
                    notifyItemRangeInserted(positionStart, itemCount);
                }

                @Override
                public void onItemRangeMoved(ObservableList<Item> items, int fromPosition, int toPosition,
                    int itemCount) {
                    notifyItemMoved(fromPosition, toPosition);
                }

                @Override
                public void onItemRangeRemoved(ObservableList<Item> items, int positionStart, int itemCount) {
                    notifyItemRangeRemoved(positionStart, itemCount);
                }
            });
        }

        @Override
        public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(context);
            RecyclerScrollItemBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.recycler_scroll_item, parent, false);
            return new BindingViewHolder(binding);
        }

        @Override
        public void onBindViewHolder(BindingViewHolder holder, int position) {
            RecyclerScrollItemBinding binding = (RecyclerScrollItemBinding) holder.getBinding();
            binding.setItem(items.get(position));

            // Or
            // holder.getBinding().setVariable(BR.item, items.get(position));
        }

        @Override
        public int getItemCount() {
            return items.size();
        }
    }

    /**
     * Data binding x Common class for RecyclerView
     */
    static class BindingViewHolder extends RecyclerView.ViewHolder {

        private final ViewDataBinding binding;

        BindingViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public ViewDataBinding getBinding() {
            return binding;
        }
    }
}
