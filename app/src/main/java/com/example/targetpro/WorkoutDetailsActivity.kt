package com.example.targetpro

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class WorkoutDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout_details)


        val workoutDescriptionTextView: TextView = findViewById(R.id.workoutDescriptionTextView)
        val workoutNameTextView: TextView = findViewById(R.id.workoutNameTextView)

        // Получаем данные из Intent
        val workoutNumber = intent.getIntExtra("workoutNumber", 1)
        val workoutDescription = intent.getStringExtra("workoutDescription")
        val exerciseDetails = intent.getStringExtra("exerciseDetails")

        workoutNameTextView.text = workoutDescription
        workoutDescriptionTextView.text = exerciseDetails

        val backToMainButton: Button = findViewById(R.id.backToMainButton)

        backToMainButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Закрываем текущую активность, чтобы вернуться в главное меню
        }
    }
}
