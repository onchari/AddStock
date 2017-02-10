package com.example.user2.addstock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
public EditText stock, amount;
    public  Button add, display;
    Add_Stock_DBHelperClass dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stock = (EditText) findViewById(R.id.stock);
        amount = (EditText) findViewById(R.id.amount);

        add = (Button) findViewById(R.id.adds);
        add.setOnClickListener(this);

        display = (Button) findViewById(R.id.display);
        display.setOnClickListener(this);

       dbHelper = new Add_Stock_DBHelperClass(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.adds:
                String st, am;
                st = stock.getText().toString();
                am = amount.getText().toString();
               boolean isInserted = dbHelper.insertData(st, am);
                if(isInserted == true){
                    Toast.makeText(this, "Successfully inserted", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this, "Failed", Toast.LENGTH_LONG).show();
                }

                break;

            case R.id.display:
                Intent display = new Intent(this, DisplayStock.class);
                startActivity(display);
                break;

            default:
                Toast.makeText(this, "No button clicked", Toast.LENGTH_LONG).show();
                break;

        }
    }

    private void addStock() {

    }

}
