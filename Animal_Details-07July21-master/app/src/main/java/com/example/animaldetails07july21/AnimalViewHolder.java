package com.example.animaldetails07july21;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AnimalViewHolder extends RecyclerView.ViewHolder {
    ImageView image;
    TextView name, sound;

    public AnimalViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        image = itemView.findViewById(R.id.ivAnimalImage);
        name = itemView.findViewById(R.id.tvAnimalName);
        sound = itemView.findViewById(R.id.tvAnimalSound);
    }

    public void setData(Animal animal) {
        image.setImageResource(animal.getImage());
        name.setText(animal.getType());
        sound.setText(animal.getSound());
    }
    
}
