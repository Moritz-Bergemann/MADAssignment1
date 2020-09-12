package com.moritz.android.madassignment1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.moritz.android.madassignment1.model.GameData;
import com.moritz.android.madassignment1.model.Question;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuestionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuestionFragment extends Fragment {

    private Question mQuestion;

    public QuestionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment QuestionFragment.
     */
    public static QuestionFragment newInstance() {
        return new QuestionFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mQuestion = GameData.getInstance().getCurQuestion();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        int layoutId = -1;

        //FIXME making the layout get filled automatically would have been a way nicer solution, but the assignment spec specifically says different 'layouts'. This makes me unhappy
        switch (mQuestion.getChoices().length) {
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

        //Setting question text
        TextView questionText = view.findViewById(R.id.questionText);
        questionText.setText(mQuestion.getQuestion());

        //Setting listeners for answers (1 and 2 must always exist)
        int[] buttonIds = new int[]{R.id.answer1, R.id.answer2, R.id.answer3, R.id.answer4};

        int ii = 0; //Tracking the current question element
        for (int id : buttonIds) {
            Button answerButton = view.findViewById(id);
            if (answerButton != null) {
                answerButton.setText(mQuestion.getChoices()[ii]);

                //If this is the right answer
                if (mQuestion.isCorrectChoice(ii)) {
                    answerButton.setOnClickListener(clickedView -> {
                        if (!mQuestion.isAnswered()) {
                            //Showing the answer was right
                            Toast.makeText(getContext(), "Right answer!", Toast.LENGTH_SHORT).show(); //TODO

                            //Adding the number of points to the player's score
                            GameData.getInstance().addCurPoints(mQuestion.getPoints());

                            //Adding special points if this question was special
                            if (mQuestion.isSpecial()) {
                                GameData.getInstance().addSpecialPoint();
                            }

                            //Setting this question to answered & showing the return button
                            mQuestion.setAnswered(true);
                            UIData.getInstance().setShowPreviousButton(true);
                        } else {
                            Toast.makeText(getContext(), "You've already answered this question!", Toast.LENGTH_SHORT).show();
                        }
                    });
                } else { //If this was a wrong answer
                    answerButton.setOnClickListener(clickedView -> {
                        if (!mQuestion.isAnswered()) {
                            //Showing the answer was wrong
                            Toast.makeText(getContext(), "Wrong answer!", Toast.LENGTH_SHORT).show(); //TODO

                            //Making the player lose the penalty points
                            GameData.getInstance().loseCurPoints(mQuestion.getPenalty());

                            //Setting this question to answered & showing the return button
                            mQuestion.setAnswered(true);
                            UIData.getInstance().setShowPreviousButton(true);
                        } else {
                            Toast.makeText(getContext(), "You've already answered this question!", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                ii++;
            }
        }
    }
}