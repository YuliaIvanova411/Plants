package com.example.plants.ui.theme

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.plants.Plant
import com.example.plants.R
import com.example.plants.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    lateinit var binding: ActivityEditBinding
    private  var indexImage = 0
    private var imageId = R.drawable.one
    private val imageIdList = listOf(
        R.drawable.one,
        R.drawable.two,
        R.drawable.three,
        R.drawable.four,
        R.drawable.five,
        R.drawable.six,)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initButtons()
        }
    private fun initButtons() = with(binding) {
        buttonNext.setOnClickListener {
            indexImage++
            if (indexImage > imageIdList.size - 1) indexImage = 0
            // и достаем из массива по индексу следующую картинку
            imageId = imageIdList[indexImage]
            ImageViewOne.setImageResource(imageId)
        }
        doneButton.setOnClickListener {
            //заполняем наш плант
            val plant = Plant(
                imageId,
                photoTitle.text.toString(),
                photoDescription.text.toString())
            //и теперь отправляем все это дело через интент
            val editIntent = Intent().apply {
                putExtra("plant", plant)
            }
            //и все это отправляется в регистерфорактивитирезалт
            setResult(RESULT_OK, editIntent)
            //и закрываем нашу активити
            finish()
        }
    }
    }
