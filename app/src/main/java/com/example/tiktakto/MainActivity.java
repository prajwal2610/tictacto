package com.example.tiktakto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static android.view.View.VISIBLE;

public class MainActivity extends AppCompatActivity {

    int[][] win={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int[] game={0,0,0,0,0,0,0,0,0};
    int[]positions={0,0,0,0,0,0,0,0,0};
    //0 is empty,1 is red,2 is yellow;
    int token=1;
    int winner=0;
    int moves=0;
    String message;
    boolean gameover=false;
    TextView textElement;
    Button button;



    public void Reload(View view) {

        token = 1;
        winner = 0;
        message = " over";
         moves=0;
         for(int i=0;i<9;i++){
            positions[i]=0;
        }
        gameover=false;
        Log.i("k", message);
        for (int m = 0; m < 9; m++) {
            game[m] = 0;
        }
        message="";
        TextView textElement = (TextView) findViewById(R.id.textView);
        Button button = (Button) findViewById(R.id.button);
        textElement.setVisibility(view.INVISIBLE);
        button.setVisibility(view.INVISIBLE);

        GridLayout myGridView = (GridLayout) findViewById(R.id.gridLayout1);

        for (int i = 0; i < myGridView.getChildCount(); i++) {
            ImageView counter = (ImageView) myGridView.getChildAt(i);
            counter.setImageDrawable(null);
        }
    }

public void check() {

    if (moves == 9 && winner == 0) {
        message = "Its a draw";
        textElement.setText(message);
        textElement.setVisibility(VISIBLE);
        button.setVisibility(VISIBLE);
        moves = 0;
        gameover=true;
    }else {

    }
}

    public void click(View view) {

        if (gameover == false) {



            String mlm = String.valueOf(moves);

            Log.i("moves",mlm);

            ImageView imageView = (ImageView) view;
            int i = Integer.parseInt(imageView.getTag().toString());

            if (game[i] == 0 && winner == 0) {
                if(positions[i]==0){
                    positions[i]=1;
                    moves = moves + 1;

                }else {}

                check();
                game[i] = token;


                imageView.setTranslationY(-800);

                for (int[] x : win) {
                    if (game[x[0]] == game[x[1]] && game[x[1]] == game[x[2]] && game[x[0]] != 0) {
                        winner = token;
                        if (winner == 1) {
                            message = "Red has won";
                            winner = 0;

                        } else if (winner == 2) {
                            message = "Yellow has won";
                            winner = 0;
                        }
                        textElement.setText(message);
                        textElement.setVisibility(VISIBLE);
                        button.setVisibility(VISIBLE);
                        gameover=true;
                    }
                }
                if (token == 1) {
                    token = 2;
                    imageView.setImageResource(R.drawable.red);
                    imageView.animate().translationY(0).rotation(720).setDuration(500);
                } else if (token == 2) {
                    token = 1;
                    imageView.setImageResource(R.drawable.yellow);
                    imageView.animate().translationY(0).rotation(720).setDuration(500);
                }
            }
        }else {
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textElement = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);
        button.setVisibility(View.INVISIBLE);

    }
}