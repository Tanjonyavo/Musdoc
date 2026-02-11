package mg.ispm.musdoc.repository

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import mg.ispm.musdoc.MusicModel
import mg.ispm.musdoc.R
import mg.ispm.musdoc.repository.MusicRepository.Singleton.musicList

class MusicRepository(context: Context?) : SQLiteOpenHelper(context, DBNAME, null, 2) {

    companion object {
        private const val DBNAME = "MusicRepo"
        private const val TABLE_MUSIC = "MusicTable"

        private const val KEY_ID = "_id"
        private const val KEY_NAME = "name"
        private const val KEY_EFFECT = "effect"
        private const val KEY_IMAGE = "image"
        private const val KEY_AUDIO = "audio"
        private const val KEY_LIKED = "liked"
    }

    object Singleton {
        //créer une liste qui va stocker les musiques
        var musicList = arrayListOf<MusicModel>()

    }

    fun updateData(callback: () -> Unit) {
        musicList.clear()
        musicList = viewMusic()
        callback()
    }

    fun viewMusic(): ArrayList<MusicModel> {
        val mlist = ArrayList<MusicModel>()
        val selectQuery = "SELECT * FROM $TABLE_MUSIC"
        val db = this.readableDatabase
        var cursor: Cursor? = null

        try {
            cursor = db.rawQuery(selectQuery, null)
        } catch (e: Exception) {
            e.printStackTrace()
            db.execSQL(selectQuery)
            return ArrayList<MusicModel>()
        }

        var id: Int
        var name: String
        var effect: String
        var image: Int
        var audio: Int
        var liked: Int

        if (cursor.moveToFirst()) {
            do {
                id = cursor.getInt(0)
                name = cursor.getString(1)
                effect = cursor.getString(2)
                image = cursor.getInt(3)
                audio = cursor.getInt(4)
                liked = cursor.getInt(5)

                val mus = MusicModel(id, name, effect, image, audio, liked)
                mlist.add(mus)
            } while (cursor.moveToNext())
        }
        return mlist
    }

    override fun onCreate(db: SQLiteDatabase?) {
        var list = arrayListOf<MusicModel>()
        list.clear()

        //enregistrer une première musique dans notre liste
        list.add(MusicModel(1, "Drug and Alcohol addiction 1",
            "Bonus",
            R.drawable.ic_bonus,
            R.raw.danda1, 0))

        //enregistrer une seconde musique dans notre liste
        list.add(MusicModel(2, "Drug and Alcohol addiction 2",
            "Bonus",
            R.drawable.ic_bonus,
            R.raw.danda2, 0))

        //enregistrer une troisième musique dans notre liste
        list.add(MusicModel(3, "Depression 1",
            "Depression",
            R.drawable.ic_depression,
            R.raw.depression1,
            0))

        //enregistrer une quatrième musique dans notre liste
        list.add(MusicModel(4, "Depression 2",
            "Depression",
            R.drawable.ic_depression,
            R.raw.depression2,
            0))

        list.add(MusicModel(5, "Concentration 1",
            "Manque de concentration",
            R.drawable.ic_mdc,
            R.raw.mdc1,
            0))

        list.add(MusicModel(6, "Concentration 2",
            "Manque de concentration",
            R.drawable.ic_mdc,
            R.raw.mdc2,
            0))

        list.add(MusicModel(7, "Concentration 3",
            "Manque de concentration",
            R.drawable.ic_mdc,
            R.raw.mdc3,
            0))

        list.add(MusicModel(8, "Peur 1",
            "Peur",
            R.drawable.ic_fear,
            R.raw.peur1,
            0))

        list.add(MusicModel(9, "Peur 2",
            "Peur",
            R.drawable.ic_fear,
            R.raw.peur2,
            0))

        list.add(MusicModel(10, "Relaxation 1",
            "Relaxation",
            R.drawable.ic_relaxation,
            R.raw.relax1,
            0))

        list.add(MusicModel(11, "Relaxation 2-1",
            "Relaxation",
            R.drawable.ic_relaxation,
            R.raw.relax21,
            0))

        list.add(MusicModel(12, "Relaxation 2-2",
            "Relaxation",
            R.drawable.ic_relaxation,
            R.raw.relax22,
            0))

        list.add(MusicModel(13, "Son curative 1-1",
            "Son curative",
            R.drawable.ic_care,
            R.raw.sc11,
            0))

        list.add(MusicModel(14, "Son curative 1-2",
            "Son curative",
            R.drawable.ic_care,
            R.raw.sc12,
            0))

        list.add(MusicModel(15, "Son curative 2-1",
            "Son curative",
            R.drawable.ic_care,
            R.raw.sc21,
            0))

        list.add(MusicModel(16, "Son curative 2-2",
            "Son curative",
            R.drawable.ic_care,
            R.raw.sc22,
            0))

        list.add(MusicModel(17, "Anti-stress 1-1",
            "Stress",
            R.drawable.ic_stress,
            R.raw.stress11,
            0))

        list.add(MusicModel(18, "Anti-stress 1-2",
            "Stress",
            R.drawable.ic_stress,
            R.raw.stress12,
            0))

        list.add(MusicModel(19, "Anti-stress 2-1",
            "Stress",
            R.drawable.ic_stress,
            R.raw.stress21,
            0))

        list.add(MusicModel(20, "Anti-stress 2-2",
            "Stress",
            R.drawable.ic_stress,
            R.raw.stress22,
            0))

        val CREATE_MUSIC_TABLE = (
            "CREATE TABLE $TABLE_MUSIC (" +
                "$KEY_ID INTEGER PRIMARY KEY, " +
                "$KEY_NAME TEXT, " +
                "$KEY_EFFECT TEXT, " +
                "$KEY_IMAGE INTEGER, " +
                "$KEY_AUDIO INTEGER, " +
                "$KEY_LIKED INTEGER" +
            ")"
        )
        db?.execSQL(CREATE_MUSIC_TABLE)

        for (i in  0 until 20) {
            val values = ContentValues().apply {
                put(KEY_ID, list[i].id)
                put(KEY_NAME, list[i].name)
                put(KEY_EFFECT, list[i].effect)
                put(KEY_IMAGE, list[i].image)
                put(KEY_AUDIO, list[i].audio)
                put(KEY_LIKED, list[i].liked)
            }
            db?.insert(TABLE_MUSIC, null, values)
        }
    }

    fun updateMusic(music: MusicModel): Int {
        val db = this.writableDatabase

        val values = ContentValues().apply {
            put(KEY_NAME, music.name)
            put(KEY_EFFECT, music.effect)
            put(KEY_IMAGE, music.image)
            put(KEY_AUDIO, music.audio)
            put(KEY_LIKED, music.liked)
        }

        return db.update(TABLE_MUSIC, values, "$KEY_ID=?", arrayOf(music.id.toString()))
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_MUSIC")
        onCreate(db)
    }


}