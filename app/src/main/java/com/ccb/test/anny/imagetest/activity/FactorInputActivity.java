package com.ccb.test.anny.imagetest.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ccb.test.anny.imagetest.R;
import com.ccb.test.anny.imagetest.fragment.BottomMenuFragment;
import com.ccb.test.anny.imagetest.fragment.FactorInputFragment;

public class FactorInputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factor_input);
        addFactorInputFragment();
        //addBottomFragment();
        //initFragment();
    }



    public void addFactorInputFragment() {
        FragmentManager fragmentManager = getFragmentManager();
        FactorInputFragment factorInputFragment = new FactorInputFragment();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.activity_factor_input, factorInputFragment, "FactorInputFragment");
        fragmentTransaction.commit();
    }

    public void addBottomFragment() {
        FragmentManager fragmentManager = getFragmentManager();
        BottomMenuFragment bottomMenuFragment = new BottomMenuFragment();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.activity_factor_input, bottomMenuFragment, "BottomMenuFragment");
        fragmentTransaction.commit();
    }

    public void initFragment() {
        FragmentManager fragmentManager = getFragmentManager();
        FactorInputFragment factorInputFragment = new FactorInputFragment();
        BottomMenuFragment bottomMenuFragment = new BottomMenuFragment();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        //transaction.add(factorInputFragment, "FactorInputFragment");
        transaction.add(bottomMenuFragment, "BottomMenuFragment");
        transaction.commit();
    }
}
