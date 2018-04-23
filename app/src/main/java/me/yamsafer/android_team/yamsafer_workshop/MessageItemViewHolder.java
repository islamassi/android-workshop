package me.yamsafer.android_team.yamsafer_workshop;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by islam on 3/10/18.
 */

public class MessageItemViewHolder extends RecyclerView.ViewHolder {

    CircleImageView avatarImage;

    TextView name;

    TextView message;

    public MessageItemViewHolder(View itemView) {

        super(itemView);

        avatarImage = itemView.findViewById(R.id.avatar_image);

        name = itemView.findViewById(R.id.name);

        message = itemView.findViewById(R.id.message);
    }

    public void bind(UserMessage userMessage) {

        Glide.with(itemView.getContext()).load(userMessage.getImageUrl()).into(avatarImage);

        name.setText(userMessage.getSender());

        message.setText(userMessage.getMessage());

    }
}
