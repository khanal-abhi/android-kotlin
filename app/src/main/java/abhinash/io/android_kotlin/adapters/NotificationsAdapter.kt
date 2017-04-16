package abhinash.io.android_kotlin.adapters

import abhinash.io.android_kotlin.R
import abhinash.io.android_kotlin.domain.Notification
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by khanal on 4/16/17.
 * This will be the adapter for the notifications class.
 */

class NotificationsAdapter(var notifications: ArrayList<Notification>, var menuItemClickListener: MainMenuRecyclerAdapter.MenuItemClickListener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val UNREAD_NOTIFICATION = 0
    val READ_NOTIFICATION = 1

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            UNREAD_NOTIFICATION -> {
                var view = LayoutInflater.from(parent?.context)
                        .inflate(R.layout.row_notification_unread, parent, false)
                return UnreadNotificationViewholder(view, menuItemClickListener)
            }

            READ_NOTIFICATION -> {
                var view = LayoutInflater.from(parent?.context)
                        .inflate(R.layout.row_notification_read, parent, false)
                return ReadNotificationViewHolder(view, menuItemClickListener)
            }
        }
        return UnreadNotificationViewholder(LayoutInflater.from(parent?.context)
                .inflate(R.layout.row_notification_unread, parent, false), menuItemClickListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        (holder as? NotificationViewHolder)?.bind(notifications[position])
    }

    override fun getItemCount(): Int {
        return notifications.size
    }

    override fun getItemViewType(position: Int): Int {
        val notification = notifications[position]
        val read = notification.read ?: false
        if (read)
            return READ_NOTIFICATION
        else
            return UNREAD_NOTIFICATION
    }

    /**
     * For unread notifications.
     */
    class UnreadNotificationViewholder(itemView: View?, var menuItemClickListener: MainMenuRecyclerAdapter.MenuItemClickListener): RecyclerView.ViewHolder(itemView), NotificationViewHolder {
        override fun bind(notification: Notification) {
            itemView.setOnClickListener { _ ->
                menuItemClickListener.onItemClickedListener(adapterPosition, notification.title)
            }
            (itemView.findViewById(R.id.txt_row_menu_title) as? TextView)?.text = notification.title
            (itemView.findViewById(R.id.txt_row_menu_subtitle) as? TextView)?.text = notification.message
        }
    }

    /**
     * For read notifications.
     */
    class ReadNotificationViewHolder(itemView: View?, var menuItemClickListener: MainMenuRecyclerAdapter.MenuItemClickListener): RecyclerView.ViewHolder(itemView), NotificationViewHolder {
        override fun bind(notification: Notification) {
            itemView.setOnClickListener { _ ->
                menuItemClickListener.onItemClickedListener(adapterPosition, notification.title)
            }
            (itemView.findViewById(R.id.txt_row_menu_title) as? TextView)?.text = notification.title
            (itemView.findViewById(R.id.txt_row_menu_subtitle) as? TextView)?.text = notification.message
        }
    }

    /**
     * Interface for all notifications (read & unread).
     */
    interface NotificationViewHolder {
        fun bind(notification: Notification)
    }
}
