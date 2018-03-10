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

    public void addUserMessage(UserMessage userMessage){

        userMessages.add(userMessage);

        notifyDataSetChanged();

    }


}
