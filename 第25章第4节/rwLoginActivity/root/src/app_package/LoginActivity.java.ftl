package ${packageName};

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A login screen that offers login via phone/password.
 */
public class ${activityClass} extends ${superClass} {

    private AutoCompleteTextView mPhoneView;
    private EditText mPasswordView;

    TextView mLoginEye;
    boolean mIsDisplayPassword = false;

    private int mPasswordLength = ${passwordLength};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rw_login);

        // Set up the login form.
        mPhoneView = (AutoCompleteTextView) findViewById(R.id.phone);
        mPasswordView = (EditText) findViewById(R.id.password);
        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.login || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        mLoginEye = (TextView) findViewById(R.id.login_eye);
        mLoginEye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnSetDisplayPassword();
            }
        });

        Button mSignInButton = (Button) findViewById(R.id.sign_in_button);
        mSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });
    }


     /**
      * Attempts to sign in or register the account specified by the login form.
      * If there are form errors (invalid phone, missing fields, etc.), the
      * errors are presented and no actual login attempt is made.
      */
     private void attemptLogin() {

         // Reset errors.
         mPhoneView.setError(null);
         mPasswordView.setError(null);

         // Store values at the time of the login attempt.
         String phone = mPhoneView.getText().toString();
         String password = mPasswordView.getText().toString();

         boolean cancel = false;
         View focusView = null;

         // Check for a valid password, if the user entered one.
         if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
             mPasswordView.setError(getString(R.string.error_invalid_password));
             focusView = mPasswordView;
             cancel = true;
         }

         // Check for a valid email address.
         if (TextUtils.isEmpty(phone)) {
             mPhoneView.setError(getString(R.string.error_field_required));
             focusView = mPhoneView;
             cancel = true;
         } else if (!isPhone(phone)) {
             mPhoneView.setError(getString(R.string.error_invalid_phone));
             focusView = mPhoneView;
             cancel = true;
         }

         if (cancel) {
             // There was an error; don't attempt login and focus the first
             // form field with an error.
             focusView.requestFocus();
         } else {
             // perform the user login attempt.
             logIn(phone, password);
         }
     }

     /**
      * 判断手机格式是否正确
      *
      * @param phone 手机号
      * @return true 正确 false 错误
      */
     public static boolean isPhone(String phone) {
         if (TextUtils.isEmpty(phone)) {
             return false;
         }
         Pattern p = Pattern
                 .compile("^((13[0-9])|(14[5,7])|(17[0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$");
         Matcher m = p.matcher(phone);
         return m.matches();
     }

     private boolean isPasswordValid(String password) {
         //TODO: Replace this with your own logic
         return password.length() >= mPasswordLength;
     }

     private void OnSetDisplayPassword() {

         mIsDisplayPassword = !mIsDisplayPassword;

         if (mIsDisplayPassword) {

             ViewCompat.setBackgroundTintList(mLoginEye, ColorStateList.valueOf(Color.parseColor("#FF4081")));
             ViewCompat.setBackgroundTintMode(mLoginEye, PorterDuff.Mode.SCREEN);

             mPasswordView.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
         } else {

             ViewCompat.setBackgroundTintList(mLoginEye, ColorStateList.valueOf(Color.parseColor("#CCCCCC")));
             ViewCompat.setBackgroundTintMode(mLoginEye, PorterDuff.Mode.SCREEN);

             mPasswordView.setTransformationMethod(PasswordTransformationMethod.getInstance());
         }

     }

     private void logIn(String phone, String password) {

     }
}

