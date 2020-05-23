package example.javatpoint.com.apppedidosmovilmicrosip.DataModel

import java.io.Serializable
import java.util.*
import kotlin.collections.ArrayList

data class Pedidos( val idPedido: Int,
                //    val folio:String,
                //    var fecha:Int,
                //    val almacen:String,
                //    val importe:Double,
                //    val impuesto: Double,
                //    val idVendedor: Int,
                //    val nombreVendedor: String,
                //    val idCliente: Int,
                //      val nombreCliente: String,
               //     val estatus: String,
                    val idListPartida:Int,
                    var listaPartidas:MutableList<PartidaPedido>
                  ):Serializable


