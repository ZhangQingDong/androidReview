package zqd.com.review;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_start;
    private Button bt_pause;
    Intent intent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        intent = new Intent(this, MusicService.class);
        bt_start = findViewById(R.id.bt_start);
        bt_pause = findViewById(R.id.bt_pause);
        bt_pause.setOnClickListener(this);
        bt_start.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_start:
                startService(intent);
                break;
            case R.id.bt_pause:
                stopService(intent);
                break;
            default:
                break;
        }
    }
}
