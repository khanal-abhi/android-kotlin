package abhinash.io.android_kotlin.domain

/**
 * Created by khanal on 4/16/17.
 * This is the fashion item domain object.
 */
class FashionItem(
        /**
         * The title of the fashion item
         */
        var title: String?,
        /**
         * The imgUrl of the fashion item
         */
        var imgUrl: String?,
        /**
         * The fashion item type.
         */
        var fashionItemType: FashionItemType,
        /**
         * Whether or not it is selected.
         */
        var selected: Boolean
)