package com.animesafar.minical;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private EditText editText2;
private Button button;
private Spinner spinner;
ArrayList<String> arrayList = new ArrayList<>();
String operation;
ArrayAdapter arrayAdapter;
TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

textView = findViewById(R.id.textView3);
        editText = findViewById(R.id.num1);
        editText2 = findViewById(R.id.num2);
spinner = findViewById(R.id.spinner);
button = findViewById(R.id.button);

arrayList.add("Select value");
        arrayList.add("Add");
        arrayList.add("Subtract");
        arrayList.add("Multiply");
        arrayList.add("Divide");
        arrayList.add("Mod");

        arrayAdapter = new ArrayAdapter(this , android.R.layout.simple_list_item_1,arrayList);

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_list_item_1);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                operation = arrayList.get(i);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinner.setAdapter(arrayAdapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if(editText.getText().toString().equals("") && editText2.getText().toString().equals("")){

                    Toast.makeText(MainActivity.this,"Please enter values first",Toast.LENGTH_LONG).show();

                }else{

                    calculate();

                }

            }
        });



    }

    private void calculate() {

        switch (operation){


            case "Add":

                int first = Integer.parseInt(editText.getText().toString());
                int second = Integer.parseInt(editText2.getText().toString());

                String result = String.valueOf(first+second);

                textView.setText(result);

                editText.setText("");
                editText2.setText("");
              break;


            case "Subtract":


                int first1 = Integer.parseInt(editText.getText().toString());
                int second1= Integer.parseInt(editText2.getText().toString());

                String result1 = String.valueOf(first1-second1);

                textView.setText(result1);

                editText.setText("");
                editText2.setText("");

                break;


            case "Multiply":


                int first11 = Integer.parseInt(editText.getText().toString());
                int second11= Integer.parseInt(editText2.getText().toString());

                String result11 = String.valueOf(first11*second11);

                textView.setText(result11);


                editText.setText("");
                editText2.setText("");

                break;


            case "Divide":



                int first12 = Integer.parseInt(editText.getText().toString());
                int second12= Integer.parseInt(editText2.getText().toString());

                String result12 = String.valueOf(first12/second12);

                textView.setText(result12);


                editText.setText("");
                editText2.setText("");
break;


case "Mod":


    int first13 = Integer.parseInt(editText.getText().toString());
    int second13= Integer.parseInt(editText2.getText().toString());

    String result13 = String.valueOf(first13%second13);

    textView.setText(result13);

    editText.setText("");
    editText2.setText("");

    break;


            default:

                Toast.makeText(MainActivity.this,"Select any operation first",Toast.LENGTH_LONG).show();


                break;
        }


    }
}