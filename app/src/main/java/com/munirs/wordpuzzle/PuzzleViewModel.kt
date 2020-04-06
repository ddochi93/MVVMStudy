package com.munirs.wordpuzzle

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PuzzleViewModel : ViewModel() {
    //var score = 0
    val score = MutableLiveData<Int>()
   // var word:WordPuzzleData? = null
    val gameFinish = MutableLiveData<Boolean>()
    val word = MutableLiveData<WordPuzzleData>()

    lateinit var words : ArrayList<WordPuzzleData>
    init {
        //Log.d("PuzzleViewModel", "PuzzleViewModel initialized")
        loadData()
        nextWord()
        score.value = 0 // 초기화? (handle null exception)
        gameFinish.value = false

    }

     fun loadData(){
        words = arrayListOf(
            WordPuzzleData("BOT","LE","T"),
            WordPuzzleData("EX","EPTION","C"),
            WordPuzzleData("PROCA","TINATION","S"),
            WordPuzzleData("INF","LTRATE","I"),
            WordPuzzleData("REC","NCILE","O")
        )
       // words.shuffle()
    }

     fun nextWord(){
        if(words.isEmpty()){
            gameFinish.value = true
        }
        else{
            //word = words.removeAt(0)
            word.value = words.removeAt(0)

        }

    }

    fun onSkip(){
        score.value = (score.value)?.minus(1)
        nextWord()
    }

    fun onWrongAnswer(){
        score.value = (score.value)?.minus(1)
        nextWord()
    }

    fun onRightAnswer() {
        score.value = (score.value)?.plus(1)
        nextWord()
    }

    fun onGameOver() {
        gameFinish.value  = false // rotate해도
    }


}