        package com.lau2022.lovecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

        public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

            int[] images = {R.drawable.python,R.drawable.javascript,R.drawable.java, R.drawable.cplus, R.drawable.csharp, R.drawable.php};
            Spinner spinner;
            String score = " ";
            EditText PersonName;
            TextView result;
            TextView scoreboard;
            ImageView imageView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.languages, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


        PersonName=findViewById(R.id.PersonName);
        result = findViewById(R.id.result);
        imageView = findViewById(R.id.imageoflang);
        scoreboard = findViewById(R.id.scoreboard);




    }

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String text = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }



            public void calculateLove(View v){
                Random random = new Random();
                int number = random.nextInt(99) + 1;

                String chosenLang = spinner.getSelectedItem().toString();
                String resultSentence = PersonName.getText() + " LOVES "+ chosenLang + " " + number + " %";
                result.setText(resultSentence);

                int itemId = (int) spinner.getSelectedItemId();
                imageView.setImageResource(images[itemId]);
                imageView.setVisibility(View.VISIBLE);
                imageView.setAlpha(0f);
                imageView.setTranslationY(50);
                imageView.animate().alpha(1f).translationYBy(-50).setDuration(1500);


                score += resultSentence + "\n";
                scoreboard.setText(score);

            }

        }