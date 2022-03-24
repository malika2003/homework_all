package com.example.month4lesson1.ui.board;


import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.month4lesson1.R;
import com.example.month4lesson1.databinding.BoardItemBinding;

class boardAdapter extends RecyclerView.Adapter<boardAdapter.ViewHolder> {
    private BoardItemBinding binding;
    private String[] sub_title = {" sub_title1"," Eating (also known as consuming) is the ingestion of food, typically to provide a heterotrophic organism with energy and to allow for growth. Animals and other heterotrophs must eat in order to survive — carnivores eat other animals, herbivores eat plants, omnivores consume a mixture of both " ,"Directed by Pierre Perifel (Kung Fu Panda 2, Monsters Vs. Aliens, Rise Of The Guardians)\n" +
            "Starring Sam Rockwell, Marc Maron, Craig Robinson, Anthony Ramos, Awkwafina, Richard Ayoade, Zazie Beetz, Lilly Singh, Alex Borstein"};
    private String[] titlelist = {"Yoga Time "," Eating Time " ,"Films Time"};
    private int[] images ={R.drawable.ic_sova, R.drawable.ic_food, R.drawable.ic_sova};
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = BoardItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onbind(titlelist[position], images[position] , sub_title[position]);


    }

    @Override
    public int getItemCount() {

        return titlelist.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull BoardItemBinding binding) {
            super(binding.getRoot());
        }

        public void onbind(String title, int image, String sub_title) {
            binding.subTitle.setText(sub_title);
            binding.title.setText(title);
            binding.imageView2.setImageDrawable(binding.imageView2.getContext().getDrawable(image));

        }
    }
}

