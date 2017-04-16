package abhinash.io.android_kotlin

import abhinash.io.android_kotlin.MenuFragment.OnFragmentInteractionListener
import abhinash.io.android_kotlin.adapters.MainPagerAdapter
import abhinash.io.android_kotlin.util.MESSAGE
import abhinash.io.android_kotlin.util.SNACKBAR
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.Snackbar
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity(), OnFragmentInteractionListener {


    override fun onFragmentInteraction(uri: Uri) {
        val mainPath = uri.pathSegments[0]
        if (mainPath.toLowerCase() == SNACKBAR.toLowerCase()) {
            val message = uri.getQueryParameter(MESSAGE)
                Snackbar.make(findViewById(R.id.container), message, Snackbar.LENGTH_SHORT).show()
        }
    }

    private var viewPager: ViewPager? = null


    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {

            R.id.navigation_menu -> {
                viewPager?.setCurrentItem(0, true)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                viewPager?.setCurrentItem(1, true)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_clothes -> {
                viewPager?.setCurrentItem(2, true)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_collections -> {
                viewPager?.setCurrentItem(3, true)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profile -> {
                viewPager?.setCurrentItem(4, true)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.contentPager) as? ViewPager
        viewPager?.adapter = MainPagerAdapter(supportFragmentManager, this)
        val navigation = findViewById(R.id.navigation) as BottomNavigationView
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

}
