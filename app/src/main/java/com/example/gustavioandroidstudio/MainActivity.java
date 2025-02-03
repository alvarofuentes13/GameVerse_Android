package com.example.gustavioandroidstudio;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView popularGamesRecycler;
    private PopularGamesAdapter popularGamesAdapter;
    private List<Game> popularGames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializa los datos
        popularGames = new ArrayList<>();
        popularGames.add(new Game("GTA V", R.drawable.gta_v));
        popularGames.add(new Game("Cyberpunk 2077", R.drawable.cyberpunk));
        popularGames.add(new Game("Red Dead Redemption 2", R.drawable.red_dead));
        popularGames.add(new Game("The Witcher 3", R.drawable.witcher_3));

        // Configura el RecyclerView
        popularGamesRecycler = findViewById(R.id.popularGamesRecycler);
        popularGamesRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        popularGamesAdapter = new PopularGamesAdapter(this, popularGames, game -> {
            Toast.makeText(this, "Clicked: " + game.getTitle(), Toast.LENGTH_SHORT).show();
        });
        popularGamesRecycler.setAdapter(popularGamesAdapter);
    }
}
