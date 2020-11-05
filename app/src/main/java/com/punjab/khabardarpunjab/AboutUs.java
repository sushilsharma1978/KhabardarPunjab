package com.punjab.khabardarpunjab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class AboutUs extends AppCompatActivity {
TextView tv_about;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
       /* tv_about=findViewById(R.id.tv_about);
        tv_about.setClickable(true);
        tv_about.setMovementMethod(LinkMovementMethod.getInstance());
        String text = "<a href='https://www.1984yesitisgenocide.org'> www.1984yesitisgenocide.org </a>";
        tv_about.setText(Html.fromHtml(text));*/
    }
}
