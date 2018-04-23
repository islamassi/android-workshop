package me.yamsafer.android_team.yamsafer_workshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private final String senderName = "YOUR-NAME";

    private final String photoUrl = "https://www.google.ps/search?q=android+oreo+logo&source=lnms&tbm=isch&sa=X&ved=0ahUKEwjNjrXomNDaAhVLEJoKHai0CtgQ_AUICigB&biw=1280&bih=659#imgrc=dHViqmhNgLv_KM:";

    RecyclerView messagesRecycler;

    private DatabaseReference mFirebaseDatabase;

    private MessagesAdapter messagesAdapter = new MessagesAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messagesRecycler = findViewById(R.id.list_of_messages);

        messagesRecycler.setLayoutManager(new LinearLayoutManager(this));

        messagesRecycler.setAdapter(messagesAdapter);

        mFirebaseDatabase = FirebaseDatabase.getInstance().getReference();

        mFirebaseDatabase.child("messages").addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                UserMessage userMessage = dataSnapshot.getValue(UserMessage.class);

                messagesAdapter.addUserMessage(userMessage);

            }


            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }


            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }


            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
