package com.wecantyo.app.sample_intent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.wecantyo.app.sample_intent.R.id.text_intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnSub1 = (Button) findViewById(R.id.button_activity_sub_1);
        Button btnSub2 = (Button) findViewById(R.id.button_activity_sub_2);
        Button btnDial = (Button)findViewById(R.id.button_activity_dial);

        final EditText inpIntent = (EditText) findViewById(R.id.text_intent);


        btnSub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Sub1Activity.class);
                startActivity(intent);
            }
        });

        btnSub2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strIntent = inpIntent.getText().toString();

                if (TextUtils.isEmpty(strIntent)) {
                    inpIntent.setError("Data untuk dikirim tidak boleh kosong !!!");
                    inpIntent.setFocusable(true);
                    return;
                }

                Intent intent = new Intent(MainActivity.this, Sub2Activity.class);
                intent.putExtra(Sub2Activity.KEY_DATA, strIntent);
                startActivityForResult(intent, 0);
            }
        });

        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:085815973015"));
                startActivity(intent);
            }
        });
    }
}
