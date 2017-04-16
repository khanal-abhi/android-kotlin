package abhinash.io.android_kotlin

import abhinash.io.android_kotlin.adapters.MainMenuRecyclerAdapter
import android.content.Context
import android.graphics.drawable.GradientDrawable
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
class MenuFragment : Fragment(), MainMenuRecyclerAdapter.MenuItemClickListener {
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

    private var mListener: OnFragmentInteractionListener? = null
    private var recyclerView: RecyclerView? = null


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView = inflater!!.inflate(R.layout.fragment_menu, container, false)
        recyclerView = rootView.findViewById(R.id.recycler_menu_frag) as? RecyclerView
        val adapter = MainMenuRecyclerAdapter(context.resources.getStringArray(R.array.menu_titles), this)
        recyclerView?.adapter = adapter
        recyclerView?.layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
        return rootView
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            mListener = context as OnFragmentInteractionListener?
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html) for more information.
     */
    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(uri: Uri)
    }
}// Required empty public constructor
