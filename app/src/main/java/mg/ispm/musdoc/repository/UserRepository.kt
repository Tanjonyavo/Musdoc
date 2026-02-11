package mg.ispm.musdoc.repository

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import mg.ispm.musdoc.MusicModel
import mg.ispm.musdoc.UserModel

class UserRepository(context: Context?) : SQLiteOpenHelper(context, DBNAME, null, 1) {

    companion object {
        private const val DBNAME = "Users"
        private const val ID = "ID"
        private const val TABLE_USERS = "tbl_users"
        private const val Name = "Name"
        private const val Anxiete = "Anxiete"
        private const val Depression = "Depression"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTBUser = ("CREATE TABLE " + TABLE_USERS + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + Name + " TEXT,"
                + Anxiete + " INTEGER,"+ Depression + " INTEGER" + ")")
        db?.execSQL(createTBUser)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_USERS")
        onCreate(db)
    }

    fun insertUsers(user : UserModel) : Long {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(Name, user.name)
        contentValues.put(Anxiete, user.anx)
        contentValues.put(Depression, user.depre)

        val succes = db.insert(TABLE_USERS, null, contentValues)

        db.close()
        return succes
    }

    @SuppressLint("Range")
    fun getAllUsers() : ArrayList<UserModel> {
        val userList : ArrayList<UserModel> = ArrayList()
        val selectQuery = "SELECT * FROM $TABLE_USERS"
        val db = this.writableDatabase

        val cursor: Cursor?

        try {
            cursor = db.rawQuery(selectQuery, null)
        }
        catch (e: Exception) {
            db.execSQL(selectQuery)
            return ArrayList()
        }
        var name: String
        var anxiete: Int
        var depression: Int

        if  (cursor.moveToFirst()) {
            do {
                name = cursor.getString(cursor.getColumnIndex(Name))
                anxiete = cursor.getInt(cursor.getColumnIndex(Anxiete))
                depression = cursor.getInt(cursor.getColumnIndex(Depression))
                val User = UserModel(name, anxiete, depression)
                userList.add(User)
            }while (cursor.moveToNext())
        }
        return userList
    }
}
