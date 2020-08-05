package com.example.maktab36_hw10.Controller.fragment.four_in_row;

import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.maktab36_hw10.R;
import com.example.maktab36_hw10.model.Player;

public class FourInRowFragment extends Fragment implements View.OnClickListener {
    //region initialzation
    ImageButton mButton1_1;
    ImageButton mButton1_2;
    ImageButton mButton1_3;
    ImageButton mButton1_4;
    ImageButton mButton1_5;

    ImageButton mButton2_1;
    ImageButton mButton2_2;
    ImageButton mButton2_3;
    ImageButton mButton2_4;
    ImageButton mButton2_5;

    ImageButton mButton3_1;
    ImageButton mButton3_2;
    ImageButton mButton3_3;
    ImageButton mButton3_4;
    ImageButton mButton3_5;

    ImageButton mButton4_1;
    ImageButton mButton4_2;
    ImageButton mButton4_3;
    ImageButton mButton4_4;
    ImageButton mButton4_5;

    ImageButton mButton5_1;
    ImageButton mButton5_2;
    ImageButton mButton5_3;
    ImageButton mButton5_4;
    ImageButton mButton5_5;

    ImageButton[][] mImageButtons = new ImageButton[5][5];

    TextView mTextViewPlayer1Name;
    TextView mTextViewPlayer2Name;
    TextView mTextViewPlayer1Point;
    TextView mTextViewPlayer2Point;
    int[] mLastRow = {0, 0, 0, 0, 0};
    int[][] mColors = new int[5][5];
    boolean mWindPlayer1 = false;

    //endregion

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void disableButton() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                mImageButtons[i][j].setEnabled(false);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_four_in_row, container, false);
        findViews(view);
        setListners();
        initSet(true, false);
        setImageButtonsTag();

        return view;
    }

    private void setImageButtonsTag() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                mImageButtons[i][j].setTag(new int[]{i, j});
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

    private void initSet(boolean b, boolean b2) {
        Player.getPlayer1().setActive(b);
        Player.getPlayer2().setActive(b2);
    }

    private void findViews(View view) {
        //region buttons
        mImageButtons[0][0] = view.findViewById(R.id.button_1_1);
        mImageButtons[0][1] = view.findViewById(R.id.button_1_2);
        mImageButtons[0][2] = view.findViewById(R.id.button_1_3);
        mImageButtons[0][3] = view.findViewById(R.id.button_1_4);
        mImageButtons[0][4] = view.findViewById(R.id.button_1_5);

        mImageButtons[1][0] = view.findViewById(R.id.button_2_1);
        mImageButtons[1][1] = view.findViewById(R.id.button_2_2);
        mImageButtons[1][2] = view.findViewById(R.id.button_2_3);
        mImageButtons[1][3] = view.findViewById(R.id.button_2_4);
        mImageButtons[1][4] = view.findViewById(R.id.button_2_5);


        mImageButtons[2][0] = view.findViewById(R.id.button_3_1);
        mImageButtons[2][1] = view.findViewById(R.id.button_3_2);
        mImageButtons[2][2] = view.findViewById(R.id.button_3_3);
        mImageButtons[2][3] = view.findViewById(R.id.button_3_4);
        mImageButtons[2][4] = view.findViewById(R.id.button_3_5);


        mImageButtons[3][0] = view.findViewById(R.id.button_4_1);
        mImageButtons[3][1] = view.findViewById(R.id.button_4_2);
        mImageButtons[3][2] = view.findViewById(R.id.button_4_3);
        mImageButtons[3][3] = view.findViewById(R.id.button_4_4);
        mImageButtons[3][4] = view.findViewById(R.id.button_4_5);

        mImageButtons[4][0] = view.findViewById(R.id.button_5_1);
        mImageButtons[4][1] = view.findViewById(R.id.button_5_2);
        mImageButtons[4][2] = view.findViewById(R.id.button_5_3);
        mImageButtons[4][3] = view.findViewById(R.id.button_5_4);
        mImageButtons[4][4] = view.findViewById(R.id.button_5_5);
//endregion
        //region editext
        mTextViewPlayer1Name = view.findViewById(R.id.edittext_player1);
        mTextViewPlayer2Name = view.findViewById(R.id.edittext_player2);
        mTextViewPlayer1Point = view.findViewById(R.id.edittext_player1_point);
        mTextViewPlayer2Point = view.findViewById(R.id.edittext_player2_point);
        //endregion
    }

    private void setListners() {
        mImageButtons[0][0].setOnClickListener(this);
        mImageButtons[0][1].setOnClickListener(this);
        mImageButtons[0][2].setOnClickListener(this);
        mImageButtons[0][3].setOnClickListener(this);
        mImageButtons[0][4].setOnClickListener(this);


        mImageButtons[1][0].setOnClickListener(this);
        mImageButtons[1][1].setOnClickListener(this);
        mImageButtons[1][2].setOnClickListener(this);
        mImageButtons[1][3].setOnClickListener(this);
        mImageButtons[1][4].setOnClickListener(this);


        mImageButtons[2][0].setOnClickListener(this);
        mImageButtons[2][1].setOnClickListener(this);
        mImageButtons[2][2].setOnClickListener(this);
        mImageButtons[2][3].setOnClickListener(this);
        mImageButtons[2][4].setOnClickListener(this);


        mImageButtons[3][0].setOnClickListener(this);
        mImageButtons[3][1].setOnClickListener(this);
        mImageButtons[3][2].setOnClickListener(this);
        mImageButtons[3][3].setOnClickListener(this);
        mImageButtons[3][4].setOnClickListener(this);

        mImageButtons[4][0].setOnClickListener(this);
        mImageButtons[4][1].setOnClickListener(this);
        mImageButtons[4][2].setOnClickListener(this);
        mImageButtons[4][3].setOnClickListener(this);
        mImageButtons[4][4].setOnClickListener(this);
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

    private boolean isEnd() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 2; j++) {
                int count = 0;
                for (int k = j; k < j + 4; k++) {
                    count += mColors[i][k];
                }
                if (count == 4) {
                    mWindPlayer1 = true;
                    return true;
                }
                if (count == 400) {
                    mWindPlayer1 = false;
                    return true;
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 2; j++) {
                int count = 0;
                for (int k = j; k < j + 4; k++) {
                    count += mColors[k][i];
                }
                if (count == 4) {
                    mWindPlayer1 = true;
                    return true;
                }
                if (count == 400) {
                    mWindPlayer1 = false;
                    return true;
                }
            }
        }


        return false;
    }

    @Override
    public void onClick(View view) {
        ImageButton imageButton = (ImageButton) view;
        int i = ((int[]) imageButton.getTag())[0], j = ((int[]) imageButton.getTag())[1];
        if (mLastRow[j] >= 5) {
            return;
        }
        if (Player.getPlayer1().isActive()) {
            mImageButtons[mLastRow[j]][j].setImageResource(R.mipmap.red);
            mColors[mLastRow[j]][j] = 1;
            initSet(false, true);
        } else {
            mImageButtons[mLastRow[j]][j].setImageResource(R.mipmap.blue);
            mColors[mLastRow[j]][j] = 100;
            initSet(true, false);
        }
        mLastRow[j]++;
        if (isEnd()) {
            if (mWindPlayer1) {
                plusPlayer1();
                disableButton();
                Snackbar snackbar = Snackbar
                        .make(getView(), "Wind----> " + Player.getPlayer1().getName(), Snackbar.LENGTH_LONG);
                snackbar.show();

            } else {
                plusPlayer2();
                disableButton();
                Snackbar snackbar = Snackbar
                        .make(getView(), "Wind----> " + Player.getPlayer2().getName(), Snackbar.LENGTH_LONG);
                snackbar.show();

            }
        }
    }
}