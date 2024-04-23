package com.calculadoradeimc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private TextView textView_resultado;
    private EditText editText_altura, editText_peso;
    private Button bt_ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textView_resultado = findViewById(R.id.textView_resultado);
        bt_ok = findViewById(R.id.button);
        editText_peso = findViewById(R.id.editText_peso);
        editText_altura = findViewById(R.id.editText_altura);

        bt_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!editText_peso.getText().toString().isEmpty() && !editText_altura.getText().toString().isEmpty()) {

                    double peso = Double.parseDouble(editText_peso.getText().toString());
                    double altura = Double.parseDouble(editText_altura.getText().toString());
                    double IMC = peso / (altura * altura);

                    if (IMC < 18.5) {

                        textView_resultado.setText(IMC + "\n Tá só o osso!");

                    } else if (IMC >= 18.5 && IMC < 25) {
                        textView_resultado.setText(IMC + "\n Ai sim, Padrão!");

                    } else if (IMC >= 25 && IMC < 30) {
                        textView_resultado.setText(IMC + "\n Fica esperto ein!!!");

                    } else if (IMC >= 30 && IMC < 35) {
                        textView_resultado.setText(IMC + "\n TA gordão!!");

                    } else if (IMC >= 35 && IMC < 40) {
                        textView_resultado.setText(IMC + "\n TA gordaçoo!!");

                    } else if (IMC > 40) {
                        textView_resultado.setText(IMC + "\n THAIS CARLA!!");
                    }

                }else {
                    AlertDialog.Builder a = new AlertDialog.Builder(v.getContext());
                    a.setTitle("Informação!");
                    a.setMessage("Os campos \"Peso\" e \"Altura\" não podem estar vazios. Por favor, digite os valores e tente novamente!");
                    a.setPositiveButton("Ok", null);
                    a.create();
                    a.show();
                    textView_resultado.setText("");
                }
            }


        });
    }

}