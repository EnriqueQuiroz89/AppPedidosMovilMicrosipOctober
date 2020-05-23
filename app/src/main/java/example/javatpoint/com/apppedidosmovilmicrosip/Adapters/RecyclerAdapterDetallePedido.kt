package example.javatpoint.com.apppedidosmovilmicrosip.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import example.javatpoint.com.apppedidosmovilmicrosip.DataModel.Articulos
import example.javatpoint.com.apppedidosmovilmicrosip.DataModel.PartidaPedido
import example.javatpoint.com.apppedidosmovilmicrosip.R
import kotlinx.android.synthetic.main.layout_item_articulo.view.*
import kotlinx.android.synthetic.main.layout_item_detalle_pedido.view.*
import kotlinx.android.synthetic.main.layout_item_pedido.view.*

class RecyclerAdapterDetallePedido(private var partidasList: ArrayList<PartidaPedido>,
                                  private var contexto: Context)
           : RecyclerView.Adapter<RecyclerAdapterDetallePedido.ViewHolder>(), Filterable {


    var partidasFilterList = ArrayList<PartidaPedido>()


    init {
        partidasFilterList= partidasList
         }

    override fun getFilter(): Filter {
        return  object: Filter(){

            override fun performFiltering(charSequence: CharSequence): FilterResults {

                // AQUI SE CAPTURA LA BUSQUEDA DEL USUARIO
                val charSearch= charSequence.toString()
                // SI LA CONSULTA NO ES VACIA DEBE REGRESAR LA MISMA LISTA DE ENTRADA
                if (charSearch.isEmpty()) {
                    // si la busqueda es vacia  regresa integra la lista de clientes de entrada
                    partidasFilterList= partidasList
                }
                else{     // si no es vacia devuelve la lista modificada
                    val resultList = ArrayList<PartidaPedido>()

                    // para cada renglon en el ArrayList
                    for(row in partidasList){
                        if(row.claveOcodigo.toLowerCase().contains(charSearch.toLowerCase())
                            ||
                          row.idArticulo.toString().toLowerCase().contains(charSearch.toLowerCase())
                           )
                        // si coincide lo agrega a la lista
                            resultList.add(row)
                    } // fin del bucle
                    partidasFilterList= resultList// asigna lo acumulado en el result list a la lista modificada
                }   // fin del else si a busqueda no es vacia

                // crea el objeto de retorno del metodo
                val filterResults= FilterResults()
                // asigna a este objeto lo que se acumulado en la listaFiltrada de clientes
                filterResults.values= partidasFilterList

                return  filterResults
            }

            override fun publishResults(charSequence: CharSequence, filterResults: FilterResults) {

                // Asigna a la lista filtrada el objeto de respuesta del metodo anterior
                partidasFilterList= filterResults.values as ArrayList<PartidaPedido>
                // Notifica de un cambio en el juego de caracteres
                notifyDataSetChanged()

            }
        }
    }// fin metodo filter



    // este metodo indica de que elementos se va llenar el Recicler View
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.layout_item_detalle_pedido,  //Infla la plantilla de el item post
                parent,
                false
            ), contexto
        )
    }

    // indica el numero de elementos que se van a agregar al RecyclerView para definir su tamaño
    override fun getItemCount(): Int {
        return partidasFilterList.size
    }


    // Usa el metodo bind() de la clase interna ViewHolder()
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // holder.bind(lista[position])
        holder.bind(partidasFilterList[position])
    }

    class ViewHolder(var vista: View, var contexto: Context) : RecyclerView.ViewHolder(vista) {

        //en una vista(elemento_lista_usuario)
        //TRES ELMENTOS VIP
        //1. data class (modelo de clase)
        //2. XML DONDE SE COLOCARAN LOS DATOS (elemento_lista_usuario
        fun bind(partida: PartidaPedido) {

            // asignacion de los datos pasados a la plantilla de layout_item_post en cada campo

            vista.lidpTvNombreArticulo.text= partida.nombreArticulo
            vista.lidpTvClave.text   =       partida.claveOcodigo
            vista.lidpTvCodigo.text  =       partida.claveOcodigo
            vista.lidpTvCantidad.text     =  partida.cantidad.toString()
            vista.lidpTvPrecioUnitario.text= (partida.precioUnitario+partida.impuestoUnitario) .toString()
            vista.lidpTvImportePartida.text =(partida.precioTotal + partida.impuestoTotal).toString()

        } // fin de bind

    } // Fin del ViewHolder()

} // fin de la clase
