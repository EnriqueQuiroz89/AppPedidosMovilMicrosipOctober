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
import example.javatpoint.com.apppedidosmovilmicrosip.DataModel.Clientes
import example.javatpoint.com.apppedidosmovilmicrosip.DataModel.Posts
import example.javatpoint.com.apppedidosmovilmicrosip.Interfaces.JsonPlaceHolderApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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
                    }

    override fun onCreate(db: SQLiteDatabase?) {
        // CREATE DATABABASE JsonsDataBase
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

        // ejecuta la sentencia
        db?.execSQL(CREATE_CLIENTS_TABLE)
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

    // ELIMINA EL CONTENIDO DE LA TABLA CLIENTES
    fun truncateTableClientes():Int{
        val db = this.writableDatabase
        // Deleting Row MEDIANTE  el metodo delete de la clase SQLiteDatabase
        val success = db.delete(TABLE_CLIENTES,null,null)
        //2nd argument is String containing nullColumnHack
        db.close() // Closing database connection
        return success
    }

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














}



