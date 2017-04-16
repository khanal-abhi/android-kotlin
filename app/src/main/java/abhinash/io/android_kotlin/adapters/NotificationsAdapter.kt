package abhinash.io.android_kotlin.adapters

import abhinash.io.android_kotlin.domain.Notification
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by khanal on 4/16/17.
 * This will be the adapter for the notifications class.
 */

class NotificationsAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder> {


    class UnreadNotifications(var itemView: View?): RecyclerView.ViewHolder(itemView) {
        fun bind(notification: Notification) {

        }
    }

    class ReadNotification(var itemView: View?): RecyclerView.ViewHolder(itemView) {
        fun bind(notification: Notification) {

        }
    }
}
