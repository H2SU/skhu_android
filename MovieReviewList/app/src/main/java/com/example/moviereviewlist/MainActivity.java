package com.example.moviereviewlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements MyAdapter.ItemClickListener {

    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] titles = {
                "명량",
                "극한직업",
                "신과함께-죄와 벌",
                "국제시장",
                "베테랑",
                "괴물",
                "도둑들",
                "7번방의 선물",
                "암살",
                "범죄도시2",
                "광해, 왕이 된 남자",
                "왕의 남자",
                "신과함께-인과 연",
                "택시운전사",
                "태극기 휘날리며",
                "부산행",
                "해운대",
                "변호인",
                "실미도",
                "기생충"
        };

        Integer[] images = {
                R.drawable.movie1,
                R.drawable.movie2,
                R.drawable.movie3,
                R.drawable.movie4,
                R.drawable.movie5,
                R.drawable.movie6,
                R.drawable.movie7,
                R.drawable.movie8,
                R.drawable.movie9,
                R.drawable.movie10,
                R.drawable.movie11,
                R.drawable.movie12,
                R.drawable.movie13,
                R.drawable.movie14,
                R.drawable.movie15,
                R.drawable.movie16,
                R.drawable.movie17,
                R.drawable.movie18,
                R.drawable.movie19,
                R.drawable.movie20
        };

        String[] releaseYears = {
                "2014",
                "2019",
                "2017",
                "2014",
                "2015",
                "2006",
                "2012",
                "2013",
                "2015",
                "2022",
                "2012",
                "2005",
                "2018",
                "2017",
                "2004",
                "2016",
                "2009",
                "2013",
                "2003",
                "2019"
        };
        Integer[] ratings = {
                4,5,4,3,4,3,5,5,5,4,
                3,4,4,3,4,5,5,4,3,5
        };

        RecyclerView recyclerView = findViewById(R.id.review);
        int columns = 1;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new MyAdapter(this, titles, images, releaseYears,ratings);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        Log.i("TAG", "item: " + adapter.getItem(position) + "number: " + position);
    }
}