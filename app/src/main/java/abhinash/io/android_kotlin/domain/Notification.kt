package abhinash.io.android_kotlin.domain

/**
 * Created by khanal on 4/16/17.
 * This is the notification domain object.
 */
class Notification {

    /**
     * Title of the notification.
     */
    private var title: String?
    get() = title
    set(value) { title = value}

    /**
     * Message of the notifcation.
     */
    private var message: String?
    get() = message
    set(value) { message = value}

    /**
     * An indicator as to whether the notification has already been read or not.
     */
    private var read: Boolean?
    get() = read
    set(value) { read = value }
}