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

import com.example.endgame.R;
import com.example.endgame.model.Thanos;
import com.squareup.picasso.Picasso;


public class ThanosFragment extends Fragment {

    private static final String THANOS_KEY = "param1";
    private View view;
    private Thanos thanos;
    private TextView thanosNameTextView;
    private ImageView thanosImageView;
    private TextView thanosHeightTextview;
    private TextView thanosWeightTextview;
    private TextView thanosGenderTextview;
    private TextView thanosQuoteTextview;
    private TextView thanosOccupationTextview;
    private Button thanosHistoryButton;


    public ThanosFragment() {
        // Required empty public constructor
    }


    public static ThanosFragment newInstance(Thanos thanos) {
        ThanosFragment fragment = new ThanosFragment();
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
        view = inflater.inflate(R.layout.fragment_thanos, container, false);

        thanosNameTextView = view.findViewById(R.id.thanosName_textView);
        thanosImageView = view.findViewById(R.id.thanos_imageView);
        thanosHeightTextview = view.findViewById(R.id.thanosHeight_textView);
        thanosWeightTextview = view.findViewById(R.id.thanosWeight_textView);
        thanosGenderTextview = view.findViewById(R.id.thanosGender_textView);
        thanosQuoteTextview = view.findViewById(R.id.thanosQuote_textView);
        thanosOccupationTextview = view.findViewById(R.id.thanosOccupation_textView);
        thanosHistoryButton = view.findViewById(R.id.thanosHistory_button);



        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        thanosNameTextView.setText(thanos.getName());
        thanosHeightTextview.setText(thanos.getHeight());
        Picasso.get().load(thanos.getFirstImage()).into(thanosImageView);
        thanosWeightTextview.setText(thanos.getWeight());
        thanosGenderTextview.setText(thanos.getGender());
        thanosQuoteTextview.setText(" \" " +thanos.getQuote() + " \" ");
        thanosOccupationTextview.setText(thanos.getOccupation());
        thanosHistoryButton.setOnClickListener(v -> {
            String url = thanos.getHistory();
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);

        });


    }
}
