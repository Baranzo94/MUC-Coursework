package com.gcu.liam.muccoursework;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.concurrent.ExecutionException;

/**
 * Created by Liam on 15/12/2015.
 */
public class carParkOutput extends MainActivity implements View.OnClickListener
{

    TextView tvPark1;
    TextView tvPark2;
    TextView tvPark3;
    TextView tvPark4;
    TextView tvPark5;
    TextView tvPark6;
    TextView tvPark7;
    TextView tvPark8;
    TextView tvPark9;
    TextView tvPark10;
    TextView tvPark11;

    Button btnBack;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carpark_screen);



        carParkData carPark = new carParkData();
        String RSSFeedURL = "https://api.open.glasgow.gov.uk/traffic/carparks";
        laAsyncRSSParser rssAsyncParse = new laAsyncRSSParser(this,RSSFeedURL);
        try {
            carPark = rssAsyncParse.execute("").get();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (ExecutionException e) {
            e.printStackTrace();
        }

        tvPark1 = (TextView) findViewById(R.id.tvPark1);
        tvPark1.setText(laAsyncRSSParser.cpData.get(0).getcarParkIdentity() +" "+laAsyncRSSParser.cpData.get(0).getcarParkOccupancy());

        tvPark2 = (TextView) findViewById(R.id.tvPark2);
        tvPark2.setText(laAsyncRSSParser.cpData.get(1).getcarParkIdentity() +" "+laAsyncRSSParser.cpData.get(1).getcarParkOccupancy());

        tvPark3 = (TextView) findViewById(R.id.tvPark3);
        tvPark3.setText(laAsyncRSSParser.cpData.get(2).getcarParkIdentity() +" "+laAsyncRSSParser.cpData.get(2).getcarParkOccupancy());

        tvPark4 = (TextView) findViewById(R.id.tvPark4);
        tvPark4.setText(laAsyncRSSParser.cpData.get(3).getcarParkIdentity() +" "+laAsyncRSSParser.cpData.get(3).getcarParkOccupancy());

        tvPark5 = (TextView) findViewById(R.id.tvPark5);
        tvPark5.setText(laAsyncRSSParser.cpData.get(4).getcarParkIdentity() +" "+laAsyncRSSParser.cpData.get(4).getcarParkOccupancy());

        tvPark6 = (TextView) findViewById(R.id.tvPark6);
        tvPark6.setText(laAsyncRSSParser.cpData.get(5).getcarParkIdentity() +" "+laAsyncRSSParser.cpData.get(5).getcarParkOccupancy());

        tvPark7 = (TextView) findViewById(R.id.tvPark7);
        tvPark7.setText(laAsyncRSSParser.cpData.get(6).getcarParkIdentity() +" "+laAsyncRSSParser.cpData.get(6).getcarParkOccupancy());

        tvPark8 = (TextView) findViewById(R.id.tvPark8);
        tvPark8.setText(laAsyncRSSParser.cpData.get(7).getcarParkIdentity() +" "+laAsyncRSSParser.cpData.get(7).getcarParkOccupancy());

        tvPark9 = (TextView) findViewById(R.id.tvPark9);
        tvPark9.setText(laAsyncRSSParser.cpData.get(8).getcarParkIdentity() +" "+laAsyncRSSParser.cpData.get(8).getcarParkOccupancy());

        tvPark10 = (TextView) findViewById(R.id.tvPark10);
        tvPark10.setText(laAsyncRSSParser.cpData.get(9).getcarParkIdentity() +" "+laAsyncRSSParser.cpData.get(9).getcarParkOccupancy());

        tvPark11 = (TextView) findViewById(R.id.tvPark11);
        tvPark11.setText(laAsyncRSSParser.cpData.get(10).getcarParkIdentity() +" "+laAsyncRSSParser.cpData.get(10).getcarParkOccupancy());

        btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);
    }

    public void onClick(View view)
    {
        if (view == btnBack) {
            setResult(Activity.RESULT_OK);
            finish();
        }

    }
}
