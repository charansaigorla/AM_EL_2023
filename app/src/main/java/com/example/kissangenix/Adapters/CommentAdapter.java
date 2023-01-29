package com.example.kissangenix.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kissangenix.Model.Comment;
import com.example.kissangenix.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder> {

    private Context mContext;
    private List<Comment> mCommentList;
    private String postid;
    private FirebaseUser firebaseUser;

    public CommentAdapter(Context mContext, List<Comment> mCommentList, String postid) {
        this.mContext = mContext;
        this.mCommentList = mCommentList;
        this.postid = postid;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.comments_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
       Comment comment = mCommentList.get(position);
       holder.commentor_comment.setText(comment.getComment());
       holder.commentdate.setText("Commented on:"+comment.getDate());


    }

    @Override
    public int getItemCount() {
        return mCommentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

       public TextView commentoruserName,commentor_comment,commentdate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            commentoruserName = itemView.findViewById(R.id.commentoruserName);
            commentor_comment = itemView.findViewById(R.id.commentor_comment);
            commentdate = itemView.findViewById(R.id.commentdate);
        }
    }


}
