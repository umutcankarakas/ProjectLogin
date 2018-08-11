package com.projectlogin;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.projectlogin.Model.User;
import com.projectlogin.ViewModel.UserViewModel;


public class LoginActivity extends AppCompatActivity {

    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;

    private EditText mEditMail;
    private EditText mEditPassword;

    private UserViewModel mUserViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mUserViewModel = ViewModelProviders.of(this).get(UserViewModel.class);

        mEditMail = findViewById(R.id.edit_mail);
        mEditPassword = findViewById(R.id.edit_password);

        final Button button_login = findViewById(R.id.button_to_login);
        button_login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //LiveData<String> pass = mUserViewModel.getPassword(mEditMail.getText().toString());
                if (mEditPassword.getText().toString().equals(mUserViewModel.getPassword(mEditMail.getText().toString()))) {
                //if (mEditPassword.getText().toString().equals("KEK")) {

                    Intent loginIntent = new Intent(LoginActivity.this, TasksActivity.class);
                    startActivity(loginIntent);
                } else {
                    Toast.makeText(
                            getApplicationContext(),
                            R.string.login_fail,
                            Toast.LENGTH_LONG).show();
                    recreate();
                }
            }
        });

        final Button button_register = findViewById(R.id.button_to_go_register);
        button_register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            User user = new User(data.getExtras().getString(SignUpActivity.EXTRA_NAME),
                    data.getExtras().getString(SignUpActivity.EXTRA_MAIL),
                    data.getExtras().getString(SignUpActivity.EXTRA_PASSWORD));
            mUserViewModel.insert(user);
            Toast.makeText(
                    getApplicationContext(),
                    R.string.saved,
                    Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }
}
