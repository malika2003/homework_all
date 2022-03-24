package com.example.month4lesson1.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.month4lesson1.App;
import com.example.month4lesson1.R;
import com.example.month4lesson1.databinding.FragmentHomeBinding;
import com.example.month4lesson1.model.Task;
import com.example.month4lesson1.ui.utils.OnClick;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements OnClick {

    private FragmentHomeBinding binding;
    private AdapterLocal adapterLocal;
    private RecyclerView recyclerView;

    private ViewPager pager;
    private LinearLayout linearLayout ;
    private TextView[] dot ;
    private TextView txtNext , txtFinish , txtSkip ;
    private int pos ;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initRecycler();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initListeners();
        fragmentListener();
        binding.localRv.setAdapter(adapterLocal);
        adapterLocal.setList((ArrayList<Task>) App.appDataBase.taskDao().getAllTask());
    }

    @Override
    public void onResume() {
        super.onResume();
        adapterLocal.setList((ArrayList<Task>) App.appDataBase.taskDao().getAllTask());
    }

    private void initRecycler() {
        adapterLocal = new AdapterLocal(this);
    }

    private void fragmentListener() {
        getParentFragmentManager().setFragmentResultListener("key",
                this,
                new FragmentResultListener() {
                    @Override
                    public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                        String text = result.getString("textKey");
                        String desc = result.getString("textDeskKey");
                        adapterLocal.addItem(text, desc);
                        App.appDataBase.taskDao().insertTask(new Task(text, desc));
                    }
                });
    }
    private void initListeners() {
        binding.addBtn.setOnClickListener(v -> {
            openFragment();
        });
    }
    private void openFragment() {
        Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_activity_main)
                .navigate(R.id.detaleFragment);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void click(int pos) {
        Task text  = adapterLocal.getList().get(pos);
        Toast.makeText(requireContext(), (CharSequence) text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void longClick(int pos) {
        adapterLocal.dalate(pos);

    }}