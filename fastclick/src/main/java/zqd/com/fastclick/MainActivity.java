package zqd.com.fastclick;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (FastClickUtils.isClickValidate()) {
                    startActivity(new Intent(MainActivity.this, SecondActivity.class));
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (FastClickUtils.isDoubleClickOut()) {
            finish();
        } else {
            Toast.makeText(this, "再按一次返回退出", Toast.LENGTH_SHORT).show();
        }
    }
}
