package com.example.zxa01.iotclient.login;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.example.zxa01.iotclient.R;
import com.example.zxa01.iotclient.home.HomeActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.gateway)
    EditText mGatewayView;

    @BindView(R.id.account)
    EditText mAccountView;

    @BindView(R.id.password)
    EditText mPasswordView;

    @BindView(R.id.sign_in_button)
    Button mSignInButton;

    @BindView(R.id.linear_login_form)
    LinearLayout mLayoutLoginForm;

    private Activity activity = this;
    private UserLoginTask mAuthTask = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        mSignInButton.setOnClickListener(view -> attemptLogin());

        mLayoutLoginForm.setOnClickListener(view -> hideKeyboard(activity));
    }


    private void attemptLogin() {
        if (mAuthTask != null) {
            return;
        }

        mAccountView.setError(null);
        mPasswordView.setError(null);

        String gateway = mGatewayView.getText().toString();
        String account = mAccountView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // check
//        if (!TextUtils.isEmpty(gateway) && !isLengthValid(gateway)) {
//            mGatewayView.setError(getString(R.string.error_invalid_gateway));
//            focusView = mGatewayView;
//            cancel = true;
//        }
//        if (!TextUtils.isEmpty(password) && !isLengthValid(password)) {
//            mPasswordView.setError(getString(R.string.error_invalid_password));
//            focusView = mPasswordView;
//            cancel = true;
//        }
//        if (TextUtils.isEmpty(account)) {
//            mAccountView.setError(getString(R.string.error_field_required));
//            focusView = mAccountView;
//            cancel = true;
//        } else if (!isLengthValid(account)) {
//            mAccountView.setError(getString(R.string.error_invalid_account));
//            focusView = mAccountView;
//            cancel = true;
//        }

        if (cancel) {
            focusView.requestFocus();
        } else {
            mAuthTask = new UserLoginTask(account, password);
            mAuthTask.execute((Void) null);
        }
    }

    private boolean isLengthValid(String text) {
        return text.length() > 3;
    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view = activity.getCurrentFocus();
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    private void startHomeActivity() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {

        private String mAccount;
        private String mPassword;

        UserLoginTask(String account, String password) {
            mAccount = account;
            mPassword = password;
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            try {
                // TODO: 帳號驗證
                Thread.sleep(100);
            } catch (InterruptedException e) {
                return false;
            }
            return true;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            mAuthTask = null;
            if (success) {
                startHomeActivity();
            } else {
                mPasswordView.setError(getString(R.string.error_incorrect_password));
                mPasswordView.requestFocus();
            }
        }

        @Override
        protected void onCancelled() {
            mAuthTask = null;
        }
    }
}

