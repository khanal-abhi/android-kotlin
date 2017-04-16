package abhinash.io.android_kotlin.adapters

import abhinash.io.android_kotlin.R
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by khanal on 4/16/17.
 * This is the adapter for the recycler view.
 */

class MainMenuRecyclerAdapter(var items: Array<String>, var menuItemClickListener: MenuItemClickListener?) : RecyclerView.Adapter<MainMenuRecyclerAdapter.MainMenuViewHolder>() {

    override fun onBindViewHolder(holder: MainMenuViewHolder?, position: Int) {
        holder?.bindMenuItem(items.get(position), this.menuItemClickListener)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MainMenuViewHolder {
        val context = parent?.context
        var view: View? = null
        if (null != context) {
            view = LayoutInflater.from(context).inflate(R.layout.row_menu_frag, parent, false)
        }
        return MainMenuViewHolder(view)
    }

    /**
     * This is the custom viewholder class.
     */
    class MainMenuViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        private var item: String? = null

        /**
         * Bind the item to the view holder.
         * - item: Optional item name.
         * - menuClickListener: Optional listener
         */
        fun bindMenuItem(item: String?, menuClickListener: MenuItemClickListener?) {
            this.item = item
            (itemView?.findViewById(R.id.txt_row_menu_title) as? TextView)?.text = item
            (itemView?.findViewById(R.id.txt_row_menu_subtitle) as? TextView)?.text = item
            itemView?.setOnClickListener { _ ->
                menuClickListener?.onItemClickedListener(adapterPosition, item)
            }
        }
    }

    /**
     * An interface to handle the click events.
     */
    interface MenuItemClickListener {

        /**
         * Fired when an item is clicked
         * - index: position of the item
         * - item: name of the item
         */
        fun onItemClickedListener(index: Int, item: String?)
    }
}
