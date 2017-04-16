package abhinash.io.android_kotlin.adapters

import abhinash.io.android_kotlin.R
import abhinash.io.android_kotlin.domain.Notification
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by khanal on 4/16/17.
 * This will be the adapter for the notifications class.
 */

class NotificationsAdapter(var notifications: ArrayList<Notification>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val UNREAD_NOTIFICATION = 0
    val READ_NOTIFICATION = 1

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            UNREAD_NOTIFICATION -> {
                return UnreadNotificationViewholder(LayoutInflater.from(parent?.context)
                        .inflate(R.layout.row_notification_unread, parent, false))
            }

            READ_NOTIFICATION -> {
                return ReadNotificationViewHolder(LayoutInflater.from(parent?.context)
                        .inflate(R.layout.row_notification_read, parent, false))
            }
        }
        return UnreadNotificationViewholder(LayoutInflater.from(parent?.context)
                .inflate(R.layout.row_notification_unread, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        return notifications.size
    }

    override fun getItemViewType(position: Int): Int {
        val notification = notifications.get(position)
        val read = notification.read ?: false
        if (read)
            return READ_NOTIFICATION
        else
            return UNREAD_NOTIFICATION
    }


    class UnreadNotificationViewholder(var itemView: View?): RecyclerView.ViewHolder(itemView) {
        fun bind(notification: Notification) {

        }
    }

    class ReadNotificationViewHolder(var itemView: View?): RecyclerView.ViewHolder(itemView) {
        fun bind(notification: Notification) {

        }
    }
}
