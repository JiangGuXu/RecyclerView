package jiangguxu.bawei.com.recyclerview.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import jiangguxu.bawei.com.recyclerview.R;
import jiangguxu.bawei.com.recyclerview.bean.NewsBean;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.viewHolder> {
    private Context context;
    private List<NewsBean.ResultsBean> list;

    public RecyclerViewAdapter(Context context, List<NewsBean.ResultsBean> newsBeanResults) {
        this.context = context;
        this.list = newsBeanResults;
    }

    @NonNull
    @Override
    //加载布局
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_layout, parent, false);
        viewHolder viewHolder = new viewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, final int position) {
        holder.textView.setText(list.get(position).getDesc());
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,list.get(position).getDesc(),Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public viewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.title);
        }
    }
}
