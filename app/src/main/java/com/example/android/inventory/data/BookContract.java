package com.example.android.inventory.data;

import android.provider.BaseColumns;
import android.content.ContentResolver;
import android.net.Uri;


/**
 * API Contract for the Inventory app.
 */
public final class BookContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private BookContract() {}


    /**
     * The "Content authority" is a name for the entire content provider, similar to the
     * relationship between a domain name and its website.  A convenient string to use for the
     * content authority is the package name for the app, which is guaranteed to be unique on the
     * device
     */
    public static final String CONTENT_AUTHORITY = "com.example.android.books";

    /**
     * Use CONTENT_AUTHORITY to create the base of all URI's which apps will use to contact
     * the content provider.
     */
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    /**
     * Possible path (appended to base content URI for possible URI's)
     * For instance, content://com.example.android.books/books/ is a valid path for
     * looking at book data. content://com.example.android.books/staff/ will fail,
     * as the ContentProvider hasn't been given any information on what to do with "staff".
     */
    public static final String PATH_BOOKS = "books";




    /**
     * Inner class that defines constant values for the books database table.
     * Each entry in the table represents a single book.
     */
    public static final class BookEntry implements BaseColumns {


        /** The content URI to access the book data in the provider */
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_BOOKS);

        /**
         * The MIME type of the {@link #CONTENT_URI} for a list of books.
         */
        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_BOOKS;

        /**
         * The MIME type of the {@link #CONTENT_URI} for a single book.
         */
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_BOOKS;



        /** Name of database table for books */
        public final static String TABLE_NAME = "books";

        /**
         * Name of the book.
         *
         * Type: TEXT
         */
        public final static String COLUMN_BOOK_NAME ="name";

        /**
         * Price of the book.
         *
         * Type: INTEGER
         */
        public final static String COLUMN_BOOK_PRICE = "price";

        /**
         * Quantity of the book.
         *
         * Type: INTEGER
         */
        public final static String COLUMN_BOOK_QUANTITY = "quantity";

        /**
         * Supplier name of the book.
         *
         * The only possible values are {@link #SUPPLIER_NAME_PEARSON, {@link #SUPPLIER_NAME_AK},
         * or {@link #SUPPLIER_NAME_HOWARTH_PRESS}.
         *
         * Type: TEXT
         */
        public final static String COLUMN_BOOK_SUPPLIER_NAME = "supplier_name";

        /**
         * Supplier phone of the book.
         *
         * Type: TEXT
         */
        public final static String COLUMN_BOOK_SUPPLIER_PHONE = "supplier_phone";

        /**
         * Possible values for the supplier name of the book.
         */
        public static final int SUPPLIER_NAME_PEARSON = 0;
        public static final int SUPPLIER_NAME_AK = 1;
        public static final int SUPPLIER_NAME_HOWARTH_PRESS = 2;


        /**
         * Returns whether or not the given gender is {@link #SUPPLIER_NAME_PEARSON}, {@link #SUPPLIER_NAME_AK},
         * or {@link #SUPPLIER_NAME_HOWARTH_PRESS}.
         */
        public static boolean isValidGender(int gender) {
            if (gender == SUPPLIER_NAME_PEARSON || gender == SUPPLIER_NAME_AK || gender == SUPPLIER_NAME_HOWARTH_PRESS) {
                return true;
            }
            return false;

        }

    }

}
