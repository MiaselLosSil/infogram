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

public class ProfileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
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
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        //toolbar
        showToolbar("", false, view);

        //recyclerview
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_profile);

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
        Toolbar toolbar = view.findViewById(R.id.toolbar_profile);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(titulo);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(botonSubir);

    }

    public ArrayList<Image> buildImages(){
        ArrayList<Image> images = new ArrayList<>();

        images.add(new Image("https://i.pinimg.com/originals/30/14/64/301464d75827230f045aec1ac75c2949.jpg", "Selena Gomez", "3 dias", "500 me gusta"));
        images.add(new Image("https://wallpaperaccess.com/full/734553.jpg", "Maria Melgar", "15 dias", "50 me gusta"));
        images.add(new Image("https://i.pinimg.com/originals/c4/32/4a/c4324ae57487411dfb91650229944b75.jpg", "Marcelo Lopez", "4 dias", "7 me gusta"));
        images.add(new Image("https://c4.wallpaperflare.com/wallpaper/39/346/426/digital-art-men-city-futuristic-night-hd-wallpaper-preview.jpg", "Francisco Pizarro", "1 dias", "21 me gusta"));
        images.add(new Image("https://images3.alphacoders.com/641/641975.jpg", "Fabiola Lobo", "9 dias", "5 me gusta"));
        images.add(new Image("https://i.pinimg.com/originals/32/17/8c/32178c65770245ad533ce6bfa51cd208.jpg", "Desire Molina", "7 dias", "60 me gusta"));
        images.add(new Image("https://wallpapers.org.es/wp-content/uploads/2013/10/wallpaper-bosque-encantado.jpg", "Armando Salazar", "20 dias", "9 me gusta"));
        images.add(new Image("https://c4.wallpaperflare.com/wallpaper/342/395/609/anime-bleach-kurosaki-ichigo-nanfe-wallpaper-preview.jpg", "Xavier Trujillo", "11 dias", "10 me gusta"));
        images.add(new Image("https://p4.wallpaperbetter.com/wallpaper/788/303/744/neon-digital-artwork-digital-art-asian-hd-wallpaper-preview.jpg", "Angela Reyes", "7 dias", "250 me gusta"));
        images.add(new Image("https://p4.wallpaperbetter.com/wallpaper/315/379/745/post-apocalyptic-4k-hd-background-download-wallpaper-preview.jpg", "Teodoro Velazquez", "2 dias", "33 me gusta"));
        images.add(new Image("https://www.xtrafondos.com/wallpapers/resoluciones/20/diseno-de-paisaje-del-espacio_2560x1440_5771.jpg", "Andrea Orozco", "21 dias", "8 me gusta"));

        return images;
    }
}