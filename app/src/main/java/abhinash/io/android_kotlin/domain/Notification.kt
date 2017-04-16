package abhinash.io.android_kotlin.domain

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by khanal on 4/16/17.
 * This is the notification domain object.
 */

public class Notification {



//    override fun writeToParcel(p0: Parcel?, p1: Int) {
//        p0?.writeString(title)
//        p0?.writeString(message)
//        p0?.writeString(read?.toString())
//    }
//
//    override fun describeContents(): Int {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }

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