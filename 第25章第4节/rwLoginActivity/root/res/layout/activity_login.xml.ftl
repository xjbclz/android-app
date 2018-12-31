<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center_horizontal"
    android:orientation="vertical"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context="${relativePackage}.${activityClass}">

    <ScrollView
        android:id="@+id/login_form"
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <LinearLayout
            android:id="@+id/phone_login_form"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="vertical">

            <ImageView
                android:id="@+id/login_image"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:src="@drawable/login_image" />

            <android.support.design.widget.TextInputLayout
                android:layout_width="match_parent"
                android:layout_height="wrap_content">

                <AutoCompleteTextView
                    android:id="@+id/phone"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:hint="@string/prompt_phone"
                    android:inputType="phone"
                    android:maxLines="1"
                    android:singleLine="true" />

            </android.support.design.widget.TextInputLayout>

            <FrameLayout
                android:id="@+id/password_layout"
                android:layout_width="match_parent"
                android:layout_height="wrap_content">

                <android.support.design.widget.TextInputLayout
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content">

                    <EditText
                        android:id="@+id/password"
                        android:layout_width="match_parent"
                        android:layout_height="wrap_content"
                        android:hint="@string/prompt_password"
                        android:imeActionId="@+id/login"
                        android:imeActionLabel="@string/action_sign_in"
                        android:imeOptions="actionUnspecified"
                        android:inputType="textPassword"
                        android:maxLines="1"
                        android:singleLine="true" />

                </android.support.design.widget.TextInputLayout>

                <android.support.v7.widget.AppCompatTextView
                    android:id="@+id/login_eye"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_gravity="center|right"
                    android:background="@drawable/login_eye"
                    android:gravity="center"
                    android:paddingRight="12dp" />
            </FrameLayout>

            <Button
                android:id="@+id/sign_in_button"
                style="?android:textAppearanceSmall"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_marginTop="16dp"
                android:text="@string/action_sign_in"
                android:textStyle="bold" />

        </LinearLayout>
    </ScrollView>
</LinearLayout>
