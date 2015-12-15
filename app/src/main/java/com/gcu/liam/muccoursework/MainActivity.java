package com.gcu.liam.muccoursework;

import android.annotation.TargetApi;
//import android.app.DialogFragment;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity implements View.OnClickListener
{
    SharedPreferences mySharedPrefs;
    FragmentManager fmAboutDialogue;

    Button btnStart;
    Button btnExit;
    Button btnVenue;
    Button btnParking;
    laMapData venueInfo;


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = (Button) findViewById(R.id.btnStart);
        btnStart.setOnClickListener(this);

        btnVenue = (Button) findViewById(R.id.btnVenues);
        btnVenue.setOnClickListener(this);

        btnExit = (Button) findViewById(R.id.btnExit);
        btnExit.setOnClickListener(this);

        btnParking = (Button) findViewById(R.id.btnParking);
        btnParking.setOnClickListener(this);

        mySharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);

        venueInfo = new laMapData();

        fmAboutDialogue = this.getSupportFragmentManager();

        Log.e("n", "message");


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.la_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.lunchMap:
                Intent laMap = new Intent(this, laMapActivity.class);
                this.startActivity(laMap);
                return true;
            case R.id.About:
                DialogFragment laAboutDlg = new laAboutDialogue();
                laAboutDlg.show(fmAboutDialogue,"la_About_Dlg");
                return true;
            case R.id.Draw:
                Intent drawingActivity = new Intent(this, drawingActivity.class);
                this.startActivity(drawingActivity);
            case R.id.Quit:
            finish();
            return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onClick(View view)
    {
        Intent outputScreen = new Intent(getApplicationContext(), outputScreen.class);

        Intent venueOutput = new Intent(getApplicationContext(), venueOutput.class);

        Intent carParkOutput = new Intent(getApplicationContext(), carParkOutput.class);


        if (view == btnExit) {
            setResult(Activity.RESULT_OK);
            finish();
        }
        if (view == btnVenue)
        {
           startActivity(venueOutput);
        }
        if (view == btnParking)
        {
            startActivity(carParkOutput);
        }
        if (view == btnStart)
        {
            startActivity(outputScreen);
        }

    }

}
