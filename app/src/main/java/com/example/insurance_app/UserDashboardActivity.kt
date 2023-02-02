package com.example.insurance_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import com.example.insurance_app.ViewModels.Help
import com.example.insurance_app.ViewModels.Home
import com.example.insurance_app.ViewModels.Policy
import com.example.insurance_app.databinding.ActivityUserDashboardBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class UserDashboardActivity : AppCompatActivity() {

    private lateinit var binding : ActivityUserDashboardBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserDashboardBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_user_dashboard)
        replaceFragment(Home())

        findViewById<BottomNavigationView>(R.id.bottomNavigationView)
            .setOnNavigationItemSelectedListener {

                when(it.itemId){
                    R.id.home -> replaceFragment(Home())
                    R.id.policy -> replaceFragment(Policy())
                    R.id.help -> replaceFragment(Help())

                    else -> {

                    }
                }

                true
            }
    }

    private fun replaceFragment(fragment : Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }
}