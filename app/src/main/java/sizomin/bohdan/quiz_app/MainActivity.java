package sizomin.bohdan.quiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonStart = (Button) findViewById(R.id.buttonStart);


        //Return to main menu button - start
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                Intent intent = new Intent(MainActivity.this,GameLevels.class);
                startActivity(intent);
                //forward animation
                    overridePendingTransition(R.anim.slide_in_right,R.anim.slide_from_left);
                //

                finish();
                }
                catch (Exception e){

                }
            }//
        });
        //Return to main menu button - end



        Window w =getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);



    }
    //Quiting app on double tap feature - start
    @Override
    public void onBackPressed(){
            if (backPressedTime + 2000 > System.currentTimeMillis()){
                backToast.cancel();
                    super.onBackPressed();
                    return;
            }
            else{
                backToast=Toast.makeText(getBaseContext(),"Press one more time to quit",Toast.LENGTH_SHORT);
                backToast.show();
            }
backPressedTime= System.currentTimeMillis();

    }
    ////Quiting app on double tap feature - end
}