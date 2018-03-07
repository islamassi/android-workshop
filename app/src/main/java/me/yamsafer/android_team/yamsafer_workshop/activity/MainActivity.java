package me.yamsafer.android_team.yamsafer_workshop.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import me.yamsafer.android_team.yamsafer_workshop.R;
import me.yamsafer.android_team.yamsafer_workshop.model.UserMessage;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth;

    private FirebaseUser mFirebaseUser;

    private Button sendButton;

    private EditText messageEditText;

    private DatabaseReference mFirebaseDatabaseReference;

    private static final String MESSAGES_CHILD = "messages";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseAuth = FirebaseAuth.getInstance();

        mFirebaseUser = mFirebaseAuth.getCurrentUser();

        mFirebaseDatabaseReference = FirebaseDatabase.getInstance().getReference();

        // Not signed in
        if (mFirebaseUser == null){

            Intent intent = new Intent(this, SignInActivity.class);

            startActivity(intent);

            finish();

            return;

        }

        sendButton = findViewById(R.id.send_button_id);

        messageEditText = findViewById(R.id.message_id);

        sendButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (messageEditText.getText() == null || messageEditText.getText().toString().isEmpty())
                    return;

                String photoUrl = null;

                if (mFirebaseUser.getPhotoUrl() != null){

                    photoUrl = mFirebaseUser.getPhotoUrl().toString();

                }

                UserMessage userMessage = new UserMessage(messageEditText.getText().toString(), mFirebaseUser.getDisplayName(), photoUrl);

                mFirebaseDatabaseReference.child(MESSAGES_CHILD).push().setValue(userMessage);
            }
        });
    }
}
