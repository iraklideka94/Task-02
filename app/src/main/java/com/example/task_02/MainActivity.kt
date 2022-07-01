package com.example.task_02

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.task_02.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var list: MutableList<String>
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        list = mutableListOf()


            binding.saveBtn.setOnClickListener {
                addToList(binding.editTextTextPersonName.text.toString())
                Toast.makeText(this, "Save", Toast.LENGTH_SHORT).show()

            }
            binding.outBtn.setOnClickListener {
                binding.textView.text = "Anagram count \n ${anagrams(list).size}"
            }


    }

    private fun addToList(input: String) {
        list.add(input)
    }

    private fun anagrams(list1: MutableList<String>): List<List<String>> {
        val resultingMap = mutableMapOf<Map<Char, Int>, List<String>>()

        list1.forEach { str ->
            val key = mutableMapOf<Char, Int>()
            str.forEach {
                key[it] = (key[it] ?: 0) + 1
            }

            resultingMap[key] = (resultingMap[key] ?: listOf()) + str
        }

        return resultingMap.values.toList()
    }


}

