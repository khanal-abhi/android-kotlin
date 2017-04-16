package abhinash.io.android_kotlin.adapters

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent

/**
 * Created by khanal on 4/16/17.
 * This is the non swipable view pager.
 */

class NONSwipableViewPager(context: Context?, attrs: AttributeSet?) : ViewPager(context, attrs) {

    /**
     * Do not handle the iterception of touch event
     */
    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return false
    }

    /**
     * Do not handle touch event
     */
    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        return false
    }
}
