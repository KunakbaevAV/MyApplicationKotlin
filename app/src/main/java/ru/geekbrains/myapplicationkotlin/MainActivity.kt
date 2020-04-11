package ru.geekbrains.myapplicationkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import ru.geekbrains.myapplicationkotlin.model.Anagram

class MainActivity : AppCompatActivity() {

    lateinit var instruction: TextView

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
        instruction = findViewById(R.id.anagramInstuction)

        anagramView.text = anagram.word
        instruction.text = resources.getString(R.string.anagramInstruction)
        variant1.text = anagram.variant1
        variant2.text = anagram.variant2
        variant3.text = anagram.variant3
        variant4.text = anagram.variant4

        variant1.setBackgroundColor(resources.getColor(R.color.colorPrimary))
        variant2.setBackgroundColor(resources.getColor(R.color.colorPrimary))
        variant3.setBackgroundColor(resources.getColor(R.color.colorPrimary))
        variant4.setBackgroundColor(resources.getColor(R.color.colorPrimary))

        anagramView.setOnClickListener { init() }
        variant1.setOnClickListener { pressVariant(anagram, 1, variant1) }
        variant2.setOnClickListener { pressVariant(anagram, 2, variant2) }
        variant3.setOnClickListener { pressVariant(anagram, 3, variant3) }
        variant4.setOnClickListener { pressVariant(anagram, 4, variant4) }
    }

    private fun pressVariant(anagram: Anagram, variant: Int, textView: TextView) {
        if (anagram.checkVariant(variant)) {
            showMessage("Верно")
            init()
        } else {
            textView.setBackgroundColor(resources.getColor(R.color.colorAccent))
            showAnswer(R.string.no)
        }
    }

    private fun showMessage(text: String) {
        val myToast = Toast.makeText(this, text, Toast.LENGTH_SHORT)
        myToast.show()
    }

    private fun showAnswer(answer: Int){
        instruction.text = resources.getString(answer)
    }

}
