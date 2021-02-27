package app.makino.harutiro.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class QuizActivity : AppCompatActivity() {

    val quizList: List<List<String>> = listOf(

        listOf("1+1=？","田","2","10","2"),
        listOf("文字サイズの設定はdp or sp どっち？","dp","sp","どっちでもない","sp"),
        listOf("GoogleのGの色は何色？","青","赤","黄色","赤")

    )

    val shuffledLists:List<List<String>> = quizList.shuffled()

    var quizCount: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        Log.d("debag",shuffledLists.toString())



    }
}