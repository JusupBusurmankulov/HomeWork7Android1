package com.example.homework7android1.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homework7android1.R;
import com.example.homework7android1.adapter.TaskAdapter;
import com.example.homework7android1.databinding.FragmentHomeBinding;
import com.example.homework7android1.interfaces.OnItemClickListener;
import com.example.homework7android1.models.TaskModel;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;
    ArrayList<TaskModel> list = new ArrayList<>();
    TaskAdapter taskAdapter = new TaskAdapter();
    TaskModel taskModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.recyclerTask.setAdapter(taskAdapter);
        getData();
        listeners();

    }

    private void getData() {
        if (getArguments() != null) {
            taskModel = (TaskModel) getArguments().getSerializable("key");
            list.add(taskModel);
            taskAdapter.data(list);

        }
    }

    private void listeners() {
        binding.btnOpenFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.taskFragment);
            }
        });

        taskAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClickListener(TaskModel taskModel) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("zxc", taskModel);
                Navigation.findNavController(requireView()).navigate(R.id.taskFragment, bundle);
            }
        });
    }

//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        list.clear();
//    }
}