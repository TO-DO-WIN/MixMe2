package com.example.bellescott.mixmetwo;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddDrinkActvity extends AppCompatActivity implements View.OnClickListener{

    Drink drink;

    private DatabaseReference databaseReference;
    private Button buttonAddDrink;
    private EditText editDrinkName;
    private EditText editAlcohol;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_drink_actvity);

        editDrinkName = (EditText) findViewById(R.id.editDrinkName);
        editAlcohol = (EditText) findViewById(R.id.editAlcohol);
        buttonAddDrink = (Button) findViewById(R.id.buttonAddDrink);

        databaseReference = FirebaseDatabase.getInstance().getReference();

        buttonAddDrink.setOnClickListener(this);
    }

    private void addDrink(){
        String drink = editDrinkName.getText().toString().trim();
        String alcohol = editAlcohol.getText().toString().trim();

        if(!(TextUtils.isEmpty(drink)) && !(TextUtils.isEmpty(alcohol))){
            Drink drink1 = new Drink(drink, alcohol);

        }
    }



    @Override
    public void onClick(View v) {
        if(v == buttonAddDrink){

        }
    }
}
