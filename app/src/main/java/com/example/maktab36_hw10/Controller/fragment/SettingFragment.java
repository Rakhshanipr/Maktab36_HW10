package com.example.maktab36_hw10.Controller.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.maktab36_hw10.R;
import com.example.maktab36_hw10.model.Player;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SettingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SettingFragment extends Fragment {
    Button mButtonSave;
    EditText mEditTextPlayer1Name;
    EditText mEditTextPlayer2Name;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_setting, container, false);
        findViews(view);
        mEditTextPlayer1Name.setText(Player.getPlayer1().getName());
        mEditTextPlayer2Name.setText(Player.getPlayer2().getName());
        mButtonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Player.getPlayer1().setName(mEditTextPlayer1Name.getText().toString());
                Player.getPlayer2().setName(mEditTextPlayer2Name.getText().toString());
            }
        });
        return view;
    }

    private void findViews(View view) {
        mButtonSave = view.findViewById(R.id.button_save_name_of_players);
        mEditTextPlayer1Name = view.findViewById(R.id.edittext_save_player1_name);
        mEditTextPlayer2Name = view.findViewById(R.id.edittext_save_player2_name);
    }
}