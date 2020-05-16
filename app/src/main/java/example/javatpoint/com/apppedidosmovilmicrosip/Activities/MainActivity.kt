package example.javatpoint.com.apppedidosmovilmicrosip.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import example.javatpoint.com.apppedidosmovilmicrosip.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

//Para validar la contraseña escrita
     fun  validatePassword(view:View){
      // guarda el contenido del editText contraseña en una constante
      val password=  amEtPassword.text.toString()
         // Validacion de la contaseña
     if(password.trim()!="")  // diferente de vacia
       {   //que sea igual a la palabra clave
           if (password== "mateo") {
               //si la contraseña es correcta dirige al menu primcipal
               val intent= Intent(this, MainMenuActivity::class.java)
               startActivity(intent)}
           else {
                  Toast.makeText(applicationContext,"LA contaseña es incorrecta", Toast.LENGTH_LONG).show()
                    amEtPassword.text.clear()// quita el texto si la password es incrrecta
                }// indica que el campo contraseña esta vacio
      }    else{
                Toast.makeText(applicationContext,"password no puede quedar vacia", Toast.LENGTH_LONG).show()}

                          }

}
