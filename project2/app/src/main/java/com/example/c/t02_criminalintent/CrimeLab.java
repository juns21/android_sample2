package com.example.c.t02_criminalintent;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by c on 2015-01-17.
 */
public class CrimeLab {
    private static CrimeLab sCrimeLab;
    private Context mAppContext;
    private ArrayList<Crime> mCrimes;

    private static final String TAG = "CrimeLab";
    private static final String FILENAME = "crime.json";

    private CrimeIntentJSONSerializer mSerializer;

    public CrimeLab(Context appContext) {
        mAppContext = appContext;
        //mCrimes = new ArrayList<Crime>();
        /*for (int i=0; i<100; i++) {
            Crime c = new Crime();
            c.setTitle("범죄 #"+ i);
            c.setSolved(i%2==0);
            mCrimes.add(c);
        }*/
        mSerializer = new CrimeIntentJSONSerializer(appContext, FILENAME);
        try {
            mCrimes = mSerializer.loadCrimes();
        } catch (Exception e) {
            e.printStackTrace();
            mCrimes = new ArrayList<Crime>();
        }
    }

    public static CrimeLab get(Context c) {
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab(c.getApplicationContext());
        }
        return sCrimeLab;
    }

    public ArrayList<Crime> getCrimes() {
        return mCrimes;
    }

    public Crime getCrime(UUID id) {
        for(Crime c : mCrimes) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    public void addCrime(Crime c) {
        mCrimes.add(c);
    }

    public boolean saveCrimes() {
        try {
            mSerializer.saveCrimes(mCrimes);
            Log.d(TAG, "CRIME SAVED TO FILE");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
