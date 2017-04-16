package abhinash.io.android_kotlin.controller

import abhinash.io.android_kotlin.R
import abhinash.io.android_kotlin.adapters.FashionItemAdapter
import abhinash.io.android_kotlin.adapters.MainMenuRecyclerAdapter
import abhinash.io.android_kotlin.domain.FashionItem
import abhinash.io.android_kotlin.domain.FashionItemType
import android.content.Context
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
class CollectionsFragment : Fragment(), MainMenuRecyclerAdapter.MenuItemClickListener {

    /**
     * This handles the click event of an item in the menu list.
     * - index: index of the item in the array.
     * - item: name of the menu item.
     * */
    override fun onItemClickedListener(index: Int, item: String?) {
//        if (null != item) {
//            var uri = Uri.Builder().scheme("fashionability")
//                    .authority("io.abhinash")
//                    .path("snackbar")
//                    .appendQueryParameter("message", "$item selected.")
//                    .build()
//            mListener?.onFragmentInteraction(uri = uri)
//        }
    }

    private var mListener: MenuFragment.OnFragmentInteractionListener? = null
    private var recyclerViewTop: RecyclerView? = null
    private var recyclerViewBottom: RecyclerView? = null
    private var recyclerViewAccy: RecyclerView? = null

    private var mockTops: ArrayList<FashionItem> = ArrayList()
    private var mockBottoms: ArrayList<FashionItem> = ArrayList()
    private var mockAccys: ArrayList<FashionItem> = ArrayList()

    /**
     * This will holdthe selected states for the adapters between pause and resume.
     */
    private var selectedTop: Int? = null
    private var selectedBottom: Int? = null
    private var selectedAccy: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mockTops = mockTops()
        mockBottoms = mockBottoms()
        mockAccys = mockAccys()
    }

    override fun onPause() {
        super.onPause()
        selectedTop = (recyclerViewTop?.adapter as? FashionItemAdapter)?.lastSelectedPosition
        selectedBottom = (recyclerViewBottom?.adapter as? FashionItemAdapter)?.lastSelectedPosition
        selectedAccy = (recyclerViewAccy?.adapter as? FashionItemAdapter)?.lastSelectedPosition

    }

    override fun onResume() {
        super.onResume()
        (recyclerViewTop?.adapter as? FashionItemAdapter)?.lastSelectedPosition = selectedTop
        (recyclerViewBottom?.adapter as? FashionItemAdapter)?.lastSelectedPosition = selectedBottom
        (recyclerViewAccy?.adapter as? FashionItemAdapter)?.lastSelectedPosition = selectedAccy
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView = inflater!!.inflate(R.layout.fragment_clothes, container, false)
        recyclerViewTop = rootView.findViewById(R.id.recycler_top) as? RecyclerView
        recyclerViewBottom = rootView.findViewById(R.id.recycler_bottom) as? RecyclerView
        recyclerViewAccy = rootView.findViewById(R.id.recycler_accy) as? RecyclerView
        val adapterTop = FashionItemAdapter(mockTops, this)
        val adapterBottom = FashionItemAdapter(mockBottoms, this)
        val adapterAccy = FashionItemAdapter(mockAccys, this)
        recyclerViewTop?.adapter = adapterTop
        recyclerViewBottom?.adapter = adapterBottom
        recyclerViewAccy?.adapter = adapterAccy
        recyclerViewTop?.layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewBottom?.layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewAccy?.layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
        return rootView
    }

    /**
     * Generate a mock list of tops.
     */
    fun mockTops(): ArrayList<FashionItem> {
        val fashionItems = ArrayList<FashionItem>()
        (0 until 10)
                .mapTo(fashionItems) {
                    FashionItem("Top #$it", null, FashionItemType.TOP, false)
                }
        return fashionItems
    }

    /**
     * Generate a mock list of bottoms.
     */
    fun mockBottoms(): ArrayList<FashionItem> {
        val fashionItems = ArrayList<FashionItem>()
        (0 until 10)
                .mapTo(fashionItems) {
                    FashionItem("Bottom #$it", null, FashionItemType.TOP, false)
                }
        return fashionItems
    }

    /**
     * Generate a mock list of accys.
     */
    fun mockAccys(): ArrayList<FashionItem> {
        val fashionItems = ArrayList<FashionItem>()
        (0 until 10)
                .mapTo(fashionItems) {
                    FashionItem("Accy #$it", null, FashionItemType.TOP, false)
                }
        return fashionItems
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
