package com.mobiotics.test.view.fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.mobiotics.test.R;
import com.mobiotics.test.utils.UtilMethods;


public class DecryptionFragment extends Fragment {

    FragmentTransaction fragmentTransaction;

    TextView output_td;
    Button submit_td;
    EditText entertext_td;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub

        View view = inflater.inflate(R.layout.fragment_decryption, container, false);

        output_td = view.findViewById(R.id.output_td);
        submit_td = view.findViewById(R.id.submit_td);
        entertext_td = view.findViewById(R.id.entertext_td);
        submit_td.setEnabled(false);
        submit_td.setOnClickListener(view1 -> {
            try {
                output_td.setTextColor(getResources().getColor(R.color.black));
                output_td.setText(UtilMethods.decryptText(entertext_td.getText().toString()));
            } catch (Exception e) {
                e.printStackTrace();
                output_td.setText("Invalid Input");
                output_td.setTextColor(getResources().getColor(R.color.red));
            }
        });

        entertext_td.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (entertext_td.getText().toString().length() != 0) {
                    submit_td.setEnabled(true);
                } else
                    submit_td.setEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
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