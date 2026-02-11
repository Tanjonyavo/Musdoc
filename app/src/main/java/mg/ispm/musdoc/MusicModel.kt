package mg.ispm.musdoc

class MusicModel(
    val id: Int = 1,
    val name: String = "Music",
    val effect: String = "Bonus",
    val image: Int = R.drawable.ic_stress,
    val audio: Int = R.raw.music,
    var liked: Int = 0
)
