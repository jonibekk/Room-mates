package com.example.jonib.rommatebeta;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RoomsFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        final ArrayList<ArgumentsClass> object = new ArrayList<>();

        object.add(new ArgumentsClass(R.drawable.ic_launcher_foreground, "Room-510", "4", "Hello There!"));
        object.add(new ArgumentsClass(R.drawable.ic_launcher_foreground, "Room-511", "6", "Hello Worlds!"));
        object.add(new ArgumentsClass(R.drawable.ic_launcher_foreground, "Room-512", "3", "Some Description!"));
        object.add(new ArgumentsClass(R.drawable.ic_launcher_foreground, "Room-513", "5", "Well Done App!"));
        object.add(new ArgumentsClass(R.drawable.ic_launcher_foreground, "Room-514", "7", "Something New!"));

        mAdapter = new CustomAdapter(getContext(), object);
        recyclerView.setAdapter(mAdapter);
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), recyclerView,
                new RecyclerItemClickListener.OnItemClickListener(){

                    @Override
                    public void onItemClick(View view, int position) {
                        Intent intent = new Intent(getActivity(), ExpenseProperty.class);
                        intent.putExtra("title", object.get(position).getRoom_name());
                        startActivity(intent);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        Toast.makeText(getContext(), "OnItemLongClick Works", Toast.LENGTH_LONG).show();
                    }
                }));



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_rooms, container, false);
    }
}
