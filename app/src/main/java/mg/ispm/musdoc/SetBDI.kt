package mg.ispm.musdoc

object SetBDI {
    fun getQuestionBDI(): ArrayList<BDIModel> {
        val questionList = ArrayList<BDIModel>()

        val q1 = BDIModel(
            1,
            "Tristesse",
            "Je ne me sens pas triste.",
            "Je me sens abattu ou triste.",
            "Je suis tout le temps abattu ou triste et je n\'en peux plus.",
            "Je suis si triste et si malheureux que je ne peux le supporter."
        )
        questionList.add(q1)

        val q2 = BDIModel(
            2,
            "Pessimisme",
            "Je ne suis pas particulièrement découragé ou pessimiste au sujet de l\'avenir.",
            "Je me sens découragé au sujet de l\'avenir.",
            "J\'ai le sentiment de n\'avoir aucun avenir.",
            "Mon avenir est sans espoir et ne peut s\'améliorer."
        )
        questionList.add(q2)

        val q3 = BDIModel(
            3,
            "Échecs dans le passé",
            "Je n\'ai pas le sentiment d\'avoir échoué dans ma vie.",
            "J\'ai l\'impression d\'avoir eu plus d\'échecs que la plupart des gens.",
            "Quand je regarde ma vie passée, tout ce que je vois est un grand nombre d\'échecs.",
            "J\'ai le sentiment d\'être un raté complet sur le plan personnel (en tant que parent, mari, femme)."
        )
        questionList.add(q3)

        val q4 = BDIModel(
            4,
            "Perte de plaisir",
            "Je tire autant de plaisir et de satisfaction des choses qu\'auparavant.",
            "Je ne prends plus autant de plaisir aux choses qu\'auparavant.",
            "Je ne tire plus aucune satisfaction de quoi que ce soit.",
            "Je suis insatisfait ou je m\'ennuie de tout."
        )
        questionList.add(q4)

        val q5 = BDIModel(
            5,
            "Sentiments de culpabilité",
            "Je ne me sens pas particulièrement coupable.",
            "Je me sens coupable pour beaucoup de choses que j\'ai faites ou que j\'aurais dû faire.",
            "Je me sens coupable presque tout le temps.",
            "Je me sens coupable en permanence."
        )
        questionList.add(q5)

        val q6 = BDIModel(
            6,
            "Sentiments d\'être puni",
            "Je n\'ai pas l\'impression d\'être puni.",
            "J\'ai le sentiment que quelque chose de mal pourrait m\'arriver.",
            "J\'ai le sentiment d\'être puni ou d\'aller être puni.",
            "Je sens que je mérite d\'être puni."
        )
        questionList.add(q6)

        val q7 = BDIModel(
            7,
            "Mésestime de soi",
            "Je ne suis pas déçu par moi-même.",
            "Je suis déçu par moi-même.",
            "Je suis dégoûté de moi-même.",
            "Je me hais."
        )
        questionList.add(q7)

        val q8 = BDIModel(
            8,
            "Image de soi",
            "Je ne me sens pas plus mauvais que les autres.",
            "Je suis très critique envers moi-même pour mes faiblesses ou mes erreurs.",
            "Je me blâme tout le temps pour mes fautes.",
            "Je me blâme pour tout le mal qui arrive."
        )
        questionList.add(q8)

        val q9 = BDIModel(
            9,
            "Idées suicidaires",
            "Je n\'ai aucune pensée de me faire du mal.",
            "J\'ai des idées de suicide, mais je ne les mettrais pas à exécution.",
            "J\'aimerais me suicider.",
            "Je me tuerais si j\'en avais l\'occasion."
        )
        questionList.add(q9)

        val q10 = BDIModel(
            10,
            "Crises de larmes",
            "Je ne pleure pas plus que d\'habitude.",
            "Je pleure plus qu\'auparavant.",
            "Je pleure maintenant pour n\'importe quoi.",
            "Avant, je pouvais pleurer, mais maintenant, je suis incapable de pleurer même si j\'en ai envie."
        )
        questionList.add(q10)

        val q11 = BDIModel(
            11,
            "Irritabilité",
            "Je ne suis pas plus agacé ou irrité que d\'habitude.",
            "Je suis un peu plus agacé ou irrité que d\'habitude.",
            "Je suis beaucoup plus agacé ou irrité que d\'habitude.",
            "Je suis agacé ou irrité en permanence."
        )
        questionList.add(q11)

        val q12 = BDIModel(
            12,
            "Perte d\'intérêt",
            "Je n\'ai pas perdu mon intérêt pour les autres.",
            "Je suis moins intéressé par les autres qu\'auparavant.",
            "J\'ai perdu la plus grande partie de mon intérêt pour les autres.",
            "J\'ai perdu tout intérêt pour les autres."
        )
        questionList.add(q12)

        val q13 = BDIModel(
            13,
            "Indécision",
            "Je prends mes décisions à peu près comme d\'habitude.",
            "J\'évite de prendre des décisions plus qu\'avant.",
            "J\'ai plus de difficultés à prendre des décisions qu\'auparavant.",
            "J\'ai du mal à prendre la moindre décision."
        )
        questionList.add(q13)

        val q14 = BDIModel(
            14,
            "Dévalorisation de son physique",
            "Je n\'ai pas l\'impression d\'avoir l\'air plus mal qu\'avant.",
            "Je crains d\'avoir l\'air vieux ou peu séduisant.",
            "J\'ai le sentiment que des changements permanents sont apparus dans mon physique et qu\'ils me rendent peu séduisant.",
            "Je suis persuadé d\'être laid."
        )
        questionList.add(q14)

        val q15 = BDIModel(
            15,
            "Perte d\'énergie",
            "Je peux travailler à peu près aussi bien qu\'auparavant.",
            "Il me faut un effort supplémentaire pour commencer à faire quelque chose.",
            "Je dois me forcer beaucoup pour faire quoi que ce soit.",
            "Je suis incapable de faire le moindre travail."
        )
        questionList.add(q15)

        val q16 = BDIModel(
            16,
            "Changements dans le sommeil",
            "Je ne dors pas plus mal que d\'habitude.",
            "Je me réveille plus fatigué le matin que d\'habitude.",
            "Je me réveille une ou deux heures plus tôt que d\'habitude et j\'ai du mal à me rendormir.",
            "Je me réveille plusieurs heures plus tôt que d\'habitude et ne peux me rendormir."
        )
        questionList.add(q16)

        val q17 = BDIModel(
            17,
            "Fatigabilité",
            "Je ne me fatigue pas plus que d\'habitude.",
            "Je me fatigue plus facilement qu\'auparavant.",
            "Je suis trop fatigué pour faire presque tout ce que je faisais.",
            "Je suis trop fatigué pour faire quoi que ce soit."
        )
        questionList.add(q17)

        val q18 = BDIModel(
            18,
            "Perte d\'appétit",
            "Mon appétit n\'est pas plus mauvais que d\'habitude.",
            "Mon appétit n\'est pas aussi bon que d\'habitude.",
            "Mon appétit est beaucoup plus mauvais qu\'auparavant.",
            "Je n\'ai plus du tout d\'appétit."
        )
        questionList.add(q18)

        val q19 = BDIModel(
            19,
            "Perte de poids",
            "Je n\'ai pas perdu beaucoup de poids, si tant est que j\'en aie perdu, récemment.",
            "J\'ai perdu plus de 2,5 kg.",
            "J\'ai perdu plus de 5 kg.",
            "J\'ai perdu plus de 7,5 kg."
        )
        questionList.add(q19)

        val q20 = BDIModel(
            20,
            "Préoccupations pour sa santé",
            "Je ne suis pas plus préoccupé par ma santé que d\'habitude.",
            "Je suis préoccupé par des problèmes physiques tels que des maux et des douleurs, ou des maux d\'estomac, ou la constipation.",
            "Je suis très préoccupé par des problèmes physiques et il m\'est difficile de penser à autre chose.",
            "Je suis si préoccupé par mes problèmes physiques que je ne peux penser à rien d'autre."
        )
        questionList.add(q20)

        val q21 = BDIModel(
            21,
            "Perte d\'intérêt pour le sexe",
            "Je n\'ai pas remarqué de changement récent dans mon intérêt pour le sexe.",
            "Je suis moins intéressé par le sexe qu\'auparavant.",
            "Je suis beaucoup moins intéressé par le sexe maintenant.",
            "J\'ai perdu tout intérêt pour le sexe."
        )
        questionList.add(q21)

        return questionList
    }
}
