package corp.sc.cafeteria

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val acti2: Button = findViewById(R.id.loginb)
        acti2.setOnClickListener {
            val Intent: Intent = Intent(this, login::class.java)
            startActivity(Intent)
        }


        val acti3:Button = findViewById(R.id.registerbutton)
        acti3.setOnClickListener {
            val intent: Intent = Intent (this, registro::class.java)
            startActivity(intent)
        }
    }
}