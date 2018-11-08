package k.anastasia.marineworld.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import k.anastasia.marineworld.ArrayCell
import k.anastasia.marineworld.R
import k.anastasia.marineworld.draw.DrawCell

class MainActivity : AppCompatActivity() {
    private lateinit var Dr: DrawCell
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Dr = findViewById(R.id.drawcell_main_activity)
        findViewById<Button>(R.id.button_main_activity).setOnClickListener {
            Dr.arrayCell = ArrayCell()
        }
    }
}
