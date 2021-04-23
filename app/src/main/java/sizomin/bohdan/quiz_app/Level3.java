package sizomin.bohdan.quiz_app;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Level3 extends AppCompatActivity{

    Dialog dialog;
    Dialog dialogEnd;
    public int count = 0;




    public int num_left;
    public int num_right;
    Array array = new Array();
    Random random = new Random();


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        try{
            Intent intent = new Intent (Level3.this,GameLevels.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_left,R.anim.slide_from_right);
            finish();
        }
        catch (Exception e){

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);


        TextView text_levels = findViewById(R.id.text_levels);
        text_levels.setText(R.string.level3);






        final ImageView img_left = (ImageView) findViewById(R.id.img_left);
        final ImageView img_right = (ImageView) findViewById(R.id.img_right);


        //Setting rounded corners - start
        img_left.setClipToOutline(true);
        final TextView text_left = findViewById(R.id.text_left);
        final TextView text_right = findViewById(R.id.text_right);




        img_right.setClipToOutline(true);
        //Setting rounded corners - end


        //Full screen mode - start
        Window w =getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        //Full screen mode - end

    //Creating dialog window
    dialog = new Dialog(this);
    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
    dialog.setContentView(R.layout.previewdialog_level2);
    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); //transparent dialog window background
    dialog.setCancelable(false);


    TextView textdescription = (TextView)dialog.findViewById(R.id.textdescription_lvl2);
    textdescription.setText(R.string.level_three);





    //close dialog window button

        TextView btnclose = (TextView) dialog.findViewById(R.id.btnclose);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent i = new Intent(Level3.this,GameLevels.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.slide_in_left,R.anim.slide_from_right);
                    finish();
                }
                catch (Exception e){

                }
                dialog.dismiss();

                    }
                });

        Button btncontinue = (Button)dialog.findViewById(R.id.btncontinue);
        btncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });


    dialog.show();


        //_______________________________________________

        dialogEnd = new Dialog(this);
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogEnd.setContentView(R.layout.dialogend);
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogEnd.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT
        );//transparent dialog window background
        dialogEnd.setCancelable(false);


        TextView textdescriptionEnd = (TextView)dialogEnd.findViewById(R.id.textdescriptionend);
        textdescriptionEnd.setText(R.string.levelthreeEnd);

//      Interesting fact - end



        //close dialog window button

        TextView btnclose2 = (TextView)dialogEnd.findViewById(R.id.btnclose);
        btnclose2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent i = new Intent(Level3.this,GameLevels.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.slide_in_left,R.anim.slide_from_right);
                    finish();
                }
                catch (Exception e){

                }
                dialogEnd.dismiss();

            }
        });

        Button btncontinue2 = (Button)dialogEnd.findViewById(R.id.btncontinue);
        btncontinue2.setText("Finish Trial");
        btncontinue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{
                    Intent i = new Intent(Level3.this,GameLevels.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.slide_in_right,R.anim.slide_from_left);
                    finish();
                }
                catch(Exception e ){

                }
                dialogEnd.dismiss();
            }
        });


        //________________________________________________
    //
        Button btn_back = (Button)findViewById(R.id.buttonBack);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                Intent intent = new Intent (Level3.this,GameLevels.class);
                startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_left,R.anim.slide_from_right);
                finish();
                }
                catch (Exception e){

                }
            }
        });


        //progress bar
        final int[] progress={
                R.id.point1, R.id.point2,R.id.point3, R.id.point4, R.id.point5,
                R.id.point6, R.id.point7, R.id.point8, R.id.point9, R.id.point10
        };
        //


        final Animation a = AnimationUtils.loadAnimation(Level3.this,R.anim.alpha);






num_left = random.nextInt(10);
img_left.setImageResource(array.images2[num_left]);
text_left.setText(array.texts2[num_left]);



num_right= random.nextInt(10);
while (num_left==num_right){
    num_right = random.nextInt(10);
}
img_right.setImageResource(array.images2[num_right]);
text_right.setText(array.texts2[num_right]);





        //Left picture logic
        img_left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {

                if (event.getAction()==MotionEvent.ACTION_DOWN){
                    //on touch function
                    img_right.setEnabled(false);

                    if (num_left>num_right){
                        img_left.setImageResource(R.drawable.correct);
                    }
                    else {
                        img_left.setImageResource(R.drawable.wrong);
                    }
                }
                else if (event.getAction()==MotionEvent.ACTION_UP) {
                    //on release
                    if (num_left>num_right){
                        if(count<10){
                            count=count+1;
                        }
                        //Painting progress bar
                        for (int i=0;i<10;i++){
                            TextView tv=findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        for (int i=0;i<count;i++){
                            TextView tv=findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }


                    }

                    else{
                    //Wrong answer
                        if (count>0){
                            if(count==1){
                                count=0;
                            }
                            else{count=count-2;
                            }
                        }

                        for (int i=0;i<9;i++){
                            TextView tv=findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        for (int i=0;i<count;i++){
                            TextView tv=findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }





                    }

                    if (count==10){
                        dialogEnd.show();
                    }
                    else{
                        num_left = random.nextInt(10);
                        img_left.setImageResource(array.images2[num_left]);
                        img_left.startAnimation(a);
                        text_left.setText(array.texts2[num_left]);



                        num_right= random.nextInt(10);
                        while (num_left==num_right){
                            num_right = random.nextInt(10);
                        }
                        img_right.setImageResource(array.images2[num_right]);
                        img_right.startAnimation(a);
                        text_right.setText(array.texts2[num_right]);


                        img_right.setEnabled(true);
                    }

                }
                //


                return true;
            }
        });

        //Right picture logic
        img_right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {

                if (event.getAction()==MotionEvent.ACTION_DOWN){
                    //on touch function
                    img_left.setEnabled(false);

                    if (num_left<num_right){
                        img_right.setImageResource(R.drawable.correct);
                    }
                    else {
                        img_right.setImageResource(R.drawable.wrong);
                    }
                }
                else if (event.getAction()==MotionEvent.ACTION_UP) {
                    //on release
                    if (num_left<num_right){
                        if(count<10){
                            count=count+1;
                        }
                        //Painting progress bar
                        for (int i=0;i<10;i++){
                            TextView tv=findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        for (int i=0;i<count;i++){
                            TextView tv=findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }


                    }

                    else{
                        //Wrong answer
                        if (count>0){
                            if(count==1){
                                count=0;
                            }
                            else{count=count-2;
                            }
                        }

                        for (int i=0;i<9;i++){
                            TextView tv=findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        for (int i=0;i<count;i++){
                            TextView tv=findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }





                    }

                    if (count==10){
                        dialogEnd.show();
                    }
                    else{
                        num_right = random.nextInt(10);
                        img_right.setImageResource(array.images2[num_right]);
                        img_right.startAnimation(a);
                        text_right.setText(array.texts2[num_right]);



                        num_left= random.nextInt(10);
                        while (num_left==num_right){
                            num_left = random.nextInt(10);
                        }
                        img_left.setImageResource(array.images2[num_left]);
                        img_left.startAnimation(a);
                        text_left.setText(array.texts2[num_left]);


                        img_left.setEnabled(true);
                    }

                }
                //


                return true;
            }
        });




    }



}