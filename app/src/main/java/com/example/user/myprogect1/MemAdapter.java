package com.example.user.myprogect1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MemAdapter extends RecyclerView.Adapter<MemAdapter.MemViewHolder>{
    private List<Mem> mems;

    public MemAdapter(List<Mem> mems) {
        this.mems = mems;
    }

    @NonNull
    @Override
    public MemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_mem, viewGroup, false);
        return new MemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MemViewHolder memViewHolder, int position) {
        memViewHolder.bind(mems.get(position));
    }

    @Override
    public int getItemCount() {
        return mems == null ? 0 : mems.size();
    }

    public void add(Mem mem){
        mems.add(mem);
        notifyDataSetChanged();
    }

    public void update(List<Mem> mems){
        this.mems.clear();
        this.mems.addAll(mems);
        notifyDataSetChanged();
    }

    public static class MemViewHolder extends RecyclerView.ViewHolder{

        ImageView ivMem;
        TextView tvComment;

        public MemViewHolder(@NonNull View itemView) {
            super(itemView);
            ivMem = itemView.findViewById(R.id.ivMem);
            tvComment = itemView.findViewById(R.id.tvComment);
        }

        public void bind(final Mem mem){
            Picasso.get().load(mem.getLink())
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .fit()
                    .centerCrop()
                    .into(ivMem);
            tvComment.setText(mem.getComment());
        }
    }

}
