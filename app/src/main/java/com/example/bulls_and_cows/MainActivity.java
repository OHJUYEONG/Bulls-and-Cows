package com.example.bulls_and_cows;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
//맨 처음 시작시 보이는 화면 관련한 class 파일입니다.
MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //oncreate함수는 이 java 파일이 시작되고 바로 실행되는 함수입니다.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = MediaPlayer.create(this, R.raw.bgm_main_theme);
        //mediaPlayer.setLooping(true); //무한재생
        mediaPlayer.start();

        //해당하는 activity를 불러옵니다.

        //main activity에 있던 버튼을 불러오기 위해 선언

        Button start = (Button)findViewById(R.id.enterStart);
        Button explain = (Button) findViewById(R.id.enterExplain);
        Button info = (Button) findViewById(R.id.enterInfo);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
                //[사운드]버튼 클릭
                //MySoundPlayer.play(MySoundPlayer.BUTTON_SOUND);
                //GameActivity 불러옵니다.
                Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                startActivity(intent);
                finish();

            }
        });


        // 게임 설명 클릭
        explain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //[사운드]버튼 클릭
                //MySoundPlayer.play(MySoundPlayer.BUTTON_SOUND);
                makeDialog("게임 설명",
                        "숨겨진 숫자를 알아내보세요!\n");
                //[텍스트수정]해당 다이어로그 타이틀, 텍스트 수정필요
            }
        });

        // 개발자 소개 클릭
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //[사운드]버튼 클릭
                //MySoundPlayer.play(MySoundPlayer.BUTTON_SOUND);
                makeDialog("개발자 소개",
                                "이다은\n" +
                                "오주영\n" +
                                "염동원");
                //[텍스트수정]해당 다이어로그 타이틀, 텍스트 수정필요
            }
        });
    }

    // 다이어로그 커스텀하는 함수입니다.
    public void makeDialog (String title, String text) {
        // 커스텀 다이얼로그를 정의하기위해 Dialog클래스를 생성한다.
        Dialog dialog = new Dialog(this);

        // 액티비티의 타이틀바를 숨긴다.
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        // 커스텀 다이얼로그의 레이아웃을 설정한다.
        dialog.setContentView(R.layout.custom_dialog_game_description);

        // 커스텀 다이얼로그를 노출한다.
        dialog.show();

        // 커스텀 다이얼로그의 각 위젯들을 정의한다.
        TextView hintTitle = (TextView) dialog.findViewById(R.id.hintTitle);
        TextView hintText = (TextView) dialog.findViewById(R.id.hintText);
        TextView hintOk = (TextView) dialog.findViewById(R.id.hintOk);

        hintTitle.setText(title);
        hintText.setText(text);
        hintOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }

}