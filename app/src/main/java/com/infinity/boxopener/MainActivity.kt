package com.infinity.boxopener
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    val listOfBoxes = mutableListOf<ImageView>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getActionBar()?.hide()
        setContentView(R.layout.activity_main)
        createImageViewList()

        val listener = View.OnClickListener { v ->
            v.visibility = View.INVISIBLE
            listOfBoxes.remove(v)
            if(listOfBoxes.size==0)
            {
                specialBox.visibility= View.VISIBLE
                ordinaryBox.visibility= View.VISIBLE
                lastOptionTextBox.visibility= View.VISIBLE
            }
        }

        specialBox.setOnClickListener()
        {
            val random = (0..4).random()
           val prize =  when(random)
            {
                0 -> "nokia"
                1 -> "samsung"
                2 -> " oppo"
               else -> " chat"
            }
            Toast.makeText(this , "you have won $prize", Toast.LENGTH_LONG).show()
            restartGame()
        }
        ordinaryBox.setOnClickListener()
        {
            val random = (0..4).random()
            val prize =  when(random)
            {
                0 -> "chicken dinner"
                1 -> "bmw"
                2 -> "usb 1mb"
                else -> "keyboard"
            }
            Toast.makeText(this , "you have won $prize", Toast.LENGTH_LONG).show()
            restartGame()
        }
        for (index in  listOfBoxes)
        {
            index.setOnClickListener(listener)
        }
        startGameBtn.setOnClickListener {
            startgame()
        }
    }

    private fun createImageViewList() {
        listOfBoxes.add(Box1)
        listOfBoxes.add(Box2)
        listOfBoxes.add(Box3)
        listOfBoxes.add(Box4)
        listOfBoxes.add(Box5)
        listOfBoxes.add(Box6)
        listOfBoxes.add(Box7)
        listOfBoxes.add(Box8)
    }

    private fun restartGame() {
        specialBox.visibility= View.INVISIBLE
        ordinaryBox.visibility= View.INVISIBLE
        lastOptionTextBox.visibility = View.GONE
        startGameBtn.visibility= View.VISIBLE
        createImageViewList()
    }

    private fun startgame() {
        startGameBtn.visibility= View.INVISIBLE
        instructionTv.visibility= View.VISIBLE
        for (element in listOfBoxes) {
            element.visibility = View.VISIBLE
        }

    }
    }


