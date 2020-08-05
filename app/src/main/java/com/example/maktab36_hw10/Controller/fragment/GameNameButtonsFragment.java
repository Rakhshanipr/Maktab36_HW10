package com.example.maktab36_hw10.Controller.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.maktab36_hw10.Controller.fragment.four_in_row.FourInRowFragment;
import com.example.maktab36_hw10.Controller.fragment.tic_tac_toe.TicTacToeFragment;
import com.example.maktab36_hw10.R;

public class GameNameButtonsFragment extends Fragment {
    //region initialization
    Button mButtonTicTacToe;
    Button mButtonFourInRow;
    Button mButtonSetting;
    //endregion

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_game_name_buttons, container, false);
        findViews(view);
        setListner();
        return view;
    }

    private void setListner() {
        mButtonTicTacToe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTransactionFragmet(new TicTacToeFragment());
            }
        });

        mButtonFourInRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTransactionFragmet(new FourInRowFragment());
            }
        });

        mButtonSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTransactionFragmet(new SettingFragment());
            }
        });
    }

    private void setTransactionFragmet(Fragment fragment) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        Fragment usedFragment = fragmentManager.findFragmentById(R.id.fragment_game_main_container);
        if (usedFragment == null) {
            fragmentManager
                    .beginTransaction()
                    .add(R.id.fragment_game_main_container, fragment)
                    .commit();
        } else {
            fragmentManager
                    .beginTransaction()
                    .remove(usedFragment)
                    .add(R.id.fragment_game_main_container, fragment)
                    .commit();
        }
    }

    private void findViews(View view) {
        mButtonFourInRow = view.findViewById(R.id.button_4_in_a_row);
        mButtonSetting=view.findViewById(R.id.button_setting);
        mButtonTicTacToe = view.findViewById(R.id.button_tic_tac_toe);
    }
}