package com.example.tiktakto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int[][] win={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int[] game={0,0,0,0,0,0,0,0,0};
    //0 is empty,1 is red,2 is yellow;
    int token=1;
    int winner=0;
    int moves = 0;
    String message;
    int x ;



    public void Reload(View view) {

        token = 1;
        winner = 0;
        message = " over";
        Log.i("k", message);
        for (int m = 0; m < 9; m++) {
            game[m] = 0;
        }
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



    public void click(View view) {

        TextView textElement = (TextView) findViewById(R.id.textView);
        Button button = (Button) findViewById(R.id.button);


            moves = moves + 1;

            ImageView imageView = (ImageView) view;
            int i = Integer.parseInt(imageView.getTag().toString());

            if (game[i] == 0 && winner == 0) {
                game[i] = token;
                Log.i("h", "yes");

                imageView.setTranslationY(-800);

                for (int[] x : win) {
                    if (game[x[0]] == game[x[1]] && game[x[1]] == game[x[2]] && game[x[0]] != 0) {
                        winner = token;
                        if (winner == 1) {
                            message = "Red has won";


                        } else if (winner == 2) {
                            message = "Yellow has won";

                        }

                        textElement.setText(message);
                        textElement.setVisibility(view.VISIBLE);
                        button.setVisibility(view.VISIBLE);

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
        if(moves==9&&winner==0) {
            textElement.setText("Its a tie");
            textElement.setVisibility(view.VISIBLE);
            button.setVisibility(view.VISIBLE);
            moves=0;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textElement = (TextView) findViewById(R.id.textView);
        Button button = (Button) findViewById(R.id.button);

        button.setVisibility(View.INVISIBLE);
    }
}