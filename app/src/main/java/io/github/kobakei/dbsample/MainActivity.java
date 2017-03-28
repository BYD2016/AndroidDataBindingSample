package io.github.kobakei.dbsample;

import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import io.github.kobakei.dbsample.databinding.MainActivityBinding;

final public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MainActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.main_activity);

        MainActivityViewModel viewModel = new MainActivityViewModel(this);
        binding.setViewModel(viewModel);
    }
}
