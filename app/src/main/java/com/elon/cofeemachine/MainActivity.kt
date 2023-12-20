package com.elon.cofeemachine

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.elon.cofeemachine.ui.theme.CofeeMachineTheme
import java.util.Scanner

// Define Coffee class
class Coffee(val name: String, val milk: Int, val sugar: Int) {
    fun makeCoffee() {
        println("Making $name with $milk ml of milk and $sugar tsp of sugar.")
        println("Your $name is ready! Enjoy!")
    }
}

// Define CoffeeMachine class
class CoffeeMachine {
    private val scanner = Scanner(System.`in`)

    // Function to take user input for milk and sugar
    private fun getUserPreferences(): Pair<Int, Int> {
        print("Enter the amount of milk (in ml): ")
        val milk = scanner.nextInt()

        print("Enter the amount of sugar (in tsp): ")
        val sugar = scanner.nextInt()

        return Pair(milk, sugar)
    }

    // Function to display coffee options
    private fun displayCoffeeOptions() {
        println("Choose your coffee:")
        println("1. Espresso")
        println("2. Cappuccino")
        println("3. Latte")
    }

    // Function to handle coffee order
    fun orderCoffee() {
        displayCoffeeOptions()

        print("Enter your choice (1-3): ")
        val choice = scanner.nextInt()

        val (milk, sugar) = getUserPreferences()

        val coffee = when (choice) {
            1 -> Coffee("Espresso", milk, sugar)
            2 -> Coffee("Cappuccino", milk, sugar)
            3 -> Coffee("Latte", milk, sugar)
            else -> {
                println("Invalid choice. Please select a valid option.")
                return
            }
        }

        coffee.makeCoffee()
    }
}

fun main() {
    val coffeeMachine = CoffeeMachine()

    println("Welcome to Masai's  Coffee Machine!")
    while (true) {
        println("\nOptions:")
        println("1. Order Coffee")
        println("2. Exit")

        print("Enter your choice (1-2): ")
        val choice = readLine()?.toIntOrNull()

        when (choice) {
            1 -> coffeeMachine.orderCoffee()
            2 -> {
                println("Thank you for using Masai's Coffee Machine. Have a great day!")
                return
            }
            else -> println("Invalid choice. Please select a valid option.")
        }
    }
}
