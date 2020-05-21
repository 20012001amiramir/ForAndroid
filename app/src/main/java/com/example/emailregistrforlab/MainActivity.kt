
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.emailregistrforlab.R
import com.example.emailregistrforlab.RegistrOk

@SuppressLint("Registered")
class MainActivity : AppCompatActivity() {
    private var username: EditText? = null
    private var password: EditText? = null
    private var login: Button? = null

    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById<EditText>(R.id.edit_mail)
        password = findViewById<EditText>(R.id.edit_password)
        login = findViewById<Button>(R.id.buttonlogin)
    }

    fun Login(view: View?) {
        if (username!!.text.toString() == "admin@mail.ru" && password!!.text.toString() == "admin") {
            Toast.makeText(
                applicationContext,
                "Вход выполнен!",
                Toast.LENGTH_SHORT
            ).show()

            val intent = Intent(this,RegistrOk::class.java)
            startActivity(intent)
        }

    }
}