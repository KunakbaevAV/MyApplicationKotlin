package ru.geekbrains.myapplicationkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import ru.geekbrains.myapplicationkotlin.model.Anagram

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {

        val words = resources.getStringArray(R.array.anagrams)
        val number = (Math.random() * words.size).toInt()
        val anagram = Anagram(words[number])

        val anagramView = findViewById<TextView>(R.id.anagramBaze)
        val variant1 = findViewById<TextView>(R.id.variant1)
        val variant2 = findViewById<TextView>(R.id.variant2)
        val variant3 = findViewById<TextView>(R.id.variant3)
        val variant4 = findViewById<TextView>(R.id.variant4)


        anagramView.text = anagram.word
        variant1.text = anagram.variant1
        variant2.text = anagram.variant2
        variant3.text = anagram.variant3
        variant4.text = anagram.variant4

        anagramView.setOnClickListener { init() }
        variant1.setOnClickListener { v -> showMessage(v, variant1.text.toString()) }
        variant2.setOnClickListener { v -> showMessage(v, variant2.text.toString()) }
        variant3.setOnClickListener { v -> showMessage(v, variant3.text.toString()) }
        variant4.setOnClickListener { v -> showMessage(v, variant4.text.toString()) }
    }


    private fun showMessage(view: View, text: String) {
        val myToast = Toast.makeText(view.context, text, Toast.LENGTH_SHORT)
        myToast.show()
    }

}
