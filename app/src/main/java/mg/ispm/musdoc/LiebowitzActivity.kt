package mg.ispm.musdoc

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import mg.ispm.musdoc.databinding.ActivityLiebowitzactivityBinding


class LiebowitzActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLiebowitzactivityBinding
    private var currentPosition: Int = 1
    private var questionList: ArrayList<LiebowitzModel>? = null
    private var selectedOption1: Int? = null
    private var selectedOption2: Int? = null
    private var nivAnxiete: Int = 0
    private var i: Int = 0
    private var nivEvitement: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLiebowitzactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        questionList = SetData.getQuestion()

        setQuestion()
        setSelectedOptionStyle(binding.Anx1, 1)
        setSelectedOptionStyle(binding.Evit1, 5)

        binding.Anx1.setOnClickListener {
            setSelectedOptionStyle(binding.Anx1, 1)
        }

        binding.Anx2.setOnClickListener {
            setSelectedOptionStyle(binding.Anx2, 2)
        }

        binding.Anx3.setOnClickListener {
            setSelectedOptionStyle(binding.Anx3, 3)
        }

        binding.Anx4.setOnClickListener {
            setSelectedOptionStyle(binding.Anx4, 4)
        }

        binding.Evit1.setOnClickListener {
            setSelectedOptionStyle(binding.Evit1, 5)
        }

        binding.Evit2.setOnClickListener {
            setSelectedOptionStyle(binding.Evit2, 6)
        }

        binding.Evit3.setOnClickListener {
            setSelectedOptionStyle(binding.Evit3, 7)
        }

        binding.Evit4.setOnClickListener {
            setSelectedOptionStyle(binding.Evit4, 8)
        }


        binding.valider.setOnClickListener {

            if (selectedOption1 != null && selectedOption2 != null) {
                var question = questionList!![currentPosition - 1]
                if (selectedOption1 == 2) {
                    nivAnxiete++
                }
                if (selectedOption1 == 3) {
                    nivAnxiete += 2
                }
                if (selectedOption1 == 4) {
                    nivAnxiete += 3
                }
                if (selectedOption2 == 6) {
                    nivEvitement++
                }
                if (selectedOption2 == 7) {
                    nivEvitement += 2
                }
                if (selectedOption2 == 8) {
                    nivEvitement += 3
                }


                currentPosition++
                when {
                    currentPosition <= questionList!!.size -> {
                        setQuestion()
                    }
                    else -> {
                        binding.valider.text = "Passer à BDII"
                        val name = intent.getStringExtra("user_name")
                        //Toast.makeText(this, (nivEvitement + nivAnxiete).toString(), Toast.LENGTH_SHORT).show()
                        val intent2 = Intent(this, BDIActivity::class.java).also {
                            it.putExtra("name_user", name).putExtra("score", nivEvitement + nivAnxiete)
                            startActivity(it)
                        }
                    }
                }
            }
        }
    }


    fun setColor(opt: Int, color: Int) {}


    fun setQuestion() {

        val question = questionList!![currentPosition - 1]
        binding.questionText.text = question.Question


    }


    fun setOptionStyle() {

        var optionList: ArrayList<TextView> = arrayListOf()
        optionList.add(0, binding.Anx1)
        optionList.add(1, binding.Anx2)
        optionList.add(2, binding.Anx3)
        optionList.add(3, binding.Anx4)

        for (op in optionList) {


            op.setTextColor(Color.parseColor("#555151"))
            op.background = ContextCompat.getDrawable(this, R.drawable.question_option)
            op.typeface = Typeface.DEFAULT

        }

    }


    fun setOptionStyle1() {
        var optonList: ArrayList<TextView> = arrayListOf()

        optonList.add(0, binding.Evit1)
        optonList.add(1, binding.Evit2)
        optonList.add(2, binding.Evit3)
        optonList.add(3, binding.Evit4)

        for (op in optonList) {


            op.setTextColor(Color.parseColor("#555151"))
            op.background = ContextCompat.getDrawable(this, R.drawable.question_option)
            op.typeface = Typeface.DEFAULT

        }
    }

    fun setSelectedOptionStyle(view: TextView, opt: Int) {


        if (opt <= 4) {
            setOptionStyle()
            selectedOption1 = opt
            view.background = ContextCompat.getDrawable(this, R.drawable.backclickbutton)

        }

        if (opt > 4) {
            setOptionStyle1()
            selectedOption2 = opt
            view.background = ContextCompat.getDrawable(this, R.drawable.backclickbutton1)
        }
        view.typeface = Typeface.DEFAULT_BOLD
        view.setTextColor(Color.parseColor("#000000"))


    }
}