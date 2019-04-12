package com.example.endgame;

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

import com.example.endgame.activities.ThanosNavigator;
import com.example.endgame.model.Character;
import com.example.endgame.model.Thanos;
import com.example.endgame.navigator.CharacterNavigator;
import com.squareup.picasso.Picasso;


public class ThanosEndgameFragment extends Fragment {
    private ImageView thanosImageView;
    private TextView thanosNameTextView;
    private View view;
    private ThanosNavigator thanosNavigator;

    private static final String THANOS_KEY = "param1";
    private Thanos thanos;



    public ThanosEndgameFragment() {
        // Required empty public constructor
    }


    public static ThanosEndgameFragment newInstance(Thanos thanos) {
        ThanosEndgameFragment fragment = new ThanosEndgameFragment();
        Bundle args = new Bundle();
        args.putParcelable(THANOS_KEY, thanos);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            thanos = getArguments().getParcelable(THANOS_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_thanos_endgame, container, false);
        thanosImageView = view.findViewById(R.id.thanosEndgameCharacter_imageView);
        thanosNameTextView = view.findViewById(R.id.thanosEndgameName_textView);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Picasso.get().load(thanos.getSecondImage()).into(thanosImageView);
        thanosNameTextView.setText(thanos.getName());

        thanosNameTextView.setOnClickListener(v -> {onButtonPressed(thanos);});
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        thanosNavigator = (ThanosNavigator) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        thanosNavigator = null;
    }

    public void onButtonPressed(Thanos thanos){
        if (thanosNavigator !=null){
            thanosNavigator.toThanosFragment(thanos);
        }
    }
}
