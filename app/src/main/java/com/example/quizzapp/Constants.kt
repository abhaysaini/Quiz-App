package com.example.quizzapp

object Constants {

    const val USER_NAME:String = "user_name"
    const val CORRECT_ANSWER :String ="correct_answer"
    const val TOTAL_QUES :String = "total_ques"

    fun getQuestion():ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val ques1 = Question(
            1,
            "What Country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "Indiana",
            "Italy",
            "India",
            "France",
            3
        )

        val ques2 = Question(
            2,
            "What Country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Armenia",
            "Argentina",
            "Austria",
            "Australia",
            2
        )

        val ques3 = Question(
            3,
            "What Country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "Armenia",
            "Argentina",
            "Austria",
            "Australia",
            4
        )

        val ques4 = Question(
            4,
            "What Country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Belgium",
            "Brazil",
            "Belarus",
            "Italy",
            1
        )

        val ques5 = Question(
            5,
            "What Country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Belgium",
            "Brazil",
            "Belarus",
            "Italy",
            2
        )

        val ques6 = Question(
            6,
            "What Country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Denmark",
            "Italy",
            "India",
            "France",
            1
        )

        val ques7 = Question(
            7,
            "What Country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Mexico",
            "Germany",
            "India",
            "France",
            2
        )

        val ques8 = Question(
            8,
            "What Country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "Australia",
            "New Zealand",
            "Belgium",
            "United State of America",
            2
        )

        val ques9 = Question(
            9,
            "What Country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "England",
            "Italy",
            "India",
            "Kuwait",
            4
        )

        val ques10 = Question(
            10,
            "What Country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "England",
            "Italy",
            "fiji",
            "Kuwait",
            3
        )

        questionList.add(ques1)
        questionList.add(ques2)
        questionList.add(ques3)
        questionList.add(ques4)
        questionList.add(ques5)
        questionList.add(ques6)
        questionList.add(ques7)
        questionList.add(ques8)
        questionList.add(ques9)
        questionList.add(ques10)


        return questionList
    }
}