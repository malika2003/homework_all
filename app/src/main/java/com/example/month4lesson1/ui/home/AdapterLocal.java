package com.example.month4lesson1.ui.home;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.month4lesson1.R;
import com.example.month4lesson1.ui.utils.OnClick;

import java.util.ArrayList;

public class AdapterLocal extends RecyclerView.Adapter<AdapterLocal.ViewHolder> {
    private ArrayList<String> list =  new ArrayList<>();
    private OnClick onClick;

    public AdapterLocal(OnClick onClick) {
        this.onClick = onClick;
    }

    public ArrayList<String> getList(){
        return list;
    }

    public void dalate( int pos){
        list.remove(pos);
        notifyItemRemoved(pos);
    }

    public void  setList(ArrayList<String>list){
        this.list = list;
        notifyDataSetChanged();
    }

    public void addItem(String item){
        this.list.add(item);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv, parent,
                false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onbind(list.get(position), onClick);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_item);
        }
        public void onbind(String text, OnClick onClick){
            textView.setText(text);
            textView.setOnClickListener(v -> {
                onClick.click(getAdapterPosition());

            });
            textView.setOnLongClickListener(v -> {
                onClick.longClick(getAdapterPosition());
                return true;
            });
        }
    }
}
