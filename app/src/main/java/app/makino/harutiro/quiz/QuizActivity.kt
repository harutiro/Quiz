package app.makino.harutiro.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible

class QuizActivity : AppCompatActivity() {

    val quizList: List<List<String>> = listOf(

        listOf("ドロイドくんはどのOSのテーマキャラ？","Android","Windows","Linux","Android"),
        listOf("文字サイズの設定はdp or sp どっち？","dp","sp","どっちでもない","sp"),
        listOf("GoogleのGの色は何色？","青","赤","黄色","赤")

    )

    //中身をシャッフルして新しい配列に代入
    val shuffledLists:List<List<String>> = quizList.shuffled()

    var quizCount: Int = 0

    var correctAnswer: String = ""

    var correctCount: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        showQuestion()

        findViewById<Button>(R.id.answerButton1).setOnClickListener {
            chueckAnswer(findViewById<Button>(R.id.answerButton1).text.toString())
        }

        findViewById<Button>(R.id.answerButton2).setOnClickListener {
            chueckAnswer(findViewById<Button>(R.id.answerButton2).text.toString())
        }

        findViewById<Button>(R.id.answerButton3).setOnClickListener {
            chueckAnswer(findViewById<Button>(R.id.answerButton3).text.toString())
        }

        findViewById<Button>(R.id.nextButton).setOnClickListener {
            if(quizCount == quizList.size){

            }else{

                findViewById<ImageView>(R.id.judgeImage).isVisible = false
                findViewById<Button>(R.id.nextButton).isVisible = false

                findViewById<Button>(R.id.answerButton1).isEnabled = true
                findViewById<Button>(R.id.answerButton2).isEnabled = true
                findViewById<Button>(R.id.answerButton3).isEnabled = true

                findViewById<TextView>(R.id.correctAnswerText).text = ""

                showQuestion()
            }
        }



    }

    //画面に表示するクイズをはめ込む
    fun showQuestion(){
        val question: List<String> = shuffledLists[quizCount]

        //配列名・・・インデックス
        Log.d("debag",shuffledLists.toString())

        findViewById<TextView>(R.id.quizText).text = question[0]

        findViewById<Button>(R.id.answerButton1).text = question[1]
        findViewById<Button>(R.id.answerButton2).text = question[2]
        findViewById<Button>(R.id.answerButton3).text = question[3]

        correctAnswer = question[4]
    }

    //回答をチェックする
    fun chueckAnswer (answerText: String){

        if(answerText == correctAnswer){
            findViewById<ImageView>(R.id.judgeImage).setImageResource(R.drawable.maru_image)
            correctCount++
        }else{
            findViewById<ImageView>(R.id.judgeImage).setImageResource(R.drawable.batu_image)

        }

        showAnswer()

        quizCount++
    }

    fun showAnswer(){
        findViewById<TextView>(R.id.correctAnswerText).text = "正解: $correctAnswer"

        findViewById<ImageView>(R.id.judgeImage).isVisible = true

        findViewById<Button>(R.id.nextButton).isVisible = true

        findViewById<Button>(R.id.answerButton1).isEnabled = false
        findViewById<Button>(R.id.answerButton2).isEnabled = false
        findViewById<Button>(R.id.answerButton3).isEnabled = false
    }
}