package com.yeet.anmp160420011midterm.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.yeet.anmp160420011midterm.R
import com.yeet.anmp160420011midterm.model.Global

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        checkUser()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawerLayout)
        navController = (supportFragmentManager.findFragmentById(R.id.hostFragment) as NavHostFragment).navController
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)

        val navView = findViewById<NavigationView>(R.id.navView)
        NavigationUI.setupWithNavController(navView, navController)

        val bottomNav: BottomNavigationView = findViewById(R.id.bottomNav)
        bottomNav.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, drawerLayout) || super.onSupportNavigateUp()
    }

    fun checkUser() {
        val sharedPref = getSharedPreferences(R.string.preference_file_key.toString(), Context.MODE_PRIVATE)
        val username = sharedPref.getString(R.string.username_key.toString(), null)

        if (username == null) {
            val intent = Intent(this, WelcomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}