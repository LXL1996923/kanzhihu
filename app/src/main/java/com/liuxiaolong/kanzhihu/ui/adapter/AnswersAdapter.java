package com.liuxiaolong.kanzhihu.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import com.liuxiaolong.kanzhihu.R;
import com.liuxiaolong.kanzhihu.model.entity.Answer;

import java.util.List;

/**
 * Created by Administrator on 2016/8/2.
 */
public class AnswersAdapter extends RecyclerView.Adapter<AnswersAdapter> implements View.OnClickListener {

    private List<Answer> answers;
    public AnswersAdapter (List<Answer> answers){
        this.answers=answers;
    }
    @Override
    public AnswersAdapter onCreateViewHolder(ViewGroup parent, int viewType) {

            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.answers_item,parent,false);
        return new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(AnswersAdapter holder, int position) {

    }


    public static  class ViewHolder extends RecyclerView.ViewHolder {




        public ViewHolder(View itemView) {
            super(itemView);

        }
    }

    @Override
    public int getItemCount() {
        return 0;
    }



    @Override
    public void onClick(View view) {

    }
}
