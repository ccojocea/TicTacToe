package com.example.ccojo.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int clickCounter = 0;
    int xo = -1;
    boolean gameOver = false;
    int[][] ticTacToe = new int[3][3];
    int winner = -1;

    Button topLeftButton, topCenterButton, topRightButton, leftCenterButton, centerButton,
        rightCenterButton, bottomLeftButton, bottomCenterButton, bottomRightButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        topLeftButton = findViewById(R.id.topLeftButton);
        topCenterButton = findViewById(R.id.topCenterButton);
        topRightButton = findViewById(R.id.topRightButton);
        leftCenterButton = findViewById(R.id.leftCenterButton);
        centerButton = findViewById(R.id.centerButton);
        rightCenterButton = findViewById(R.id.rightCenterButton);
        bottomLeftButton = findViewById(R.id.bottomLeftButton);
        bottomCenterButton = findViewById(R.id.bottomCenterButton);
        bottomRightButton = findViewById(R.id.bottomRightButton);

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                ticTacToe[i][j] = -1;
            }
        }
    }

    public void placeXO(View view){
        if (gameOver){
            Toast.makeText(this, "Game is over!", Toast.LENGTH_SHORT).show();
            return;
        }

        Button button = (Button) view;
        if (button.getText() != ""){
            Toast.makeText(this, "Choose another square!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (clickCounter % 2 == 0){
            button.setText("X");
            xo = 1;
        } else {
            button.setText("O");
            xo = 0;
        }

        int buttonId = 0;
        int clickedViewId = button.getId();
        switch (clickedViewId){
            case R.id.topLeftButton:
                ticTacToe[0][0] = xo;
                buttonId = 1;
                Log.i("Button click: ", "0 0");
                break;
            case R.id.topCenterButton:
                ticTacToe[1][0] = xo;
                buttonId = 2;
                Log.i("Button click: ", "1 0");
                break;
            case R.id.topRightButton:
                ticTacToe[2][0] = xo;
                buttonId = 3;
                Log.i("Button click: ", "2 0");
                break;
            case R.id.leftCenterButton:
                ticTacToe[0][1] = xo;
                buttonId = 4;
                Log.i("Button click: ", "0 1");
                break;
            case R.id.centerButton:
                ticTacToe[1][1] = xo;
                buttonId = 5;
                Log.i("Button click: ", "1 1");
                break;
            case R.id.rightCenterButton:
                ticTacToe[2][1] = xo;
                buttonId = 6;
                Log.i("Button click: ", "2 1");
                break;
            case R.id.bottomLeftButton:
                ticTacToe[0][2] = xo;
                buttonId = 7;
                Log.i("Button click: ", "0 2");
                break;
            case R.id.bottomCenterButton:
                ticTacToe[1][2] = xo;
                buttonId = 8;
                Log.i("Button click: ", "1 2");
                break;
            case R.id.bottomRightButton:
                ticTacToe[2][2] = xo;
                buttonId = 9;
                Log.i("Button click: ", "2 2");
                break;
        }

        if(gameOver(buttonId)){
            gameOver = true;
            switch (xo){
                case 1:
                    Toast.makeText(this, "Game Over! Player X wins!", Toast.LENGTH_SHORT).show();
                    return;
                case 0:
                    Toast.makeText(this, "Game Over! Player 0 wins!", Toast.LENGTH_SHORT).show();
                    return;
            }
        }

        if(++clickCounter == 9){
            gameOver = true;
            Toast.makeText(this, "Game Over! No winner!", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean gameOver(int buttonId){
        switch (buttonId){
            case 1:
                if(ticTacToe[0][0] == ticTacToe[0][1] && ticTacToe[0][0] == ticTacToe[0][2]){
                    winner = ticTacToe[0][0];
                    return true;
                }
                if(ticTacToe[0][0] == ticTacToe[1][0] && ticTacToe[0][0] == ticTacToe[2][0]){
                    winner = ticTacToe[0][0];
                    return true;
                }
                if(ticTacToe[0][0] == ticTacToe[1][1] && ticTacToe[0][0] == ticTacToe[2][2]){
                    winner = ticTacToe[0][0];
                    return true;
                }
                break;
            case 2:
                if(ticTacToe[1][0] == ticTacToe[0][0] && ticTacToe[1][0] == ticTacToe[2][0]){
                    winner = ticTacToe[0][0];
                    return true;
                }
                if(ticTacToe[1][0] == ticTacToe[1][1] && ticTacToe[1][0] == ticTacToe[1][2]){
                    winner = ticTacToe[0][0];
                    return true;
                }
                break;
            case 3:
                if(ticTacToe[2][0] == ticTacToe[0][0] && ticTacToe[2][0] == ticTacToe[1][0]){
                    winner = ticTacToe[0][0];
                    return true;
                }
                if(ticTacToe[2][0] == ticTacToe[1][1] && ticTacToe[2][0] == ticTacToe[0][2]){
                    winner = ticTacToe[0][0];
                    return true;
                }
                if(ticTacToe[2][0] == ticTacToe[2][1] && ticTacToe[2][0] == ticTacToe[2][2]){
                    winner = ticTacToe[0][0];
                    return true;
                }
                break;
            case 4:
                if(ticTacToe[0][1] == ticTacToe[0][0] && ticTacToe[0][1] == ticTacToe[0][2]){
                    winner = ticTacToe[0][0];
                    return true;
                }
                if(ticTacToe[0][1] == ticTacToe[1][1] && ticTacToe[0][1] == ticTacToe[2][1]){
                    winner = ticTacToe[0][0];
                    return true;
                }
                break;
            case 5:
                if(ticTacToe[1][1] == ticTacToe[0][0] && ticTacToe[1][1] == ticTacToe[2][2]){
                    winner = ticTacToe[0][0];
                    return true;
                }
                if(ticTacToe[1][1] == ticTacToe[2][0] && ticTacToe[1][1] == ticTacToe[0][2]){
                    winner = ticTacToe[0][0];
                    return true;
                }
                if(ticTacToe[1][1] == ticTacToe[1][0] && ticTacToe[1][1] == ticTacToe[1][2]){
                    winner = ticTacToe[0][0];
                    return true;
                }
                if(ticTacToe[1][1] == ticTacToe[0][1] && ticTacToe[1][1] == ticTacToe[2][1]){
                    winner = ticTacToe[0][0];
                    return true;
                }
                break;
            case 6:
                if(ticTacToe[2][1] == ticTacToe[2][0] && ticTacToe[2][1] == ticTacToe[2][2]){
                    winner = ticTacToe[0][0];
                    return true;
                }
                if(ticTacToe[2][1] == ticTacToe[0][1] && ticTacToe[2][1] == ticTacToe[1][1]){
                    winner = ticTacToe[0][0];
                    return true;
                }
                break;
            case 7:
                if(ticTacToe[0][2] == ticTacToe[1][2] && ticTacToe[0][2] == ticTacToe[2][2]){
                    winner = ticTacToe[0][0];
                    return true;
                }
                if(ticTacToe[0][2] == ticTacToe[1][1] && ticTacToe[0][2] == ticTacToe[2][0]){
                    winner = ticTacToe[0][0];
                    return true;
                }
                if(ticTacToe[0][2] == ticTacToe[0][0] && ticTacToe[0][2] == ticTacToe[0][1]){
                    winner = ticTacToe[0][0];
                    return true;
                }
                break;
            case 8:
                if(ticTacToe[1][2] == ticTacToe[0][2] && ticTacToe[1][2] == ticTacToe[2][2]){
                    winner = ticTacToe[0][0];
                    return true;
                }
                if(ticTacToe[1][2] == ticTacToe[1][1] && ticTacToe[1][2] == ticTacToe[1][0]){
                    winner = ticTacToe[0][0];
                    return true;
                }
                break;
            case 9:
                if(ticTacToe[2][2] == ticTacToe[1][2] && ticTacToe[2][2] == ticTacToe[0][2]){
                    winner = ticTacToe[0][0];
                    return true;
                }
                if(ticTacToe[2][2] == ticTacToe[1][1] && ticTacToe[2][2] == ticTacToe[0][0]){
                    winner = ticTacToe[0][0];
                    return true;
                }
                if(ticTacToe[2][2] == ticTacToe[2][1] && ticTacToe[2][2] == ticTacToe[2][0]){
                    winner = ticTacToe[0][0];
                    return true;
                }
                break;
        }
        return false;
    }

    public void restartGame(View view){
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }
}
