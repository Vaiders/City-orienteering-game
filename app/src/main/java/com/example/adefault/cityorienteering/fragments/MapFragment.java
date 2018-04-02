package com.example.adefault.cityorienteering.fragments;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adefault.cityorienteering.R;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

/**
 * Created by default on 4/2/18.
 */

public class MapFragment extends BaseFragment {

    private ImageView imageView;
    private static final String TAG = MapFragment.class.getSimpleName();

    @Override
    public String getFragmentTitle() {
        return "Map";
    }

    @Override
    protected int getCurrentFragmentLayout() {
        return R.layout.fragment_map;
    }
    public static String getFragmentTag() {
        return TAG;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //imageView = (ImageView) getView().findViewById(R.id.image);
        //imageView.setImageDrawable();

    }
}
