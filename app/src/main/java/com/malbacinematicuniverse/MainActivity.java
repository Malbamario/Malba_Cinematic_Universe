package com.malbacinematicuniverse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.malbacinematicuniverse.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvFilm;
    private ArrayList<Film> list;
    final String STATE_LIST = "state_list";
    final String STATE_MODE = "state_mode";
    int mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvFilm = findViewById(R.id.rv_film);
        rvFilm.setHasFixedSize(true);

        list = new ArrayList<>();

        if (savedInstanceState == null){
            list.addAll(FilmData.getListData());
            showRecyclerList();
            mode = R.id.action_list;
        } else {
            ArrayList<Film> stateList = savedInstanceState.getParcelableArrayList(STATE_LIST);
            int stateMode = savedInstanceState.getInt(STATE_MODE);
            list.addAll(stateList);
            setMode(stateMode);
        }
    }

    private void showSelectedFilm(String film){
        Intent intent = new Intent(this, DetailFilmActivity.class);
        intent.putExtra(DetailFilmActivity.EXTRA_INDEX, film);
        startActivity(intent);
    }

    private void showRecyclerList(){
        rvFilm.setLayoutManager(new LinearLayoutManager(this));
        ListFilmAdapter listFilmAdapter = new ListFilmAdapter(this);
        listFilmAdapter.setListFilm(list);
        rvFilm.setAdapter(listFilmAdapter);

        ItemClickSupport.addTo(rvFilm).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedFilm(list.get(position).getIndex());
            }
        });
    }

    private void showRecyclerGrid(){
        rvFilm.setLayoutManager(new GridLayoutManager(this, 2));
        GridFilmAdapter gridFilmAdapter = new GridFilmAdapter(this);
        gridFilmAdapter.setListFilm(list);
        rvFilm.setAdapter(gridFilmAdapter);

        ItemClickSupport.addTo(rvFilm).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedFilm(list.get(position).getIndex());
            }
        });
    }

    private void showRecyclerCardView(){
        rvFilm.setLayoutManager(new LinearLayoutManager(this));
        CardViewFilmAdapter cardViewFilmAdapter = new CardViewFilmAdapter(this);
        cardViewFilmAdapter.setListFilm(list);
        rvFilm.setAdapter(cardViewFilmAdapter);
    }

   @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedmode) {
        switch (selectedmode){
            case R.id.action_list:
                showRecyclerList();
                break;
            case R.id.action_grid:
                showRecyclerGrid();
                break;
            case R.id.action_cardview:
                showRecyclerCardView();
                break;
        }
        mode = selectedmode;
    }
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(STATE_LIST, list);
        outState.putInt(STATE_MODE, mode);
    }
}