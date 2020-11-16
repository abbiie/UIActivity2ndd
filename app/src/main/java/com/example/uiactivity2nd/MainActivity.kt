package com.example.uiactivity2nd

import android.content.Intent
import android.content.pm.PackageManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ListView
import androidx.core.app.ActivityCompat
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {
    var songList = ArrayList<SongDetails>()
    var mp : MediaPlayer? = null
    var adapter : SongAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.READ_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),
                111
            )
        } else loadSong()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode==111 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            loadSong()
    }
    inner class SongAdapter : BaseAdapter{
        var myListSong = ArrayList<SongDetails>()

        constructor(myListSong: ArrayList<SongDetails>) : super() {
            this.myListSong = myListSong
        }

        override fun getCount(): Int {
            return myListSong.size
        }

        override fun getItem(position: Int): Any {
           return myListSong[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {
            var myView = layoutInflater.inflate(R.layout.activity_main, null)
            var song = myListSong[position]
//            myView.textView1.text = song.Title
//            myView.

            return myView
//            val myView = layoutInflater.inflate(R.layout.mylayout, null)
//            var song: SongDetails = myListSong[position]
//            myView. =
//            return myView

        }

    }
    private fun loadSong() {

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.GoAlbum -> {
                startActivity(Intent(this, Album::class.java))
                true
            }
            R.id.GoSongs -> {
                startActivity(Intent(this, Songs::class.java))
                true
            }
            R.id.SongQueue -> {
                startActivity(Intent(this, SongQueue::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}