 package mg.ispm.musdoc



import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import mg.ispm.musdoc.databinding.ActivityBdiactivityBinding
import mg.ispm.musdoc.repository.ScoreStore
import mg.ispm.musdoc.repository.UserRepository

class BDIActivity : AppCompatActivity() {
    private var currentPosition: Int = 1
    private var questionList: ArrayList<BDIModel>? = null
    private var selectedOption1: Int? = null
    private var bdii: Int = 0
    private lateinit var users : UserRepository
    private lateinit var binding: ActivityBdiactivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBdiactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSelectedOptionStyle(binding.depre1, 1)
        questionList = SetData.getQuestionA()

        setQuestion()

        binding.depre1.setOnClickListener {
            setSelectedOptionStyle(binding.depre1, 1)
        }

        binding.depre2.setOnClickListener {
            setSelectedOptionStyle(binding.depre2, 2)
        }

        binding.depre3.setOnClickListener {
            setSelectedOptionStyle(binding.depre3, 3)
        }

        binding.depre4.setOnClickListener {
            setSelectedOptionStyle(binding.depre4, 4)
        }


        users = UserRepository(this)

        binding.valider1.setOnClickListener {

            if (selectedOption1 != null) {
                val question = questionList!![currentPosition - 1]
                if (selectedOption1 == 2) {
                    bdii++
                }
                if (selectedOption1 == 3) {
                    bdii += 2
                }
                if (selectedOption1 == 4) {
                    bdii += 3
                }


                currentPosition++
                when {
                    currentPosition <= questionList!!.size -> {
                        setQuestion()
                    }
                    else -> {
                        binding.valider1.text = "TERMINER"
                        val name: String? = intent.getStringExtra("name_user")
                        val liebowitz = intent.getIntExtra("score", 0)
                        val toast = Toast.makeText(this,
                            name + " " + liebowitz.toString() + " " + bdii.toString(),
                            Toast.LENGTH_SHORT).show()
                        val use = UserModel(name, liebowitz, bdii)

                        val check=users.insertUsers(use)

                        if (check <= -1) {
                            Toast.makeText(this, "PAS SAUVEGARDER", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this, "Sauvegarder", Toast.LENGTH_SHORT).show()
                        }
                        val intent1 = Intent(this ,ResultActivity::class.java)
                        intent1.putExtra("extra_name", name)
                        startActivity(intent1)

                    }
                }

            }
        }

    }


    fun setColor(opt: Int, color: Int) {}


    fun setQuestion() {

        val question = questionList!![currentPosition - 1]
        binding.questionText.text = question.question
        binding.depre1.text = question.opt1
        binding.depre2.text = question.opt2
        binding.depre3.text = question.opt3
        binding.depre4.text = question.opt4


    }


    fun setOptionStyle() {

        val optionList: ArrayList<TextView> = arrayListOf()
        optionList.add(0, binding.depre1)
        optionList.add(1, binding.depre2)
        optionList.add(2, binding.depre3)
        optionList.add(3, binding.depre4)

        for (op in optionList) {


            op.setTextColor(Color.parseColor("#555151"))
            op.background = ContextCompat.getDrawable(this, R.drawable.question_option)
            op.typeface = Typeface.DEFAULT

        }

    }

    fun setSelectedOptionStyle(view: TextView, opt: Int) {

        setOptionStyle()
        selectedOption1 = opt
        view.background = ContextCompat.getDrawable(this, R.drawable.backclickbutton)
        view.typeface = Typeface.DEFAULT_BOLD
        view.setTextColor(Color.parseColor("#000000"))


    }
}