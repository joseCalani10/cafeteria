package corp.sc.cafeteria

import android.content.ContentValues
import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.graphics.convertTo
import java.lang.Exception

class registro : AppCompatActivity() {

    val l=this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        val c1 = findViewById<EditText>(R.id.a1)
        val c2 = findViewById<EditText>(R.id.a2)
        val c3 = findViewById<EditText>(R.id.a3)
        val c4 = findViewById<EditText>(R.id.a4)

        val ini: Button = findViewById(R.id.registerbtn)
        ini.setOnClickListener {

            val cc1 = c1.text.toString()
            val cc2 = c2.text.toString()
            val cc3 = c3.text.toString()
            val cc4 = c4.text.toString()
            try{
                val d = D(this,true).run()
                val v:ContentValues = ContentValues()
                v.put("nombres",cc1)
                v.put("usu",cc3)
                v.put("correo",cc2)
                v.put("clave",cc4)
                val r = d.insert("usuario",null,v)
                if(r.toInt()!=-1){
                    Toast.makeText(l,"($r) Usuario Registrado!", Toast.LENGTH_LONG).show()
                    val intent: Intent = Intent (this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                d.close()
                }
                else  Toast.makeText(l,"Error al guardar los datos!", Toast.LENGTH_LONG).show()
            }catch (e: Exception){
                Toast.makeText(l,e.message, Toast.LENGTH_LONG).show()
            }
        }
    }
}