package com.example.agnieszka.kompetencyjny;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class LoginActivity extends Activity {

    String login = "test@test.com";
    String password = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void login(View v) throws Exception {
        EditText testlogin = (EditText) findViewById(R.id.EditTextLogin);
        EditText testpassword = (EditText) findViewById(R.id.EditTextPassword);
        Log.i("testLogin", testlogin.getText().toString());
        Log.i("testPassword", testpassword.getText().toString());
        if(testlogin.getText().toString().equals(login) && testpassword.getText().toString().equals(password))
        {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
        else
        {
            new AlertDialog.Builder(this)
                    .setTitle("Błąd logowania")
                    .setMessage("Niepoprawny login lub hasło.")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })
                    .show();

        }

    }
}
