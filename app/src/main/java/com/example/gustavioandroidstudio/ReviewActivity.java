package com.example.gustavioandroidstudio;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ReviewActivity extends AppCompatActivity {

    private ImageView gameImage;
    private TextView gameTitle, gameYear;
    private RatingBar ratingBar;
    private EditText reviewText;
    private Button submitButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        gameImage = findViewById(R.id.gameImage);
        gameTitle = findViewById(R.id.gameTitle);
        gameYear = findViewById(R.id.gameYear);
        ratingBar = findViewById(R.id.ratingBar);
        reviewText = findViewById(R.id.reviewText);
        submitButton = findViewById(R.id.submitButton);

        // Obtener datos del intent
        Intent intent = getIntent();
        if (intent != null) {
            gameTitle.setText(intent.getStringExtra("GAME_TITLE"));
            gameYear.setText(intent.getStringExtra("GAME_YEAR"));
            gameImage.setImageResource(intent.getIntExtra("GAME_IMAGE", R.drawable.game_placeholder));
        }

        // Acción del botón
        submitButton.setOnClickListener(view -> {
            String review = reviewText.getText().toString();
            float rating = ratingBar.getRating();

            // Guardar o enviar la reseña (ejemplo de toast)
            Toast.makeText(this, "Reseña enviada: " + review + " con " + rating + " estrellas", Toast.LENGTH_SHORT).show();
            finish(); // Cierra la actividad
        });
    }
}
