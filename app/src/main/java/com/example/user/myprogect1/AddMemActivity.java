package com.example.user.myprogect1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.google.android.material.textfield.TextInputLayout;
import com.squareup.picasso.Picasso;

import androidx.appcompat.app.AppCompatActivity;

public class AddMemActivity extends AppCompatActivity {

    ImageView ivMem;
    TextInputLayout tilComment;
    DataGenerator generator = new DataGenerator();
    String memLink = "";

    public static Intent getStartIntent(Context context) {
        return new Intent(context, AddMemActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_mem);

        ivMem = findViewById(R.id.ivMem);
        tilComment = findViewById(R.id.tilComment);
        loadImage();
        ivMem.setOnClickListener(view -> loadImage());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_add_mem, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.actionAdd) {
            Mem mem = new Mem(memLink, tilComment.getEditText().getText().toString());
            AppDatabase.getInstance(this).memDao().insertMem(mem);
            finish();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void loadImage() {
        memLink = generator.getMem();
        Picasso.get().load(memLink)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .fit()
                .centerCrop()
                .into(ivMem);
    }
}
