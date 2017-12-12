package www.alltest.dinu;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;


@SuppressWarnings("ConstantConditions")
public class MainActivity extends AppCompatActivity {

    String answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        try {
            //        startService(new Intent(this, NetworkService.class));

            TextView mTxtView = findViewById(R.id.textView);


            WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
            WifiInfo info = wifiManager.getConnectionInfo();
            String address = info.getBSSID();
            Log.e("BSSIB", address);

            mTxtView.setText(String.valueOf(address));

            checkMode();

        } catch (Exception ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


    private void checkMode() {
        ConnectivityManager cm = (ConnectivityManager) getApplicationContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (null != activeNetwork) {
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI)
                answer = "You are connected to a WiFi Network";
            if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE)
                answer = "You are connected to a Mobile Network";
        } else
            answer = "No internet Connectivity";
        Toast.makeText(getApplicationContext(), answer, Toast.LENGTH_LONG).show();
    }
}
