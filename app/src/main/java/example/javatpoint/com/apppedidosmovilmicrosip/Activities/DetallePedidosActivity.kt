package example.javatpoint.com.apppedidosmovilmicrosip.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import example.javatpoint.com.apppedidosmovilmicrosip.Adapters.RecyclerAdapterDetallePedido
import example.javatpoint.com.apppedidosmovilmicrosip.Adapters.RecyclerAdapterPedidos
import example.javatpoint.com.apppedidosmovilmicrosip.DataModel.PartidaPedido
import example.javatpoint.com.apppedidosmovilmicrosip.DataModel.Pedidos
import example.javatpoint.com.apppedidosmovilmicrosip.FakeDataToDB.FillTablesDataFake
import example.javatpoint.com.apppedidosmovilmicrosip.R

class DetallePedidosActivity : AppCompatActivity() {

    val titulo = "Listado de Partidas"

    //Importante declarar un solo adaptador en la clase =,)
    private lateinit var mAdapter: RecyclerAdapterDetallePedido
    // Importante declarar una sola ArrayList sobre la cual trabajar
    private lateinit var listaPartidasBD : ArrayList<PartidaPedido>
    // Lista ue se llenara con datos falsos
    private lateinit var listaPartidasFake : ArrayList<PartidaPedido>

    private lateinit var  listaDePartidas: ArrayList<PartidaPedido>

    private lateinit var pedidoSeleccionado: Pedidos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_pedidos)


          setUpRecyclerView()

    }

    fun getListaPartidasFromPedidoSeleccionado():ArrayList<PartidaPedido>{

        // obtiene el objeto serializado Pedido y lo guarda en una Variable
       pedidoSeleccionado = intent.getSerializableExtra("pedido") as Pedidos
       // Obtiene la lista mutable del objeto pedidoSeleccionado
       // y la castea en ArrayList `para que el RecyclerAdapter la procese
       listaDePartidas = pedidoSeleccionado.listaPartidas as ArrayList<PartidaPedido>
       // Mediante un Toast muestra la cantidad de elementos que contiene el pedido
        Toast.makeText(applicationContext, "Cantidad de Partidas ${listaDePartidas.size}", Toast.LENGTH_LONG).show()

        // retorna el ListArray lleno para que el AdapterRecycler lo muestre
        return listaDePartidas
                                                 }


    //lena de dastos estaticos una arrayList
    fun fillListaPartidasPedidosFake():ArrayList<PartidaPedido>{

        val fillTablesDataFake = FillTablesDataFake()
        listaPartidasFake= fillTablesDataFake.fillListaPartidasPedido()

        return listaPartidasFake
    }

    // Con este metodo se renderiza el RecylclerView con los objetos de listaClientes
    private fun setUpRecyclerView(){
        //Busca el RecyclerView declarado en la vista y lo asigna a un recyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.actRvDetallePedidos)
        // significa que RV tiene hijos(Items) que tienen ancho y alto fijado
        //Optimiza el RecyclerView
        recyclerView.setHasFixedSize(true)
        //Asigna un admistrador de elementos en el Recycler View
        recyclerView.layoutManager = LinearLayoutManager(this)

/* deshailitado para ingresar datos Falsos
    //declara el adaptador que vincular datos(listaClientes) con vista (RecyclerView)
        mAdapter= RecyclerAdapter(listaClientes,this)
 */
        //el adaptador usara un ArrayList con datos estaticos declarados en el programa
       mAdapter = RecyclerAdapterDetallePedido(getListaPartidasFromPedidoSeleccionado(),this)

        // asigna adaptador a RecyclerView
        recyclerView.adapter= mAdapter
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.search_articulos_menu,menu)

        // asigna search_item del XML a un Item SearchView
        val searchItem= menu!!.findItem(R.id.search_item)
        // Si el search_item existe entonces
        if (searchItem!= null){
            // al searchItem del menu le asigna la una accion como SearchView
            // super importante elegir la libreria android.Widget.SearchView
            val searchView= searchItem.actionView as SearchView
            //Concede la capacidad de escuchar cuando se escribe algo en el
            searchView.setOnQueryTextListener(
                object : SearchView.OnQueryTextListener{

                    // Hace la accion cuando el usuario presiona enviar
                    override fun onQueryTextSubmit(query: String?): Boolean {
                        mAdapter.filter.filter(query)
                        return true                                          }

                    override fun onQueryTextChange(newText: String?): Boolean {
                        mAdapter.filter.filter(newText)
                        return true                                           }
                } // end OnQueryListener
            )// fin setOnQueryTextListener
        }// cierra if (searchItem!= null)

        return super.onCreateOptionsMenu(menu)
    }

}
