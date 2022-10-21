package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextView usernameTV;
    TextView passwordTV;
    Spinner spinner;
    SharedPreferences sharedPreferences;
    String locale;
    int locale_number;
    ArrayList<String> locales;
    ArrayAdapter adapter;
    static final int GET_RESULT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("shared",MODE_PRIVATE);

        //버전 확인후 sharedpreferences에 locale키 값의 value값을 가져옵니다.
        //값이 없을 경우 기본언어 설정

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            locale = sharedPreferences.getString("locale",getResources().getConfiguration().getLocales().get(0).getLanguage());
        }else{
            locale = sharedPreferences.getString("locale", Resources.getSystem().getConfiguration().locale.getLanguage());
        }



        //스피너 기본 선택값을 주기 위해서 해당 언어의 순서에 맞게 int값을 준비해줍니다.
        switch (locale){
            case "ko":{
                locale_number = 0;
                break;
            }
            case "en":{
                locale_number = 1;
                break;
            }
        }

        usernameTV = findViewById(R.id.usernameTV);
        passwordTV = findViewById(R.id.passwordTV);
        Button loginbutton = (Button) findViewById(R.id.loginbutton);
        EditText editID = (EditText) findViewById(R.id.editID);
        EditText editPW = (EditText) findViewById(R.id.editPW);
        loginbutton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(), SubActivity.class);
                in.putExtra("username", editID.getText().toString());
                in.putExtra("password", editPW.getText().toString());
                startActivity(in);
            }
        });
        //스피너로 설정한 언어에 맞는 언어로 TextView에 텍스트를 넣어줍니다.
        usernameTV.setText(getStringByLocal(this,R.string.username,locale));
        passwordTV.setText(getStringByLocal(this,R.string.password,locale));

        spinner = findViewById(R.id.languageSpinner);


        locales = new ArrayList<>();

        //strings.xml에 있는 언어 가져와서 리스트에 추가
        locales.add(getStringByLocal(this,R.string.korean,locale));
        locales.add(getStringByLocal(this,R.string.english,locale));


        adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, locales);


        spinner.setAdapter(adapter);
        spinner.setSelection(locale_number);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //선택한 아이템의 포지션이 현재 설정되어있는 언어의 포지션이 아닐 경우
                if(position != locale_number){

                    switch (position){
                        case 0:{
                            locale = "ko";
                            break;
                        }
                        case 1:{
                            locale = "en";
                            break;
                        }
                    }

                    //sharedpreferences를 생성
                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    //sharedpreferences 안에 선택한 locale값 넣기
                    editor.putString("locale",locale);

                    //저장
                    editor.commit();

                    //어플 재시작
                    Intent intent = getBaseContext().getPackageManager()
                            .getLaunchIntentForPackage(getBaseContext().getPackageName());
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    finish();
                    startActivity(intent);

                }
            }


            //아무것도 선택하지 않았을 경우
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                spinner.setSelection(locale_number);
            }
        });
    }


    //선택한 언어에 맞는 String값을 반환합니다.
    @NonNull
    public static String getStringByLocal(Activity context, int resId, String locale) {
        Configuration configuration = new Configuration(context.getResources().getConfiguration());
        configuration.setLocale(new Locale(locale));
        return context.createConfigurationContext(configuration).getResources().getString(resId);
    }
}