package com.example.gustavioandroidstudio;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText etUsuario = findViewById(R.id.etUsuario);
        EditText etContrasena = findViewById(R.id.etContrasena);
        Button btnIniciarSesion = findViewById(R.id.btnIniciarSesion);
        Button btnCrearCuenta = findViewById(R.id.btnCrearCuenta);

        btnIniciarSesion.setOnClickListener(v -> {
            String usuario = etUsuario.getText().toString().trim();
            String contrasena = etContrasena.getText().toString().trim();

            // Si el usuario es "admin" y la contraseña es "1234", lo lleva a PaginaPrincipal
            if (usuario.equals("admin") && contrasena.equals("1234")) {
                Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, MainActivity.class));
            } else {

                startActivity(new Intent(this, PaginaPrincipal.class));
            }
            finish(); // Cierra la actividad actual
        });

        btnCrearCuenta.setOnClickListener(v -> startActivity(new Intent(this, RegisterActivity.class)));
    }
}
