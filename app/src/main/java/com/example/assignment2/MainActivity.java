package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup,radioGroup1;
    RadioButton radioButton,radioButton1;
    TextView textView;
    CheckBox android, java, angular, python;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        textView = findViewById(R.id.textViewResults);
        radioGroup1 = findViewById(R.id.radioGroup1);
        android = (CheckBox)findViewById(R.id.chkAndroid);
        angular = (CheckBox)findViewById(R.id.chkAngular);
        java = (CheckBox)findViewById(R.id.chkJava);
        python = (CheckBox)findViewById(R.id.chkPython);
        Button btn = (Button)findViewById(R.id.getBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = "Selected Courses";
                if(android.isChecked()){
                    result += "\nAndroid";
                }
                else if(angular.isChecked()){
                    result += "\nAngularJS";
                }
                else if(java.isChecked()){
                    result += "\nJava";
                }
                else if(python.isChecked()){
                    result += "\nPython";
                }
                else{
                    result = "No Course Select";
                }


                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                intent.putExtra("message", result);
                startActivity(intent);
            }
        });
    }

    public void ShowSelection(View view) {

        int checked = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(checked);
        int checked1 = radioGroup1.getCheckedRadioButtonId();
        radioButton1 = findViewById(checked1);
        String text=radioButton.getText().toString()+radioButton1.getText().toString();
        textView.setText(text);

    }
    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        String str="";
        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.chkAndroid:
                str = checked?"Android Selected":"Android Deselected";
                break;
            case R.id.chkAngular:
                str = checked?"AngularJS Selected":"AngularJS Deselected";
                break;
            case R.id.chkJava:
                str = checked?"Java Selected":"Java Deselected";
                break;
            case R.id.chkPython:
                str = checked?"Python Selected":"Python Deselected";
                break;
        }
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();


    }


}
