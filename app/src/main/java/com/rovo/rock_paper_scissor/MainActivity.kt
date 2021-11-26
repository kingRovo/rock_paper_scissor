package com.rovo.rock_paper_scissor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

import android.text.TextUtils
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.rovo.rock_paper_scissor.DatabaseHandler

class MainActivity : AppCompatActivity() {
    private lateinit var nameField: EditText
    private lateinit var playButton: Button
    private lateinit var databaseHandler: DatabaseHandler
    private lateinit var leaderboardButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        databaseHandler= DatabaseHandler(this)
        nameField=findViewById(R.id.entername)
        playButton=findViewById(R.id.submit)
        leaderboardButton=findViewById(R.id.leaderboardButton)
        playButton.setOnClickListener {
            val name=nameField.text.toString()
            if(TextUtils.isEmpty(name)){
                return@setOnClickListener
            }
            val s=Student(name,"0")
            val status=databaseHandler.addstu(s)
            if(status > -1){
                val intent=Intent(this,MainActivity2::class.java)
                intent.putExtra("name",name)
                startActivity(intent)

            }
            else{
                Toast.makeText(applicationContext,"Username exist", Toast.LENGTH_LONG).show()
            }
        }

    }
}
