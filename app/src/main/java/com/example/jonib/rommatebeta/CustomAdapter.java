package com.example.jonib.rommatebeta;

import java.util.ArrayList;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private ArrayList<ArgumentsClass> mObject = new ArrayList<>();
    private Context mContext;

    public CustomAdapter(Context context, ArrayList<ArgumentsClass> object) {
        mContext = context;
        mObject = object;
    }

    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.each_room_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomAdapter.ViewHolder holder, int position) {
        holder.bindRestaurant(mObject.get(position));
    }

    @Override
    public int getItemCount() {
        return mObject.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.icon) ImageView imageView;
        @BindView(R.id.firstLine) TextView rooms;
        @BindView(R.id.secondLine) TextView users;
        @BindView(R.id.thirdLine) TextView descs;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindRestaurant(ArgumentsClass argumentsClass) {
            imageView.setImageResource(argumentsClass.getImageView());
            rooms.setText("" + argumentsClass.getRoom_name());
            users.setText( "Users: " + argumentsClass.getUsers());
            descs.setText("Description: " + argumentsClass.getDescription());
        }
    }
}