package location.in.findlocation;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.service.carrier.CarrierMessagingService;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SmsReceiver extends BroadcastReceiver {
    public  String sendernumber;
    public String message;
    SmsManager smsManager;


    @Override
    public void onReceive(Context context, Intent intent) {



        Bundle bundle=intent.getExtras();

        if(bundle!=null){
            Object [] pdus= (Object[]) bundle.get("pdus");

            for(int i=0;i<pdus.length;i++){

                SmsMessage sms=SmsMessage.createFromPdu((byte[]) pdus[i]);

                sendernumber=sms.getDisplayOriginatingAddress();
                message=sms.getDisplayMessageBody().toString();
                Toast.makeText(context,"from: "+sendernumber+" and the message is:"+message,Toast.LENGTH_LONG).show();

                MainActivity mref=new MainActivity();
                mref.smsset("Number: "+sendernumber+ "\n Message: "+message);
               // Log.i(null,"it is running");
                double lon=mref.longitude;
                double lat=mref.latitude;

                Toast.makeText(context, (int) (lat+lon),Toast.LENGTH_LONG).show();




            }

        }

        if(message.contains("Lost") || message.contains("lost")) {
            smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(sendernumber,null,"heyy",null,null);
    }
                }

}
