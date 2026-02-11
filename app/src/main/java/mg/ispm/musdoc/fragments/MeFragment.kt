package mg.ispm.musdoc.fragments

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import mg.ispm.musdoc.LiebowitzActivity
import mg.ispm.musdoc.R
import mg.ispm.musdoc.databinding.FragmentMeBinding

class MeFragment : Fragment() {

    private var _binding: FragmentMeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentMeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.quizBtn.setOnClickListener {
            val name = binding.username.text?.toString()?.trim()
            if (TextUtils.isEmpty(name)) {
                Toast.makeText(requireContext(), getString(R.string.fill_all_fields), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Intent(requireContext(), LiebowitzActivity::class.java).also {
                it.putExtra("user_name", name)
                startActivity(it)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
