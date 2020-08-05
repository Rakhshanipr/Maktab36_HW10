package com.example.maktab36_hw10.Controller.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.maktab36_hw10.Controller.fragment.GameNameButtonsFragment;
import com.example.maktab36_hw10.Controller.fragment.four_in_row.FourInRowFragment;
import com.example.maktab36_hw10.Controller.fragment.tic_tac_toe.TicTacToeFragment;
import com.example.maktab36_hw10.R;
import com.example.maktab36_hw10.model.Player;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Player.run();
        fragmentManager();
        initSitting();
    }

    private void fragmentManager() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_game_button_container);
        if (fragment == null) {
            fragmentManager
                    .beginTransaction()
                    .add(R.id.fragment_game_button_container, new GameNameButtonsFragment())
                    .commit();
        }
    }

    private void initSitting() {
        getSupportActionBar().hide();
    }

}