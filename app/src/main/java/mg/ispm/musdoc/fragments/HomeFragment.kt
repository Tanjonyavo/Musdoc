package mg.ispm.musdoc.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import mg.ispm.musdoc.MPlayerActivity
import mg.ispm.musdoc.R
import mg.ispm.musdoc.adapter.GroupAdapter
import mg.ispm.musdoc.adapter.MusicAdapter
import mg.ispm.musdoc.adapter.MusicItemDecoration
import mg.ispm.musdoc.databinding.FragmentHomeBinding
import mg.ispm.musdoc.viewmodel.MusicCatalogViewModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val vm: MusicCatalogViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Horizontal list: discovery
        vm.music.observe(viewLifecycleOwner) { musicList ->
            val horizontalRecycler: RecyclerView = binding.horizontalRecyclerView
            horizontalRecycler.adapter = MusicAdapter(
                list = musicList.filter { it.liked == 0 },
                layoutId = R.layout.item_horizontal_music,
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

        // Vertical list: categories
        vm.groups.observe(viewLifecycleOwner) { groups ->
            val verticalRecycler: RecyclerView = binding.verticalRecyclerView
            verticalRecycler.adapter = GroupAdapter(
                groupList = groups,
                layoutId = R.layout.item_vertical_group,
                onGroupClick = { group ->
                    val args = Bundle().apply { putString("data", group.name) }
                    // Switch to list tab + filter
                    findNavController().navigate(R.id.list_page, args)
                }
            )
            if (verticalRecycler.itemDecorationCount == 0) {
                verticalRecycler.addItemDecoration(MusicItemDecoration())
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
