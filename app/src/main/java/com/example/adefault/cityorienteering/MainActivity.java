package com.example.adefault.cityorienteering;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adefault.cityorienteering.fragments.BaseFragment;
import com.example.adefault.cityorienteering.fragments.ListFragment;
import com.example.adefault.cityorienteering.fragments.MapFragment;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private static final int ZXING_CAMERA_PERMISSION = 1;
    private Class<?> mClss;
    private BaseFragment currentFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    changeContentFragment(getSupportFragmentManager(), ListFragment.getFragmentTag(),new ListFragment(),R.id.flFragmentsContainer,false);
                    return true;
                case R.id.navigation_map:
                    changeContentFragment(getSupportFragmentManager(), MapFragment.getFragmentTag(),new MapFragment(),R.id.flFragmentsContainer,false);
                    return true;
                case R.id.navigation_notifications:
                    launchActivity(SimpleScannerActivity.class);
                    return true;
            }
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        changeContentFragment(getSupportFragmentManager(), ListFragment.getFragmentTag(),new ListFragment(),R.id.flFragmentsContainer,false);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public void launchActivity(Class<?> clss) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            mClss = clss;
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CAMERA}, ZXING_CAMERA_PERMISSION);
        } else {
            Intent intent = new Intent(this, clss);
            startActivity(intent);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,  String permissions[], int[] grantResults) {
        switch (requestCode) {
            case ZXING_CAMERA_PERMISSION:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if(mClss != null) {
                        Intent intent = new Intent(this, mClss);
                        startActivity(intent);
                    }
                } else {
                    Toast.makeText(this, "Please grant camera permission to use the QR Scanner", Toast.LENGTH_SHORT).show();
                }
                return;
        }
    }

    public void changeContentFragment(String fragmentTag, BaseFragment frag, int containerId) {
        this.changeContentFragment(getSupportFragmentManager(), fragmentTag, frag, containerId, true);
    }

    public void changeContentFragment(FragmentManager fm, String fragmentTag, BaseFragment frag, int containerId, boolean shouldAddToBackStack) {

        // Check fragment manager to see if fragment exists
        currentFragment = fm.popBackStackImmediate(fragmentTag, 0)
                ? (BaseFragment) fm.findFragmentByTag(fragmentTag)
                : frag;

        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(containerId, frag, fragmentTag);
        if (shouldAddToBackStack) {
            transaction.addToBackStack(fragmentTag);
        }

        transaction.commitAllowingStateLoss();
    }
}
