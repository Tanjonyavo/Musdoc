package mg.ispm.musdoc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mg.ispm.musdoc.adapter.UserAdapter
import mg.ispm.musdoc.databinding.ItemScoreBinding
import mg.ispm.musdoc.repository.UserRepository

class ScoreActivity : AppCompatActivity() {

    private lateinit var binding: ItemScoreBinding
    private lateinit var sqliteHelper: UserRepository
    private lateinit var recyclerView: RecyclerView
    private var adapters: UserAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ItemScoreBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        initRecyler()
        getUsers()

    }

    private fun initRecyler() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapters = UserAdapter()
        recyclerView.adapter = adapters

    }

    private fun getUsers() {
        val userList = sqliteHelper.getAllUsers()
        adapters?.addItem(userList)
    }

    private fun initView() {
        recyclerView = binding.recyclerViewScore
        sqliteHelper = UserRepository(this)

    }
}