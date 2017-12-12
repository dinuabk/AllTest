package www.alltest.dinu;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.treebo.internetavailabilitychecker.InternetAvailabilityChecker;
import com.treebo.internetavailabilitychecker.InternetConnectivityListener;

/*
 * Created by Dinesh Kumar on 18-11-2017.
 */

public class NetworkService extends Service implements InternetConnectivityListener {

    InternetAvailabilityChecker mInternetAvailabilityChecker;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("Network Service", "IBinder");
        return null;
    }


    public void onCreate() {
        Log.e("Network Service", "onCreate");
        mInternetAvailabilityChecker = InternetAvailabilityChecker.getInstance();
        mInternetAvailabilityChecker.addInternetConnectivityListener(this);
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Log.e("Network Service", "onDestroy");
        mInternetAvailabilityChecker
                .removeInternetConnectivityChangeListener(this);
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("Network Service", "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onInternetConnectivityChanged(boolean isConnected) {
        Log.e("Network Service", "onInternetConnectivityChanged");
        if (!isConnected) {
            Log.e("Network Service", "onMethod");
            Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show();
        }
    }
}
