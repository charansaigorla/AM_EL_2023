package com.example.kissangenix.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kissangenix.CommentActivity;
import com.example.kissangenix.Model.Post;
import com.example.kissangenix.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.annotations.NotNull;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    public Context mContext;
    public List<Post> mPostList;
    private FirebaseUser firebaseUser;

    public PostAdapter(Context mContext, List<Post> mPostList) {
        this.mContext = mContext;
        this.mPostList = mPostList;
    }
@NotNull
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.question_retrived_layout, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        Post post = mPostList.get(position);
        Picasso.get()
                .load(post.getQuestionimage())
                .into(holder.expandcollapse);
        holder.askedby.setText(post.getAskedby());
        holder.askedOnTextViews.setText(post.getDate());
        holder.username.setText(post.getQuestion());
        holder.topicTextViews.setText(post.getTopic());

        isLiked(post.getPostid(),holder.likes);
        isDisLiked(post.getPostid(),holder.dislikes);



        holder.likes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.likes.getTag().equals("like") && holder.dislikes.getTag().equals("dislike")){
                    FirebaseDatabase.getInstance().getReference().child("likes").child(post.getPostid()).child(firebaseUser.getUid()).setValue(true);
                }
                else if (holder.likes.getTag().equals("like") && holder.dislikes.getTag().equals("disliked")){
                    FirebaseDatabase.getInstance().getReference().child("dislikes").child(post.getPostid()).child(firebaseUser.getUid()).removeValue();
                    FirebaseDatabase.getInstance().getReference().child("likes").child(post.getPostid()).child(firebaseUser.getUid()).setValue(true);

                }else {
                    FirebaseDatabase.getInstance().getReference().child("likes").child(post.getPostid()).child(firebaseUser.getUid()).removeValue();
                }

            }
        });

        holder.dislikes.setOnClickListener(v -> {
            if (holder.dislikes.getTag().equals("dislike") && holder.likes.getTag().equals("like")){
                FirebaseDatabase.getInstance().getReference().child("dislikes").child(post.getPostid()).child(firebaseUser.getUid()).setValue(true);
            }else if (holder.dislikes.getTag().equals("dislike") && holder.likes.getTag().equals("liked")){
                FirebaseDatabase.getInstance().getReference().child("likes").child(post.getPostid()).child(firebaseUser.getUid()).removeValue();
                FirebaseDatabase.getInstance().getReference().child("dislikes").child(post.getPostid()).child(firebaseUser.getUid()).setValue(true);
            }else {
                FirebaseDatabase.getInstance().getReference().child("dislikes").child(post.getPostid()).child(firebaseUser.getUid()).removeValue();
            }
        });



    holder.comments.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(mContext, CommentActivity.class);
            intent.putExtra("postid",post.getPostid());
            intent.putExtra("publisher",post.getPublisher());
            mContext.startActivity(intent);
        }
    });

        holder.commenttext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, CommentActivity.class);
                intent.putExtra("postid",post.getPostid());
                intent.putExtra("publisher",post.getPublisher());
                mContext.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mPostList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public ImageView expandcollapse,more;
        public ImageView likes,dislikes,comments,saves;
        public TextView topicTextViews,askedOnTextViews,askedby,commenttext;
        public TextView username;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            expandcollapse = itemView.findViewById(R.id.expand_collapse);
            commenttext = itemView.findViewById(R.id.commenttext);
            likes = itemView.findViewById(R.id.like);
            dislikes = itemView.findViewById(R.id.dislike);
            comments = itemView.findViewById(R.id.comment);
            saves = itemView.findViewById(R.id.save);
            more = itemView.findViewById(R.id.more);
            topicTextViews = itemView.findViewById(R.id.topicTextView);
            askedOnTextViews = itemView.findViewById(R.id.askedOnTextView);
            askedby = itemView.findViewById(R.id.askedby);
            username = itemView.findViewById(R.id.question_text);


        }
    }
   private void isLiked(String postid, final ImageView imageView){
       FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
       DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("likes").child(postid);
       reference.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot snapshot) {
               if(snapshot.child(firebaseUser.getUid()).exists()){
                   imageView.setImageResource(R.drawable.ic_liked);
                   imageView.setTag("liked");
               }
               else{
                   imageView.setImageResource(R.drawable.ic_baseline_thumb_up_24);
                   imageView.setTag("like");
               }
           }

           @Override
           public void onCancelled(@NonNull DatabaseError error) {

           }
       });
   }
    private void isDisLiked(String postid,final ImageView imageView){
        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("dislikes").child(postid);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.child(firebaseUser.getUid()).exists()){
                    imageView.setImageResource(R.drawable.ic_disliked);
                    imageView.setTag("Disliked");
                }
                else{
                    imageView.setImageResource(R.drawable.ic_baseline_thumb_down_24);
                    imageView.setTag("Dislike");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}
