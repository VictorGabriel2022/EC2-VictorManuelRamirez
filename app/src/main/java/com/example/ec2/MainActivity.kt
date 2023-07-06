package com.example.ec2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView

    private val camaraFragment = CamaraFragment()
    private val infoFragment = InfoFragment()
    private val mapFragment = Map_Fragment()

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_camara -> {
                    replaceFragment(camaraFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.menu_info -> {
                    replaceFragment(infoFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.menu_map -> {
                    replaceFragment(mapFragment)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        // Establecer el fragmento inicial
        replaceFragment(camaraFragment)
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }


}




