package com.example.kissangenix;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kissangenix.Adapters.PostAdapter;
import com.example.kissangenix.Model.Post;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private FloatingActionButton fab;

    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    private PostAdapter postAdapter;
    private List<Post> postList;
    private DatabaseReference mDatabaseRef;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, AskAQuestion.class));
            }
        });



        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        progressBar = findViewById(R.id.progressbar);

        postList = new ArrayList<>();
        postAdapter = new PostAdapter(HomeActivity.this, postList);



        mDatabaseRef = FirebaseDatabase.getInstance().getReference("questions posts");
        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Post post = dataSnapshot.getValue(Post.class);
                    postList.add(post);
                }
                postAdapter = new PostAdapter(HomeActivity.this, postList);
                postAdapter.notifyDataSetChanged();
                progressBar.setVisibility(View.INVISIBLE);
                recyclerView.setAdapter(postAdapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(HomeActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}