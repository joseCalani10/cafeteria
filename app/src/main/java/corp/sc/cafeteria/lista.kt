package corp.sc.cafeteria

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import corp.sc.cafeteria.databinding.ActivityListaBinding

class lista : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val producto = Producto("Cafe Expreso", 20.0, " Despierta tus sentidos con nuestro Café Espresso. Nuestro café espresso se elabora con granos cuidadosamente seleccionados y molidos en el momento justo para extraer la esencia perfecta. Disfruta de su cuerpo sedoso, su crema espesa y su sabor equilibrado y robusto. ", R.drawable.cafe_expreso)
        val producto2 = Producto("Cafe Frio", 15.0, "¡Disfruta de nuestro café helado, una deliciosa y refrescante opción para satisfacer tus antojos! Nuestro café helado combina a la perfección el sabor intenso del café con la suavidad y cremosidad de los helados.", R.drawable.cafe_helado)
        val producto3 = Producto("Cafe con Crema", 18.0, "Prueba nuestra deliciosa combinación de café y crema, una experiencia indulgente que cautivará tus sentidos. Nuestro café con crema es la perfecta armonía entre el suave y rico sabor del café y la cremosidad irresistible de la crema fresca. ", R.drawable.cafe_con_crema)
        val producto4 = Producto("Cafe con leche", 20.0, "Disfruta de la perfecta unión entre el café y la leche en nuestro exquisito café con leche. Con cada sorbo, te envolverás en una experiencia de sabor suave y reconfortante. ", R.drawable.cafe_con_leche)
        val producto5 = Producto("Cafe negro", 18.0, "Descubre la esencia pura del café en nuestra taza de café negro. Con un carácter audaz y un sabor intenso, nuestro café negro te transportará a un mundo de auténtico deleite. Cada sorbo despierta tus sentidos con su aroma profundo y su sabor robusto.", R.drawable.cafe_negro)

        val vin = ActivityListaBinding.inflate(this.layoutInflater)
        val v1 = vin.root
        setContentView(v1)


        val listaProductos = listOf(producto, producto2, producto3, producto4
        , producto5)

        val adapter = ProductosAdapter(this, listaProductos)

        vin.list.adapter = adapter


        vin.list.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, ProductoActivity::class.java)
            intent.putExtra("producto", listaProductos[position])
            startActivity(intent)
        }
    }
}