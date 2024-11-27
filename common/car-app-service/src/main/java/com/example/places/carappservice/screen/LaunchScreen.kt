package com.example.places.carappservice.screen

import androidx.car.app.CarContext
import androidx.car.app.Screen
import androidx.car.app.model.*

class LaunchScreen(carContext: CarContext) : Screen(carContext) {

    override fun onGetTemplate(): Template {
        val itemListBuilder = ItemList.Builder()
            .setNoItemsMessage("No options available")

        // Define the initial list options
        val options = listOf("Engage Autonomous", "Disengage Autonomous", "Select Destination")

        options.forEachIndexed { index, option ->
            itemListBuilder.addItem(
                Row.Builder()
                    .setTitle(option)
                    .setOnClickListener {
                        // If the third or last option is tapped, navigate to MainScreen
                        if (index == 2) {
                            screenManager.push(MainScreen(carContext))
                        }
                    }
                    .build()
            )
        }

        return ListTemplate.Builder()
            .setTitle("Welcome")
            .setSingleList(itemListBuilder.build())
            .setHeaderAction(Action.APP_ICON)
            .build()
    }
}
