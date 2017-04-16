package abhinash.io.android_kotlin.domain

/**
 * Created by khanal on 4/16/17.
 * This is the notification domain object.
 */

public class Notification {

    private var title: String?
    get() = title
    set(value) { title = value}

    private var message: String?
    get() = message
    set(value) { message = value}

    private var read: Boolean?
    get() = read
    set(value) { read = value }
}