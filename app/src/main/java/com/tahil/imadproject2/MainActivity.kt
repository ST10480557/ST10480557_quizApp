package com.tahil.imadproject2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }//end of viewCompat
        // code starts here
        // link the elements from the GUI to the backend
        val edtUsername = findViewById<EditText>(R.id.edtUsername)
        val btnButton = findViewById<Button>(R.id.btnButton)
        //retrive the data from elemnets
        val username = edtUsername.text.toString()
      btnButton.setOnClickListener {
          //start the quiz activity
          val intent = Intent(this, quizzActivity::class.java).putExtras("username", username)
          startActivity(intent)
          finish()
    }// end of oncreate
}//end of mainActivity