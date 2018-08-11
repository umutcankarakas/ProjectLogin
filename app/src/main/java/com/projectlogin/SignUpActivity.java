package com.projectlogin;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.projectlogin.Model.User;
import com.projectlogin.ViewModel.UserViewModel;

public class SignUpActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "com.example.android.wordlistsql.NAME";
    public static final String EXTRA_MAIL = "com.example.android.wordlistsql.MAIL";
    public static final String EXTRA_PASSWORD = "com.example.android.wordlistsql.PASSWORD";




    private EditText mEditName;
    private  EditText mEditMail;
    private  EditText mEditPassword;

    //private UserViewModel mUserViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mEditName = findViewById(R.id.edt_name);
        mEditMail = findViewById(R.id.edt_mail);
        mEditPassword = findViewById(R.id.edt_password);

        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                Bundle extras = new Bundle();
                if (TextUtils.isEmpty(mEditPassword.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    extras.putString(EXTRA_NAME,  mEditName.getText().toString());
                    extras.putString(EXTRA_MAIL,  mEditMail.getText().toString());
                    extras.putString(EXTRA_PASSWORD,  mEditPassword.getText().toString());
                    replyIntent.putExtras(extras);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }
}
