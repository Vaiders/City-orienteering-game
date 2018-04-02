package com.example.adefault.cityorienteering.fragments;


import android.support.v4.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by default on 4/2/18.
 */

public abstract class BaseFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(getCurrentFragmentLayout(), container, false);
        setHasOptionsMenu(true);
        return view;
    }

    public abstract String getFragmentTitle();

    protected abstract int getCurrentFragmentLayout();
}
