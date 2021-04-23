package sizomin.bohdan.quiz_app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class GameLevels extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamelevels);

        SharedPreferences save = getSharedPreferences("Save",MODE_PRIVATE);

//      Wiping saves
//      save.edit().clear().commit();



        final int level=save.getInt("Level",1);




        Button button_back = (Button) findViewById(R.id.button_back);

        TextView textView1 = (TextView) findViewById(R.id.textView1);



        //Move to 1st level - start
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (level >=1) {
                        Intent intent = new Intent(GameLevels.this, Level1.class);
                        startActivity(intent);
                        // Forward animation
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_from_left);
                        //

                        finish();
                    }

                    else {
                        //
                    }


                }
                catch(Exception e){

                }
            }
        });
        //Move to 1st level - end

        //Move to 2nd level - start
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        //Move to 1st level - start
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (level>=2) {
                        Intent intent = new Intent(GameLevels.this, Level2.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_from_left);


                        finish();
                    }
                }
                catch(Exception e){

                }
            }
        });
        //Move to 2nd level - end


//        Move to 3rd level - start
        TextView textView3 = (TextView) findViewById(R.id.textView3);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (level >= 3) {
                        Intent intent = new Intent(GameLevels.this, Level3.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_from_left);
                        finish();
                    }
                }
                catch(Exception e){

                }
            }
        });
//        Move to 3rd level - end

            final int[] x={
                    R.id.textView1,
                    R.id.textView2,
                    R.id.textView3
            };

            for (int i=1;i<level;i++){
                TextView tv = findViewById(x[i]);
                tv.setText(""+ (i+1));
            }










        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(GameLevels.this,MainActivity.class);
                    startActivity(intent);
                    //backward animation
                    overridePendingTransition(R.anim.slide_in_left,R.anim.slide_from_right);
                    //
                    finish();
                }
                catch (Exception e){

                }//
            }
        });
        Window w =getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }

    @Override
    public void onBackPressed(){
        try {
            Intent intent = new Intent(GameLevels.this,MainActivity.class);
            startActivity(intent);
            //backward animation
            overridePendingTransition(R.anim.slide_in_left,R.anim.slide_from_right);
            //
            finish();
        }
        catch (Exception e){

        }//




    }

}