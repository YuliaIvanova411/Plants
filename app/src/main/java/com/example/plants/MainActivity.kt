package com.example.plants

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
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
import com.example.plants.ui.theme.EditActivity
import com.example.plants.ui.theme.PlantsTheme

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val adapter = PlantsAdapter()
    private var editLauncher: ActivityResultLauncher<Intent>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        //запускаем функцию которая будет ждать результата с другого активити когда мы ее запустим
        editLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            //и когда вернется результат, его надо проверить на нормальность
            if (it.resultCode == RESULT_OK)
                // и передаем в адаптер полученное растение - достаем его из данных интента (it.data), а getSerializableExtra умеет
                //передавать целый класс и указываем его ключевое слово и приводим все это дело к планту
                adapter.addPlant(it.data?.getSerializableExtra("plant") as Plant)

        }
    }
    private fun init() {
        binding.apply {
            //настроим наш ресайклер
        recycler.layoutManager = GridLayoutManager(this@MainActivity,3)
            //и создадим адаптер
            recycler.adapter = adapter
        addButton.setOnClickListener{
            //прописываем где находимся и какую активити хотим запустить
            editLauncher?.launch(Intent(this@MainActivity, EditActivity::class.java))
        }
        }
    }
}

