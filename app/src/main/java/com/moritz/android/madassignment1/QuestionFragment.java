package com.moritz.android.madassignment1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuestionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuestionFragment extends Fragment {

    private static final String ARG_QUESTION = "question";
    private static final String ARG_SPECIAL = "special";
    private static final String ARG_ANSWERS = "answers";
    private static final String ARG_CORRECT_ANSWER = "correctAnswer";

    String mQuestion;
    boolean mSpecial;
    String[] mAnswers;
    int mCorrectAnswer;

    public QuestionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment QuestionFragment.
     */
    public static QuestionFragment newInstance(String question, boolean special, String[] answers, int correctAnswer) {
        QuestionFragment fragment = new QuestionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_QUESTION, question);
        args.putBoolean(ARG_SPECIAL, special);
        args.putStringArray(ARG_ANSWERS, answers);
        args.putInt(ARG_CORRECT_ANSWER, correctAnswer);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mQuestion = getArguments().getString(ARG_QUESTION);
            mSpecial = getArguments().getBoolean(ARG_SPECIAL);
            mAnswers = getArguments().getStringArray(ARG_ANSWERS);
            mCorrectAnswer = getArguments().getInt(ARG_CORRECT_ANSWER);
        } else {
            throw new IllegalArgumentException("Arguments required");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        int layoutId = -1;

        //FIXME making the layout get filled automatically would have been a way nicer solution, but the assignment spec specifically says different 'layouts'. This makes me unhappy
        switch (mQuestion.length()) {
            case 2:
                layoutId = R.layout.fragment_question_2;
                break;
            case 3:
                layoutId = R.layout.fragment_question_3;
                break;
            case 4:
                layoutId = R.layout.fragment_question_4;
                break;
            default:
                throw new IllegalArgumentException("Bad number of answers");
        }

        return inflater.inflate(layoutId, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Setting listeners for answers (1 and 2 must always exist)
        int[] buttonIds = new int[]{R.id.answer1, R.id.answer2, R.id.answer3, R.id.answer4};

        int ii = 0;
        for (int id : buttonIds) {
            Button answerButton = view.findViewById(id);
            if (answerButton != null) {
                answerButton.setText(mAnswers[ii]);

                //If this is the right answer
                if (ii == mCorrectAnswer) {
                    answerButton.setOnClickListener(clickedView -> {
                        Toast.makeText(getContext(), "Right answer!", Toast.LENGTH_SHORT).show(); //TODO
                    });
                } else { //If this was a wrong answer
                    Toast.makeText(getContext(), "Wrong answer!", Toast.LENGTH_SHORT).show(); //TODO
                }

                ii++;
            }
        }
    }
}