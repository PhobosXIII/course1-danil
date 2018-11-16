package com.example.user.myprogect1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MemsActivity extends AppCompatActivity {

    MemAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mems);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initList();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            final Intent intent = AddMemActivity.getStartIntent(this);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_mems, menu);
        MenuItem menuItem = menu.findItem(R.id.actionSearch);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                List<Mem> memsByComment = AppDatabase.getInstance(MemsActivity.this).memDao().getMemsByComment(query);
                adapter.update(memsByComment);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        menuItem.setOnActionExpandListener(new MenuItem.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                updateList();
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    private void updateList() {
        List<Mem> mems = AppDatabase.getInstance(MemsActivity.this).memDao().getAll();
        adapter.update(mems);
    }

    private void initList() {
        RecyclerView rvMems = findViewById(R.id.rvMems);
        rvMems.setHasFixedSize(true);
        rvMems.setLayoutManager(new GridLayoutManager(this, 2));
        List<Mem> mems = AppDatabase.getInstance(this).memDao().getAll();
        adapter = new MemAdapter(mems);
        rvMems.setAdapter(adapter);
    }
}
