package com.example.zxa01.iotclient.component.login;

import com.example.zxa01.iotclient.R;
import com.example.zxa01.iotclient.databinding.ActivityLoginBinding;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;
    private LoginViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding();
        init();
    }

    private void binding() {
        viewModel = new LoginViewModel(binding.getRoot().getContext());
        binding.setViewModel(viewModel);
        binding.linearLoginForm.setOnClickListener(view -> hideKeyboard(LoginActivity.this));
    }

    private void init() {
        viewModel.isAuthorized().observe(this, viewModel::checkAuthorized);
    }


    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view = activity.getCurrentFocus();
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}

