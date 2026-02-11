package mg.ispm.musdoc.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import mg.ispm.musdoc.GroupModel
import mg.ispm.musdoc.MusicModel
import mg.ispm.musdoc.repository.GroupRepository
import mg.ispm.musdoc.repository.MusicRepository

class MusicCatalogViewModel(app: Application) : AndroidViewModel(app) {

    private val musicRepo = MusicRepository(app.applicationContext)
    private val groupRepo = GroupRepository()

    private val _music = MutableLiveData<List<MusicModel>>()
    val music: LiveData<List<MusicModel>> = _music

    private val _groups = MutableLiveData<List<GroupModel>>()
    val groups: LiveData<List<GroupModel>> = _groups

    init {
        refresh()
    }

    fun refresh() {
        musicRepo.updateData {
            groupRepo.updateData()
            _music.value = MusicRepository.Singleton.musicList
            _groups.value = GroupRepository.Singleton.groupList
        }
    }

    fun toggleLike(music: MusicModel) {
        music.liked = (music.liked + 1) % 2
        musicRepo.updateMusic(music)
        refresh()
    }
}
