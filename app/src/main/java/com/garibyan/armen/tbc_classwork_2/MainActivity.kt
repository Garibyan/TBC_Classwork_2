package com.garibyan.armen.tbc_classwork_2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.garibyan.armen.tbc_classwork_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var listOfString: MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        listOfString = mutableListOf()
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {
            listOfString.add(binding.edtAnagram.text.toString())
            binding.edtAnagram.setText("")
        }
        binding.btnOutput.setOnClickListener {
            binding.tvAnagramsCount.text = sortAlphabetically(listOfString).toSet().size.toString()
        }

    }

    fun sortAlphabetically(list: MutableList<String>): MutableList<String> {
        var sortedList = mutableListOf<String>()
        list.forEach {
            var str = it
            var chars = str.toCharArray()
            chars.sort()
            str = String(chars)
            sortedList.add(str)
        }
        sortedList.sort()
        return sortedList
    }
}



