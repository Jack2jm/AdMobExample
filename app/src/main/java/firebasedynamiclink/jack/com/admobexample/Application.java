package firebasedynamiclink.jack.com.admobexample;

import com.google.android.gms.ads.MobileAds;

/*
 * Created by jatin on 8/11/2018.
 */

public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        MobileAds.initialize(this, "ca-app-pub-6251629544760523~1125423145");
    }
}
