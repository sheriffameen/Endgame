package com.example.endgame.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.endgame.model.Character;
import com.example.endgame.navigator.CharacterNavigator;
import com.example.endgame.R;
import com.squareup.picasso.Picasso;


public class EndgameFragment extends Fragment {
    private static final String CHARACTER_KEY = "param1";
    private Character character;
    private TextView characterNameTextView;
    private ImageView characterImageView;
    private View view;
    private CharacterNavigator characterNavigator;


    public EndgameFragment() {
    }


    public static EndgameFragment newInstance(Character character) {
        EndgameFragment fragment = new EndgameFragment();
        Bundle args = new Bundle();
        args.putParcelable(CHARACTER_KEY, character);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            character = getArguments().getParcelable(CHARACTER_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.endgame_fragment, container, false);
        characterNameTextView = view.findViewById(R.id.endgameName_textView);
        characterImageView = view.findViewById(R.id.endgameCharacter_imageView);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String realImage = character.getRealImage();
        String name = character.getName();

        characterNameTextView.setText(name);
        Picasso.get().load(realImage).into(characterImageView);

        characterNameTextView.setOnClickListener(v -> onButtonPressed(character));

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        characterNavigator = (CharacterNavigator) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        characterNavigator = null;
    }

    public void onButtonPressed(Character character){
        if (characterNavigator !=null){
            characterNavigator.toCharacterFragment(character);
        }
    }






}
