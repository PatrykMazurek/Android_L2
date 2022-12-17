package com.masiad.myapplication_l2;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.masiad.myapplication_l2.databinding.FragmentFirstBinding;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonProgresBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startProgress();
                randNumber();
            }
        });

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = binding.eTInfo.getText().toString();
//                SecondFragment fragment = new SecondFragment();
                Bundle bundle = new Bundle();
                if(!text.isEmpty()){
                    bundle.putString("info", text);
                }else{
                    bundle.putString("info", "");
                }
//                fragment.setArguments(bundle);
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment,bundle);
            }
        });
    }

    public void startProgress(){
        binding.progressBar.setProgress(0);
        binding.progressBar.setMax(10);
        Thread thread = new Thread(new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void run() {

                for (int i = 1; i<=10; i++){
                    final int n = i;
                    binding.progressBar.setProgress(i, true);
                    binding.textviewFirst.post(new Runnable() {
                        @Override
                        public void run() {
                            binding.textviewFirst.setText(n + " / 10");
                        }
                    });
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }

    public void randNumber(){
        ExecutorService service = Executors.newFixedThreadPool(4);
        for (int i = 0; i<10; i++){
            service.submit(new ShowNumber(getContext()));
        }
        service.shutdown();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}