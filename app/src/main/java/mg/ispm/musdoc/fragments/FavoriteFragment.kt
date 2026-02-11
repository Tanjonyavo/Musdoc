package mg.ispm.musdoc.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import mg.ispm.musdoc.MPlayerActivity
import mg.ispm.musdoc.R
import mg.ispm.musdoc.adapter.MusicAdapter
import mg.ispm.musdoc.adapter.MusicItemDecoration
import mg.ispm.musdoc.databinding.FragmentListBinding
import mg.ispm.musdoc.viewmodel.MusicCatalogViewModel

class FavoriteFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    private val vm: MusicCatalogViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.listRecycler.layoutManager = LinearLayoutManager(requireContext())
        if (binding.listRecycler.itemDecorationCount == 0) {
            binding.listRecycler.addItemDecoration(MusicItemDecoration())
        }

        vm.music.observe(viewLifecycleOwner) { musicList ->
            val favorites = musicList.filter { it.liked == 1 }
            binding.listRecycler.adapter = MusicAdapter(
                list = favorites,
                layoutId = R.layout.item_vertical_music,
                onMusicClick = { music ->
                    val intent = Intent(requireContext(), MPlayerActivity::class.java)
                        .putExtra("extra_message", music.audio)
                        .putExtra("extra", music.name)
                        .putExtra("extra_image", music.image)
                    startActivity(intent)
                },
                onToggleLike = { music -> vm.toggleLike(music) }
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
