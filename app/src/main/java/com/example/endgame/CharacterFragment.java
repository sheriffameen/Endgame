package com.example.endgame;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class CharacterFragment extends Fragment {
    private static final String CHARACTER = "marvel character";
    private Character character;
    private TextView characterNameTextView;
    private ImageView characterImageView;
    private View view;


    public CharacterFragment() {
        // Required empty public constructor
    }


    public static CharacterFragment newInstance(@NonNull Character character) {
        CharacterFragment fragment = new CharacterFragment();
        Bundle args = new Bundle();
        args.putParcelable(CHARACTER, character);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         if (getArguments() != null) {
            character = getArguments().getParcelable(CHARACTER);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_blank, container, false);
        characterNameTextView = view.findViewById(R.id.name_textView);
        characterImageView = view.findViewById(R.id.imageView);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String characterName = character.getName();
        characterNameTextView.setText(characterName);
        String characterImageUrl = character.getImage();

        Picasso.get().load(characterImageUrl).into(characterImageView);


    }
}
