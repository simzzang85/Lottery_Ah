package com.simstudious.lottery_ah;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class MainActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
//    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link } that will host the section contents.
     */
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextInitiate();
        AdsShow();
        Button btnDraw = findViewById(R.id.btnDraw);
        btnDraw.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                BtnDrawOnClick();
            }
        });
    }
    public void AdsShow(){

        // Initialize the Mobile Ads SDK
        MobileAds.initialize(this,"ca-app-pub-5527371243503810/3528818688");

        // Find Banner ad
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        // Display Banner ad
        mAdView.loadAd(adRequest);
    }
    public void BtnDrawOnClick()
    {
        int[] numbers1 = new int[6];
        int[] numbers2 = new int[6];
        int[] numbers3 = new int[6];
        int[] numbers4 = new int[6];
        int[] numbers5 = new int[6];
        String type = "";

        RadioGroup rg1 = findViewById(R.id.radioGroup1);
        RadioButton rb1 = findViewById(R.id.tp1);
        //RadioButton rb2 = findViewById(R.id.tp2);
        //RadioButton rb3 = findViewById(R.id.tp3);
        RadioGroup rg2 = findViewById(R.id.radioGroup2);
        RadioButton cnt1 = findViewById(R.id.cnt1);
        RadioButton cnt2 = findViewById(R.id.cnt2);
        RadioButton cnt3 = findViewById(R.id.cnt3);

        int selectedId = rg2.getCheckedRadioButtonId();
        RadioButton rdoBtn = findViewById(selectedId);

        type = "pw";
        /*
        if (rdoBtn.getText().toString().equals("Powerball"))
        {
            type = "pw";
        }
        else if (rdoBtn.getText().toString().equals("Mega Million"))
        {
            type = "mg";
        }
        else if (rdoBtn.getText().toString().equals( "Life4Cash"))
        {
            type = "cash";
        }
        */
        int selectedId2 = rg1.getCheckedRadioButtonId();
        RadioButton rdoBtn2 = findViewById(selectedId2);

        //String strToast = rdoBtn2.getText().toString();
        //Toast.makeText(getApplicationContext(),strToast,Toast.LENGTH_SHORT).show();
        if (cnt1.isChecked())
        {
            //Log.v("PickNum","LotteryAh000000:::::"+ type+"::number::"+numbers1[0]);
            TextInitiate();
            //AssginBackgound();
            TextView tv11 = findViewById(R.id.num11);
            TextView tv12 = findViewById(R.id.num12);
            TextView tv13 = findViewById(R.id.num13);
            TextView tv14 = findViewById(R.id.num14);
            TextView tv15 = findViewById(R.id.num15);
            TextView tv16 = findViewById(R.id.numSp1);

            numbers1 = LotteryLib.LotteryAh(type);

            tv11.setText(numbers1[0]+"");
            tv12.setText(numbers1[1]+"");
            tv13.setText(numbers1[2]+"");
            tv14.setText(numbers1[3]+"");
            tv15.setText(numbers1[4]+"");
            tv16.setText(numbers1[5]+"");
        }
        else if (cnt2.isChecked())
        {
            Log.v("PlaceNumToArry211111","TYPE:::::::number::");
            TextInitiate();
            //AssginBackgound();
            numbers1 = LotteryLib.LotteryAh(type);
            TextView tv11 = findViewById(R.id.num11);
            TextView tv12 = findViewById(R.id.num12);
            TextView tv13 = findViewById(R.id.num13);
            TextView tv14 = findViewById(R.id.num14);
            TextView tv15 = findViewById(R.id.num15);
            TextView tv16 = findViewById(R.id.numSp1);
            tv11.setText(numbers1[0]+"");
            tv12.setText(numbers1[1]+"");
            tv13.setText(numbers1[2]+"");
            tv14.setText(numbers1[3]+"");
            tv15.setText(numbers1[4]+"");
            tv16.setText(numbers1[5]+"");

            numbers2 = LotteryLib.LotteryAh(type);
            TextView tv21 = findViewById(R.id.num21);
            TextView tv22 = findViewById(R.id.num22);
            TextView tv23 = findViewById(R.id.num23);
            TextView tv24 = findViewById(R.id.num24);
            TextView tv25 = findViewById(R.id.num25);
            TextView tv26 = findViewById(R.id.numSp2);
            tv21.setText(numbers2[0]+"");
            tv22.setText(numbers2[1]+"");
            tv23.setText(numbers2[2]+"");
            tv24.setText(numbers2[3]+"");
            tv25.setText(numbers2[4]+"");
            tv26.setText(numbers2[5]+"");

            numbers3 = LotteryLib.LotteryAh(type);
            TextView tv31 = findViewById(R.id.num31);
            TextView tv32 = findViewById(R.id.num32);
            TextView tv33 = findViewById(R.id.num33);
            TextView tv34 = findViewById(R.id.num34);
            TextView tv35 = findViewById(R.id.num35);
            TextView tv36 = findViewById(R.id.numSp3);
            tv31.setText(numbers3[0]+"");
            tv32.setText(numbers3[1]+"");
            tv33.setText(numbers3[2]+"");
            tv34.setText(numbers3[3]+"");
            tv35.setText(numbers3[4]+"");
            tv36.setText(numbers3[5]+"");

        }
        else// if (rdoBtn2.isChecked())
        {
            //Log.v("PlaceNumToArry222222","TYPE:::::::number::");
            TextInitiate();
            //AssginBackgound();
            numbers1 = LotteryLib.LotteryAh(type);
            TextView tv11 = findViewById(R.id.num11);
            TextView tv12 = findViewById(R.id.num12);
            TextView tv13 = findViewById(R.id.num13);
            TextView tv14 = findViewById(R.id.num14);
            TextView tv15 = findViewById(R.id.num15);
            TextView tv16 = findViewById(R.id.numSp1);
            tv11.setText(numbers1[0]+"");
            tv12.setText(numbers1[1]+"");
            tv13.setText(numbers1[2]+"");
            tv14.setText(numbers1[3]+"");
            tv15.setText(numbers1[4]+"");
            tv16.setText(numbers1[5]+"");

            numbers2 = LotteryLib.LotteryAh(type);
            TextView tv21 = findViewById(R.id.num21);
            TextView tv22 = findViewById(R.id.num22);
            TextView tv23 = findViewById(R.id.num23);
            TextView tv24 = findViewById(R.id.num24);
            TextView tv25 = findViewById(R.id.num25);
            TextView tv26 = findViewById(R.id.numSp2);
            tv21.setText(numbers2[0]+"");
            tv22.setText(numbers2[1]+"");
            tv23.setText(numbers2[2]+"");
            tv24.setText(numbers2[3]+"");
            tv25.setText(numbers2[4]+"");
            tv26.setText(numbers2[5]+"");

            numbers3 = LotteryLib.LotteryAh(type);
            TextView tv31 = findViewById(R.id.num31);
            TextView tv32 = findViewById(R.id.num32);
            TextView tv33 = findViewById(R.id.num33);
            TextView tv34 = findViewById(R.id.num34);
            TextView tv35 = findViewById(R.id.num35);
            TextView tv36 = findViewById(R.id.numSp3);
            tv31.setText(numbers3[0]+"");
            tv32.setText(numbers3[1]+"");
            tv33.setText(numbers3[2]+"");
            tv34.setText(numbers3[3]+"");
            tv35.setText(numbers3[4]+"");
            tv36.setText(numbers3[5]+"");

            numbers4 = LotteryLib.LotteryAh(type);
            TextView tv41 = findViewById(R.id.num41);
            TextView tv42 = findViewById(R.id.num42);
            TextView tv43 = findViewById(R.id.num43);
            TextView tv44 = findViewById(R.id.num44);
            TextView tv45 = findViewById(R.id.num45);
            TextView tv46 = findViewById(R.id.numSp4);
            tv41.setText(numbers4[0]+"");
            tv42.setText(numbers4[1]+"");
            tv43.setText(numbers4[2]+"");
            tv44.setText(numbers4[3]+"");
            tv45.setText(numbers4[4]+"");
            tv46.setText(numbers4[5]+"");

            numbers5 = LotteryLib.LotteryAh(type);
            TextView tv51 = findViewById(R.id.num51);
            TextView tv52 = findViewById(R.id.num52);
            TextView tv53 = findViewById(R.id.num53);
            TextView tv54 = findViewById(R.id.num54);
            TextView tv55 = findViewById(R.id.num55);
            TextView tv56 = findViewById(R.id.numSp5);
            tv51.setText(numbers5[0]+"");
            tv52.setText(numbers5[1]+"");
            tv53.setText(numbers5[2]+"");
            tv54.setText(numbers5[3]+"");
            tv55.setText(numbers5[4]+"");
            tv56.setText(numbers5[5]+"");
        }

    }
    public void AssginBackgound()
    {
        findViewById(R.id.num11).setBackgroundResource(R.drawable.abc_ic_star_black_16dp);
        findViewById(R.id.num12).setBackgroundResource(R.drawable.abc_ic_star_black_16dp);
        findViewById(R.id.num13).setBackgroundResource(R.drawable.abc_ic_star_black_16dp);
        findViewById(R.id.num14).setBackgroundResource(R.drawable.abc_ic_star_black_16dp);
        findViewById(R.id.num15).setBackgroundResource(R.drawable.abc_ic_star_black_16dp);
        findViewById(R.id.numSp1).setBackgroundResource(R.drawable.abc_ic_star_black_16dp);

        RadioButton rbCnt2 = findViewById(R.id.cnt2);
        RadioButton rbCnt3 = findViewById(R.id.cnt3);

        if ( rbCnt2.isChecked() == true || rbCnt3.isChecked() == true)
        {
            findViewById(R.id.num21).setBackgroundResource(R.drawable.abc_ic_star_black_16dp);
            findViewById(R.id.num22).setBackgroundResource(R.drawable.abc_ic_star_black_16dp);
            findViewById(R.id.num23).setBackgroundResource(R.drawable.abc_ic_star_black_16dp);
            findViewById(R.id.num24).setBackgroundResource(R.drawable.abc_ic_star_black_16dp);
            findViewById(R.id.num25).setBackgroundResource(R.drawable.abc_ic_star_black_16dp);
            findViewById(R.id.numSp2).setBackgroundResource(R.drawable.abc_ic_star_black_16dp);

            findViewById(R.id.num31).setBackgroundResource(R.drawable.abc_ic_star_black_16dp);
            findViewById(R.id.num32).setBackgroundResource(R.drawable.abc_ic_star_black_16dp);
            findViewById(R.id.num33).setBackgroundResource(R.drawable.abc_ic_star_black_16dp);
            findViewById(R.id.num34).setBackgroundResource(R.drawable.abc_ic_star_black_16dp);
            findViewById(R.id.num35).setBackgroundResource(R.drawable.abc_ic_star_black_16dp);
            findViewById(R.id.numSp3).setBackgroundResource(R.drawable.abc_ic_star_black_16dp);
        }

        if (rbCnt3.isChecked() == true)
        {
            findViewById(R.id.num41).setBackgroundResource(R.drawable.abc_ic_star_black_16dp);
            findViewById(R.id.num42).setBackgroundResource(R.drawable.abc_ic_star_black_16dp);
            findViewById(R.id.num43).setBackgroundResource(R.drawable.abc_ic_star_black_16dp);
            findViewById(R.id.num44).setBackgroundResource(R.drawable.abc_ic_star_black_16dp);
            findViewById(R.id.num45).setBackgroundResource(R.drawable.abc_ic_star_black_16dp);
            findViewById(R.id.numSp4).setBackgroundResource(R.drawable.abc_ic_star_black_16dp);

            findViewById(R.id.num51).setBackgroundResource(R.drawable.abc_ic_star_black_16dp);
            findViewById(R.id.num52).setBackgroundResource(R.drawable.abc_ic_star_black_16dp);
            findViewById(R.id.num53).setBackgroundResource(R.drawable.abc_ic_star_black_16dp);
            findViewById(R.id.num54).setBackgroundResource(R.drawable.abc_ic_star_black_16dp);
            findViewById(R.id.num55).setBackgroundResource(R.drawable.abc_ic_star_black_16dp);
            findViewById(R.id.numSp5).setBackgroundResource(R.drawable.abc_ic_star_black_16dp);
        }
    }
    public void TextInitiate()
    {
        TextView tv11 = findViewById(R.id.num11);
        TextView tv12 = findViewById(R.id.num12);
        TextView tv13 = findViewById(R.id.num13);
        TextView tv14 = findViewById(R.id.num14);
        TextView tv15 = findViewById(R.id.num15);
        TextView tv16 = findViewById(R.id.numSp1);
        tv11.setText(" ");
        tv12.setText(" ");
        tv13.setText(" ");
        tv14.setText(" ");
        tv15.setText(" ");
        tv16.setText(" ");
        TextView tv21 = findViewById(R.id.num21);
        TextView tv22 = findViewById(R.id.num22);
        TextView tv23 = findViewById(R.id.num23);
        TextView tv24 = findViewById(R.id.num24);
        TextView tv25 = findViewById(R.id.num25);
        TextView tv26 = findViewById(R.id.numSp2);
        tv21.setText(" ");
        tv22.setText(" ");
        tv23.setText(" ");
        tv24.setText(" ");
        tv25.setText(" ");
        tv26.setText(" ");
        TextView tv31 = findViewById(R.id.num31);
        TextView tv32 = findViewById(R.id.num32);
        TextView tv33 = findViewById(R.id.num33);
        TextView tv34 = findViewById(R.id.num34);
        TextView tv35 = findViewById(R.id.num35);
        TextView tv36 = findViewById(R.id.numSp3);
        tv31.setText(" ");
        tv32.setText(" ");
        tv33.setText(" ");
        tv34.setText(" ");
        tv35.setText(" ");
        tv36.setText(" ");
        TextView tv41 = findViewById(R.id.num41);
        TextView tv42 = findViewById(R.id.num42);
        TextView tv43 = findViewById(R.id.num43);
        TextView tv44 = findViewById(R.id.num44);
        TextView tv45 = findViewById(R.id.num45);
        TextView tv46 = findViewById(R.id.numSp4);
        tv41.setText(" ");
        tv42.setText(" ");
        tv43.setText(" ");
        tv44.setText(" ");
        tv45.setText(" ");
        tv46.setText(" ");
        TextView tv51 = findViewById(R.id.num51);
        TextView tv52 = findViewById(R.id.num52);
        TextView tv53 = findViewById(R.id.num53);
        TextView tv54 = findViewById(R.id.num54);
        TextView tv55 = findViewById(R.id.num55);
        TextView tv56 = findViewById(R.id.numSp5);
        tv51.setText(" ");
        tv52.setText(" ");
        tv53.setText(" ");
        tv54.setText(" ");
        tv55.setText(" ");
        tv56.setText(" ");
    }
}
