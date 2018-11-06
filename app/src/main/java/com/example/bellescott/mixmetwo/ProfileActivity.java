package com.example.bellescott.mixmetwo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase database;

    private TextView UserEmail;
    private Button buttonLogout;
    private Button addDrink;
    private Button buttonSaveData;
    private DatabaseReference databaseReference;
    private EditText drinkName;
    private EditText alcohol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        firebaseAuth = FirebaseAuth.getInstance();


        if(firebaseAuth == null){
            //finish();
            startActivity(new Intent(this, Login.class));
        }

        FirebaseUser user = firebaseAuth.getCurrentUser();


        UserEmail = (TextView) findViewById(R.id.textViewUserEmail);
        UserEmail.setText("Welcome " + user.getEmail());
        buttonLogout = (Button) findViewById(R.id.buttonLogout);
        buttonSaveData = (Button) findViewById(R.id.buttonSaveData);
        drinkName = (EditText) findViewById(R.id.editTextDrinkName);
        alcohol = (EditText) findViewById(R.id.editAlcohol);

        buttonLogout.setOnClickListener(this);
        buttonSaveData.setOnClickListener(this);


    }

    public void logout(){

        startActivity(new Intent(getApplicationContext(), MainActivity.class));

    }

    public void saveData(){

        Toast.makeText(this, "Inside Save Data...", Toast.LENGTH_LONG).show();
        String drink = drinkName.getText().toString().trim();
        String drinkAlcohol = alcohol.getText().toString().trim();

        Drink drink1 = new Drink(drink, drinkAlcohol);

        FirebaseUser user = firebaseAuth.getCurrentUser();
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference();



        databaseReference.child(user.getUid()).setValue(drink1);

        Toast.makeText(this, "Drink Saved...", Toast.LENGTH_LONG).show();

    }

    @Override
    public void onClick(View view) {

        if(view == buttonLogout){
            firebaseAuth.signOut();;
            finish();
            startActivity(new Intent(this, Login.class));
        }
        if(view == buttonSaveData){
            Toast.makeText(this, "Calling Save Data...", Toast.LENGTH_LONG).show();
            saveData();
        }

    }
}
