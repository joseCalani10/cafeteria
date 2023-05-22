package corp.sc.cafeteria

import android.content.ContentValues
import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import java.lang.Exception

class productos : AppCompatActivity() {

    val l=this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos)
        val ini5 : ImageButton = findViewById(R.id.cafe)

        // temporal
        val np= arrayOf("helado de platano","helado de vainilla","helado de chocolate","torta de mani")
        val cp= arrayOf(2,2,2,5)
        val pp= arrayOf(12,11,15,23)
        val dp= arrayOf("ninguno","ninguno","ninguno","un producto novedoso")
        val fp= arrayOf("helado.png","hel.png","helado2.jpg","torta002.jpg")

       //restx

        try{
            val d = D(this,true).run()
            var i=0
            while(i<4){
                val v: ContentValues = ContentValues()
                v.put("nombre",np[i])
                v.put("categoria",cp[i])
                v.put("precio",pp[i])
                v.put("descripcion",dp[i])
                v.put("foto",fp[i])

                d.insert("productos",null,v)
                i++
            }
            d.close()
            Toast.makeText(l,"cargando datos...", Toast.LENGTH_LONG).show()
        }catch (e: Exception){
            Toast.makeText(l,e.message, Toast.LENGTH_LONG).show()
        }

        ini5.setOnClickListener {

            val intent : Intent = Intent (this, lista::class.java)
            startActivity(intent)
        }
    }

}