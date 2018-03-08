package me.yamsafer.android_team.yamsafer_workshop.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;


import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;
import me.yamsafer.android_team.yamsafer_workshop.R;
import me.yamsafer.android_team.yamsafer_workshop.model.UserMessage;

/**
 * Created by islam on 3/8/18.
 */

public class MessageViewHolder extends RecyclerView.ViewHolder {

    private CircleImageView profileImage;

    private TextView messageTextView;

    private TextView senderTextView;

    public MessageViewHolder(View itemView) {

        super(itemView);

        profileImage = itemView.findViewById(R.id.profile_image);

        messageTextView = itemView.findViewById(R.id.message_text_view);

        senderTextView = itemView.findViewById(R.id.sender_text_view);
    }

    public void showMessage(UserMessage userMessage){

        if (userMessage == null)
            return;

        if (userMessage.getText() != null){
            messageTextView.setText(userMessage.getText());
        }

        if (userMessage.getName() != null){
            senderTextView.setText(userMessage.getName());
        }

        if (userMessage.getPhotoUrl() != null){
            Glide.with(itemView.getContext())
                    .load(userMessage.getPhotoUrl())
                    .into(profileImage);
        }

    }
}
