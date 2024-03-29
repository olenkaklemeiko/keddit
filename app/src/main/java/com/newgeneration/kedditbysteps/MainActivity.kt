package com.newgeneration.kedditbysteps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.newgeneration.kedditbysteps.features.news.NewsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        if(savedInstanceState == null){
            changeFragment(NewsFragment())
        }
    }

    fun changeFragment(f: Fragment, cleanStack: Boolean = false){
        val ft =supportFragmentManager.beginTransaction()
        if(cleanStack){
            clearBackStack()
        }
        ft.setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out, R.anim.abc_popup_enter, R.anim.abc_popup_exit)
        ft.replace(R.id.action_context_bar,f)
        ft.addToBackStack(null)
        ft.commit()

    }

    fun clearBackStack(){
        val manager = supportFragmentManager;
        if(manager.backStackEntryCount > 0){
            val first = manager.getBackStackEntryAt(0)
            manager.popBackStack(first.id,FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
    }

    override fun onBackPressed() {
        val fragmentManager = supportFragmentManager
        if (fragmentManager.backStackEntryCount > 1) {
            fragmentManager.popBackStack()
        } else {
            finish()
        }
    }
}
