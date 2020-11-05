package com.punjab.khabardarpunjab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class ContactUs extends AppCompatActivity {
TextView tv_contact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
tv_contact=findViewById(R.id.tv_contact);

        tv_contact.setClickable(true);
        tv_contact.setMovementMethod(LinkMovementMethod.getInstance());
        String text = "<a href='https://www.referendum2020.org/'>  www.referendum2020.org </a>";
        tv_contact.setText(Html.fromHtml(text));


    }
}
