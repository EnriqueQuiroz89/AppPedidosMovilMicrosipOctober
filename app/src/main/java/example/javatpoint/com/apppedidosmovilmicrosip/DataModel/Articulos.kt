package example.javatpoint.com.apppedidosmovilmicrosip.DataModel

import java.io.Serializable
import java.nio.file.attribute.GroupPrincipal

data class Articulos(val idArticulo:Int,
                    val clavePrincipal: String,
                    val claveAlterna: String,
                    val nombreArticulo: String,
                    var precioDistribuidor: Double,
                    var impuesto: Double,
                    var existencia: Double
                    ) : Serializable