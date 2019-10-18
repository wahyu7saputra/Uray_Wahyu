package com.example.fluxy.uray_wahyu;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    private static Button btn_syntax;
    private Context mContext;
    public String[] url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Initialize the views.
        TextView sportsTitle = findViewById(R.id.titleDetail);
        ImageView sportsImage = findViewById(R.id.sportsImageDetail);
        TextView compDetailt = findViewById(R.id.subTitleDetail);
        String[] compDetails = getResources().getStringArray(R.array.component_details);

        // Set the text from the Intent extra.
        sportsTitle.setText(getIntent().getStringExtra("title"));
        compDetailt.setText(compDetails[getIntent().getIntExtra("pos",0)]);

        // Load the image using the Glide library and the Intent extra.
        Glide.with(this).load(getIntent().getIntExtra("image_resource",0))
                .into(sportsImage);
    }

    public void launchSyntaxActivity(View view) {
        Intent intent = new Intent(this, SyntaxActivity.class);
        intent.putExtra("pos", getIntent().getIntExtra("pos",0));
        startActivity(intent);
    }

    public void openWebsite(View view) {
        url = getResources().getStringArray(R.array.url);
        String urls = url[getIntent().getIntExtra("pos",0)];
        Uri webpage = Uri.parse(urls);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this!");
        }
    }

}