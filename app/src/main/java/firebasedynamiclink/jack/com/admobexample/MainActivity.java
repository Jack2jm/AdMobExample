package firebasedynamiclink.jack.com.admobexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_interestial_ads = findViewById(R.id.interestial_Ads);
        Button video_ads = findViewById(R.id.video_ads);

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("9FAB71663EA15A56CE49EE32338B77B3")
                .build();

        mAdView.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                Toast.makeText(MainActivity.this, "onAdLoaded()", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdOpened() {
                super.onAdOpened();
                Toast.makeText(MainActivity.this, "onAdOpened()", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdClosed() {
                super.onAdClosed();
                Toast.makeText(MainActivity.this, "onAdClosed()", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdFailedToLoad(int i) {
                super.onAdFailedToLoad(i);
                Toast.makeText(MainActivity.this, "onAdFailedToLoad() " + i, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdLeftApplication() {
                super.onAdLeftApplication();
                Toast.makeText(MainActivity.this, "onAdLeftApplication()", Toast.LENGTH_SHORT).show();
            }
        });
        mAdView.loadAd(adRequest);

        /*String android_id = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);
        String deviceId = md5(android_id).toUpperCase();
        Log.i("device id=", deviceId);*/
        btn_interestial_ads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i_u = new Intent(MainActivity.this, InterstitialAdActivity.class);
                startActivity(i_u);
            }
        });

        video_ads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i_video = new Intent(MainActivity.this, RewardAdVideoActivity.class);
                startActivity(i_video);
            }
        });

    }

    @Override
    public void onPause() {
        // This method should be called in the parent Activity's onPause() method.
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        // This method should be called in the parent Activity's onResume() method.
        if (mAdView != null) {
            mAdView.resume();
        }
    }

    public String md5(String s) {
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < messageDigest.length; i++)
                hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public void onDestroy() {
        // This method should be called in the parent Activity's onDestroy() method.
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }
}
