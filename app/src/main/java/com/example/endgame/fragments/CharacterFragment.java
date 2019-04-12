package com.example.endgame.fragments;



import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.endgame.model.Character;
import com.example.endgame.R;
import com.squareup.picasso.Picasso;



public class CharacterFragment extends Fragment {
    private static final String CHARACTER = "marvel character";
    private Character character;
    private TextView characterNameTextView;
    private TextView quoteTextView;
    private TextView occupationTextView;
    private TextView genderTextView;
    private TextView heightTextView;
    private TextView weightTextView;
    private ImageView characterImageView;
    private Button historyButton;
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
        view = inflater.inflate(R.layout.character_fragment, container, false);
        characterNameTextView = view.findViewById(R.id.name_textView);
        characterImageView = view.findViewById(R.id.imageView);
        quoteTextView = view.findViewById(R.id.quote_textView);
        occupationTextView = view.findViewById(R.id.occupation_textView);
        genderTextView = view.findViewById(R.id.gender_textView);
        heightTextView = view.findViewById(R.id.height_textview);
        weightTextView = view.findViewById(R.id.weight_textview);
        historyButton = view.findViewById(R.id.thanosHistory_button);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String characterName = character.getName();
        String quote = " \" " +character.getQuote() + " \" ";
        String occupation = character.getOccupation();
        String gender = character.getGender();
        String height = character.getHeight();
        String weight = character.getWeight();


        quoteTextView.setText(quote);
        characterNameTextView.setText(characterName);
        occupationTextView.setText(occupation);
        genderTextView.setText(gender);
        heightTextView.setText(height);
        weightTextView.setText(weight);
        String characterImageUrl = character.getComicImage();



        Picasso.get().load(characterImageUrl).into(characterImageView);

        historyButton.setOnClickListener(v -> {
            String url = character.getHistory();
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);


        });


    }


}
