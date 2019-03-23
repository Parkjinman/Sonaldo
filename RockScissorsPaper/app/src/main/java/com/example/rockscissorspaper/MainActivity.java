package com.example.rockscissorspaper;

import java.util.*;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    ImageView user;
    ImageView computer;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.PlayUserView);
        computer = findViewById(R.id.ComView);
        result = findViewById(R.id.ResultText);

        Button RockButton = findViewById(R.id.RockButton);
        Button ScissorsButton = findViewById(R.id.ScissorsButton);
        Button PaperButton = findViewById(R.id.PaperButton);

        RockButton.setOnClickListener(this);
        ScissorsButton.setOnClickListener(this);
        PaperButton.setOnClickListener(this);

        /* 툴바는 화면상 위에 구분선있는 직사각형 */
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            /* 화면 아래 메세지 모양의 아이콘 */
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClick(View v) {
        int userNum = 1;
        int comNum;
        String ResultText;

        /**/
        String Lost, Win, Draw;

        Lost = "Computer Win!";
        Win = "Play User Win!";
        Draw = "Draw in a game";

        /* 컴퓨터 랜덤 가위바위보 */
        Random random = new Random();
        comNum = random.nextInt(3);

        /* 사용자 가위바위보 선택 */
        switch (v.getId()) {
            case R.id.RockButton:
                userNum = 0;
                break;
            case R.id.ScissorsButton:
                userNum = 1;
                break;
            case R.id.PaperButton:
                userNum = 2;
                break;
        }

        /*컴퓨터랑 사람의 승패 결정*/
        if(userNum == 0 && comNum == 1) {
            ResultText = Win;
        } else if(userNum == 1 && comNum == 2) {
            ResultText = Win;
        } else if(userNum == 2 && comNum == 0) {
            ResultText = Win;
        } else if(userNum == comNum) {
            ResultText = Draw;
        } else {
            ResultText = Lost;
        }
        result.setText(ResultText);

        /* 화면에 표시 */
        int userImage = getGBBImage(userNum);
        user.setImageResource(userImage);
        int comImage = getGBBImage(comNum);
        computer.setImageResource(comImage);
    }
    /* 이미지 리턴 함수*/
    private int getGBBImage(int x) {
        if (x==1) {
            return R.drawable.scissors;
        } else if(x==0) {
            return R.drawable.rock;
        } else {
            return R.drawable.paper;
        }
    }
}