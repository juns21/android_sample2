package com.example.c.t02_criminalintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;

/**
 * Created by c on 2015-01-24.
 */
public abstract class SingleFragmentActivity extends ActionBarActivity {
    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fr = fm.findFragmentById(R.id.fragmentContainer);
        if (fr == null) {
            fr = createFragment();
            //FragmentTransaction tr = fm.beginTransaction();
            fm.beginTransaction()
                    .add(R.id.fragmentContainer, fr)
                    .commit();
        }
    }
}
