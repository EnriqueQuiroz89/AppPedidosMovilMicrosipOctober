package example.javatpoint.com.apppedidosmovilmicrosip.Adapters

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import example.javatpoint.com.apppedidosmovilmicrosip.Activities.InformacionClienteActivity
import example.javatpoint.com.apppedidosmovilmicrosip.DataModel.Clientes
import example.javatpoint.com.apppedidosmovilmicrosip.R
import kotlinx.android.synthetic.main.layout_item_cliente.view.*


class RecyclerAdapter(private var clientesList: ArrayList<Clientes>,
                      private var contexto: Context
): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(),Filterable {

var clientesFilterList = ArrayList<Clientes>()

    init {
        clientesFilterList= clientesList
       }

    override fun getFilter(): Filter {
        return  object:Filter(){

            override fun performFiltering(charSequence: CharSequence): FilterResults {

                // AQUI SE CAPTURA LA BUSQUEDA DEL USUARIO
                val charSearch= charSequence.toString()
                // SI LA CONSULTA NO ES VACIA DEBE REGRESAR LA MISMA LISTA DE ENTRADA
                if (charSearch.isEmpty()) {
                    // si la busqueda es vacia  regresa integra la lista de clientes de entrada
                  clientesFilterList= clientesList
                                           }
                else{     // si no es vacia devuelve la lista modificada
                    val resultList = ArrayList<Clientes>()

                    // para cada renglon en el ArrayList
                    for(row in clientesList){
                     if(row.nombre_cliente!!.toString().toLowerCase().contains(charSearch.toLowerCase())
                         ||
                         row.clave_cliente!!.toString().toLowerCase().contains(charSearch.toLowerCase()) )
                       // si coincide lo agrega a la lista
                         resultList.add(row)
                                      } // fin del bucle
                    clientesFilterList= resultList// asigna lo acumulado en el result list a la lista modificada
                    }   // fin del else si a busqueda no es vacia

                // crea el objeto de retorno del metodo
              val filterResults= FilterResults()
                // asigna a este objeto lo que se acumulado en la listaFiltrada de clientes
                filterResults.values= clientesFilterList

               return  filterResults
           }

            override fun publishResults(charSequence: CharSequence, filterResults: FilterResults) {

                // Asigna a la lista filtrada el objeto de respuesta del metodo anterior
                clientesFilterList= filterResults.values as ArrayList<Clientes>
                 // Notifica de un cambio en el juego de caracteres
                   notifyDataSetChanged()

            }
        }
  }// fin metodo filter




    // este metodo indica de que elementos se va llenar el Recicler View
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.layout_item_cliente,  //Infla la plantilla de el item post
                parent,
                false
            ), contexto
        )
    }

    // indica el numero de elementos que se van a agregar al RecyclerView para definir su tamaño
    override fun getItemCount(): Int {
        return clientesFilterList.size
    }

    // Usa el metodo bind() de la clase interna ViewHolder()
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       // holder.bind(lista[position])
        holder.bind(clientesFilterList[position])
    }

    class ViewHolder(var vista: View, var contexto: Context) : RecyclerView.ViewHolder(vista) {

        //en una vista(elemento_lista_usuario)
        //TRES ELMENTOS VIP
        //1. data class (modelo de clase)
        //2. XML DONDE SE COLOCARAN LOS DATOS (elemento_lista_usuario
        fun bind(cliente: Clientes) {

            // asignacion de los datos pasados a la plantilla de layout_item_post en cada campo
            vista.licTvClaveCliente.text = cliente.clave_cliente
            vista.licTvNombreCliente.text = cliente.nombre_cliente

           // mostrarOpcionesDelCliente(vista,cliente)

            vista.setOnClickListener {
                contexto.startActivity(Intent(contexto, InformacionClienteActivity::class.java)
                    .putExtra("cli",cliente) )
            }
            // Otorga la funcion de escucha al Item del RecyclerView
            mostrarOpcionesDelCliente(vista,cliente)
                                    } // fin de bind


    // Metodo muestra las opciones que tiene un cliente y su info completa
        fun mostrarOpcionesDelCliente(vista: View, cliente:Clientes){

            vista.setOnClickListener {
                contexto.startActivity(Intent(contexto, InformacionClienteActivity::class.java)
                    .putExtra("cliente",cliente) )
                                     }
                                                                    }

    } // Fin del ViewHolder()


} // fin de la clase
