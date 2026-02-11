package mg.ispm.musdoc

object SetData {

    fun getQuestionA(): ArrayList<BDIModel> {
        var tmp = ArrayList<BDIModel>();

        tmp.add(BDIModel(1,
            "Tristesse",
            "Je ne me sens pas triste",
            "Je me sens très souvent triste",
            "Je suis tout le temps triste",
            "Je suis si triste que ce n'est pas supportable"))
        tmp.add(BDIModel(2,
            "Pessimisme",
            "Je ne suis pas découragé face à mon avenir",
            "Je me sens plus découragé qu'avant face à mon avenir",
            "Je ne m'attends pas à ce que les choses s'arrangent pour moi",
            "J'ai le sentiment que mon avenir est sans espoir et ne peut qu'empirer"))
        tmp.add(BDIModel(3,
            "Echec dans le passé",
            "Je n'ai pas le sentiment d'avoir échoué dans la vie",
            "J'ai échoué plus souvent que je n'aurais du",
            "Quand je pense à mon passé, je constate un grand nombre d'échec",
            "J'ai le sentiment d'avoir complètement raté ma vie"))
        tmp.add(BDIModel(4,
            "Perte de plaisir",
            "J'éprouve toujours de plaisir qu'avant aux choses qui me plaisent",
            "Je n'éprouve pas autant de plaisir qu'avant",
            "J'éprouve très peu de plaisir aux choses qui me plaisent",
            "Je n'éprouve aucun plaisir aux choses qui me plaisaient"))
        tmp.add(BDIModel(5,
            "Sentiments de culpabilité",
            "Je ne me sens pas particulièrement coupable",
            "Je me sens coupable pour bien des choses que j'ai faites ou que j'aurais dû faire",
            "Je me sens coupable la plupart du temps",
            "Je me sens tout le temps coupable"))
        tmp.add(BDIModel(6,
            "Sentiment d'être puni(e)",
            "Je n'ai pas le sentiment d'être puni(e)",
            "Je sens que je pourrais être puni(e)",
            "Je m'attends à être puni(e)",
            "J'ai le sentiment d'être puni(e)"))
        tmp.add(BDIModel(7,
            "Sentiments négatifs envers soi-même",
            "Mes sentiments envers moi-même n'ont pas changé",
            "J'ai perdu confiance en moi",
            "Je suis déçu(e) par moi-même",
            "Je ne m'aime pas du tout"))
        tmp.add(BDIModel(8,
            "Attitude critique envers soi",
            "Je ne me blâme pas ou ne me critique pas plus que d'habitude",
            "Je suis plus critique envers moi-même que je ne l'étais",
            "Je me reproche tous mes défauts",
            "Je me reproche tous les malheurs qui arrivent"))
        tmp.add(BDIModel(9,
            "Pensées ou désirs de suicide",
            "Je ne pense pas du tout à me suicider",
            "Il m'arrive de penser à me suicider, mais je ne le ferais pas",
            "J'aimerais me suicider",
            "Je me suiciderais si l'occasion se présenterait"))
        tmp.add(BDIModel(10,
            "Pleurs",
            "Je ne pleure pas plus qu'avant",
            "Je pleure plus qu'avant",
            "Je pleure pour la moindre petite chose",
            "Je voudrais pleurer mais je ne suis pas capable"))
        tmp.add(BDIModel(11,
            "Agitation",
            "Je ne suis pas plus agité(e) que d'habitude",
            "Je me sens plus agité(e) que d'habitude",
            "Je suis si agité(e) que j'ai du mal à retser tranquille",
            "Je suis si agité(e) que je dois continuellement bouger ou faire quelque chose"))
        tmp.add(BDIModel(12,
            "Perte d'intérêts",
            "Je n'ai pas perdu d'intérêt pour les gens ou pour les activités",
            "Je m'intéresse moins qu'avant aux gens et aux choses",
            "Je ne m'intéresse presque plus aux gens et aux choses",
            "J'ai du mal à m'intéresser à quoique ce soit"))
        tmp.add(BDIModel(13,
            "Indécision",
            "Je prends des décisions toujours aussi bien qu'avant",
            "Il m'est plus difficile que d'habitude de prendre des décisions",
            "J'ai beaucoup plus de mal qu'avant à prendre des décisions",
            "J'ai du mal à prendre n'importe quelle décision"))
        tmp.add(BDIModel(14,
            "Dévalorisation",
            "Je pense être quelqu'un de valable",
            "Je ne crois pas avoir autant de valeur ni être aussi utile qu'avant",
            "je me sens moins valable que les autres",
            "Je ne je sens que je ne vaux absulement rien"))
        tmp.add(BDIModel(15,
            "Perte d'énergie",
            "J'ai toujours autant d'énergie",
            "J'ai moins d'énergie qu'avant ",
            "je n'ai pas assez d'énergie pour pouvoir faire grand-chose",
            "J'ai trop peu d'énergie pour faire quoi que ce soit"))
        tmp.add(BDIModel(16,
            "Modifications dans les habitudes de sommeil",
            "Je dors un peu plus/moins que d'habitude",
            "Je dors beaucoup plus/moins que d'habitude",
            "Je me reveille une ou deux heures plus tôt et je suis incaple de me rendormir",
            "Je dors presque toute la journée"))
        tmp.add(BDIModel(17,
            "Irritabilité",
            "Je ne suis pas plus irritable qu'avant",
            "Je suis plus irrritable qu'avant",
            "Je suis beaucoup plus irrritable qu'avant",
            "Je suis constament irritable"))
        tmp.add(BDIModel(18,
            "Modifications de l'appétit",
            "Mon appétit n'a pas changé",
            "J'ai un peu plus/moins d'appétit qu'avant",
            "J'ai beaucoup plus/moins d'apppétit",
            "J'ai toujours envie de manger/Je n'ai pas du tout envie de manger"))
        tmp.add(BDIModel(19,
            "Difficulté à se concentrer",
            "Je parvient à me concentrer toujours aussi bien qu'avant",
            "je ne parviens pas à me concentrer aussi bien comme d'habitude",
            "J'ai du mal à me concentrer longtemps sur quoi que ce soit",
            "Je me trouve incapable de me concentrer sur quoi que ce soit"))
        tmp.add(BDIModel(20,
            "Fatigue",
            "Je ne suis pas plus fatigué(e) que d'habitude",
            "Je me fatigue plus facilement",
            "Je suis trop fatigué(e) pour faire un grand nombre de choses que je faisait avant",
            "Je suis trop fatigué(e) pour faire la plupart des choses que je faisait avant"))
        tmp.add(BDIModel(21,
            "Perte d'intérêt pour le sexe",
            "Pas de changement pour l'intérêt au sexe",
            "Le sexe m'interesse moins qu'avant",
            "Le sexe m'interesse beaucoup moins maintenant",
            "J'ai perdu tout intérêt pour le sexe"))

        return tmp
    }

    fun getQuestion(): ArrayList<LiebowitzModel> {
        var Allquest: ArrayList<LiebowitzModel> = arrayListOf()


        var quest1 = LiebowitzModel(
            "Telephoner en public",
            1
        )

        var quest2 = LiebowitzModel(
            "Participer au sein d'un petit groupe",
            2
        )

        var quest3 = LiebowitzModel(
            "Manger dans un lieu public",
            3
        )

        var quest4 = LiebowitzModel(
            "Boire en compagnie dans un lieu public",
            4
        )

        var quest5 = LiebowitzModel(
            "Parler à des gens qui détiennent une autorité",
            5
        )

        var quest6 = LiebowitzModel(
            "Jouer, donner une représentation ou une conférence",
            6
        )

        var quest7 = LiebowitzModel(
            "Aller à une soirée",
            7
        )

        var quest8 = LiebowitzModel(
            "Travailler en étant observé",
            8
        )

        var quest9 = LiebowitzModel(
            "Ecrire en étant observé",
            9
        )

        var quest10 = LiebowitzModel(
            "Contacter par téléphone quelqu'un que vous ne connaissez pas très bien",
            10
        )
        var quest11 = LiebowitzModel(
            "Parler à des inconnues",
            11
        )
        var quest12 = LiebowitzModel(
            "Rencontrer des inconnus",
            12
        )
        var quest13 = LiebowitzModel(
            "Uriner dans les toilettes publiques",
            13
        )
        var quest14 = LiebowitzModel(
            "Entrer dans une pièce alors que tout le monde est déja assis",
            14
        )
        var quest15 = LiebowitzModel(
            "Être le centre d'attention",
            15
        )
        var quest16 = LiebowitzModel(

            "Prendre la parole à une réunion",
            16
        )
        var quest17 = LiebowitzModel(
            "Passer un examen",
            17
        )
        var quest18 = LiebowitzModel(
            "Exprimer son désaccord à des inconnues",
            18
        )
        var quest19 = LiebowitzModel(
            "Regarder dans les yeux des gens que vous ne connaissez pas très bien",
            19
        )
        var quest20 = LiebowitzModel(
            "Faire un compte-rendu à un groupe",
            20
        )
        var quest21 = LiebowitzModel(
            "Essayer de draguer quelqu'un",
            21
        )
        var quest22 = LiebowitzModel(
            "Rapporter des marchandises dans un magasin",
            22
        )
        var quest23 = LiebowitzModel(
            "Donner une soirée",
            23
        )
        var quest24 = LiebowitzModel(
            "Résister aux pressions d'un vendeur insistant",
            24
        )


        Allquest.add(quest1)
        Allquest.add(quest2)
        Allquest.add(quest3)
        Allquest.add(quest4)
        Allquest.add(quest5)
        Allquest.add(quest6)
        Allquest.add(quest7)
        Allquest.add(quest8)
        Allquest.add(quest9)
        Allquest.add(quest10)
        Allquest.add(quest11)
        Allquest.add(quest12)
        Allquest.add(quest13)
        Allquest.add(quest14)
        Allquest.add(quest15)
        Allquest.add(quest16)
        Allquest.add(quest17)
        Allquest.add(quest18)
        Allquest.add(quest19)
        Allquest.add(quest20)
        Allquest.add(quest21)
        Allquest.add(quest22)
        Allquest.add(quest23)
        Allquest.add(quest24)


        return Allquest
    }
}