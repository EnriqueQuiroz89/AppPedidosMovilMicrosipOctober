package example.javatpoint.com.apppedidosmovilmicrosip.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import example.javatpoint.com.apppedidosmovilmicrosip.DataModel.Articulos
import example.javatpoint.com.apppedidosmovilmicrosip.R
import kotlinx.android.synthetic.main.layout_item_articulo.view.*

class RecyclerAdapterArticulos(private var articulosList: ArrayList<Articulos>,
                      private var contexto: Context
): RecyclerView.Adapter<RecyclerAdapterArticulos.ViewHolder>(), Filterable {



    var articulosFilterList = ArrayList<Articulos>()

    init {
        articulosFilterList= articulosList
    }

    override fun getFilter(): Filter {
        return  object: Filter(){

            override fun performFiltering(charSequence: CharSequence): FilterResults {

                // AQUI SE CAPTURA LA BUSQUEDA DEL USUARIO
                val charSearch= charSequence.toString()
                // SI LA CONSULTA NO ES VACIA DEBE REGRESAR LA MISMA LISTA DE ENTRADA
                if (charSearch.isEmpty()) {
                    // si la busqueda es vacia  regresa integra la lista de clientes de entrada
                    articulosFilterList= articulosList
                }
                else{     // si no es vacia devuelve la lista modificada
                    val resultList = ArrayList<Articulos>()

                    // para cada renglon en el ArrayList
                    for(row in articulosList){
                        if(row.nombreArticulo!!.toString().toLowerCase().contains(charSearch.toLowerCase())
                            ||
                            row.clavePrincipal!!.toString().toLowerCase().contains(charSearch.toLowerCase())
                            ||
                            row.claveAlterna!!.toString().toLowerCase().contains(charSearch.toLowerCase()))
                        // si coincide lo agrega a la lista
                            resultList.add(row)
                    } // fin del bucle
                    articulosFilterList= resultList// asigna lo acumulado en el result list a la lista modificada
                }   // fin del else si a busqueda no es vacia

                // crea el objeto de retorno del metodo
                val filterResults= FilterResults()
                // asigna a este objeto lo que se acumulado en la listaFiltrada de clientes
                filterResults.values= articulosFilterList

                return  filterResults
            }

            override fun publishResults(charSequence: CharSequence, filterResults: FilterResults) {

                // Asigna a la lista filtrada el objeto de respuesta del metodo anterior
                articulosFilterList= filterResults.values as ArrayList<Articulos>
                // Notifica de un cambio en el juego de caracteres
                notifyDataSetChanged()

            }
        }
    }// fin metodo filter



    // este metodo indica de que elementos se va llenar el Recicler View
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.layout_item_articulo,  //Infla la plantilla de el item post
                parent,
                false
            ), contexto
        )
    }

    // indica el numero de elementos que se van a agregar al RecyclerView para definir su tamaño
    override fun getItemCount(): Int {
        return articulosFilterList.size
    }


    // Usa el metodo bind() de la clase interna ViewHolder()
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // holder.bind(lista[position])
        holder.bind(articulosFilterList[position])
    }

    class ViewHolder(var vista: View, var contexto: Context) : RecyclerView.ViewHolder(vista) {

        //en una vista(elemento_lista_usuario)
        //TRES ELMENTOS VIP
        //1. data class (modelo de clase)
        //2. XML DONDE SE COLOCARAN LOS DATOS (elemento_lista_usuario
        fun bind(articulo: Articulos) {

            // asignacion de los datos pasados a la plantilla de layout_item_post en cada campo

            vista.liaTvClavePrincipal.text= articulo.clavePrincipal
            vista.liaTvClaveAlterna.text = articulo.claveAlterna
            vista.liaTvNombreArticulo.text = articulo.nombreArticulo
            vista.liaTvExistencia.text = articulo.existencia.toString()

                                    } // fin de bind

    } // Fin del ViewHolder()

} // fin de la clase
