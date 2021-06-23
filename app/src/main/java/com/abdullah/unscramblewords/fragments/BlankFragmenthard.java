package com.abdullah.unscramblewords.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.abdullah.unscramblewords.R;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class BlankFragmenthard extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BlankFragmenthard() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static BlankFragmenthard newInstance(String param1, String param2) {
        BlankFragmenthard fragment = new BlankFragmenthard();
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
    //shuffling words from dictionary
    private String shuffleword(String word){
        List<String> Letters = Arrays.asList(word.split(""));
        Collections.shuffle(Letters);
        String Shuffled ="";
        for(String letter : Letters){
            Shuffled += letter;
        }
        return Shuffled;
    }
    private void NewGame(){
        //getting random word from dictionary
        CurrentWord = Dictionary[(Rand.nextInt(Dictionary.length))];
        //showing shuffled word
        Word.setText(shuffleword(CurrentWord));
        //to clear text
        Answer.setText("");
        Next.setEnabled(false);
        Check.setEnabled(true);
    }
    TextView Information,Word;
    EditText Answer;
    Button Check,Next;
    Random Rand;
    String CurrentWord;
    String[] Dictionary={
            "italy","germany","mountain","android","register","camera","villa","wheat","islamabad","building"
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank_fragmenthard, container, false);


        Information= view.findViewById(R.id.information);
        Word = view.findViewById(R.id.word);
        Answer= view.findViewById(R.id.answer);
        Check = view.findViewById(R.id.check);
        Next = view.findViewById(R.id.next);
        Rand = new Random();
        NewGame();

        Check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Answer.getText().toString().equalsIgnoreCase(CurrentWord)){
                    Information.setText("Correct Answer");
                    Check.setEnabled(false);
                    Next.setEnabled(true);
                }
                else {
                    Information.setText("Opps Wrong Answer");
                }
            }
        });
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewGame();
            }
        });
        return view;
    }
}