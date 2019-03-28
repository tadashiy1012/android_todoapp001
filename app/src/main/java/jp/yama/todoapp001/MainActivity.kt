package jp.yama.todoapp001

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.container, MainFragment.newInstance())
            .commit()
    }
}
