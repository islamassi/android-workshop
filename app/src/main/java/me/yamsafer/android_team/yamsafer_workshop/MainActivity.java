package me.yamsafer.android_team.yamsafer_workshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private final String senderName = "YOUR-NAME";

    private final String photoUrl = "https://cdn-images-1.medium.com/max/324/1*XwETOHbx50_CT4tRbbBdog.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
