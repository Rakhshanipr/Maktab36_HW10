package com.example.maktab36_hw10.Controller.fragment.tic_tac_toe;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.maktab36_hw10.R;
import com.example.maktab36_hw10.model.Player;

public class TicTacToeFragment extends Fragment implements View.OnClickListener {
    //region initialization
//    ImageButton mButton1_1;
//    ImageButton mButton1_2;
//    ImageButton mButton1_3;
//
//    ImageButton mButton2_1;
//    ImageButton mButton2_2;
//    ImageButton mButton2_3;
//
//    ImageButton mButton3_1;
//    ImageButton mButton3_2;
//    ImageButton mButton3_3;
    ImageButton[][] mImageButtons = new ImageButton[3][3];
    boolean mIsPlayer1Wind = false;
    boolean[] clicked = new boolean[10];
    //endregion

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tic_tac_toe, container, false);
        findViews(view);
        Player.run();
        setListner();
        return view;
    }

    private void setListner() {
        mImageButtons[0][0].setOnClickListener(this);
        mImageButtons[0][1].setOnClickListener(this);
        mImageButtons[0][2].setOnClickListener(this);
        mImageButtons[1][0].setOnClickListener(this);
        mImageButtons[1][1].setOnClickListener(this);
        mImageButtons[1][2].setOnClickListener(this);
        mImageButtons[2][0].setOnClickListener(this);
        mImageButtons[2][1].setOnClickListener(this);
        mImageButtons[2][2].setOnClickListener(this);
    }

    private void findViews(View view) {
        mImageButtons[0][0] = view.findViewById(R.id.button_1_1);
        mImageButtons[0][1] = view.findViewById(R.id.button_1_2);
        mImageButtons[0][2] = view.findViewById(R.id.button_1_3);
        mImageButtons[1][0] = view.findViewById(R.id.button_2_1);
        mImageButtons[1][1] = view.findViewById(R.id.button_2_2);
        mImageButtons[1][2] = view.findViewById(R.id.button_2_3);
        mImageButtons[2][0] = view.findViewById(R.id.button_3_1);
        mImageButtons[2][1] = view.findViewById(R.id.button_3_2);
        mImageButtons[2][2] = view.findViewById(R.id.button_3_3);
    }

    private boolean isEnd() {
        //region for ever culumn
        for (int i = 0; i < 3; i++) {
            int count = 0;
            boolean isUsed = false;
            for (int j = 0; j < 3; j++) {
                if (mImageButtons[i][j].getTag() != null) {
                    count += (int) mImageButtons[i][j].getTag();
                    isUsed = true;
                } else {
                    isUsed = false;
                    break;
                }
            }
            if (count == 3 && isUsed) {
                mIsPlayer1Wind = false;
                return true;
            } else if (count == 0 && isUsed) {
                mIsPlayer1Wind = true;
                return true;
            }
        }

        //endregion
        //region for ever row
        for (int i = 0; i < 3; i++) {
            int count = 0;
            boolean isUsed = false;

            for (int j = 0; j < 3; j++) {
                if (mImageButtons[j][i].getTag() != null) {
                    count += (int) mImageButtons[j][i].getTag();
                    isUsed = true;
                } else {
                    isUsed = false;
                    break;
                }
            }
            if (count == 3 && isUsed) {
                mIsPlayer1Wind = false;
                return true;
            } else if (count == 0 && isUsed) {
                mIsPlayer1Wind = true;
                return true;
            }
        }
        //endregion
        //region other
        int count = 0;
        boolean isUsed = false;
        for (int i = 0; i < 3; i++) {
            if (mImageButtons[i][i].getTag() != null) {
                count += (int) mImageButtons[i][i].getTag();
                isUsed = true;
            } else {
                isUsed = false;
                break;
            }
        }
        if (count == 3 && isUsed) {
            mIsPlayer1Wind = false;
            return true;
        } else if (count == 0 && isUsed) {
            mIsPlayer1Wind = true;
            return true;
        }

        count = 0;
        isUsed = false;


        for (int i = 0; i < 3; i++) {
            if (mImageButtons[i][(2-i)].getTag() != null) {
                count += (int) mImageButtons[i][(2-i)].getTag();
                isUsed = true;
            } else {
                isUsed = false;
                break;
            }
        }
        if (count == 3 && isUsed) {
            mIsPlayer1Wind = false;
            return true;
        } else if (count == 0 && isUsed) {
            mIsPlayer1Wind = true;
            return true;
        }
        //endregion
        return false;
    }

    @Override
    public void onClick(View view) {
        ImageButton b = (ImageButton) view;
        if (b.getTag() == null) {


            if (Player.getPlayer1().isActive()) {
                Player.getPlayer1().setActive(false);
                Player.getPlayer2().setActive(true);
                b.setImageResource(R.mipmap.circl);
                b.setTag(0);
            } else {
                Player.getPlayer1().setActive(true);
                Player.getPlayer2().setActive(false);
                b.setImageResource(R.mipmap.multiple);
                b.setTag(1);
            }

        }
        if (isEnd()) {
            if (mIsPlayer1Wind) {
                Toast.makeText(getActivity(), "player 1", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getActivity(), "player 2", Toast.LENGTH_SHORT).show();
            }
        }

    }

}