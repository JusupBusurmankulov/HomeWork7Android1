package com.example.homework7android1.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homework7android1.R;
import com.example.homework7android1.databinding.FragmentTaskBinding;
import com.example.homework7android1.models.TaskModel;


public class TaskFragment extends Fragment {

    FragmentTaskBinding binding;
    TaskModel taskModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTaskBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getData();
        sendData();
    }

    private void getData() {
        if (getArguments() != null) {
            taskModel = (TaskModel) getArguments().getSerializable("zxc");
            binding.etInputTask.setText(taskModel.getTask());
        }
    }

    private void sendData() {
        binding.btnSendTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String task = binding.etInputTask.getText().toString().trim();
                taskModel = new TaskModel(task);
                Bundle bundle = new Bundle();
                bundle.putSerializable("key", taskModel);
                Navigation.findNavController(view).navigate(R.id.homeFragment, bundle);
            }
        });
    }
}