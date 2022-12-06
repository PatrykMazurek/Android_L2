package com.masiad.myapplication_l2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Adapter;
import android.widget.SimpleAdapter;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.masiad.myapplication_l2.databinding.FragmentSecondBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    private String text;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            text = getArguments().getString("info");
            System.out.println(text);
        }else {
            text = "Puste";
        }
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.personList.setAdapter(buildList());

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }

    public SimpleAdapter buildList(){
        List<Map <String, String>> personMap = new ArrayList<Map <String, String>>() {
        };
        for (Person p : MainActivity.personList){
            Map<String, String> temp = new HashMap<>();
            temp.put("name", p.name+" "+p.lastName);
            temp.put("city", p.city);
            personMap.add(temp);
        }
        SimpleAdapter simple = new SimpleAdapter(getContext(), personMap,
                android.R.layout.simple_list_item_2,
                new String[]{"name", "city"},
                new int[] {android.R.id.text1,android.R.id.text2 });
        return simple;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}