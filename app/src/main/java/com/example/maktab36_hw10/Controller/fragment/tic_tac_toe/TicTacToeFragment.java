package com.example.maktab36_hw10.Controller.fragment.tic_tac_toe;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
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
    TextView mTextViewPlayer1Name;
    TextView mTextViewPlayer2Name;
    TextView mTextViewPlayer1Point;
    TextView mTextViewPlayer2Point;
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
        setListner();
        initSet(true, false);
        updateEdittext();
        return view;
    }

    private void initSet(boolean b, boolean b2) {
        Player.getPlayer1().setActive(b);
        Player.getPlayer2().setActive(b2);
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
        mTextViewPlayer1Name = view.findViewById(R.id.edittext_player1);
        mTextViewPlayer2Name = view.findViewById(R.id.edittext_player2);
        mTextViewPlayer1Point = view.findViewById(R.id.edittext_player1_point);
        mTextViewPlayer2Point = view.findViewById(R.id.edittext_player2_point);

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
            if (mImageButtons[i][(2 - i)].getTag() != null) {
                count += (int) mImageButtons[i][(2 - i)].getTag();
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
                initSet(false, true);
                b.setImageResource(R.mipmap.circl);
                b.setTag(0);
            } else {
                initSet(true, false);
                b.setImageResource(R.mipmap.multiple);
                b.setTag(1);
            }

        }
        if (isEnd()) {
            if (mIsPlayer1Wind) {
                plusPlayer1();
                Snackbar snackbar = Snackbar
                        .make(getView(), "Wind----> " + Player.getPlayer1().getName(), Snackbar.LENGTH_LONG);
                snackbar.show();
                onPause();
            } else {
                plusPlayer2();
                Snackbar snackbar = Snackbar
                        .make(getView(), "Wind----> " + Player.getPlayer2().getName(), Snackbar.LENGTH_LONG);
                snackbar.show();
                this.onPause();

            }
        }

    }

    private void plusPlayer1() {
        Player.getPlayer1().setPoint(Player.getPlayer1().getPoint() + 1);
        updateEdittext();
    }

    private void plusPlayer2() {
        Player.getPlayer2().setPoint(Player.getPlayer2().getPoint() + 1);
        updateEdittext();
    }

    @Override
    public void onResume() {
        super.onResume();
        updateEdittext();
    }

    private void updateEdittext() {
        mTextViewPlayer1Name.setText(Player.getPlayer1().getName());
        mTextViewPlayer2Name.setText(Player.getPlayer2().getName());
        mTextViewPlayer1Point.setText(Integer.toString(Player.getPlayer1().getPoint()));
        mTextViewPlayer2Point.setText(Integer.toString(Player.getPlayer2().getPoint()));
    }
}