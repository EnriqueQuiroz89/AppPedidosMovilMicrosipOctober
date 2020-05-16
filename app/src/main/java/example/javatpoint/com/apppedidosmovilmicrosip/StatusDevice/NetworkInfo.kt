
package example.javatpoint.com.apppedidosmovilmicrosip.StatusDevice

import android.annotation.TargetApi
import android.net.ConnectivityManager
import android.app.Service
import android.content.*
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.os.Build
import androidx.core.content.ContextCompat.getSystemService
import androidx.lifecycle.LiveData

class NetworkInfo(private val context: Context):LiveData<Boolean>() {

   private var connectivityManager: ConnectivityManager=
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    private  lateinit var  networkCallbacks: ConnectivityManager.NetworkCallback

    override fun onActive(){
        super.onActive()
        updateConnection()
        when {
                 Build.VERSION.SDK_INT >= Build.VERSION_CODES.N ->{
                       connectivityManager.registerDefaultNetworkCallback(connectivityManagerCallback())
                 }
                 Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP ->{
                       lollipopNetworkRequest()
                 }
                 else ->{
                      context.registerReceiver(networkReceiver,
                      IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
                      )
                 }
            }
      }

    override fun onInactive() {
        super.onInactive()
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            connectivityManager.unregisterNetworkCallback(connectivityManagerCallback())
        }  else{
            context.unregisterReceiver(networkReceiver)
        }
    }



    @TargetApi(Build.VERSION_CODES.LOLLIPOP)

    private fun  lollipopNetworkRequest(){

        val requestBuider = NetworkRequest.Builder()
            .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
            .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
            .addTransportType(NetworkCapabilities.TRANSPORT_ETHERNET)

            connectivityManager.registerNetworkCallback(
            requestBuider.build(),
            connectivityManagerCallback()          )

    }

    private fun connectivityManagerCallback(): ConnectivityManager.NetworkCallback{

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            networkCallbacks = object : ConnectivityManager.NetworkCallback()
            {
                override fun onLost(network: Network) {
                    super.onLost(network)
                    postValue(false)            }

                override fun onAvailable(network: Network) {
                    super.onAvailable(network)
                    postValue(true)                  }
           }

            return  networkCallbacks
        }else{
              throw IllegalAccessError("Error")
             }

       }  // end fun

    private val networkReceiver = object : BroadcastReceiver(){

        override fun onReceive(context: Context?, intent: Intent?) {
                      updateConnection()
                }
    }

    private fun updateConnection(){
        val activeNetwork = connectivityManager.activeNetworkInfo
        postValue((activeNetwork?.isConnected== true))

    }

}