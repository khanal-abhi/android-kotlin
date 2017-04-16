package abhinash.io.android_kotlin.controller

import abhinash.io.android_kotlin.R
import abhinash.io.android_kotlin.adapters.MainMenuRecyclerAdapter
import abhinash.io.android_kotlin.adapters.NotificationsAdapter
import abhinash.io.android_kotlin.domain.Notification
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [MenuFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 */
class NotificationsFragment : Fragment(), MainMenuRecyclerAdapter.MenuItemClickListener {

    /**
     * This handles the click event of an item in the menu list.
     * - index: index of the item in the array.
     * - item: name of the menu item.
     * */
    override fun onItemClickedListener(index: Int, item: String?) {
        if (null != item) {
            var uri = Uri.Builder().scheme("fashionability")
                    .authority("io.abhinash")
                    .path("snackbar")
                    .appendQueryParameter("message", "$item selected.")
                    .build()
            mListener?.onFragmentInteraction(uri = uri)
        }
    }

    private var mListener: MenuFragment.OnFragmentInteractionListener? = null
    private var recyclerView: RecyclerView? = null


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView = inflater!!.inflate(R.layout.fragment_notifications, container, false)
        recyclerView = rootView.findViewById(R.id.recycler_menu_notifications) as? RecyclerView
        val adapter = NotificationsAdapter(mockNotifications(), this)
        recyclerView?.adapter = adapter
        recyclerView?.layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
        return rootView
    }

    /**
     * Generate a mock list of notifications.
     */
    fun mockNotifications(): ArrayList<Notification> {
        var notifications = ArrayList<Notification>()
        (0 until 10)
                .mapTo(notifications) {
                    Notification(it > 3, "Title #$it", "This is a long message that was sent to you. On the list of messages, it's position is #$it")
                }
        return notifications
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is MenuFragment.OnFragmentInteractionListener) {
            mListener = context as MenuFragment.OnFragmentInteractionListener?
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }
}// Required empty public constructor
