package tomuch.coffee.ecommerce

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import tomuch.coffee.ecommerce.fragment.Blank1Fragment
import tomuch.coffee.ecommerce.fragment.Blank2Fragment
import tomuch.coffee.ecommerce.fragment.CardFragment
import tomuch.coffee.ecommerce.fragment.MainFragment

class MainActivity : AppCompatActivity() {
    private val fm: FragmentManager = supportFragmentManager
    private val mf: Fragment = MainFragment()
    private var active: Fragment = mf
    private val cf: Fragment = CardFragment()
    private val fb1: Fragment = Blank1Fragment()
    private val fb2: Fragment = Blank2Fragment()

    private lateinit var bottomNavView: BottomNavigationView
    private lateinit var menu: Menu
    private lateinit var menuItem: MenuItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()


        setUpBottomNav()
    }

    private fun setUpBottomNav() {
        fm.beginTransaction().add(R.id.main1,mf).show(mf).commit()
        fm.beginTransaction().add(R.id.main1,cf).hide(cf).commit()
        fm.beginTransaction().add(R.id.main1,fb1).hide(cf).commit()
        fm.beginTransaction().add(R.id.main1,fb2).hide(cf).commit()

        bottomNavView = findViewById(R.id.bottom_navigation_bar)

        menu = bottomNavView.menu
        menuItem = menu.getItem(0)
        menuItem.isChecked = true

        bottomNavView.setOnItemSelectedListener   {  item ->
            when(item.itemId){
                R.id.nav_home -> {
                    callFragment(0, mf)
                }

                R.id.nav_catalog -> {
                    callFragment(1, cf)
                }

                R.id.nav_cart -> {
                    callFragment(2, fb1)
                }

                R.id.nav_user -> {
                    callFragment(3, fb2)
                }
            }

            false

        }
    }

    fun callFragment(int: Int, fragment: Fragment){
        menuItem = menu.getItem(int)
        menuItem.isChecked = true
        fm.beginTransaction().hide(active).show(fragment).commit()
        active = fragment
    }
}