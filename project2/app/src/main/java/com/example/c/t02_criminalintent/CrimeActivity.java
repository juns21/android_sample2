package com.example.c.t02_criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by c on 2015-01-24.
 */
public class CrimeActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeFragment();
    }
}
