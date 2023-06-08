package com.example.dummyapplication.presentation

import android.R.attr.key
import android.R.attr.name
import android.accessibilityservice.AccessibilityServiceInfo
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.view.accessibility.AccessibilityManager
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.text.font.FontVariation
import androidx.core.view.accessibility.AccessibilityManagerCompat
import androidx.navigation.fragment.NavHostFragment
import com.example.dummyapplication.R
import com.example.dummyapplication.databinding.ActivityMainBinding
import okhttp3.internal.http2.Settings


//class MainActivity : ComponentActivity() {
//    private lateinit var binding: ActivityMainBinding
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        val sharedPreferences: SharedPreferences = application.getSharedPreferences("shared_pref", Context.MODE_PRIVATE)
//        val editor = sharedPreferences.edit()
//        editor.apply {
//            putBoolean("isDatabase", false)
//        }
////        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
////        val navController = navHostFragment.navController
////
////        // Set the navigation graph
////        val navInflater = navController.navInflater
////        val graph = navInflater.inflate(R.navigation.nav_graph)
////        navController.graph = graph
//
//
//    }
//}
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val permissionIntent = Intent(android.provider.Settings.ACTION_ACCESSIBILITY_SETTINGS)
        binding.btn.setOnClickListener {
            if(!isAccessibilityServiceEnabled())
            startActivity(permissionIntent)
        }



    }

    private fun isAccessibilityServiceEnabled(): Boolean {
        val accessibilityManager = getSystemService(Context.ACCESSIBILITY_SERVICE) as AccessibilityManager
        val enabledServices = AccessibilityManagerCompat.getEnabledAccessibilityServiceList(
            accessibilityManager,
            AccessibilityServiceInfo.FEEDBACK_GENERIC
        )
        return enabledServices.any { it.id == ComponentName(this, MyAccessibilityService::class.java).flattenToString() }
    }
}
