package mx.edu.tesoem.hugo4295.itics.sqlite7t11;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class actualizar extends AppCompatActivity {

    private EditText et1, et2, et3, et4;

    Bundle datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar);

        et1 = (EditText) findViewById(R.id.editText1); et2 = (EditText) findViewById(R.id.editText2);
        et3 = (EditText) findViewById(R.id.editText3); et4 = (EditText) findViewById(R.id.editText4);

         datos = getIntent().getExtras();
        String datosoptenidos = datos.getString("dni");
        EditText mostrardatos = (EditText) findViewById(R.id.editText1);

        mostrardatos.setText(datosoptenidos);

        String datosoptenidos2 = datos.getString("nombre");
        EditText mostrardatos2 = (EditText) findViewById(R.id.editText2);


        mostrardatos2.setText(datosoptenidos2);

        String datosoptenidos3 = datos.getString("ciudad");
        EditText mostrardatos3 = (EditText) findViewById(R.id.editText3);


        mostrardatos3.setText(datosoptenidos3);

        String datosoptenidos4 = datos.getString("numero");
        EditText mostrardatos4 = (EditText) findViewById(R.id.editText4);


        mostrardatos4.setText(datosoptenidos4);






    }


    public void modificacion(View v) {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,

                "administracion", null, 1);

        SQLiteDatabase bd = admin.getWritableDatabase();

        String dni = et1.getText().toString();
        String nombre = et2.getText().toString();
        String ciudad = et3.getText().toString();
        String numero = et4.getText().toString();

        ContentValues registro = new ContentValues();


        registro.put("nombre", nombre);
        registro.put("ciudad", ciudad);
        registro.put("numero", numero);

        int cant = bd.update("usuario", registro, "dni=" + dni, null);

        bd.close();

        if (cant == 1)

            Toast.makeText(this, "Datos modificados con éxito", Toast.LENGTH_SHORT)

                    .show();

        else

            Toast.makeText(this, "No existe usuario",

                    Toast.LENGTH_SHORT).show();

    }

    public void btncancelar(View v){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        this.finish();
    }

}
