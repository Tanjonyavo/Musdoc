package mg.ispm.musdoc

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import mg.ispm.musdoc.databinding.ActivityMplayerBinding

class MPlayerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMplayerBinding
    private lateinit var runnable: Runnable
    private var handler = Handler(Looper.getMainLooper())
    private var mediaPlayer: MediaPlayer? = null

    override fun onBackPressed() {}

    private fun timer(duration: Int): String {
        val min = duration / 1000 / 60
        val sec = duration / 1000 % 60
        return String.format("%d:%02d", min, sec)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMplayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.titreMusique.text = intent.getStringExtra("extra")
        val mp = intent.getIntExtra("extra_message", R.raw.botsy)
        mediaPlayer = MediaPlayer.create(this, mp)
        val image = intent.getIntExtra("extra_image", R.drawable.ic_stress)

        binding.imageMusique.setImageResource(image)

        binding.seekbar.progress = 0
        mediaPlayer?.let { binding.seekbar.max = it.duration }

        binding.mpback.setOnClickListener {
            if (mediaPlayer?.isPlaying == true) {
                mediaPlayer?.pause()
                binding.playBtn.setImageResource(R.drawable.ic_play)
            }
            val intent = Intent(this, MusicTActivity::class.java)
            startActivity(intent)
        }


        binding.playBtn.setOnClickListener {
            mediaPlayer?.let {
                if (!it.isPlaying) {
                    it.start()
                    binding.playBtn.setImageResource(R.drawable.ic_pause)
                } else {
                    it.pause()
                    binding.playBtn.setImageResource(R.drawable.ic_play)
                }
            }
        }
        binding.seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                if (p2) {
                    mediaPlayer?.seekTo(p1)
                }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                p0?.let {
                    mediaPlayer?.seekTo(it.progress)
                }
            }

        })

        mediaPlayer?.let {
            val endTime = timer(it.duration)
            binding.textSongEnd.text = endTime
            runnable = Runnable {
                binding.seekbar.progress = it.currentPosition
                val timeCurrent = timer(it.currentPosition)
                binding.textSongStart.text = timeCurrent
                handler.postDelayed(runnable, 1000)
            }
            handler.postDelayed(runnable, 1000)
            it.setOnCompletionListener {
                binding.playBtn.setImageResource(R.drawable.ic_play)
            }
        }
    }

    override fun onStop() {
        super.onStop()
        mediaPlayer?.release()
        handler.removeCallbacks(runnable)
    }
}