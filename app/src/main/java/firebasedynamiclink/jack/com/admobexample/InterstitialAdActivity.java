package firebasedynamiclink.jack.com.admobexample;
// How to Add Full screen Ad (Interstitial Ad) of AdMob in Android Application and Game

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class InterstitialAdActivity extends AppCompatActivity {

    InterstitialAd mAdMobInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        mAdMobInterstitialAd = new InterstitialAd(this);
        mAdMobInterstitialAd.setAdUnitId("ca-app-pub-6251629544760523/1518741592");
        AdRequest adRequest = new AdRequest.Builder()
                //.addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("9FAB71663EA15A56CE49EE32338B77B3")// Add your real device id here
                .build();

        mAdMobInterstitialAd.loadAd(adRequest);
        mAdMobInterstitialAd.setAdListener(new AdListener() {
            public void onAdLoaded() {
                showInterstitialAd();
            }
        });

    }

    private void showInterstitialAd() {
        if (mAdMobInterstitialAd.isLoaded()) {
            mAdMobInterstitialAd.show();
        }
    }
}