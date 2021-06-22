package com.example.login;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText correo;
    EditText apodo;
    EditText name;
    EditText apellido;
    EditText password;
    ProgressBar progressbar;
    Usuario prueba = new Usuario();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        correo=findViewById(R.id.correoRegistro);
        apodo=findViewById(R.id.apodoRegistro);
        name=findViewById(R.id.nombreRegistro);
        apellido=findViewById(R.id.apellidoRegistro);
        password=findViewById(R.id.passwordRegistro);
        progressbar=findViewById(R.id.progressBar);

    }

    public void registro(View view){

        progressbar.setVisibility(View.INVISIBLE);
        Intent intent = new Intent(this, DashboardActivity.class);
        Usuario usuario = new Usuario(correo.getText().toString(), apodo.getText().toString(), name.getText().toString(), apellido.getText().toString(), password.getText().toString());
        Call<Usuario> call = ApiClient.getUserService().getUsuarioCorreo(correo.getText().toString());
        Bundle bundle  = new Bundle();
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {

                if (response.code()==404)
                {
                    Call<Usuario> call1 = ApiClient.getUserService().Registro(usuario);
                    call1.enqueue(new Callback<Usuario>() {
                        @Override
                        public void onResponse(Call<Usuario> call1, Response<Usuario> response) {
                           Log.i("G4", "Codico del servidor \n"+ response.code());
                            Usuario usuarioServidor = response.body();
                            Log.i("G4","El objeto que me envia el servidor es\n" + usuarioServidor);
                            if (response.code() ==201)
                            {

                                progressbar.setVisibility(View.VISIBLE);
                                bundle.putSerializable("correo", response.body().correo );
                                bundle.putSerializable("apodo", response.body().apodo);
                                intent.putExtras(bundle);
                                startActivity(intent);
                            }
                        }

                        @Override
                        public void onFailure(Call<Usuario> call, Throwable t) {

                        }
                    });
                }
                else  {

                    AlertDialog alertDialog = new AlertDialog.Builder (MainActivity.this).create();
                    alertDialog.setTitle("Error: Ya existe usuario con ese correo" );
                    alertDialog.setMessage("");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();

                                }
                            });
                    alertDialog.show();

                }
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {

            }
        });



    }
    }

