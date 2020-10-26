package com.example.vihz.theplane;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class ThePlane extends AppCompatActivity {
    private boolean isMute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_the_plane);

        findViewById(R.id.play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ThePlane.this, GameActivity.class));
            }
        });

        TextView highScoreTxt=findViewById(R.id.highScoreTxt);
        final SharedPreferences prefs=getSharedPreferences("game",MODE_PRIVATE);
        highScoreTxt.setText("HighScore : "+prefs.getInt("highscore",0));

        isMute=prefs.getBoolean("isMute",false);
        final ImageView VolumeCtr1 =findViewById(R.id.volumeCtrl);
        if (isMute)
            VolumeCtr1.setImageResource(R.drawable.ic_volume_off_black_24dp);
        else
            VolumeCtr1.setImageResource(R.drawable.ic_volume_up_black_24dp);



        VolumeCtr1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                isMute = !isMute;
                if (isMute)
                    VolumeCtr1.setImageResource(R.drawable.ic_volume_off_black_24dp);
                else
                    VolumeCtr1.setImageResource(R.drawable.ic_volume_up_black_24dp);

                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean("isMute", isMute);
                editor.apply();

            }
        });
    }
}
