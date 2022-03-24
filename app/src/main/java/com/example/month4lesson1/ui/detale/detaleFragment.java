package com.example.month4lesson1.ui.detale;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.month4lesson1.R;
import com.example.month4lesson1.databinding.FragmentDetaleBinding;


public class detaleFragment extends Fragment {

        private FragmentDetaleBinding binding;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
                binding = FragmentDetaleBinding.inflate(inflater, container, false);
                return binding.getRoot();
        }

        @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
                super.onViewCreated(view, savedInstanceState);
                initListeners();
        }

        private void initListeners() {
                binding.saveBtn.setOnClickListener(v -> {
                        sendData();
                        closeFragment();
                });
        }
        private void closeFragment() {
                NavController navController =  Navigation.findNavController(requireActivity(),
                        R.id.nav_host_fragment_activity_main);
                navController.navigateUp();
        }

        private void sendData() {
                String text = binding.textEt.getText().toString();
                String desc = binding.textdesc.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("textKey", text);
                bundle.putString("textDeskKey", text);
                getParentFragmentManager().setFragmentResult("key", bundle);
                getParentFragmentManager().popBackStack();
        }

        @Override
        public void onDestroy() {
                super.onDestroy();
                binding = null;
        }
}