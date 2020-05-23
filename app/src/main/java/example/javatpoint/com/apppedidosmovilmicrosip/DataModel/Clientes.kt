package example.javatpoint.com.apppedidosmovilmicrosip.DataModel

import java.io.Serializable

// Atributos que maneja timobile para un cliente
data class Clientes(val id_cliente:Int,
                    val nombre_cliente: String,
                    val vendedor_id:Int,
                    var cobrador_id:Int,
                    var clave_cliente: String,
                    var direccion: String,
                    var poblacion: String,
                    var colonia: String,
                    var limiteCredito:Double,
                    var saldo:Double,
                    var latitud: Double,
                    var longitud: Double):Serializable