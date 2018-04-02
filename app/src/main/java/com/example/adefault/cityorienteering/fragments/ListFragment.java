package com.example.adefault.cityorienteering.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.adefault.cityorienteering.R;

/**
 * Created by default on 4/2/18.
 */

public class ListFragment extends BaseFragment {

    private ImageView imageView;
    private static final String TAG = MapFragment.class.getSimpleName();


    @Override
    public String getFragmentTitle() {
        return "List";
    }

    @Override
    protected int getCurrentFragmentLayout() {
        return R.layout.fragment_list;
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