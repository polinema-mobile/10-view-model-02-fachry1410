package id.putraprima.mvvmlogin.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import id.putraprima.mvvmlogin.R;
import id.putraprima.mvvmlogin.databinding.FragmentSplashBinding;

public class SplashFragment extends Fragment {

    public SplashFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentSplashBinding binding =  DataBindingUtil.inflate(inflater,R.layout.fragment_splash, container, false);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Navigation.findNavController(binding.getRoot()).navigate(R.id.action_splashFragment_to_loginFragment);
            }
        }, 3000);
        return binding.getRoot();
    }
}