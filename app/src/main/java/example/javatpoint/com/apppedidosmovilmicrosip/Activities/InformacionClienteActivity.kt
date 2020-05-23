package example.javatpoint.com.apppedidosmovilmicrosip.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import example.javatpoint.com.apppedidosmovilmicrosip.DataModel.Clientes
import example.javatpoint.com.apppedidosmovilmicrosip.R
import kotlinx.android.synthetic.main.activity_informacion_cliente.*

class InformacionClienteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_informacion_cliente)

       accareaIndiceFromRecycler()

    }

    fun accareaIndiceFromRecycler(){

        val cliente = intent.getSerializableExtra("cliente") as Clientes

        aicTvClave.text    = getString(R.string.clave, cliente.clave_cliente)
        aicTvNombre.text   = getString(R.string.nombre, cliente.nombre_cliente)
        aicTvDireccion.text= getString(R.string.direccion, cliente.direccion)
        aicTvPoblacion.text= getString(R.string.poblacion, cliente.poblacion)
        aicTvColonia.text  = getString(R.string.colonia, cliente.colonia)
        aicTvLatitud.text  = getString(R.string.latitud, cliente.latitud.toString())
        aicTvLongitud.text = getString(R.string.longitud, cliente.longitud.toString())
        aicTvSaldo.text    = getString(R.string.saldo, cliente.saldo.toString())



    }





}
