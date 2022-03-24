package com.example.month4lesson1.ui.auth;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.month4lesson1.App;
import com.example.month4lesson1.R;
import com.example.month4lesson1.databinding.FragmentAuthBinding;

public class AuthFragment extends Fragment {
    private FragmentAuthBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAuthBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initListeners();
    }

    private void initListeners() {
        binding.btnRegister.setOnClickListener(v -> {
            signIn();

        });
        binding.btnRegister.setOnLongClickListener(v -> {
            signUp();
            return true;
        });
    }

    private void signUp() {
        App.auth.createUserWithEmailAndPassword(
                binding.etEmail.getText().toString()
                ,binding.etPass.getText().toString()
        ).addOnCompleteListener(task -> {
            if (task.isSuccessful()){
                Toast.makeText(requireContext(), "Goooooood", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(requireContext(), "Baaaaaaaad", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void signIn() {
        App.auth.createUserWithEmailAndPassword(
                binding.etEmail.getText().toString()
                , binding.etPass.getText().toString()
        ).addOnCompleteListener(task -> {
            if (task.isSuccessful()){
                Navigation.findNavController(requireActivity(),
                        R.id.nav_host_fragment_activity_main).navigateUp();
            }else {
                Log.e("-------", task.getException().getMessage());
                Toast.makeText(requireContext(), "baddddddddddddddddddd", Toast.LENGTH_SHORT).show();
            }
        });
    }
}