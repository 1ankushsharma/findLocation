package location.in.findlocation;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements LocationListener{
     public static TextView textView;
    LocationManager locationManager;
    public double latitude;
    public double longitude;

    void show(){
        textView=findViewById(R.id.textView4);
         locationManager= (LocationManager) getSystemService(LOCATION_SERVICE);
    }

    public void smsset(String s){

        textView.setText(s);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show();


    }


    @Override
    public  void onLocationChanged(Location location) {
          latitude=location.getLatitude();
          longitude=location.getLongitude();
        //  Toast.makeText(MainActivity.this, (int) (latitude+longitude),Toast.LENGTH_LONG).show();
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}





