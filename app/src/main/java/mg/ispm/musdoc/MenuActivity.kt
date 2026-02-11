package mg.ispm.musdoc

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import mg.ispm.musdoc.fragments.MeFragment
import mg.ispm.musdoc.fragments.ScoreFragment

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val n = intent.getIntExtra("extra_message", 0)
        when (n) {
            1 -> loadFragment(MeFragment())
            2 -> loadFragment(ScoreFragment())
            3 -> {
                AlertDialog.Builder(this)
                    .setTitle(getString(R.string.about_title))
                    .setMessage(getString(R.string.about_body))
                    .setPositiveButton(android.R.string.ok) { _, _ -> finish() }
                    .show()
            }
            4 -> {
                AlertDialog.Builder(this)
                    .setTitle(getString(R.string.credits_title))
                    .setMessage(getString(R.string.credits_body))
                    .setPositiveButton(android.R.string.ok) { _, _ -> finish() }
                    .show()
            }
            else -> finish()
        }

    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.menufragment_container, fragment)
        transaction.commit()
    }
}