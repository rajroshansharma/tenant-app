package com.android.dev.tenatapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.android.dev.tenatapp.databinding.ActivityMainBinding
import com.android.dev.tenatapp.home.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        setSupportActionBar(binding.toolBar)
        supportActionBar?.setDisplayShowTitleEnabled(true)
        supportActionBar?.title = "Home"

        AppBarConfiguration.Builder(R.id.homeFragment, R.id.record, R.id.profileFragment)
        setupNav()

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        val navController: NavController = navHostFragment.navController

        binding.bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.homeFragment->{
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                        HomeFragment()
                    ).commit()
                }
                R.id.record->{
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container,RecordFragment()).commit()
                }
                R.id.profileFragment->{
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container,ProfileFragment()).commit()
                }
            }
            true
        }


    }


    private fun setupNav() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        val navController: NavController = navHostFragment.navController
//        val navController = findNavController(R.id.fragment_container)
//        findViewById<BottomNavigationView>(R.id.bottomNav).setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.foodSectionFragment -> hideBottomNav()
                R.id.bedroomSectionFragment -> hideBottomNav()
                R.id.facilitiesSectionFragment -> hideBottomNav()
                R.id.securitySectionFragment -> hideBottomNav()
                else -> showBottomNav()
            }

            if ( destination.id==R.id.facilitiesSectionFragment) {
                binding.fragmentContainer.margin(bottom = 0F)
            } else {
                 binding.fragmentContainer.margin(bottom = 52F)
            }
        }
    }

    private fun showBottomNav() {
        binding.bottomNav.isVisible = true

    }

    private fun hideBottomNav() {
        binding.bottomNav.isVisible = false

    }


    fun View.margin(left: Float? = null, top: Float? = null, right: Float? = null, bottom: Float? = null) {
        layoutParams<ViewGroup.MarginLayoutParams> {
            left?.run { leftMargin = dpToPx(this) }
            top?.run { topMargin = dpToPx(this) }
            right?.run { rightMargin = dpToPx(this) }
            bottom?.run { bottomMargin = dpToPx(this) }
        }
    }

    inline fun <reified T : ViewGroup.LayoutParams> View.layoutParams(block: T.() -> Unit) {
        if (layoutParams is T) block(layoutParams as T)
    }

    fun View.dpToPx(dp: Float): Int = context.dpToPx(dp)
    fun Context.dpToPx(dp: Float): Int = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.displayMetrics).toInt()

}