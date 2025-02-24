package com.example.gustavioandroidstudio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class PopularGamesAdapter extends RecyclerView.Adapter<PopularGamesAdapter.ViewHolder> {

    private final Context context;
    private List<Game> games;
    private final OnGameClickListener onGameClickListener;

    public PopularGamesAdapter(Context context, List<Game> games, OnGameClickListener listener) {
        this.context = context;
        this.games = games;
        this.onGameClickListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.popular_game_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Game game = games.get(position);
        holder.gameTitle.setText(game.getTitle());
        holder.gameImage.setImageResource(game.getImageResId()); // Usa un recurso local para la imagen

        holder.itemView.setOnClickListener(v -> onGameClickListener.onGameClick(game));
    }

    @Override
    public int getItemCount() {
        return games.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView gameImage;
        TextView gameTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            gameImage = itemView.findViewById(R.id.gameImage);
            gameTitle = itemView.findViewById(R.id.gameTitle);
        }
    }

    public interface OnGameClickListener {
        void onGameClick(Game game);
    }

    public void filtrar(String texto) {
        List<Game> juegosFiltrados = new ArrayList<>();
        for (Game game : games) {
            if (game.getTitle().toLowerCase().contains(texto.toLowerCase())) {
                juegosFiltrados.add(game);
            }
        }
        this.games.clear();
        this.games.addAll(juegosFiltrados);
        notifyDataSetChanged();
    }
}
