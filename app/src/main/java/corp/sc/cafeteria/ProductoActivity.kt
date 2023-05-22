package corp.sc.cafeteria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import kotlinx.android.synthetic.main.activity_producto.*
import corp.sc.cafeteria.databinding.ActivityProductoBinding

class ProductoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bin = ActivityProductoBinding.inflate(layoutInflater)
        val v1 = bin.root
        setContentView(v1)

        val producto = intent.getSerializableExtra("producto") as Producto

        bin.nameProducto.text = producto.nombre
        bin.precioProducto.text = "$${producto.precio}"
        bin.detallesProducto.text = producto.descripcion
        bin.imagen.setImageResource(producto.imagen)
    }
}