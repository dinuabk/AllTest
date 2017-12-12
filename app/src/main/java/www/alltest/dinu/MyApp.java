package www.alltest.dinu;

import android.app.Application;

import com.treebo.internetavailabilitychecker.InternetAvailabilityChecker;

/*
 * Created by Dinesh Kumar on 18-11-2017.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        InternetAvailabilityChecker.init(this);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        InternetAvailabilityChecker.getInstance().removeAllInternetConnectivityChangeListeners();
    }
}