package ru.geekbrains.myapplicationkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    val myClickListener = View.OnClickListener {
        v ->  showMessage(v)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.myButton)
        button.setOnClickListener(myClickListener)
    }

    private fun showMessage(view: View){
        val myToast = Toast.makeText(view.context, "Есть контакт!", Toast.LENGTH_SHORT)
        myToast.show()
    }
}
