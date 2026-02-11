package mg.ispm.musdoc

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import mg.ispm.musdoc.databinding.ActivityResultBinding
import mg.ispm.musdoc.repository.ScoreStore
import mg.ispm.musdoc.repository.UserRepository

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    lateinit var users: UserRepository

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("extra_name")
        val user = ScoreStore.scores.filter { it.name == name }

        val toast = Toast.makeText(this, "hello -world", Toast.LENGTH_SHORT).show()

        binding.redo.setOnClickListener {
            Intent(this, MenuActivity::class.java).also {
                it.putExtra("extra_message", 1)
                startActivity(it)
            }
        }

        binding.quit.setOnClickListener {
            startActivity(Intent(this, MusicTActivity::class.java))
        }
    }
}