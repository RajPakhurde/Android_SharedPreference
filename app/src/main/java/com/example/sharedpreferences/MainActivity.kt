package com.example.sharedpreferences

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var sharePref = getSharedPreferences("mypref", MODE_PRIVATE)
        var editor = sharePref.edit()

        binding.btnSave.setOnClickListener {
            var name = binding.etName.text.toString()
            var age = binding.etAge.text.toString().toInt()
            var isCheked = binding.cbIsAdult.isChecked

            editor.apply(){
                putString("name",name)
                putInt("age",age)
                putBoolean("isChecked",isCheked)
                apply()
            }
        }

        binding.btnLaod.setOnClickListener {
            var name = sharePref.getString("name",null)
            var age = sharePref.getInt("age",0)
            var isChecked = sharePref.getBoolean("isChecked",false)

            binding.etName.setText(name)
            binding.etAge.setText(age.toString())
            binding.cbIsAdult.isChecked = isChecked
        }
    }
}