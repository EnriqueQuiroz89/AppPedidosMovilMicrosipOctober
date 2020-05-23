package example.javatpoint.com.apppedidosmovilmicrosip.DataModel

import java.io.Serializable

data class PartidaPedido(val idPedido: Int,
                         val idArticulo: Int,
                         val claveOcodigo: String,
                         val nombreArticulo: String,
                         val cantidad:Double,
                         val precioUnitario:Double,
                         val impuestoUnitario: Double,
                         val precioTotal: Double,
                         val impuestoTotal: Double
                         ):Serializable