package tomuch.coffee.ecommerce.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import tomuch.coffee.ecommerce.R

class CardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card)
        supportActionBar?.hide()
    }
}