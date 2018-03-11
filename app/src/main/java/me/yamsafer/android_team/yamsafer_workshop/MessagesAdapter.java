package me.yamsafer.android_team.yamsafer_workshop;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by islam on 3/10/18.
 */

public class MessagesAdapter extends RecyclerView.Adapter <MessageItemViewHolder> {

    List<UserMessage> userMessages = new ArrayList<>();

    public MessagesAdapter() {

        UserMessage userMessage = new UserMessage();

        userMessage.setPhotoUrl("https://avatarfiles.alphacoders.com/643/thumb-64385.png");

        userMessage.setMessagesSender("Pikatcho");

        userMessage.setText("Pika Pika1");

        userMessages.add(userMessage);

        userMessage = new UserMessage();

        userMessage.setPhotoUrl("https://avatarfiles.alphacoders.com/643/thumb-64385.png");

        userMessage.setMessagesSender("Pikatcho");

        userMessage.setText("Pika Pika2");

        userMessages.add(userMessage);

        userMessage = new UserMessage();

        userMessage.setPhotoUrl("https://avatarfiles.alphacoders.com/643/thumb-64385.png");

        userMessage.setMessagesSender("Pikatcho");

        userMessage.setText("Pika Pika3");

        userMessages.add(userMessage);
    }

    @NonNull
    @Override
    public MessageItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_item_view, null);

        MessageItemViewHolder holder = new MessageItemViewHolder(view);

        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull MessageItemViewHolder holder, int position) {

        holder.bind(userMessages.get(position));

    }


    @Override
    public int getItemCount() {

        return userMessages.size();
    }
}
