package example.javatpoint.com.apppedidosmovilmicrosip.Interfaces

import example.javatpoint.com.apppedidosmovilmicrosip.DataModel.Clientes
import example.javatpoint.com.apppedidosmovilmicrosip.DataModel.Posts
import retrofit2.Call
import retrofit2.http.GET

interface JsonPlaceHolderApi {

    // ES PROPIO DE RETROFI
    // se declara la punta del de la url de la api
    @get:GET("posts") // esto es la magia de retro fit
    /// Asignar en una variable la llmada Call que almacenara una lista de objetos Clientes
    val post: Call<List<Posts>>

                            }