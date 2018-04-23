package me.yamsafer.android_team.yamsafer_workshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private final String senderName = "YOUR-NAME";

    private final String photoUrl = "https://www.google.ps/search?q=android+oreo+logo&source=lnms&tbm=isch&sa=X&ved=0ahUKEwjNjrXomNDaAhVLEJoKHai0CtgQ_AUICigB&biw=1280&bih=659#imgrc=dHViqmhNgLv_KM:";

    RecyclerView messagesRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messagesRecycler = findViewById(R.id.list_of_messages);

        messagesRecycler.setLayoutManager(new LinearLayoutManager(this));

        messagesRecycler.setAdapter(new MessagesAdapter());
    }
}
