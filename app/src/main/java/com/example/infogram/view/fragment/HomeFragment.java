package com.example.infogram.view.fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import com.example.infogram.R;
import com.example.infogram.adapter.CardViewAdapter;
import com.example.infogram.model.Image;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //toolbar
        showToolbar(getString(R.string.title_home_fragment), false, view);

        //recyclerview
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);

        //layout manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        //adapter
        CardViewAdapter cardViewAdapter = new CardViewAdapter(buildImages(), R.layout.cardview_image, getActivity());
        recyclerView.setAdapter(cardViewAdapter);

        return view;
    }

    public void showToolbar(String titulo, boolean botonSubir, View view) {
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(titulo);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(botonSubir);

    }

    public ArrayList<Image> buildImages(){
        ArrayList<Image> images = new ArrayList<>();

        images.add(new Image("", "Selena Gomez", "3 dias", "500 me gusta"));
        images.add(new Image("", "Maria Melgar", "15 dias", "50 me gusta"));
        images.add(new Image("", "Marcelo Lopez", "4 dias", "7 me gusta"));
        images.add(new Image("", "Francisco Pizarro", "1 dias", "21 me gusta"));
        images.add(new Image("", "Fabiola Lobo", "9 dias", "5 me gusta"));
        images.add(new Image("", "Desire Molina", "7 dias", "60 me gusta"));
        images.add(new Image("", "Armando Salazar", "20 dias", "9 me gusta"));
        images.add(new Image("", "Xavier Trujillo", "11 dias", "10 me gusta"));
        images.add(new Image("", "Angela Reyes", "7 dias", "250 me gusta"));
        images.add(new Image("", "Teodoro Velazquez", "2 dias", "33 me gusta"));
        images.add(new Image("", "Andrea Orozco", "21 dias", "8 me gusta"));



        return images;
    }
}