package com.example.myapplication.data.data

import com.example.myapplication.domain.model.ElementDetailsModel
import com.example.myapplication.domain.model.VocabularyListModel
import com.example.myapplication.domain.model.FormulasModel
import com.example.myapplication.domain.model.Question

object Elements {
    fun getElements(): List<VocabularyListModel> {
        val list = mutableListOf<VocabularyListModel>()
        list.add(VocabularyListModel(1, "Адабиёт", "литература", "literature"))
        list.add(VocabularyListModel(2, "Адад", "число", "number"))
        list.add(VocabularyListModel(3, "Адолат", "справедливость", "justice"))
        list.add(VocabularyListModel(4, "Азиз", "уважаемый", "dear"))
        list.add(VocabularyListModel(5, "Ақл", "ум", "intelligence"))
        list.add(VocabularyListModel(6, "Алов", "огонь", "fire"))
        list.add(VocabularyListModel(7, "Алаф", "трава", "grass"))
        list.add(VocabularyListModel(8, "Аскар", "солдат", "soldier"))
        list.add(VocabularyListModel(9, "Атроф", "вокруг", "around"))
        list.add(VocabularyListModel(10, "Афсона", "сказка", "story"))
        return list
    }

    fun getElementsById(id: Int): VocabularyListModel {
        val position = getElements().indexOfFirst { it.id == id }
        return getElements()[position]
    }

    private fun getElementsDetails(): List<ElementDetailsModel> {
        val list = mutableListOf<ElementDetailsModel>()
        list.add(
            ElementDetailsModel(
                1,
                "2,1",
                "-255.34°C",
                "-252.87°C",
                "0",
                "8.988x10!^5 г/см^3",
                "Генри Кавендиш Англия 1766г"
            )
        )
        list.add(
            ElementDetailsModel(
                2,
                "",
                "-272,2°C",
                "-268,934°C",
                "0",
                "0,0001787 г/см^3",
                "Вилям Рэмсли, Нилс Ленгет, П.Т. Клив"
            )
        )
        list.add(
            ElementDetailsModel(
                3,
                "0,97",
                "180,54°C",
                "1342°C",
                "71",
                "0,53 г/см^3",
                "Йоханн Арфведсон"
            )
        )
        list.add(
            ElementDetailsModel(
                4,
                "1,47",
                "1287°C",
                "2472°C",
                "179",
                "1,848 г/см^3",
                "Ф. Велер, А. А. Басси"
            )
        )
        list.add(
            ElementDetailsModel(
                5,
                "2,02",
                "2079°C",
                "4000°C",
                "26",
                "2,34 г/см^3",
                "Г. Дэви, Ж. Гей-Люссак, Л. Тенар"
            )
        )
        list.add(ElementDetailsModel(6, "2,50", "3825°C", "4827°C", "0", "2,62 г/см^3", ""))
        list.add(
            ElementDetailsModel(
                7,
                "3,07",
                "-209,86°C",
                "-195,8°C",
                "0",
                "0,0012506 г/см^3",
                "Даниэл Резерфорд"
            )
        )
        list.add(
            ElementDetailsModel(
                8,
                "3,50",
                "-218,4°C",
                "-182,962°C",
                "0",
                "0,001429 г/см^3",
                "Ҷозеф Пристли, Карл Вилям Шейл"
            )
        )
        list.add(
            ElementDetailsModel(
                9,
                "4,10",
                "-219,62°C",
                "-188,14°C",
                "0",
                "0,001696 г/см^3",
                "Генри Муассан"
            )
        )
        list.add(
            ElementDetailsModel(
                10,
                "",
                "-248,67°C",
                "-246,048°C",
                "0",
                "0,0008999 г/см^3",
                "Вилям Рамзай, М. Траверс"
            )
        )
        return list
    }


    fun getQuestions(): MutableList<Question> {
        val questionsList = mutableListOf<Question>()

        val question1 = Question(
            1,
            "Тарҷумаи калимаи адабиёт",
            "литература",
            "число",
            "справедливость",
            1
        )
        questionsList.add(question1)

        val question2 = Question(
            1,
            "Тарҷумаи калимаи Адад",
            "уважаемый",
            "число",
            "справедливость",
            2
        )
        questionsList.add(question2)

        val question3 = Question(
            1,
            "Тарҷумаи калимаи Азиз",
            "уважаемый",
            "огонь",
            "число",
            1
        )
        questionsList.add(question3)

        val question4 = Question(
            1,
            "Тарҷумаи калимаи Алаф",
            "трава",
            "солдат",
            "вокруг",
            1
        )
        questionsList.add(question4)

        val question5 = Question(
            1,
            "Тарҷумаи калимаи Ахлоқ",
            "сказка",
            "трава",
            "мораль",
            3
        )
        questionsList.add(question5)

        val question6 = Question(
            1,
            "Тарҷумаи калимаи Афсона",
            "сказка",
            "новость",
            "солдат",
            1
        )
        questionsList.add(question6)

        val question7 = Question(
            1,
            "Тарҷумаи калимаи Аломат",
            "традиция",
            "безопасность",
            "знак",
            3
        )
        questionsList.add(question7)


        val question8 = Question(
            1,
            "Тарҷумаи калимаи Адолат",
            "число",
            "справедливость",
            "литература",
            2
        )
        questionsList.add(question8)

        val question9 = Question(
            1,
            "Тарҷумаи калимаи Атроф",
            "сказка",
            "вокруг",
            "разум",
            2
        )
        questionsList.add(question9)

        val question10 = Question(
            1,
            "Тарҷумаи калимаи Ахбор",
            "новость",
            "мораль",
            "население",
            1
        )
        questionsList.add(question10)
        return questionsList
    }

    fun getFormulas(): List<FormulasModel> {
        val list = mutableListOf<FormulasModel>()
        list.add(FormulasModel("Азиди барий :", "BaN6"))
        list.add(FormulasModel("Азиди кадмий :", "Cd(N3)2"))
        list.add(FormulasModel("Азиди нуқра :", "AgN3"))
        list.add(FormulasModel("Сезий азиди :", "CsN3"))
        list.add(FormulasModel("Нитроген :", "N2"))
        list.add(FormulasModel("Кислотаи нитроген :", "HNO2"))
        list.add(FormulasModel("Кислотаи гидразой :", "HN3"))
        list.add(FormulasModel("Кислотаи нитрат :", "HNO3"))
        list.add(FormulasModel("Азулен :", "C10H8"))
        list.add(FormulasModel("Акрилонитрил :", "H2C(CH)CN"))
        list.add(FormulasModel("Албит :", "N4H4"))
        return list
    }

    fun getDetailsElementById(id: Int): ElementDetailsModel {
        val position = getElementsDetails().indexOfFirst { it.id == id }
        return getElementsDetails()[position]
    }
}