package corp.sc.cafeteria

import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.lang.Exception

class login : AppCompatActivity() {
    val l=this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val ini1: Button = findViewById(R.id.loginbtn)
        val usu:EditText = findViewById(R.id.usuario)
        val cla:EditText = findViewById(R.id.clave1)
        ini1.setOnClickListener {
            val u1 = usu.text.toString()
            val c1 = cla.text.toString()
            try{
                val d = D(this,false).run()
                val c:Cursor = d.rawQuery("select * from usuario where usu='$u1' and clave='$c1'",null)
                if(c.count!=0){
                val intent: Intent = Intent (this, productos::class.java)
                startActivity(intent)
                d.close()
                finish()
                }
                else  Toast.makeText(l,"Error:datos incorrectos!",Toast.LENGTH_LONG).show()
            }catch (e:Exception){
                Toast.makeText(l,e.message,Toast.LENGTH_LONG).show()
            }

        }
    }
}