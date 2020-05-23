package example.javatpoint.com.apppedidosmovilmicrosip.EstructuraTablas

class EstructuraTablasSql{


    fun createTableClientes():String{

        // campos de la base de datos
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

       return  CREATE_CLIENTS_TABLE
                                     }

    fun createTableArticulos():String {

        // campos de la base de datos
        val TABLE_ARTICULOS    = "ArticulosTable"
        val KEY_ID_ARTICULO    = "id_articulo"
        val KEY_CLAVE_PRINCIPAL= "clave_principal"
        val KEY_CLAVE_ALTERNA  = "clave_alterna"
        val KEY_NOMBRE_ARTICULO= "nombre_articulo"
     val KEY_PRECIO_DITRIBUIDOR= "precio_distribuidor"
        val KEY_IMPUESTO      = "tasa_impuesto"
        val KEY_EXISTENCIA     = "existencia"

        // sentencia a ejecutar para crear la tabla
        val CREATE_ARTICULOS_TABLE=("CREATE TABLE " + TABLE_ARTICULOS + "("
                + KEY_ID_ARTICULO    +" INTEGER PRIMARY KEY, "
                + KEY_CLAVE_PRINCIPAL +" TEXT,"
                + KEY_CLAVE_ALTERNA   +" TEXT,"
                + KEY_NOMBRE_ARTICULO   +" TEXT,"
                + KEY_PRECIO_DITRIBUIDOR +" TEXT,"
                + KEY_IMPUESTO      +" TEXT,"
                + KEY_EXISTENCIA    +" TEXT) ")

        return  CREATE_ARTICULOS_TABLE

    }




    }