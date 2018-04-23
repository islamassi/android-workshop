package me.yamsafer.android_team.yamsafer_workshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private final String senderName = "Islam Assi";

    private final String photoUrl = "https://cdn-images-1.medium.com/max/324/1*XwETOHbx50_CT4tRbbBdog.png";

    RecyclerView messagesRecycler;

    private DatabaseReference mFirebaseDatabase;

    private MessagesAdapter messagesAdapter = new MessagesAdapter();

    private Button sendButton;

    EditText messageEditText;

    private static final String MESSAGES = "messages";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messagesRecycler = findViewById(R.id.list_of_messages);

        messagesRecycler.setLayoutManager(new LinearLayoutManager(this));

        messagesRecycler.setAdapter(messagesAdapter);

        mFirebaseDatabase = FirebaseDatabase.getInstance().getReference();

        mFirebaseDatabase.child(MESSAGES).addChildEventListener(new ChildEventListener() {

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

        sendButton = findViewById(R.id.button);

        messageEditText = findViewById(R.id.message_edit_text);

        sendButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                UserMessage userMessage = new UserMessage(photoUrl, senderName, messageEditText.getText().toString());

                mFirebaseDatabase.child(MESSAGES).push().setValue(userMessage);

                messageEditText.setText("");
            }
        });
    }
}
