package ru.geekbrains.myapplicationkotlin.model

class Anagram(val word: String) {

    private val variantTrue = (Math.random() * 4).toInt() + 1

    var variant1 = getCharArray(1)
    val variant2 = getCharArray(2)
    val variant3 = getCharArray(3)
    val variant4 = getCharArray(4)

    private fun getCharArray(variant: Int): String{
        return if (variant == variantTrue){
            getRandomCharArrayTrue(word.toCharArray().toMutableList())
        }else{
            getRandomCharArrayFalse(word.toCharArray().toMutableList())
        }
    }

    private fun getRandomCharArrayTrue(charArray: MutableList<Char>): String {
        val newArray = CharArray(charArray.size)
        for (i in charArray.indices) {
            val index = (Math.random() * charArray.size).toInt()
            val char = charArray[index].toUpperCase()
            newArray[i] = char
            charArray.removeAt(index)
        }
        return newArray.joinToString(separator = "")
    }

    private fun getRandomCharArrayFalse(charArray: MutableList<Char>): String {
        val newArray = CharArray(charArray.size)

        for (i in charArray.indices) {
            val index = (Math.random() * charArray.size).toInt()
            val char = charArray[index].toUpperCase()
            newArray[i] = char
        }
        return newArray.joinToString(separator = "")
    }

    fun checkVariant(variant: Int): Boolean{
        return variant == variantTrue
    }
}

