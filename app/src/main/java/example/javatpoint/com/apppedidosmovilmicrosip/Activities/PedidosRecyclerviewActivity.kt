package example.javatpoint.com.apppedidosmovilmicrosip.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import example.javatpoint.com.apppedidosmovilmicrosip.Adapters.DatabaseHandler
import example.javatpoint.com.apppedidosmovilmicrosip.Adapters.RecyclerAdapterArticulos
import example.javatpoint.com.apppedidosmovilmicrosip.Adapters.RecyclerAdapterPedidos
import example.javatpoint.com.apppedidosmovilmicrosip.DataModel.Articulos
import example.javatpoint.com.apppedidosmovilmicrosip.DataModel.Pedidos
import example.javatpoint.com.apppedidosmovilmicrosip.FakeDataToDB.FillTablesDataFake
import example.javatpoint.com.apppedidosmovilmicrosip.R

class PedidosRecyclerviewActivity : AppCompatActivity() {


    val titulo = "Listado de Pedidos"

    //Importante declarar un solo adaptador en la clase =,)
    private lateinit var mAdapter: RecyclerAdapterPedidos
    // Importante declarar una sola ArrayList sobre la cual trabajar
    private lateinit var listaPedidos : ArrayList<Pedidos>
    // Lista ue se llenara con datos falsos
    private lateinit var listaPedidosFake : ArrayList<Pedidos>
    // Instancia del DatabaseHandler para tarer los metodos
    var databaseHandler = DatabaseHandler(this)




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pedidos_recyclerview)

       // LENA LA TABLA PEDIDOS CON DATSO ESTATICOS Y LOCALES
        fillListaPedidos()
        // Renderiza los datos en el Recycler View
        setUpRecyclerView()

    }

    //lena de dastos estaticos una arrayList
    fun fillListaPedidosFake():ArrayList<Pedidos>{
        val fillTablesDataFake = FillTablesDataFake()
        listaPedidosFake= fillTablesDataFake.fillListaPedidos()
        return listaPedidosFake                  }


    //  llena de Objetos "Cliente" que provienen de la base de datos el ArrayList listaClientes y la devuelve llena
    fun fillListaPedidos(): ArrayList<Pedidos>{
        listaPedidos= databaseHandler.showPedidosFromDB()
        return listaPedidos                   } //retorna a la lista llena de datos


    // Con este metodo se renderiza el RecylclerView con los objetos de listaClientes
    private fun setUpRecyclerView(){
        //Busca el RecyclerView declarado en la vista y lo asigna a un recyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.actRvPedidos)
        // significa que RV tiene hijos(Items) que tienen ancho y alto fijado
        //Optimiza el RecyclerView
        recyclerView.setHasFixedSize(true)
        //Asigna un admistrador de elementos en el Recycler View
        recyclerView.layoutManager = LinearLayoutManager(this)

        //el adaptador usara un ArrayList llenado con datos en la BD
        mAdapter= RecyclerAdapterPedidos(listaPedidos,this)

        // asigna adaptador a RecyclerView
        recyclerView.adapter= mAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.search_pedidos_menu,menu)

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



    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {

            R.id.downloadPedidos -> {
                downloadPedidosToDatabase()  // descarga los clientes del api y los guarda en BD
                //    playToRunnable()        // renderiza clientes nuevamente
                Toast.makeText(applicationContext, "Pedidos descargados", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.deletePedidos -> {
                deleteAllPedidos()   // borra los clientes de la bd
                //  playToRunnable()   //    Renderiza nuevamente los clientes
                Toast.makeText(applicationContext, "Borra los pedidos de la base de datos", Toast.LENGTH_LONG).show()
                return true
            }

            else -> super.onOptionsItemSelected(item)
        }//Fin del when
    }// en onOptionItemSelected

    //trunca los datos de la tabla clientes
    private fun deleteAllPedidos(){
        val status = databaseHandler.truncateTablePedidos()
        Toast.makeText(applicationContext, "Total de pedidos ELIMINADOS ${status}", Toast.LENGTH_LONG).show()
    }



    private fun downloadPedidosToDatabase(){
               val conteo= databaseHandler.getFakeDataToInsertInTablePedidos()
                Toast.makeText(applicationContext, "El conteo de Pedidos es ${conteo}", Toast.LENGTH_LONG).show()
    }


}


