package com.example.plants

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.GridLayoutManager
import com.example.plants.databinding.ActivityMainBinding
import com.example.plants.ui.theme.PlantsTheme

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val adapter = PlantsAdapter()
    private val imageIdList = listOf(
        R.drawable.one,
        R.drawable.two,
        R.drawable.three,
        R.drawable.four,
        R.drawable.five,
        R.drawable.six,)
    private var index = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }
    private fun init() {
        binding.apply {
            //настроим наш ресайклер
        recycler.layoutManager = GridLayoutManager(this@MainActivity,3)
            //и создадим адаптер
            recycler.adapter = adapter
        addButton.setOnClickListener{
            //складываем в плант растения по очереди из списка, начиная с нулевой позиции)
            val plantIndex = index + 1
            if(index > 5) index = 0
            val plant = Plant(imageIdList[index], "plant $plantIndex")
            //и передаем все это дело в адаптер
            adapter.addPlant(plant)
            index++
        }
        }
    }
}

