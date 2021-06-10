package com.nayan.quizapp

object Constants {

    fun getQuestion(): ArrayList<Question> {
        val questionList = ArrayList<Question>()

        val que1 = Question(
            1,
            "What country does this flag belongs to?",
            R.drawable.brazil,
            "Brazil",
            "Japan",
            "India",
            "Germany",
            1
        )
        questionList.add(que1)

        val que2 = Question(
            2,
            "What country does this flag belongs to?",
            R.drawable.chile,
            "United Kingdom",
            "Japan",
            "France",
            "Chile",
            4
        )
        questionList.add(que2)

        val que3 = Question(
            3,
            "What country does this flag belongs to?",
            R.drawable.france,
            "United State",
            "France",
            "India",
            "Portugal",
            2
        )
        questionList.add(que3)

        val que4 = Question(
            4,
            "What country does this flag belongs to?",
            R.drawable.germany,
            "Thailand",
            "Japan",
            "Germany",
            "Chile",
            3
        )
        questionList.add(que4)

        val que5 = Question(
            5,
            "What country does this flag belongs to?",
            R.drawable.india,
            "United States",
            "Japan",
            "India",
            "Germany",
            3
        )
        questionList.add(que5)

        val que6 = Question(
            6,
            "What country does this flag belongs to?",
            R.drawable.japan,
            "Portugal",
            "Japan",
            "Thailand",
            "United Kingdom",
            2
        )
        questionList.add(que6)

        val que7 = Question(
            7,
            "What country does this flag belongs to?",
            R.drawable.portugal,
            "Portugal",
            "France",
            "Chile",
            "Brazil",
            1
        )
        questionList.add(que7)

        val que8 = Question(
            8,
            "What country does this flag belongs to?",
            R.drawable.thailand,
            "Brazil",
            "Thailand",
            "India",
            "Germany",
            2
        )
        questionList.add(que8)

        val que9 = Question(
            1,
            "What country does this flag belongs to?",
            R.drawable.united_kingdom,
            "Germany",
            "Japan",
            "United Kingdom",
            "Chile",
            3
        )
        questionList.add(que9)

        val que10 = Question(
            10,
            "What country does this flag belongs to?",
            R.drawable.united_states,
            "India",
            "United States",
            "France",
            "Germany",
            2
        )
        questionList.add(que10)

        return questionList
    }
}