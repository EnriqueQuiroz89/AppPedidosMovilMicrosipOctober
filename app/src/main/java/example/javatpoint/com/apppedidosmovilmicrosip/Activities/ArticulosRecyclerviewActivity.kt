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
import example.javatpoint.com.apppedidosmovilmicrosip.DataModel.Articulos
import example.javatpoint.com.apppedidosmovilmicrosip.FakeDataToDB.FillTablesDataFake
import example.javatpoint.com.apppedidosmovilmicrosip.R

class ArticulosRecyclerviewActivity : AppCompatActivity() {


    val titulo = "Listado de Articulos"

    //Importante declarar un solo adaptador en la clase =,)
    private lateinit var mAdapter: RecyclerAdapterArticulos
    // Importante declarar una sola ArrayList sobre la cual trabajar
    private lateinit var listaArticulos : ArrayList<Articulos>
    // Lista ue se llenara con datos falsos
    private lateinit var listaArticulosFake : ArrayList<Articulos>

    var databaseHandler = DatabaseHandler(this)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_articulos_recyclerview)

        //llena la lista con datos falsos
    ///    fillListaArticulosFake()
        //llena la lista con datos falsos
        fillListaArticulos()
        //Instala el Adapter
        setUpRecyclerView()

    }

/*    //llena de dastos estaticos una arrayList
    fun fillListaArticulosFake():ArrayList<Articulos>{

        val fillTablesDataFake = FillTablesDataFake()
        listaArticulosFake= fillTablesDataFake.fillListaArticulos()
        return listaArticulosFake                    }
*/

   // metodod para llenar desde la BD
    //  llena las Array list con datso que vienen de la BD
    fun fillListaArticulos(): ArrayList<Articulos>{
        listaArticulos= databaseHandler.showArticulosFromDB()
        return listaArticulos                    } //retorna a la lista llena de datos


    // Con este metodo se renderiza el RecylclerView con los objetos de listaClientes
    private fun setUpRecyclerView(){
        //Busca el RecyclerView declarado en la vista y lo asigna a un recyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.actRvArticulos)
        // significa que RV tiene hijos(Items) que tienen ancho y alto fijado
        //Optimiza el RecyclerView
        recyclerView.setHasFixedSize(true)
        //Asigna un admistrador de elementos en el Recycler View
        recyclerView.layoutManager = LinearLayoutManager(this)

    //declara el adaptador que vincular datos(listaClientes) con vista (RecyclerView)
        mAdapter= RecyclerAdapterArticulos(listaArticulos,this)

  /*      //el adaptador usara un ArrayList con datos estaticos declarados en el programa
        mAdapter= RecyclerAdapterArticulos(listaArticulosFake,this)
*/
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


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {

            R.id.downloadArticulos -> {
                downloadArticulosToDatabase()  // descarga los clientes del api y los guarda en BD
            //    playToRunnable()        // renderiza clientes nuevamente
                Toast.makeText(applicationContext, "Articulos descargados", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.deleteArticulos -> {
                deleteAllArticulos()   // borra los clientes de la bd
              //  playToRunnable()   //    Renderiza nuevamente los clientes
                Toast.makeText(applicationContext, "Borra los datos de la base de datos", Toast.LENGTH_LONG).show()
                return true
            }

            else -> super.onOptionsItemSelected(item)
        }//Fin del when
    }// en onOptionItemSelected


    //trunca los datos de la tabla clientes
    private fun deleteAllArticulos(){
        val status = databaseHandler.truncateTableArtuculos()
        Toast.makeText(applicationContext, "Total de clientes ELIMINADOS ${status}", Toast.LENGTH_LONG).show()
    }


    // EN OTRA CLASE
    //Ejecuta la funcion que descarga clientes y los almacena en la base de datos
    private fun downloadArticulosToDatabase(){
        //   val conteo = databaseHandler.getClientesFromApiToInsertInTableClientes()
        val conteo= databaseHandler.getFakeDataToInsertInTableArticulos()
        Toast.makeText(applicationContext, "El conteo de articulos es ${conteo}", Toast.LENGTH_LONG).show()
    }









}
