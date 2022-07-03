package com.garibyan.armen.tbc_classwork_2

import android.os.Bundle
import android.util.Log.d
import android.widget.Toast
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
            if (binding.edtAnagram.text.toString() == "") {
                Toast.makeText(this, R.string.empty_edt, Toast.LENGTH_SHORT).show()
            } else {
                listOfString.add(binding.edtAnagram.text.toString())
                binding.edtAnagram.setText("")
            }
        }
        binding.btnOutput.setOnClickListener {
            binding.tvAnagramsCount.text = groupAnagrams(listOfString).toSet().size.toString()
            d("myLog", groupAnagrams(listOfString).toString())
        }
    }

    fun groupAnagrams(words: MutableList<String>): Set<MutableList<String>> {

        val anagrams: MutableSet<MutableList<String>> = HashSet()
        val list = mutableListOf<String>()

        words.forEach {
            var str = it
            val chars = str.toCharArray()
            chars.sort()
            str = String(chars)
            list.add(str.lowercase())
        }

        val map: MutableMap<String, MutableList<Int>> = HashMap()
        for (i in list.indices) {
            if (!map.containsKey(list[i])) {
                map[list[i]] = ArrayList()
                map[list[i]]!!.add(i)
            } else {
                map[list.get(i)]!!.add(i)
            }
        }

        for (entry in map) {
            var anogramsList = mutableListOf<String>()

            entry.value.forEach {
                anogramsList.add(words[it])
            }
            anagrams.add(anogramsList)
        }
        return anagrams
    }
}



