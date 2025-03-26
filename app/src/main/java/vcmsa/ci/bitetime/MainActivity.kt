package vcmsa.ci.bitetime

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val mealSuggestion = findViewById<TextView>(R.id.mealSuggestion)
        val resetButton = findViewById<Button>(R.id.resetButton)
        val suggestMeal = findViewById<Button>(R.id.suggestMeal)
        val timeOfDay = findViewById<EditText>(R.id.timeOfDay)
        val tag = "Bite Time"

        resetButton.setOnClickListener {
            timeOfDay.text.clear()
        }

        Log.d(TAG,"The user has entered cleared inputs and outputs.")
        suggestMeal.setOnClickListener {
            val time = timeOfDay.text.toString().trim().lowercase()

            if (time.isEmpty()) {
                mealSuggestion.text = "Please enter a time"
                Log.d("Debug", "Time is empty")
            } else {
                Log.d("Debug", "Time is not empty")

                when (timeOfDay.text.toString().lowercase()) {
                    "morning" -> mealSuggestion.text = "corn flakes"
                    "mid-morning" -> mealSuggestion.text = "fruit"
                    "afternoon" -> mealSuggestion.text = "sandwich"
                    "afternoon snack" -> mealSuggestion.text = "burger"
                    "dinner" -> mealSuggestion.text = "full_meal"
                    "after dinner" -> mealSuggestion.text = "mc flurry"
                    else -> {
                        Toast.makeText(
                            this,
                            "invalid time of day.please try again.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }

    }


}



