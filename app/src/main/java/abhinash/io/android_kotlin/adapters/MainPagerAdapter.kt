package abhinash.io.android_kotlin.adapters

import abhinash.io.android_kotlin.controller.MenuFragment
import abhinash.io.android_kotlin.R
import abhinash.io.android_kotlin.controller.CollectionsFragment
import abhinash.io.android_kotlin.controller.NotificationsFragment
import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by khanal on 4/16/17.
 * This is the Pager adapter for the fragment pager.
 */
class MainPagerAdapter(val fm: FragmentManager?, val context: Context?) : FragmentPagerAdapter(fm) {

    /**
     * Return the corresponding fragment to the pager.
     */
    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                val frag = MenuFragment()
                return frag
            }
            1 -> {
                val frag = NotificationsFragment()
                return frag
            }
            2 -> {
                val frag = CollectionsFragment()
                return frag
            }
            3 -> {
                val frag = MenuFragment()
                return frag
            }
            4 -> {
                val frag = MenuFragment()
                return frag
            }
        }
        val frag = MenuFragment()
        return frag
    }

    override fun getCount(): Int {
        return context?.resources?.getStringArray(R.array.fragment_names)?.size ?: 0
    }

}