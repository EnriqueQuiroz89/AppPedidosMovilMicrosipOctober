package example.javatpoint.com.apppedidosmovilmicrosip.Adapters

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.view.View
import android.widget.Toast
import example.javatpoint.com.apppedidosmovilmicrosip.DataModel.*
import example.javatpoint.com.apppedidosmovilmicrosip.EstructuraTablas.EstructuraTablasSql
import example.javatpoint.com.apppedidosmovilmicrosip.FakeDataToDB.FillTablesDataFake
import example.javatpoint.com.apppedidosmovilmicrosip.Interfaces.JsonPlaceHolderApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.sql.Date
import java.util.*
import java.util.zip.DeflaterOutputStream


class DatabaseHandler(context: Context)
    : SQLiteOpenHelper(context,
    DATABASE_NAME, null,
    DATABASE_VERSION)
{
    companion object{
    val DATABASE_VERSION=1
    val DATABASE_NAME= "VentaMobil"
    val TABLE_CLIENTES= "ClientesTable"
    val KEY_ID_CLIENTE= "id_cliente"
    val KEY_NOMBRE_CLIENTE = "nombre_cliente"
    val KEY_VENDEDOR_ID= "vendedor_id"
    val KEY_COBRADOR_ID= "cobrador_id"
    val KEY_CLAVE_CLIENTE= "clave_cliente"
    val KEY_DIRECCION = "direccion"
    val KEY_POBLACION = "poblacion"
    val KEY_COLONIA = "colonia"
    val KEY_LIMITE_CREDITO = "limite_credito"
    val KEY_SALDO = "saldo"
    val KEY_LATITUD= "latitud"
    val KEY_LONGITUD= "longitud"

   //TABLA ARTICULOS
    val TABLE_ARTICULOS    = "ArticulosTable"
    val KEY_ID_ARTICULO    = "id_articulo"
    val KEY_CLAVE_PRINCIPAL= "clave_principal"
    val KEY_CLAVE_ALTERNA  = "clave_alterna"
    val KEY_NOMBRE_ARTICULO= "nombre_articulo"
    val KEY_PRECIO_DITRIBUIDOR= "precio_distribuidor"
    val KEY_IMPUESTO      = "tasa_impuesto"
    val KEY_EXISTENCIA     = "existencia"

     //TABLA PEDIDOS
  val TABLE_PEDIDOS    = "PedidosTable"
  val KEY_ID_PEDIDO    = "id_pedido"
  val KEY_FOLIO_PEDIDO = "folio"
  val KEY_FECHA        = "fecha"
  val KEY_ALMACEN      = "almacen"
  val KEY_IMPORTE_PEDIDO  = "importe"
  val KEY_IMPUESTO_PEDIDO = "impuesto"
  val KEY_ID_VENDEDOR_PEDIDO      = "id_vendedor"
  val KEY_ID_CLIENTE_PEDIDO       = "id_cliente"
  val KEY_NOMBRE_VENDEDOR_PEDIDO  = "nombre_vendedor"
  val KEY_NOMBRE_CLIENTE_PEDIDO   = "nombre_cliente"
  val KEY_STATUS                  = "status"
  val KEY_ID_LISTA_PARTIDAS       = "id_lista_partidas"

                    }

    // se instancia la clase que guarda todos los Fake data
    // De aqui se obtienen los datos falsos predefinidos
    val fillTablesDataFake = FillTablesDataFake()

   // esye metodo crea las Tablas
    override fun onCreate(db: SQLiteDatabase?) {

      // trae la esctructura para crear la tabla clientes
        val creaTablaClientes= createTableClientes()
        val creaTablaArticulos= createTableArticulos()
        val creaTablaPedidos = createTablePedidos()

      // Ejeuta la creacion de las tablas
     //   db?.execSQL(CREATE_CLIENTS_TABLE)
         db?.execSQL(creaTablaClientes)
         db?.execSQL(creaTablaArticulos)
         db?.execSQL(creaTablaPedidos)

   }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        // obliga a que db sea no nula
        // borra la tabla si existe para actualizarla
        db!!.execSQL("DROP TABLE IF EXISTS "+ TABLE_CLIENTES)
        onCreate(db)
    }

    // LLENA un ArrayList con los registros de la tabla CLIENTES
    //method to read data
    fun viewClientesForRecycler():ArrayList<Clientes>{

        //declaro el ArrayList que servira de almacen a los datos consultados
        val clientesList:ArrayList<Clientes> = ArrayList<Clientes>()
        // Hago la consulta a la base de datos
        val selectQuery = "SELECT  * FROM $TABLE_CLIENTES"
        // Permite la lectura de la base de datos
        val db = this.readableDatabase
        // el cursor es el lente que saltara de resgitro en regitro leyendo los datos
        var cursor: Cursor?

        try{ // rewQuery Facillita la escritura de la consulta
            cursor = db.rawQuery(selectQuery, null) // ejecuta la consulta
        }catch (e: SQLiteException) {  // cacha la excepcion si la hubiera
            db.execSQL(selectQuery)  // y ejecuta la query
            return ArrayList()
        }
        // variables para separar los datos arrojados por la consulta
        // de preferencia que coincidan con los nombres de los campos de la BD
        var idCliente:Int
        var nombreCliente: String
        var vendedorId: Int
        var cobradorId: Int
        var claveCliente: String
        var direccion: String
        var poblacion: String
        var colonia: String
        var limiteCredito:Double
        var saldo:Double
        var latitud: Double
        var longitud: Double
        // si encuntra un primer registro posiciona al cursor en el
        if (cursor.moveToFirst()) {
            do {

            idCliente= cursor.getInt(cursor.getColumnIndex("id_cliente"))
            nombreCliente = cursor.getString(cursor.getColumnIndex("nombre_cliente"))
            vendedorId = cursor.getInt(cursor.getColumnIndex("vendedor_id"))
            cobradorId = cursor.getInt(cursor.getColumnIndex( "cobrador_id"))
            claveCliente= cursor.getString(cursor.getColumnIndex("clave_cliente"))
            direccion= cursor.getString(cursor.getColumnIndex("direccion"))
            poblacion = cursor.getString(cursor.getColumnIndex("poblacion"))
            colonia= cursor.getString(cursor.getColumnIndex("colonia"))
            limiteCredito= cursor.getDouble(cursor.getColumnIndex("limite_credito"))
            saldo= cursor.getDouble(cursor.getColumnIndex("saldo"))
            latitud= cursor.getDouble(cursor.getColumnIndex("latitud"))
            longitud= cursor.getDouble(cursor.getColumnIndex("longitud"))

                // Construye un objeto de tipo post en base al resultado de la consulta
                val cliente= Clientes(idCliente,
                                      nombreCliente,
                                      vendedorId,
                                      cobradorId,
                                      claveCliente,
                                      direccion,
                                      poblacion,
                                      colonia,
                                      limiteCredito,
                                      saldo,
                                      latitud,
                                      longitud)
                // agrega el objeto construido al ArrayList
                clientesList.add(cliente)
                //y Siempre y cuando haya otro registro que ller mueve el cursor al siguiente
            } while (cursor.moveToNext())
        }
        return clientesList
    }

    // LLENA un ArrayList con los registros de la tabla ARTICULOS
    //method to read data
    fun showArticulosFromDB():ArrayList<Articulos>{

        //declaro el ArrayList que servira de almacen a los datos consultados
        val articulosList:ArrayList<Articulos> = ArrayList()
        // Hago la consulta a la base de datos
        val selectQuery = "SELECT  * FROM $TABLE_ARTICULOS"
        // Permite la lectura de la base de datos
        val db = this.readableDatabase
        // el cursor es el lente que saltara de resgitro en regitro leyendo los datos
        var cursor: Cursor?

        try{ // rewQuery Facillita la escritura de la consulta
            cursor = db.rawQuery(selectQuery, null) // ejecuta la consulta
        }catch (e: SQLiteException) {  // cacha la excepcion si la hubiera
            db.execSQL(selectQuery)  // y ejecuta la query
            return ArrayList()
        }
        // variables para separar los datos arrojados por la consulta
        // de preferencia que coincidan con los nombres de los campos de la BD
        var idArticulo:Int
        var clavePrincipal: String
        var claveAlterna: String
        var nombreArticulo: String
        var precioDistribuidor: Double
        var impuesto: Double
        var existencia: Double

        if (cursor.moveToFirst()) {
            do {

                idArticulo= cursor.getInt(cursor.getColumnIndex("id_articulo"))
                clavePrincipal = cursor.getString(cursor.getColumnIndex("clave_principal"))
                claveAlterna = cursor.getString(cursor.getColumnIndex("clave_alterna"))
                nombreArticulo = cursor.getString(cursor.getColumnIndex( "nombre_articulo"))
                precioDistribuidor= cursor.getDouble(cursor.getColumnIndex("precio_distribuidor"))
                impuesto= cursor.getDouble(cursor.getColumnIndex("tasa_impuesto"))
                existencia = cursor.getDouble(cursor.getColumnIndex("existencia"))

                // Construye un objeto de tipo post en base al resultado de la consulta
                val articulo= Articulos(
                    idArticulo,
                    clavePrincipal,
                    claveAlterna,
                    nombreArticulo,
                    precioDistribuidor,
                    impuesto,
                    existencia)
                // agrega el objeto construido al ArrayList
                articulosList.add(articulo)
                //y Siempre y cuando haya otro registro que ller mueve el cursor al siguiente
            } while (cursor.moveToNext())
        }
        return articulosList
    }

    // LLENA un ArrayList con los registros de la tabla ARTICULOS
    //method to read data
    fun showPedidosFromDB():ArrayList<Pedidos>{

        //declaro el ArrayList que servira de almacen a los datos consultados
        val pedidosList:ArrayList<Pedidos> = ArrayList()
        // Hago la consulta a la base de datos
        val selectQuery = "SELECT  * FROM $TABLE_PEDIDOS"
        // Permite la lectura de la base de datos
        val db = this.readableDatabase
        // el cursor es el lente que saltara de resgitro en regitro leyendo los datos
        var cursor: Cursor?

        try{ // rewQuery Facillita la escritura de la consulta
            cursor = db.rawQuery(selectQuery, null) // ejecuta la consulta
        }catch (e: SQLiteException) {  // cacha la excepcion si la hubiera
            db.execSQL(selectQuery)  // y ejecuta la query
            return ArrayList()
        }
        // variables para separar los datos arrojados por la consulta
        // de preferencia que coincidan con los nombres de los campos de la BD

        var idPedido: Int
        var folio:String
        var fecha: Int
        var almacen: String
        var importe:Double
        var impuesto: Double
        var idVendedor: Int
        var nombreVendedor: String
        var idCliente: Int
        var nombreCliente: String
        var estatus: String
        var idListaPartida:Int

        var listaPartidas:MutableList<PartidaPedido>

        // se instancia un objeto para traer datso falsos y estaticos y
        // completar el objeto pedido
        // pero hace falta una funcion que en base al idListaPartida contenido en la base de datos
        // pueda ser capaz de devolver un ArrayList<PartidasPedido> asociado con el Pedido
        var fillTablesDataFake = FillTablesDataFake()
            listaPartidas = fillTablesDataFake.fillListaPartidasCuatro()

        if (cursor.moveToFirst()) {
            do {

        idPedido= cursor.getInt(cursor.getColumnIndex("id_pedido"))
    //    folio = cursor.getString(cursor.getColumnIndex("folio"))
    //    fecha = cursor.getInt(cursor.getColumnIndex("fecha"))
    //    almacen = cursor.getString(cursor.getColumnIndex("almacen"))
    //    importe = cursor.getDouble(cursor.getColumnIndex( "importe"))
    //    impuesto= cursor.getDouble(cursor.getColumnIndex("impuesto"))
    //    idVendedor= cursor.getInt(cursor.getColumnIndex("id_vendedor"))
     //   nombreVendedor = cursor.getString(cursor.getColumnIndex("nombre_vendedor"))
     //   idCliente= cursor.getInt(cursor.getColumnIndex("id_cliente"))
     //   nombreCliente = cursor.getString(cursor.getColumnIndex("nombre_cliente"))
     //   estatus = cursor.getString(cursor.getColumnIndex("estatus"))
        idListaPartida = cursor.getInt(cursor.getColumnIndex("id_lista_partidas"))


                // Construye un objeto de tipo post en base al resultado de la consulta
                val pedido= Pedidos(
                    idPedido,
              //      folio,
              //      fecha,

               //     Date(2020, 2, 13, 5, 1, 0),
                //    almacen,
                //    importe,
                //    impuesto,
                //    idVendedor,
                //    nombreVendedor,
                //    idCliente,
                //    nombreCliente,
                //    estatus,
                    idListaPartida,
                    listaPartidas
                    )

                // agrega el objeto construido al ArrayList
                pedidosList.add(pedido)
                //y Siempre y cuando haya otro registro que ller mueve el cursor al siguiente
            } while (cursor.moveToNext())
        }
        return pedidosList
    }


    // ELIMINA EL CONTENIDO DE LA TABLA CLIENTES
    fun truncateTableClientes():Int{
        val db = this.writableDatabase
        // Deleting Row MEDIANTE  el metodo delete de la clase SQLiteDatabase
        val success = db.delete(TABLE_CLIENTES,null,null)
        //2nd argument is String containing nullColumnHack
        db.close() // Closing database connection
        return success             }

    // ELIMINA EL CONTENIDO DE LA TABLA ES
    fun truncateTableArtuculos():Int{
        val db = this.writableDatabase
        // Deleting Row MEDIANTE  el metodo delete de la clase SQLiteDatabase
        val success = db.delete(TABLE_ARTICULOS,null,null)
        //2nd argument is String containing nullColumnHack
        db.close() // Closing database connection
        return success             }

    // ELIMINA EL CONTENIDO DE LA TABLA ES
    fun truncateTablePedidos():Int{
        val db = this.writableDatabase
        // Deleting Row MEDIANTE  el metodo delete de la clase SQLiteDatabase
        val success = db.delete(TABLE_PEDIDOS,null,null)
        //2nd argument is String containing nullColumnHack
        db.close() // Closing database connection
        return success             }


    // al indicar como entrada un objeto del tipo POST declaramos la estructura de lo que
    // compondra el renglon de datos sin asignar nada aun
    fun addCliente(cliente: Clientes):Long{

        // usa el this para meter en conetxto la variable
        val db = this.writableDatabase
        val contentValues = ContentValues()

        //asigncion de valores en un content value
        contentValues.put(KEY_ID_CLIENTE,    cliente.id_cliente)
        contentValues.put(KEY_NOMBRE_CLIENTE,cliente.nombre_cliente)
        contentValues.put(KEY_VENDEDOR_ID,   cliente.vendedor_id)
        contentValues.put(KEY_COBRADOR_ID,   cliente.cobrador_id)
        contentValues.put(KEY_CLAVE_CLIENTE, cliente.clave_cliente)
        contentValues.put(KEY_DIRECCION ,    cliente.direccion)
        contentValues.put(KEY_POBLACION ,    cliente.poblacion)
        contentValues.put(KEY_COLONIA ,      cliente.colonia)
        contentValues.put(KEY_LIMITE_CREDITO,cliente.limiteCredito)
        contentValues.put(KEY_SALDO ,        cliente.saldo)
        contentValues.put(KEY_LATITUD ,      cliente.latitud)
        contentValues.put(KEY_LONGITUD ,     cliente.longitud)

        // INSERTANDO UN RENGLON DE DATOS
        val success = db.insert(TABLE_CLIENTES,
                 null,
                                contentValues)
        //despues de insrtar cierra la base de datos
        db.close()
        // retorna un valor numerico que es la clave de respuesta
        return  success
                                      }

    // al indicar como entrada un objeto del tipo POST declaramos la estructura de lo que
    // compondra el renglon de datos sin asignar nada aun
    fun addArticulo(articulo: Articulos):Long{

        // usa el this para meter en conetxto la variable
        val db = this.writableDatabase
        val contentValues = ContentValues()

        //asigncion de valores en un content value
        contentValues.put(KEY_ID_ARTICULO    ,    articulo.idArticulo)
        contentValues.put(KEY_CLAVE_PRINCIPAL,    articulo.clavePrincipal)
        contentValues.put(KEY_CLAVE_ALTERNA  ,    articulo.claveAlterna)
        contentValues.put(KEY_NOMBRE_ARTICULO,    articulo.nombreArticulo)
        contentValues.put(KEY_PRECIO_DITRIBUIDOR, articulo.precioDistribuidor)
        contentValues.put(KEY_IMPUESTO          , articulo.impuesto)
        contentValues.put(KEY_EXISTENCIA        , articulo.existencia)

        // INSERTANDO UN RENGLON DE DATOS
        val success = db.insert(
            TABLE_ARTICULOS,
            null,
            contentValues)
        //despues de insrtar cierra la base de datos
        db.close()
        // retorna un valor numerico que es la clave de respuesta
        return  success
    }

    // al indicar como entrada un objeto del tipo POST declaramos la estructura de lo que
    // compondra el renglon de datos sin asignar nada aun
    fun addPedido(pedido: Pedidos):Long{

        // usa el this para meter en conetxto la variable
        val db = this.writableDatabase
        val contentValues = ContentValues()

        //asigncion de valores en un content value
        contentValues.put(KEY_ID_PEDIDO             , pedido.idPedido)
    //    contentValues.put(KEY_FOLIO_PEDIDO          , pedido.folio)
       // IInserta la fecha con un metodo
     //   contentValues.put(KEY_FECHA                 , System.currentTimeMillis())
     //   contentValues.put(KEY_FECHA                 , pedido.fecha)
     ///   contentValues.put(KEY_ALMACEN               , pedido.almacen)
    //    contentValues.put(KEY_IMPORTE_PEDIDO        , pedido.estatus)
    //    contentValues.put(KEY_IMPUESTO_PEDIDO       , pedido.idCliente)
    //    contentValues.put(KEY_ID_VENDEDOR_PEDIDO    , pedido.idVendedor)
    //    contentValues.put(KEY_ID_CLIENTE_PEDIDO     , pedido.nombreCliente)
    //    contentValues.put(KEY_NOMBRE_VENDEDOR_PEDIDO, pedido.nombreVendedor)
    //   contentValues.put(KEY_NOMBRE_CLIENTE_PEDIDO  , pedido.nombreVendedor)
    //    contentValues.put(KEY_STATUS                , pedido.estatus)
        contentValues.put(KEY_ID_LISTA_PARTIDAS     , pedido.idListPartida)


/*
        //asigncion de valores en un content value
        contentValues.put(KEY_ID_PEDIDO             , pedido.idPedido)
        contentValues.put(KEY_FOLIO_PEDIDO          , "LU2345")
        contentValues.put(KEY_FECHA                 , 1212)
        contentValues.put(KEY_ALMACEN               ,"Truper")
        contentValues.put(KEY_IMPORTE_PEDIDO        , 1456.04)
        contentValues.put(KEY_IMPUESTO_PEDIDO       , 16.0)
        contentValues.put(KEY_ID_VENDEDOR_PEDIDO    , 3295)
        contentValues.put(KEY_ID_CLIENTE_PEDIDO     , 4562)
        contentValues.put(KEY_NOMBRE_VENDEDOR_PEDIDO, "Moises Pulido")
        contentValues.put(KEY_NOMBRE_CLIENTE_PEDIDO  , "Ramiro Peña")
        contentValues.put(KEY_STATUS                , "Pendiente")
        contentValues.put(KEY_ID_LISTA_PARTIDAS     , 5)
*/

        // INSERTANDO UN RENGLON DE DATOS
        val success = db.insert(
            TABLE_PEDIDOS,
            null,
            contentValues)
        //despues de insrtar cierra la base de datos
        db.close()
        // retorna un valor numerico que es la clave de respuesta
        return  success
    }




    // LLena la tabla con datos que vienen de la clase FillTablesDataFake
    // simulando un API REST
        fun getFakeDataToInsertInTableClientes():Long?{

        val listaclientes= fillTablesDataFake.fillListaClientes()
        var status:Long=0

        // Recorre el objeto que almaceno la respuesta del server API
        for (cliente in listaclientes) {
            //EN cada ciclo realiza la insercion de un Post con el
            // metodo addCliente del DatabaseHandler
            status = addCliente(
                Clientes(cliente.id_cliente,            // id cliente
                         cliente.nombre_cliente,         //nombre_cliente
                         cliente.vendedor_id,            //vendedor_id
                         cliente.cobrador_id,            //cobrador_id
                         cliente.clave_cliente,         //clave_cliente
                         cliente.direccion,         //direccion
                         cliente.poblacion,         // poblacion
                         cliente.colonia,         //colonia
                         cliente.limiteCredito,//limiteCredito
                         cliente.saldo,//saldo
                         cliente.latitud,//latitud
                         cliente.longitud     //longitud
                         )// Fin objeto cliente
                                )// fin metodo add
        } // fin del for
        Log.println(Log.INFO, "Results ", "Resultado de la ejecucion " + status  )
        return status    }


    // LLena la tabla con datos que vienen de la clase FillTablesDataFake
    // simulando un API REST
      fun getFakeDataToInsertInTableArticulos():Long?{

        val listaArticulos= fillTablesDataFake.fillListaArticulos()
        var status:Long=0

        // Recorre el objeto que almaceno la respuesta del server API
        for (articulo in listaArticulos) {
            //EN cada ciclo realiza la insercion de un Post con el
            // metodo addCliente del DatabaseHandler
            status = addArticulo(
                Articulos(articulo.idArticulo,             // id_articulo
                          articulo.clavePrincipal,         //clave
                          articulo.claveAlterna,
                          articulo.nombreArticulo,
                          articulo.precioDistribuidor,
                          articulo.impuesto,
                          articulo.existencia
                         )// Fin objeto articulo
                                )// fin metodo add
                                          } // fin del for
        Log.println(Log.INFO, "Results ", "Resultado de la ejecucion " + status  )
        return status    }



    // LLena la tabla con datos que vienen de la clase FillTablesDataFake
    // simulando un API REST
    fun getFakeDataToInsertInTablePedidos():Long?{

        val listaPedidos= fillTablesDataFake.fillListaPedidos()
        var status:Long=0

        // Recorre el objeto que almaceno la respuesta del server API
        for (pedido in listaPedidos) {
            //EN cada ciclo realiza la insercion de un Post con el
            // metodo addCliente del DatabaseHandler
            status = addPedido(
                Pedidos(pedido.idPedido,             // id_articulo

                  /*      pedido.folio,
                       123,
                        pedido.almacen,//clave,
                        pedido.importe,
                        pedido.impuesto,
                        pedido.idVendedor,
                        pedido.nombreVendedor,
                        pedido.idCliente,
                        pedido.nombreCliente,
                        pedido.estatus,
                        pedido.idListPartida,
                        pedido.listaPartidas
                   */
                        pedido.idListPartida,
                    pedido.listaPartidas
                       )// Fin objeto articulo
            )// fin metodo add
        } // fin del for
        Log.println(Log.INFO, "Results ", "Resultado de la ejecucion " + status  )
        return status    }


    // esta funcion conceta con un API REST real en internet y guarda los datos en SQULITE
    // Accion al presosnar boton insert to table
    fun getClientesFromApiToInsertInTableClientes():Long? {

        // Se inicializa la variable que guarda el retorno de el metodo
        // agregarPost   addPost
        var status:Long=0

        // Como se expresa se declara un constructor y se le asigana la base de la URL del API
        // solo funciona si termina con diagonal la baseURL
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")// Se asigna la base de la URL de la api
            .addConverterFactory(GsonConverterFactory.create()) // aqui agregamos a Gson para convertir los datos
            .build()
        // ¿Donde va a buscar? En donde indicamos en la Intefaz JsonPlaceHolder APi
        // ¿Que va a buscar?  Va a buscar la informacion que coincide con el modelo de datos de Posts

        // paso 4 LLamar a la interfaz
        // Se instancia un objeto de la intefza y con Retrofin?
        val jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi::class.java)

        // el post del final viene de la interfaz JsonPlaceHolder
        val call = jsonPlaceHolderApi.post



        // llama al encolamiento
        call.enqueue(object : Callback<List<Posts>> {
            override fun onResponse(call: Call<List<Posts>>, response: Response<List<Posts>>) {

                // si el response marca algun erro HTTP
                if (!response.isSuccessful) {   // muestra que error HTML salio en la conexion
                    //    Toast.makeText(applicationContext, "record save", Toast.LENGTH_LONG).show()
                    return                  }

                //  Se llena una constante con la respuesta del Servidor API REST
                val postsList = response.body()  //No confundir con el campo body de el JSON



                // Recorre el objeto que almaceno la respuesta del server API
                for (post in postsList!!) {
                    //EN cada ciclo realiza la insercion de un Post con el
                    // metodo addCliente del DatabaseHandler
                    status = addCliente(
                        Clientes(post.id,            // id cliente
                            post.title,         //nombre_cliente
                            post.id,            //vendedor_id
                            post.id,            //cobrador_id
                            post.title,         //clave_cliente
                            post.title,         //direccion
                            post.title,         // poblacion
                            post.body,         //colonia
                            post.userId.toDouble(),//limiteCredito
                            post.userId.toDouble(),//saldo
                            post.userId.toDouble(),//latitud
                            post.id.toDouble()     //longitud
                        )// Fin objeto cliente
                                      )// fin metodo add
                   //    Log.println(Log.INFO, "Results ", "Resultado de la ejecucion " + status  )
                } // fin del for


            } // fin del onResponse

            override fun onFailure(call: Call<List<Posts>>, t: Throwable) {}
        })     // FIN DEL enqueue e(Encolamiento)

           Log.println(Log.INFO, "Results ", "Resultado de la ejecucion " + status  )

        return status

    }// fin del metodo


// aqui se declara la creacion de Tablas
    fun createTableClientes():String{
        // sentencia a ejecutar para crear la tabla
        val CREATE_CLIENTS_TABLE=("CREATE TABLE " + TABLE_CLIENTES + "("
                + KEY_ID_CLIENTE    +" INTEGER PRIMARY KEY, "
                + KEY_NOMBRE_CLIENTE +" TEXT,"
                + KEY_VENDEDOR_ID   +" TEXT,"
                + KEY_COBRADOR_ID   +" TEXT,"
                + KEY_CLAVE_CLIENTE +" TEXT,"
                + KEY_DIRECCION     +" TEXT,"
                + KEY_POBLACION     +" TEXT,"
                + KEY_COLONIA       +" TEXT, "
                + KEY_LIMITE_CREDITO+" REAL, "
                + KEY_SALDO         +" REAL, "
                + KEY_LATITUD       +" REAL, "
                + KEY_LONGITUD      +" REAL) ")
        return  CREATE_CLIENTS_TABLE  }


    fun createTableArticulos():String {
        // sentencia a ejecutar para crear la tabla
        val CREATE_ARTICULOS_TABLE=("CREATE TABLE " + TABLE_ARTICULOS + "("
                + KEY_ID_ARTICULO       +" INTEGER PRIMARY KEY, "
                + KEY_CLAVE_PRINCIPAL   +" TEXT,"
                + KEY_CLAVE_ALTERNA     +" TEXT,"
                + KEY_NOMBRE_ARTICULO   +" TEXT,"
                + KEY_PRECIO_DITRIBUIDOR+" REAL,"
                + KEY_IMPUESTO          +" REAL,"
                + KEY_EXISTENCIA        +" REAL) ")
        return  CREATE_ARTICULOS_TABLE    }


    fun createTablePedidos():String {
        // sentencia a ejecutar para crear la tabla
        val CREATE_PEDIDOS_TABLE=("CREATE TABLE " + TABLE_PEDIDOS + "("
      //          + KEY_ID_PEDIDO             +" INTEGER PRIMARY KEY, "
                + KEY_ID_PEDIDO             +" INTEGER PRIMARY KEY, "

/*              + KEY_FOLIO_PEDIDO          +" TEXT, "
                + KEY_FECHA                 +" INTEGER,"
                + KEY_ALMACEN               +" TEXT,"
                + KEY_IMPORTE_PEDIDO        +" REAL,"
                + KEY_IMPUESTO_PEDIDO       +" REAL,"
                + KEY_ID_VENDEDOR_PEDIDO    +" INTEGER,"
                + KEY_NOMBRE_VENDEDOR_PEDIDO+" TEXT,"
                + KEY_ID_CLIENTE_PEDIDO     +" INTEGER,"
                + KEY_NOMBRE_CLIENTE_PEDIDO +" TEXT,"
                + KEY_STATUS                +" TEXT,"
 */
                + KEY_ID_LISTA_PARTIDAS     +" INTEGER) ")
        return  CREATE_PEDIDOS_TABLE    }



}



