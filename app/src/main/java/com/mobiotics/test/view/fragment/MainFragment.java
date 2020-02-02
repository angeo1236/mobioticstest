package com.mobiotics.test.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.mobiotics.test.R;


public class MainFragment extends Fragment {

    FragmentTransaction fragmentTransaction;
    TextView encrypt_btn, decrypt_btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub

        View view = inflater.inflate(R.layout.fragment_main, container, false);
        decrypt_btn = view.findViewById(R.id.decrypt_btn);
        encrypt_btn = view.findViewById(R.id.encrypt_btn);

        decrypt_btn.setOnClickListener(v -> {
            replaceFragment(new DecryptionFragment());
        });

        encrypt_btn.setOnClickListener(v -> {
            replaceFragment(new EncryptionFragment());
        });


        return view;
    }

    public void replaceFragment(Fragment fragment) {

        try {
            fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.container_layout, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commitAllowingStateLoss();

        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}