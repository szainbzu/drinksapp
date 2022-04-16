package edu.cs.birzeit.drinksapp;

import androidx.appcompat.app.AppCompatActivity;
import edu.cs.birzeit.drinksapp.model.Drink;
import edu.cs.birzeit.drinksapp.model.DrinksMockup;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText edtDrinks;
    private Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setViews();
        setSpinner();

    }

    private void setSpinner() {

        DrinksMockup database = new DrinksMockup();
        String[] cats = database.getCategories();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, cats);

        spinner.setAdapter(adapter);



    }

    private void setViews() {
        edtDrinks = findViewById(R.id.edtDrinks);
        spinner = findViewById(R.id.spinner);
    }

    public void btnSubmit_Click(View view) {

        String cat = spinner.getSelectedItem().toString();

        DrinksMockup database = new DrinksMockup();

        ArrayList<Drink> result = database.getDrinks(cat);

        String str = "";

        for(Drink d : result){
            str+= d.getName() + ", Price: " + d.getUnitPrice() + "\n";
        }

        edtDrinks.setText(str);



    }
}