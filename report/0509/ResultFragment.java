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

public class ResultFragment extends Fragment {
    private static final String ARG_THINKING = "thinking_score";
    private static final String ARG_FEELING = "feeling_score";
    private int thinkingScore;
    private int feelingScore;

    public static ResultFragment newInstance(int thinking, int feeling) {
        ResultFragment fragment = new ResultFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_THINKING, thinking);
        args.putInt(ARG_FEELING, feeling);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, container, false);

        if (getArguments() != null) {
            thinkingScore = getArguments().getInt(ARG_THINKING);
            feelingScore = getArguments().getInt(ARG_FEELING);
        }

        TextView tvResult = view.findViewById(R.id.tv_result_text);
        Button btnRestart = view.findViewById(R.id.btn_restart);

        String result;
        if (thinkingScore > feelingScore) {
            result = "당신은 사고형(T) 성향입니다!";
        } else if (feelingScore > thinkingScore) {
            result = "당신은 감정형(F) 성향입니다!";
        } else {
            result = "당신은 사고형과 감정형의 균형을 가진 유형입니다!";
        }

        result += "\n\nT 선택: " + thinkingScore + "개\nF 선택: " + feelingScore + "개";
        tvResult.setText(result);

        btnRestart.setOnClickListener(v -> {
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container_view, new StartFragment());
            ft.commit();
        });

        return view;
    }
}
