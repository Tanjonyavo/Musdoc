package mg.ispm.musdoc

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import mg.ispm.musdoc.databinding.ActivityMusictBinding

class MusicTActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMusictBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMusictBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Navigation Component + BottomNavigationView
        val navHost = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHost.navController
        binding.navigationView.setupWithNavController(navController)

        // Update page title based on destination
        navController.addOnDestinationChangedListener { _, destination, _ ->
            binding.pageTitle.text = destination.label ?: getString(R.string.app_name)
        }

        MenuFun(this)
    }

    private var backPressedTime: Long = 0
    private var backToast: Toast? = null

    override fun onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast!!.cancel()
            super.finishAffinity()
            return
        } else {
            backToast = Toast.makeText(baseContext, getString(R.string.tap_again_to_exit), Toast.LENGTH_SHORT)
            backToast!!.show()
        }
        backPressedTime = System.currentTimeMillis()
    }


    fun MenuFun(context: Context) {
        binding.menu.setOnClickListener {
            val popupMenu = androidx.appcompat.widget.PopupMenu(context, it)
            popupMenu.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.me -> {
                        val intent1 = Intent(context, MenuActivity::class.java).also {
                            it.putExtra("extra_message", 1)
                            startActivity(it)
                        }
                        true
                    }
                    R.id.tools -> {
                        val intent2 = Intent(context, ScoreActivity::class.java).also {
                            it.putExtra("extra_message", 2)
                            startActivity(it)
                        }
                        true
                    }
                    R.id.about -> {
                        val intent3 = Intent(context, MenuActivity::class.java).also {
                            it.putExtra("extra_message", 3)
                            startActivity(it)
                        }
                        true
                    }
                    R.id.credits -> {
                        val intent4 = Intent(context, MenuActivity::class.java).also {
                            it.putExtra("extra_message", 4)
                            startActivity(it)
                        }
                        true
                    }
                    R.id.logout -> {
                        val builder = AlertDialog.Builder(this@MusicTActivity)
                        builder.setMessage(getString(R.string.confirm_exit_message))
                        builder.setCancelable(true)

                        builder.setNegativeButton(getString(R.string.yes)) { _, _ ->
                            finishAffinity()
                        }
                        builder.setPositiveButton(getString(R.string.no)) { dialog, _ -> dialog.cancel() }
                        val alertDialog = builder.create()
                        alertDialog.show()

                        true
                    }
                    else -> false
                }
            }
            popupMenu.inflate(R.menu.menu_drawer)

            try {
                val fieldMPopup =
                    androidx.appcompat.widget.PopupMenu::class.java.getDeclaredField("mPopup")
                fieldMPopup.isAccessible = true
                val mPopup = fieldMPopup.get(popupMenu)
                mPopup.javaClass.getDeclaredMethod("setForceShowIcon", Boolean::class.java)
                    .invoke(mPopup, true)
            } catch (e: Exception) {
                Log.e("MusicT", "Erreur d'affichage des icônes de menu1", e)
            } finally {
                popupMenu.show()
            }
        }
    }
}