package com.aad.ar.as.hawkeye;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aad.ar.as.hawkeye.models.Information;

import java.util.ArrayList;

/**
 * Created by cirmac3 on 7/11/16.
 */
public class HomeRecyclerView extends RecyclerView.Adapter<HomeRecyclerView.ARRecyclerViewHolder> {
//    private ArrayList<String> list = new ArrayList<>();
    private LayoutInflater inflater;
    private static HomeItemClickListener listener;
    private ArrayList<Information> infoList;

    public HomeRecyclerView(Context context,ArrayList<Information> infoList) {
        inflater = LayoutInflater.from(context);
        this.infoList=infoList;
        listener= (HomeItemClickListener) context;

    }

    @Override
    public ARRecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View root = inflater.inflate(R.layout.custom_row, viewGroup, false);
        ARRecyclerViewHolder holder = new ARRecyclerViewHolder(root);
        return holder;
    }

    @Override
    public void onBindViewHolder(ARRecyclerViewHolder holder, int i) {
        holder.nameTV.setText(infoList.get(i).getInfoName());
        holder.distanceTV.setText(infoList.get(i).getInfoDistance());
        holder.addressTV.setText(infoList.get(i).getInfoAddress());
    }

    @Override
    public int getItemCount() {
        return infoList.size();
    }

    static class ARRecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView nameTV,distanceTV,addressTV;

        public ARRecyclerViewHolder(View itemView) {
            super(itemView);
            nameTV = (TextView) itemView.findViewById(R.id.homeMapName);
            distanceTV = (TextView) itemView.findViewById(R.id.homeMapDistance);
            addressTV = (TextView) itemView.findViewById(R.id.homeMapAddress);

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
