package com.aad.ar.as.hawkeye;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by cirmac3 on 7/11/16.
 */
public class HomeRecyclerView extends RecyclerView.Adapter<HomeRecyclerView.ARRecyclerViewHolder> {
    private ArrayList<String> list = new ArrayList<>();
    private LayoutInflater inflater;
    private static HomeItemClickListener listener;

    public HomeRecyclerView(Context context) {
        inflater = LayoutInflater.from(context);
        list.add("A-Bomb (HAS)");
        list.add("A.I.M.");
        list.add("Abe");
        list.add("Abin");
        list.add("Abomination");
        list.add("Abraxas");
        list.add("Absorbing");
        list.add("Adam");
        list.add("Agent Bob");
        list.add("Agent Zero");
        list.add("Air Walker");
        list.add("Ajax");
        list.add("Alan Scott");
        list.add("Alex Mercer");
        list.add("Alex Woolsly");
        list.add("Alfred Pennyworth");
        list.add("Allan Quartermain");
        list.add("Amazo");
        list.add("Ammo Ando");
        list.add("Masahashi Angel");
        list.add("Angel Dust");
        list.add("Angel Salvadore");
        list.add("A-Bomb");
        list.add("Abe");
        list.add("Abin");
        list.add("Abomination");
        list.add("Abraxas");
        list.add("Absorbing");
        list.add("Adam");
        list.add("Agent Bob");
        list.add("Agent Zero");
        list.add("Air Walker");
        list.add("Ajax");
        list.add("Alan Scott");
        list.add("Alex Mercer");
        list.add("Alex Woolsly");
        list.add("Alfred Pennyworth");
        list.add("Allan Quartermain");
        list.add("Amazo");
        list.add("Ammo Ando");
        list.add("Masahashi Angel");
        list.add("Angel Dust");
        list.add("Angel Salvadore");
        listener= (HomeItemClickListener) context;

    }

    @Override
    public ARRecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View root = inflater.inflate(R.layout.custom_row, viewGroup, false);
        ARRecyclerViewHolder holder = new ARRecyclerViewHolder(root);
        return holder;
    }

    @Override
    public void onBindViewHolder(ARRecyclerViewHolder yourRecyclerViewHolder, int i) {
        yourRecyclerViewHolder.textView.setText(list.get(i));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ARRecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public ARRecyclerViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.customText);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onHomeListItemClick(getLayoutPosition());
                }
            });

        }
    }

    public interface HomeItemClickListener
    {
        void onHomeListItemClick(int position);
    }

}
