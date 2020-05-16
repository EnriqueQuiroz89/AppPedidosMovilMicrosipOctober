package example.javatpoint.com.apppedidosmovilmicrosip.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import example.javatpoint.com.apppedidosmovilmicrosip.R

class MainMenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
    }

    fun showClients(view: View){

        val intent= Intent(this, ClientRecyclerViewActivity::class.java)
        startActivity(intent)}

   override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.clients_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }







 }


