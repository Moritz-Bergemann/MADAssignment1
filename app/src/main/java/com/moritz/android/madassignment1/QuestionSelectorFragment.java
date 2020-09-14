package com.moritz.android.madassignment1;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.moritz.android.madassignment1.model.Country;
import com.moritz.android.madassignment1.model.GameData;
import com.moritz.android.madassignment1.model.Question;

import java.util.List;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuestionSelectorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuestionSelectorFragment extends SelectorFragment {
    private Country mCountry;

    public QuestionSelectorFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question_selector, container, false);
    }

    public static QuestionSelectorFragment newInstance() {
        return new QuestionSelectorFragment();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView countryName = view.findViewById(R.id.countryName);
        countryName.setText(mCountry.getName());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mCountry = GameData.getInstance().getCurCountry();
    }

    @Override
    protected RecyclerView.Adapter<? extends RecyclerView.ViewHolder> getAdapter() {
        //Return an instance of the created QuestionAdapter class bound to the questions for the
        //  country it has been called with
        return new QuestionAdapter(mCountry.getQuestions(), getActivity());
    }

    private class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder> {
        List<Question> mQuestions;
        Activity mActivity;

        public QuestionAdapter(List<Question> questions, Activity activity) {
            mQuestions = questions;
            mActivity = activity;
        }

        @NonNull
        @Override
        public QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new QuestionViewHolder(LayoutInflater.from(mActivity).inflate(R.layout.question,
                    parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull QuestionViewHolder holder, int position) {
            holder.bind(mQuestions.get(position), position + 1);
        }

        @Override
        public int getItemCount() {
            return mQuestions.size();
        }

        private class QuestionViewHolder extends RecyclerView.ViewHolder {
            private Question mQuestion;

            private TextView mName;
            private TextView mPointsValue;
            private TextView mPenaltyValue;

            public QuestionViewHolder(@NonNull View itemView) {
                super(itemView);

                mQuestion = null;
                mName = itemView.findViewById(R.id.questionName);
                mPointsValue = itemView.findViewById(R.id.pointsValue);
                mPenaltyValue = itemView.findViewById(R.id.penaltyValue);
            }

            public void bind(Question question, int questionNumber) {
                mQuestion = question;

                //Setting layout values
                String questionName = String.format(Locale.US, "Q%d", questionNumber);
                if (mQuestion.isSpecial()) {
                    questionName += " (Special)";
                }
                mName.setText(questionName);
                mPointsValue.setText(String.format(Locale.US, "%d", question.getPoints()));
                mPenaltyValue.setText(String.format(Locale.US, "%d", question.getPenalty()));

                itemView.setOnClickListener(clickedView -> {
                    if (!mQuestion.isAnswered()) { //If question isn't already answered
                        if (getActivity() instanceof QuestionsActivity) {
                            GameData.getInstance().setCurQuestion(mQuestion);

                            GameData.getInstance().setCurQuestion(mQuestion);
                            ((QuestionsActivity) getActivity()).goToQuestion();
                        }
                    } else {
                        Toast.makeText(getContext(), "Question already answered!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
    }
}