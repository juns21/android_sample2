package com.example.c.t02_criminalintent;

import android.support.v4.app.Fragment;

import java.util.UUID;

/**
 * Created by c on 2015-01-24.
 */
public class CrimeActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        //return new CrimeFragment();
        UUID crimeId = (UUID)getIntent().getExtras().get(CrimeFragment.EXTRA_CRIME_ID);
        return CrimeFragment.newInstance(crimeId);
    }
}