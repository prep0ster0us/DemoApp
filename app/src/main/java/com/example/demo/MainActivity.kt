package com.example.demo

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.demo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val tag = "IceBreakerAndroidF23Tag"     // used to set a custom tag, to debug in the log cat. we can filter logcat msg's using this tag and check for errors.
    //@SuppressLint("MissingInflateId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

        //setContentView(R.layout.activity_main)
        setContentView(binding.root)

        Log.d(tag, "Entered into onCreate()")       // used to push a msg onto logcat for debugging

        binding.btnGetQuestion.setOnClickListener { // container for actions when getQuestion is pressed
            Log.d(tag, "Button get question was pressed")
            binding.txtAnswer.setText("Button was clicked!")

            getQuestionsFromFirebase()
        }

        binding.btnSubmit.setOnClickListener {  // container for actions when submit is pressed
            Log.d(tag, "Submit button was pressed.")
            val firstName = binding.txtFirstName
            val lastName = binding.txtLastName
            val prefName = binding.txtPrefName
            val question = binding.txtQuestion
            val answer = binding.txtAnswer

            Log.d(tag, "First Name = ${firstName.text}")
            firstName.setText("")



        }
    }

    // overriding functions from android activity life cycle, we can add some code to run based on when this activity reaches this particular state in its life cycle
    override fun onDestroy() {
        super.onDestroy()

    }

    // private because we want this function to be only accessible from this particular activity (limits access to database outside of this activity)
    private fun getQuestionsFromFirebase() {
        Log.d(tag, "Fetching questions from database....")
    }
}