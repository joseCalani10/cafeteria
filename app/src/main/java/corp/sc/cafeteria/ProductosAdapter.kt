package corp.sc.cafeteria

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import corp.sc.cafeteria.databinding.ItemProductoBinding

class ProductosAdapter(private val mContext: Context, private val listaProductos: List<Producto>) : ArrayAdapter<Producto>(mContext, 0, listaProductos) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.item_producto, parent, false)

        val producto = listaProductos[position]

        val v1 = ItemProductoBinding.inflate(LayoutInflater.from(mContext),parent,false)

        v1.name.text = producto.nombre
        v1.price.text = "$${producto.precio}"
        v1.imagenes.setImageResource(producto.imagen)

        return layout
    }

}