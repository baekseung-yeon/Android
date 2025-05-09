package com.example.myapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.example.myapplication.R;
import com.example.myapplication.model.TfQuestion;
import java.util.ArrayList;
import java.util.List;

public class QuestionFragment extends Fragment {
    private static final String ARG_INDEX = "question_index";
    private int currentIndex;
    private static List<TfQuestion> questionList;
    private static int thinkingScore = 0;
    private static int feelingScore = 0;

    public static QuestionFragment newInstance(int index) {
        QuestionFragment fragment = new QuestionFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_INDEX, index);
        fragment.setArguments(args);

        if (questionList == null) {
            questionList = new ArrayList<>();
            questionList.add(new TfQuestion("친구가 고민을 털어놓으면?", "논리적 해결책을 제시한다", "감정에 공감하며 위로한다"));
            questionList.add(new TfQuestion("회의에서 의견 충돌이 생기면?", "논리적으로 설득한다", "상대 감정을 배려한다"));
            questionList.add(new TfQuestion("결정을 내릴 때?", "객관적 근거를 따진다", "사람의 감정을 고려한다"));
            questionList.add(new TfQuestion("누군가 실수했을 때?", "원인과 해결을 말한다", "감정을 먼저 이해한다"));
            questionList.add(new TfQuestion("자기소개서 쓸 때?", "논리적 구성 강조", "마음과 느낌 중심"));
            questionList.add(new TfQuestion("다툰 친구에게?", "왜 그랬는지 분석한다", "기분이 어땠는지 물어본다"));
            questionList.add(new TfQuestion("피드백할 때?", "사실 위주로 말한다", "기분 나쁘지 않게 조심한다"));
            questionList.add(new TfQuestion("갈등 상황에서?", "공정함이 우선", "조화로움이 우선"));
            questionList.add(new TfQuestion("팀 프로젝트 중?", "효율을 우선시한다", "팀원 감정을 배려한다"));
            questionList.add(new TfQuestion("문제 상황 해결 시?", "무엇이 잘못됐는지 분석", "누가 상처받았는지 생각"));
        }

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question, container, false);

        currentIndex = getArguments().getInt(ARG_INDEX);

        TextView tvQuestion = view.findViewById(R.id.tv_question);
        Button btnT = view.findViewById(R.id.btn_option_t);
        Button btnF = view.findViewById(R.id.btn_option_f);

        TfQuestion q = questionList.get(currentIndex);
        tvQuestion.setText(q.getQuestionText());
        btnT.setText(q.getThinkingOption());
        btnF.setText(q.getFeelingOption());

        btnT.setOnClickListener(v -> {
            thinkingScore++;
            goToNext();
        });

        btnF.setOnClickListener(v -> {
            feelingScore++;
            goToNext();
        });

        return view;
    }

    private void goToNext() {
        if (currentIndex + 1 < questionList.size()) {
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container_view, newInstance(currentIndex + 1));
            ft.addToBackStack(null);
            ft.commit();
        } else {
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container_view, ResultFragment.newInstance(thinkingScore, feelingScore));
            ft.commit();
        }
    }
}
