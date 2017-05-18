package com.haishinkit.studio

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    private var fragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navigation = findViewById(R.id.navigation) as BottomNavigationView
        navigation.setOnNavigationItemSelectedListener(this)

        fragment = CameraTabFragment.newInstance()
        val transaction = supportFragmentManager?.beginTransaction()
        transaction?.replace(R.id.content, fragment)?.commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            R.id.navigation_home -> {
                fragment = CameraTabFragment.newInstance()
            }
            R.id.navigation_dashboard -> {
                fragment = PreferenceFragment.newInstance()
            }
            else -> {

            }
        }
        val transaction = supportFragmentManager?.beginTransaction()
        transaction?.replace(R.id.content, fragment)?.commit()
        return true
    }
}
