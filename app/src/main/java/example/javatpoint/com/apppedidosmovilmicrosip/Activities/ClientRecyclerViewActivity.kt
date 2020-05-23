package example.javatpoint.com.apppedidosmovilmicrosip.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.SearchView
//import androidx.appcompat.widget.SearchView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.lifecycle.Observer
import example.javatpoint.com.apppedidosmovilmicrosip.Adapters.DatabaseHandler
import example.javatpoint.com.apppedidosmovilmicrosip.Adapters.RecyclerAdapter
import example.javatpoint.com.apppedidosmovilmicrosip.DataModel.Clientes
import example.javatpoint.com.apppedidosmovilmicrosip.DataModel.Posts
import example.javatpoint.com.apppedidosmovilmicrosip.FakeDataToDB.FillTablesDataFake
import example.javatpoint.com.apppedidosmovilmicrosip.Interfaces.JsonPlaceHolderApi
import example.javatpoint.com.apppedidosmovilmicrosip.R
import example.javatpoint.com.apppedidosmovilmicrosip.StatusDevice.NetworkInfo
import kotlinx.android.synthetic.main.activity_client_recyclerview.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import kotlin.collections.ArrayList

class ClientRecyclerViewActivity : AppCompatActivity() {

    val titulo = "Listado de Clientes"

//Importante declarar un solo adaptador en la clase =,)
    private lateinit var mAdapter: RecyclerAdapter
// Importante declarar una sola ArrayList sobre la cual trabajar
    private lateinit var listaClientes : ArrayList<Clientes>
// Lista ue se llenara con datos falsos
    private lateinit var listaClientesFake : ArrayList<Clientes>
// Probar con utilizar una sola intancia del DatabaseHandler
    private val databaseHandler= DatabaseHandler(this)

    // Para renderizado liego de actualizar clientes

    private lateinit var mRandom: Random

    private lateinit var mHandler: Handler

    private lateinit var mRunnable: Runnable


    // VERIFICAR LA CONEXION



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client_recyclerview)
        //le da un nombre a la actividad
        this.setTitle(R.string.activity_clientes)
//Este metodo llena al ArrayList<Clientes> con los datos de la base datos
 fillListaClientes()
//Llena los datos con datos estaticos y falsos
//  fillListaClientesFake()
// This metodo configura la vista de los Clientes en el RecyclerView
  setUpRecyclerView()
//accion de actualizar
   actionRefresh()


                                                       }

// habilita 

    fun checkInternet(){
        val networkConnection = NetworkInfo(applicationContext)
        networkConnection.observe(this, Observer { isConnected->

            if(isConnected){
                Toast.makeText(applicationContext, "CONEXION ACTIVA", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(applicationContext, "CONEXION INACTIVA", Toast.LENGTH_LONG).show()
            }
        })

    }


    fun actionRefresh(){
        // Inicialize a new Random instante
        mRandom= Random()

        // Inicialize the handler instance
        mHandler = Handler()
        //Set an on refresh listener for swipe refresh layout
     swipeRefreshLayout.setOnRefreshListener {
          playToRunnable()
                                             }
                         }//fin de actionRefresh()


    //refresca los elementos de la pantalla luego de descargar o borrar clientes
    private fun playToRunnable(){  //inicializa un nuevo runnable
        mRunnable= Runnable {
            //invoca el Renderizado nuevamente
          //  showClientesOnRecyclerView()
            //invoca el Renderizado nuevamente
            setUpRecyclerView()
            //Oculta el icono animado de "arrastra para refrescar"
            swipeRefreshLayout.isRefreshing= false
                            }// fin de Runnable
        // Ejecuta la tarea despues del tiempo especificado

        mHandler.postDelayed(mRunnable,3000.toLong())// Despues de un segundo, renderiza el listado nuevamente
                               } // fin del runnable


    fun fillListaClientesFake():ArrayList<Clientes>{

        val fillTablesDataFake = FillTablesDataFake()
        listaClientesFake= fillTablesDataFake.fillListaClientes()


        return listaClientesFake
    }

    //  llena de Objetos "Cliente" que provienen de la base de datos el ArrayList listaClientes y la devuelve llena
    fun fillListaClientes(): ArrayList<Clientes>{
        listaClientes= databaseHandler.viewClientesForRecycler()
        return listaClientes      } //retorna a la lista llena de datos



    // Con este metodo se renderiza el RecylclerView con los objetos de listaClientes
    private fun setUpRecyclerView(){
        //Busca el RecyclerView declarado en la vista y lo asigna a un recyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.aclRvClientes)
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
        mAdapter= RecyclerAdapter(listaClientes,this)

   // asigna adaptador a RecyclerView
        recyclerView.adapter= mAdapter
                                 }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.search_menu,menu)

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

            R.id.downloadClientes -> {
                downloadClientesToDatabase()  // descarga los clientes del api y los guarda en BD
               playToRunnable()        // renderiza clientes nuevamente
                Toast.makeText(applicationContext, "Clientes descargados", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.borrarClientes -> {
                deleteAllClientes()   // borra los clientes de la bd
              playToRunnable()   //    Renderiza nuevamente los clientes
                Toast.makeText(applicationContext, "Borra los datos de la base de datos", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.showClientes -> {
                showClientesOnRecyclerView()
                Toast.makeText(applicationContext, "Muestro los clientes", Toast.LENGTH_LONG).show()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }//Fin del when
    }// en onOptionItemSelected



    private fun showClientesOnRecyclerView(){

        // Asigna un LayoutManager al RecyclerView en ActivityShowRecyclerViewFotos
        aclRvClientes.layoutManager = LinearLayoutManager(this)
        aclRvClientes.setHasFixedSize(true)

        // Crea el objeto del manejador de Base de datos
        val databaseHandler= DatabaseHandler(this)

     /*           SUPER IMPORTANTE
        // llamando la funcion viewEmployeForRecycler del DatabaseHandler para leer los registros
        // este metodo devuelve un ArrayList que ocupa
        val emp: ArrayList<Clientes> = databaseHandler.viewClientesForRecycler()
        aclRvClientes.adapter = RecyclerAdapter(emp, this)
       */
        aclRvClientes.adapter = RecyclerAdapter(listaClientesFake, this)

    }



//trunca los datos de la tabla clientes
    private fun deleteAllClientes(){
        val status = databaseHandler.truncateTableClientes()
        Toast.makeText(applicationContext, "Total de clientes ELIMINADOS ${status}", Toast.LENGTH_LONG).show()
                                  }



    // EN OTRA CLASE
    //Ejecuta la funcion que descarga clientes y los almacena en la base de datos
       private fun downloadClientesToDatabase(){
     //   val conteo = databaseHandler.getClientesFromApiToInsertInTableClientes()
         val conteo= databaseHandler.getFakeDataToInsertInTableClientes()
        Toast.makeText(applicationContext, "TEl conteo arrojo ${conteo}", Toast.LENGTH_LONG).show()
                                   }



}// end class