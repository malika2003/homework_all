package com.example.month4lesson1.ui.board;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.month4lesson1.R;
import com.example.month4lesson1.databinding.FragmentBoardBinding;

public class boardFragment extends Fragment {
    private int pos;
    private TextView[] dot ;
    private FragmentBoardBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBoardBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViewPager();
        addDots(1);
    }


    private void addDots(int dom){
        dot = new TextView[3];
        binding.listDot.removeAllViews();
        for (int i = 0; i <dot.length ; i++) {
            dot[i] = new TextView(requireContext());
            dot[i].setText(Html.fromHtml("•"));
            dot[i].setTextSize(40);
            binding.listDot.addView(dot[i]);
        }
        if(dot.length > 0){
            dot[dom].setTextColor(getResources().getColor(R.color.white));
        }
    }



    private void initViewPager() {

        binding.boardVp.setAdapter( new boardAdapter());

        binding.txtNext.setOnClickListener(v -> {
            int current = binding.boardVp.getCurrentItem();
            binding.boardVp.setCurrentItem(current+1);
        });
        binding.txtSkip.setOnClickListener(v -> {
            binding.boardVp.setCurrentItem(2);
        });
        binding.boardVp.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                pos = position ;
                    addDots(position);
                super.onPageSelected(position);
                if (binding.boardVp.getCurrentItem()==2){
                    binding.txtSkip.setVisibility(View.GONE);
                    binding.txtNext.setVisibility(View.GONE);
                    binding.txtFinish.setVisibility(View.VISIBLE);
                } else {
                    binding.txtFinish.setVisibility(View.GONE);
                    binding.txtSkip.setVisibility(View.VISIBLE);
                    binding.txtNext.setVisibility(View.VISIBLE);

                }
            }
        });

    }
}


