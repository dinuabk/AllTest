package www.alltest.dinu;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import junit.framework.Test;


@SuppressWarnings("ConstantConditions")
public class MainActivity extends AppCompatActivity {

    String answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        try {

            oreoNotif();

            Button mBtn = findViewById(R.id.button2);
            mBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Notification();
                }
            });

            //        startService(new Intent(this, NetworkService.class));

           // startActivity(new Intent(MainActivity.this, TestActivity.class));

//            TextView mTxtView = findViewById(R.id.textView);
//
//
//            WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
//            WifiInfo info = wifiManager.getConnectionInfo();
//            String address = info.getBSSID();
//            Log.e("BSSIB", address);
//
//            mTxtView.setText(String.valueOf(address));
//
//            checkMode();

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
            startActivity(new Intent(MainActivity.this, TestActivity.class));
            if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE)
                answer = "You are connected to a Mobile Network";
            startActivity(new Intent(MainActivity.this, TestActivity.class));
        } else
            answer = "No internet Connectivity";
        Toast.makeText(getApplicationContext(), answer, Toast.LENGTH_LONG).show();
    }

    public void Notification() {
        // Set Notification Title
        String strtitle = getString(R.string.app_name);
        // Set Notification Text
        String strtext = getString(R.string.app_name);

        // Open NotificationView Class on Notification Click
        Intent intent = new Intent(this, Test2Activity.class);
        // Send data to NotificationView Class
        intent.putExtra("title", strtitle);
        intent.putExtra("text", strtext);
        // Open NotificationView.java Activity
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        //Create Notification using NotificationCompat.Builder
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                // Set Icon
                .setSmallIcon(R.mipmap.ic_launcher)
                // Set Ticker Message
                .setTicker(getString(R.string.app_name))
                // Set Title
                .setContentTitle(getString(R.string.app_name))
                // Set Text
                .setContentText(getString(R.string.app_name))
                // Add an Action Button below Notification
                .addAction(R.mipmap.ic_launcher, "Action Button", pIntent)
                // Set PendingIntent into Notification
                .setContentIntent(pIntent)
                // Dismiss Notification
                .setAutoCancel(true);

        // Create Notification Manager
        NotificationManager notificationmanager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // Build Notification with Notification Manager
        notificationmanager.notify(0, builder.build());

    }

    private void oreoNotif()
    {
        int notifyID = 1;
        String CHANNEL_ID = "my_channel_01";// The id of the channel.
        CharSequence name = getString(R.string.app_name);// The user-visible name of the channel.
        int importance = NotificationManager.IMPORTANCE_HIGH;
        NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, name, importance);
// Create a notification and set the notification channel.
        Notification notification = new Notification.Builder(MainActivity.this)
                .setContentTitle("New Message")
                .setContentText("You've received new messages.")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setChannelId(CHANNEL_ID)
                .build();

        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.createNotificationChannel(mChannel);

// Issue the notification.
        mNotificationManager.notify(notifyID , notification);

    }
}
