package com.example.ghienphim.sql

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.ghienphim.model.User
import android.widget.Toast
import com.example.ghienphim.Cur
import java.util.*
import kotlin.collections.List

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    // create table sql query


    override fun onCreate(db: SQLiteDatabase) {
//        db.execSQL(createusertable)
        db.execSQL("CREATE TABLE FAVORITE(FName TEXT PRIMARY KEY)");
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

        //Drop User Table if exist
//        db.execSQL(dropusertable)
        db.execSQL("DROP TABLE IF EXISTS FAVORITE")
        // Create tables again
        onCreate(db)

    }

    /**
     * This method is to fetch all user and return the list of user records
     *
     * @return list
     */
    fun getAllFilm(): List<String> {
        val filmList = kotlin.collections.ArrayList<String>()

        val db = this.readableDatabase

        // query the user table
        val cursor = db.rawQuery("SELECT * FROM FAVORITE", null)
        if (cursor.moveToFirst()) {
            for(i in 1..cursor.count) {
                val film = cursor.getString(0)

                filmList.add(film)
                cursor.moveToNext()
            }
        }
        cursor.close()
        db.close()
        return filmList
    }


    /**
     * This method is to create user record
     *
     * @param user
     */
    fun addFilm(fname: String) : Long {
        val db = this.writableDatabase
//
//        val listU = db.query(TABLE_USER, //Table to query
//         arrayOf(COLUMN_USER_ID),        //columns to return
//        null,      //columns for the WHERE clause
//        null,  //The values for the WHERE clause
//        null,  //group the rows
//        null,   //filter by row groups
//        null)  //The sort order
//        val numU = listU.count()
        val values = ContentValues()
//        user.id = values
//        values.put(COLUMN_USER_ID, user.id)
        values.put("FName", fname)

        // Inserting Row
        val ins = db.insert("FAVORITE", null, values)

        db.close()
        return ins
    }

    /**
     * This method to update user record
     *
     * @param user
     */
//    fun updateUser(user: User) {
//        val db = this.writableDatabase
//
//        val values = ContentValues()
//        values.put(COLUMN_USER_NAME, user.name)
//        values.put(COLUMN_USER_EMAIL, user.email)
//        values.put(COLUMN_USER_PASSWORD, user.pass)
//        values.put(COLUMN_USER_AGE, user.age)
//
//        // updating row
//        db.update(
//            TABLE_USER, values, "$COLUMN_USER_ID = ?",
//            arrayOf(user.id.toString()))
//        db.close()
//    }

    /**
     * This method is to delete user record
     *
     * @param user
     */
//    fun deleteFilm(fname: String) {
//
//        val db = this.writableDatabase
//        // delete user record by id
//        db.delete(
//            TABLE_USER, "$COLUMN_FILM_NAME = ?",
//            arrayOf(fname))
//        db.close()
//    }

    /**
     * This method to check user exist or not
     *
     * @param email
     * @return true/false
     */
    fun checkFilmExist(fname: String): Boolean {
        // array of columns to fetch

//        val db = this.writableDatabase
//        db.execSQL("CREATE TABLE FAVORITE (COLUMN_FILM_NAME TEXT)")
//        db.close()
        val db = this.readableDatabase
        //val columns = arrayOf(COLUMN_FILM_NAME)

        // selection criteria
//        val selection = "$COLUMN_FILM_NAME = ?"

        // selection argument
//        val selectionArgs = arrayOf(fname)

        // query user table with condition
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com';
         */
//        val cursor = db.query(
//            TABLE_USER, //Table to query
//            columns,        //columns to return
//            selection,      //columns for the WHERE clause
//            selectionArgs,  //The values for the WHERE clause
//            null,  //group the rows
//            null,   //filter by row groups
//            null)  //The sort order


//        val cursorCount = cursor.count
//        cursor.close()

        val cursor = db.rawQuery("SELECT * FROM FAVORITE WHERE COLUMN_FILM_NAME=?", arrayOf(fname));
        cursor.moveToNext()
        if (cursor.isNull(0)) { // khong co phim nay trong table
            return true
        }
        return false

    }

    /**
     * This method to check user exist or not
     *
     * @param email
     * @param password
     * @return true/false
     */
//    fun checkUser(username: String, password: String): Boolean {
//
//        // array of columns to fetch
//        val columns = arrayOf(COLUMN_USER_ID)
//
//        val db = this.readableDatabase
//
//        // selection criteria
//        val selection = "$COLUMN_USER_NAME = ? AND $COLUMN_USER_PASSWORD = ?"
//
//        // selection arguments
//        val selectionArgs = arrayOf(username, password)
//
//        // query user table with conditions
//        /**
//         * Here query function is used to fetch records from user table this function works like we use sql query.
//         * SQL query equivalent to this query function is
//         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
//         */
//        val cursor = db.query(
//            TABLE_USER, //Table to query
//            columns, //columns to return
//            selection, //columns for the WHERE clause
//            selectionArgs, //The values for the WHERE clause
//            null,  //group the rows
//            null, //filter by row groups
//            null) //The sort order
//
//        val cursorCount = cursor.count
//        cursor.close()
//        db.close()
//
//        if (cursorCount > 0)
//            return true
//        return false
//    }
//    fun checkWPassUser(username: String): Boolean {
//
//        // array of columns to fetch
//        val columns = arrayOf(COLUMN_USER_ID)
//
//        val db = this.readableDatabase
//
//        // selection criteria
//        val selection = "$COLUMN_USER_NAME = ?"
//
//        // selection arguments
//        val selectionArgs = arrayOf(username)
//
//        // query user table with conditions
//        /**
//         * Here query function is used to fetch records from user table this function works like we use sql query.
//         * SQL query equivalent to this query function is
//         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
//         */
//        val cursor = db.query(
//                TABLE_USER, //Table to query
//                columns, //columns to return
//                selection, //columns for the WHERE clause
//                selectionArgs, //The values for the WHERE clause
//                null,  //group the rows
//                null, //filter by row groups
//                null) //The sort order
//
//        val cursorCount = cursor.count
//        cursor.close()
//        db.close()
//
//        if (cursorCount > 0)
//            return true
//        return false
//    }

    companion object {

        // Database Version
        private val DATABASE_VERSION = 2

        // Database Name
        private val DATABASE_NAME = Cur.name+".db"
//
//        // User table name
//        private val TABLE_USER = "FAVORITE"
//
//        // User Table Columns names
//        private val COLUMN_FILM_NAME = "COLUMN_FILM_NAME"

    }
}