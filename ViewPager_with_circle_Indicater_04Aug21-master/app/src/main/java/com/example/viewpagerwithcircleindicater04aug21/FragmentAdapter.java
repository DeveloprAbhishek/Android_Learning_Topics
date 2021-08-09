package com.example.viewpagerwithcircleindicater04aug21;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.viewpagerwithcircleindicater04aug21.fragments.FragmentA;
import com.example.viewpagerwithcircleindicater04aug21.fragments.FragmentB;
import com.example.viewpagerwithcircleindicater04aug21.fragments.FragmentC;
import com.example.viewpagerwithcircleindicater04aug21.fragments.FragmentD;

public class FragmentAdapter extends FragmentStateAdapter {

    public FragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return FragmentA.newInstance();
            case 1:
                return FragmentB.newInstance();
            case 2:
                return FragmentC.newInstance();
            case 3:
                return FragmentD.newInstance();
        }
        return FragmentA.newInstance();
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
