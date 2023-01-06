package com.kdl.seacher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        setContentView(R.layout.activity_main)
        val user_txt = findViewById<EditText>(R.id.user_txt)
        val submit = findViewById<Button>(R.id.submit_btn)

        submit.setOnClickListener{
            if(user_txt.text.isNotBlank()){
                viewModel.generateSearch(user_txt.text.toString())
                supportFragmentManager
                    .beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.content,FragmentDisplay())
                    .commit()
            }
        }
    }
}