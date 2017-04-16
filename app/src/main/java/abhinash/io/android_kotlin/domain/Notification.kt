package abhinash.io.android_kotlin.domain

/**
 * Created by khanal on 4/16/17.
 * This is the notification domain object.
 */
class Notification(
        /**
         * Read status of the notification.
         */
        var read: Boolean?,
        /**
         * Title of the notification.
         */
        var title: String?,
        /**
         * Message of the notifcation.
         */
        var message: String?) {

}