package com.example.plants

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.plants.databinding.PlantItemBinding

class PlantsAdapter : RecyclerView.Adapter<PlantsAdapter.PlantHolder>() {
    val plantList = ArrayList<Plant>()
    // хранит ссылки на созданные адаптером элементы вью
    class PlantHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = PlantItemBinding.bind(item)
        fun bind (plant: Plant) = with(binding) {
            image.setImageResource(plant.imageId)
            photoTitle.text = plant.title
        }

    }
//берет разметку плант_айтем, создает ее и передаем в плантхолдер, который уже заполняет ее данными
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.plant_item, parent, false)
    return PlantHolder(view)
}
//заполняет созданную вью, принимает созданный плантхолдер с вью внутри, по очереди приходят парами холдер элемента и позиция
override fun onBindViewHolder(holder: PlantHolder, position: Int) {
    holder.bind(plantList[position])
}
    //сюда передаем размер нашего массива, с помощью которого заполняем адаптер
    override fun getItemCount(): Int {
        return plantList.size
    }

fun addPlant(plant: Plant){
    plantList.add(plant)
    //и расскажем адаптеру что у нас поменялись данные
    notifyDataSetChanged()
}
}