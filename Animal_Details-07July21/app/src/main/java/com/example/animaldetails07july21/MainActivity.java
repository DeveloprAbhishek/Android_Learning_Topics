package com.example.animaldetails07july21;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Animal> animalList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        buildAnimalData();
        setDataAnimalAdapter();
    }

    private void setDataAnimalAdapter() {
        AnimalAdapter animalAdapter = new AnimalAdapter(animalList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(animalAdapter);
    }

    private void buildAnimalData() {
        animalList.add(new Animal(R.drawable.cat_with_sound,"Name: Cat","Sound: Meow"));
        animalList.add(new Animal(R.drawable.cow_with_sound,"Name: Cow","Sound: Moo"));
        animalList.add(new Animal(R.drawable.donkey_sound,"Name: Donkey","Sound: HeeHaw"));
        animalList.add(new Animal(R.drawable.duck_sound,"Name: Duck","Sound: Quack"));
        animalList.add(new Animal(R.drawable.elephant_sounf,"Name: Elephant","Sound: Honk"));
        animalList.add(new Animal(R.drawable.hen_sound,"Name: Hen","Sound: Cluck"));
        animalList.add(new Animal(R.drawable.lion_sound,"Name: Lion","Sound: Roar"));
        animalList.add(new Animal(R.drawable.monkey_sound,"Name: Monkey","Sound: Chatter"));
        animalList.add(new Animal(R.drawable.owl_soung,"Name: Owl","Sound: Hoot"));
        animalList.add(new Animal(R.drawable.pig_sound,"Name: Pig","Sound: Oink"));
        animalList.add(new Animal(R.drawable.sheep_sound,"Name: Sheep","Sound: Bleat"));
        animalList.add(new Animal(R.drawable.snack_sound,"Name: Snack","Sound: Hiss"));
        animalList.add(new Animal(R.drawable.wolf_sound,"Name: Wolf","Sound: Howl"));
        animalList.add(new Animal(R.drawable.cat_with_sound,"Name: Cat","Sound: Meow"));
        animalList.add(new Animal(R.drawable.cow_with_sound,"Name: Cow","Sound: Moo"));
        animalList.add(new Animal(R.drawable.donkey_sound,"Name: Donkey","Sound: HeeHaw"));
        animalList.add(new Animal(R.drawable.duck_sound,"Name: Duck","Sound: Quack"));
        animalList.add(new Animal(R.drawable.elephant_sounf,"Name: Elephant","Sound: Honk"));
        animalList.add(new Animal(R.drawable.hen_sound,"Name: Hen","Sound: Cluck"));
        animalList.add(new Animal(R.drawable.lion_sound,"Name: Lion","Sound: Roar"));
    }

    private void initViews() {
        recyclerView = findViewById(R.id.rvRecyclerView);
    }
}