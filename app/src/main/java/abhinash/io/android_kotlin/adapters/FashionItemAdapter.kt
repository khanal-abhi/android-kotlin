package abhinash.io.android_kotlin.adapters

import abhinash.io.android_kotlin.R
import abhinash.io.android_kotlin.domain.FashionItem
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by khanal on 4/16/17.
 * This is an adapter for the fashion item.
 */

class FashionItemAdapter(var fashionItems: ArrayList<FashionItem>,
                         var menuItemClickListener: MainMenuRecyclerAdapter.MenuItemClickListener?): RecyclerView.Adapter<FashionItemAdapter.FashionItemViewHolder>() {

    var lastSelectedPosition: Int? = null
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): FashionItemViewHolder {
        return FashionItemViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.row_fashion_item, parent, false),
                this,
                menuItemClickListener)
    }

    override fun getItemCount(): Int {
        return fashionItems.size
    }

    override fun onBindViewHolder(holder: FashionItemViewHolder?, position: Int) {
        holder?.bind(fashionItems[position])
    }

    /**
     * Deals with the selection.
     */
    fun onNewItemSelected(position: Int) {
        val lastPosition = lastSelectedPosition
        if (null != lastPosition) {
            fashionItems[lastPosition].selected = false
            this.notifyItemChanged(lastPosition)
        }
        lastSelectedPosition = position
        val currentPosition = lastSelectedPosition
        if (null != currentPosition) {
            fashionItems[currentPosition].selected = true
            this.notifyItemChanged(currentPosition)
        }
    }

    /**
     * Class to bind the fashion item with title and image.
     */
    class FashionItemViewHolder(itemView: View?,
                                var adapter: FashionItemAdapter?,
                                var menuItemClickListener: MainMenuRecyclerAdapter.MenuItemClickListener?) : RecyclerView.ViewHolder(itemView) {
        /**
         * Bind the current fashion item to viewHolder.
         */
        fun bind(fashionItem: FashionItem) {
            (itemView.findViewById(R.id.txt_clothing_title) as? TextView)?.text = fashionItem.title
            if (fashionItem.selected) {
                (itemView.findViewById(R.id.txt_clothing_title) as? TextView)?.setTextColor(ContextCompat.getColor(itemView?.context, R.color.black))
                itemView.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.lightGrey))
            } else {
                (itemView.findViewById(R.id.txt_clothing_title) as? TextView)?.setTextColor(ContextCompat.getColor(itemView?.context, R.color.darkGrey))
                itemView.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.lightestGrey))
            }
            itemView.setOnClickListener { _ ->
                this.adapter?.onNewItemSelected(adapterPosition)
                menuItemClickListener?.onItemClickedListener(adapterPosition, fashionItem.title)
                (itemView.findViewById(R.id.txt_clothing_title) as? TextView)?.setTextColor(ContextCompat.getColor(itemView?.context, R.color.black))
                itemView.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.lightGrey))
            }
        }
    }
}
