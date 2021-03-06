package abhinash.io.android_kotlin.controller

import abhinash.io.android_kotlin.R
import abhinash.io.android_kotlin.adapters.MainPagerAdapter
import abhinash.io.android_kotlin.controller.MenuFragment.OnFragmentInteractionListener
import abhinash.io.android_kotlin.util.MESSAGE
import abhinash.io.android_kotlin.util.SNACKBAR
import android.net.Uri
import android.os.Bundle
import android.support.design.internal.BottomNavigationPresenter
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.Snackbar
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import java.lang.reflect.Field

class MainActivity : AppCompatActivity(), OnFragmentInteractionListener {

    /**
     * When one of the fragments are interacted with, a uri is sent here to perform actions in the
     * activity or communicate with other fragments.
     * - uri: sent uri
     */
    override fun onFragmentInteraction(uri: Uri) {
        val mainPath = uri.pathSegments[0]
        if (mainPath.toLowerCase() == SNACKBAR.toLowerCase()) {
            val message = uri.getQueryParameter(MESSAGE)
                Snackbar.make(findViewById(R.id.container), message, Snackbar.LENGTH_SHORT).show()
        }
    }

    private var viewPager: ViewPager? = null
    private var navigation: BottomNavigationView? = null



    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {

            R.id.navigation_menu -> {
                supportActionBar?.title = resources.getString(R.string.title_menu)
                viewPager?.setCurrentItem(0, true)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                supportActionBar?.title = resources.getString(R.string.title_notifications)
                viewPager?.setCurrentItem(1, true)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_clothes -> {
                supportActionBar?.title = resources.getString(R.string.title_clothes)
                viewPager?.setCurrentItem(2, true)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_collections -> {
                supportActionBar?.title = resources.getString(R.string.title_collections)
                viewPager?.setCurrentItem(3, true)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profile -> {
                supportActionBar?.title = resources.getString(R.string.title_profile)
                viewPager?.setCurrentItem(4, true)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.setDisplayShowTitleEnabled(true)
        supportActionBar?.title = resources.getString(R.string.title_menu)

        viewPager = findViewById(R.id.contentPager) as? ViewPager
        viewPager?.adapter = MainPagerAdapter(supportFragmentManager, this)
        navigation = findViewById(R.id.navigation) as BottomNavigationView
        navigation?.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

}
