package com.example.android.pets;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.pets.POJO.AnimalModel;

import java.util.ArrayList;

public class AllAnimalAdapter extends RecyclerView.Adapter<AllAnimalAdapter.MyViewHolder> {

    Context mContext;
    ArrayList<AnimalModel> animalModel_list;

    public AllAnimalAdapter(Context context) {
        this.mContext = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_all_animals, viewGroup, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        AnimalModel pos = animalModel_list.get(position);
        holder.tv_animalType_var.setText(pos.type_name);
        holder.tv_animalName_var.setText(pos.animal_name);


    }

    @Override
    public int getItemCount() {
        if (animalModel_list == null) {
            return 0;
        } else return animalModel_list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_animalType_var,tv_animalName_var;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_animalType_var = itemView.findViewById(R.id.tv_animalType_xml);
            tv_animalName_var = itemView.findViewById(R.id.tv_petName_xml);
        }
    }

    public void setAnimalModel_list(ArrayList<AnimalModel> animalModel_list) {
        this.animalModel_list = animalModel_list;
        notifyDataSetChanged();
    }
}
