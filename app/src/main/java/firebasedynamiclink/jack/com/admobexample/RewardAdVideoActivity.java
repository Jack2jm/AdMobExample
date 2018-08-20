package firebasedynamiclink.jack.com.admobexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

/*
 * Created by jatin on 8/20/2018.
 */

public class RewardAdVideoActivity extends AppCompatActivity implements RewardedVideoAdListener {

    private RewardedVideoAd mRewardedVideoAd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Use an activity context to get the rewarded video instance.
        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        mRewardedVideoAd.setRewardedVideoAdListener(this);

        loadRewardedVideoAd();
    }

    @Override
    public void onRewardedVideoAdLoaded() {
        Log.d("Reward ads", "Rewarded: onRewardedVideoAdLoaded");
        try {
            if (mRewardedVideoAd.isLoaded()) {
                mRewardedVideoAd.show();
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onRewardedVideoAdOpened() {
        Log.d("Reward ads", "Rewarded: onRewardedVideoAdOpened");
    }

    @Override
    public void onRewardedVideoStarted() {
        Log.d("Reward ads", "Rewarded: onRewardedVideoStarted");
    }

    @Override
    public void onRewardedVideoAdClosed() {
        Log.d("Reward ads", "Rewarded: onRewardedVideoAdClosed");
    }

    @Override
    public void onRewarded(RewardItem rewardItem) {
        Log.d("Reward ads", "Rewarded:  onRewarded! currency: " + rewardItem.getType() + "  amount: " +
                rewardItem.getAmount());

    }

    @Override
    public void onRewardedVideoAdLeftApplication() {
        Log.d("Reward ads", "Rewarded: onRewardedVideoAdLeftApplication ");
    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {
        Log.d("Reward ads", "Rewarded: onRewardedVideoAdFailedToLoad: " + i);

    }

    @Override
    public void onRewardedVideoCompleted() {
        Log.d("Reward ads", "Rewarded: onRewardedVideoCompleted: ");
    }

    private void loadRewardedVideoAd() {
        mRewardedVideoAd.loadAd("ca-app-pub-6251629544760523/6006874848",
                new AdRequest.Builder().addTestDevice("9FAB71663EA15A56CE49EE32338B77B3").build());
    }

   /* @Override
    protected void onPause() {
        super.onPause();
        mRewardedVideoAd.pause(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mRewardedVideoAd.resume(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRewardedVideoAd.destroy(this);
    }*/
}
