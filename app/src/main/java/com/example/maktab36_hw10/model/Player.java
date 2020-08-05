package com.example.maktab36_hw10.model;

import android.widget.ImageButton;

public class Player {
    private String mName;
    private int mPoint;
    private boolean mActive;
    private static Player sPlayer1;
    private static Player sPlayer2;
    private static boolean isCreated = false;
    public static ImageButton[][] mImageButtons;

    private Player(String name, int point, boolean active) {

        mName = name;
        mPoint = point;
        mActive = active;

    }

    public static void run() {
        if (isCreated == false) {
            sPlayer1 = new Player("Player 1   ", 0, true);
            sPlayer2 = new Player("Player 2   ", 0, false);
            isCreated = true;
        }
    }

    public static Player getPlayer1() {
        return sPlayer1;
    }

    public static Player getPlayer2() {
        return sPlayer2;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getPoint() {
        return mPoint;
    }

    public void setPoint(int point) {
        mPoint = point;
    }

    public boolean isActive() {
        return mActive;
    }

    public void setActive(boolean active) {
        mActive = active;
    }

    //    public String getName1() {
//        return mPlayer1.mName;
//    }
//
//    public void setName1(String name) {
//        mPlayer1.mName = name;
//    }
//
//
//    public String getName2() {
//        return mPlayer2.mName;
//    }
//
//    public void setName2(String name) {
//        mPlayer2.mName = name;
//    }
//
//
//    public int getPoint1() {
//        return mPlayer1.mPoint;
//    }
//
//    public void setPoint1(int point) {
//        mPlayer1.mPoint = point;
//    }
//
//
//    public int getPoint2() {
//        return mPlayer2.mPoint;
//    }
//
//    public void setPoint2(int point) {
//        mPlayer2.mPoint = point;
//    }
//
//    public boolean isActive1() {
//        return mPlayer1.mActive;
//    }
//
//    public void setActive1(boolean active) {
//        mPlayer1.mActive = active;
//    }
//
//    public boolean isActive2() {
//        return mPlayer2.mActive;
//    }
//
//    public void setActive2(boolean active) {
//        mPlayer2.mActive = active;
//    }

}
