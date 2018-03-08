package me.yamsafer.android_team.yamsafer_workshop.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import me.yamsafer.android_team.yamsafer_workshop.R;
import me.yamsafer.android_team.yamsafer_workshop.model.UserMessage;
import me.yamsafer.android_team.yamsafer_workshop.viewholder.MessageViewHolder;

/**
 * Created by islam on 3/8/18.
 */

public class MessagesRecyclerAdapter extends FirebaseRecyclerAdapter<UserMessage, MessageViewHolder> {

    private Context mContext;

    public MessagesRecyclerAdapter(FirebaseRecyclerOptions<UserMessage> options) {

        super(options);
    }


    @Override
    protected void onBindViewHolder(MessageViewHolder holder, int position, UserMessage model) {

        holder.showMessage(model);
    }


    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.item_message, parent, false);

        return new MessageViewHolder(view);
    }
}
