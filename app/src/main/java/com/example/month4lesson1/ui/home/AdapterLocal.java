package com.example.month4lesson1.ui.home;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.month4lesson1.R;
import com.example.month4lesson1.model.Task;
import com.example.month4lesson1.ui.utils.OnClick;

import java.util.ArrayList;

public class AdapterLocal extends RecyclerView.Adapter<AdapterLocal.ViewHolder> {
    private ArrayList<Task> list =  new ArrayList<>();
    private OnClick onClick;

    public AdapterLocal(OnClick onClick) {
        this.onClick = onClick;
    }

    public ArrayList<Task> getList(){
        return list;
    }

    public void dalate( int pos){
        list.remove(pos);
        notifyItemRemoved(pos);
    }

    public void  setList(ArrayList< Task> list){
        this.list = list;
        notifyDataSetChanged();
    }

    public void addItem( Task task){
        this.list.add(task);
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

    public void addItem(String text, String desc) {
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private TextView textViewDesk;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_item);
            textViewDesk = itemView.findViewById(R.id.tv_desk);

        }
        public void onbind(Task task, OnClick onClick){
            textViewDesk.setText(task.getDescription());
            textView.setText(task.getTitle() + task.getDescription());
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
