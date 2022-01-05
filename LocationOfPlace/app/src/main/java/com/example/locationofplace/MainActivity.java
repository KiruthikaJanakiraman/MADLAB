package com.example.locationofplace;

import androidx.appcompat.app.AppCompatActivity;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    double latitude,longitude;
    EditText locationName;
    Button okbtn;
    TextView lat;
    TextView lon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        locationName=(EditText)findViewById(R.id.location);
        okbtn=(Button)findViewById(R.id.button);
        lat=(TextView)findViewById(R.id.lat);
        lon=(TextView)findViewById(R.id.lon);

        okbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Geocoder geocoder = new Geocoder(getBaseContext(), Locale.getDefault());
                try
                {
                    List<Address> address;

                    address = geocoder.getFromLocationName(locationName.getText().toString(),1);

                    if(address.size() >= 0)
                    {
                            latitude= address.get(0).getLatitude();
                            longitude= address.get(0).getLongitude();
                            lat.setText("Latitude : "+latitude);
                            lon.setText("Longitude : "+longitude);
                        }
                } catch (IOException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
    }
}