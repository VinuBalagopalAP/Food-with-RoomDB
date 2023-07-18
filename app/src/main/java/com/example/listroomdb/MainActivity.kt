package com.example.listroomdb

import android.app.AlertDialog
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.listroomdb.data.FoodItem
import com.example.listroomdb.data.FoodItemViewModel
import com.example.listroomdb.ui.theme.ListRoomDBTheme

class MainActivity : ComponentActivity() {

    private val foodItemViewModel: FoodItemViewModel by viewModels {
        FoodItemViewModel.FoodItemViewModelFactory((application as MyApplication).repository)
    }

    lateinit var foodItems : MutableList<FoodItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val foodItem = FoodItem("Vinu",140f)
        val foodItem2 = FoodItem("Anu",120f)

// Add new Item
        foodItemViewModel.insert(foodItem)
        foodItemViewModel.insert(foodItem2)


        foodItemViewModel.allFoodItems.observe(this) { foodItemList ->
            foodItemList?.let {
                foodItems = foodItemList

                // Now you can use this "foodItems" list
                // eg., show this list to the user using RecyclerView

                var msg = ""

                for (foodItem in foodItems){
                    msg += foodItem.toString() + "\n\n"
                }

                AlertDialog.Builder(this).setMessage(msg).show()
            }
        }



        setContent {
            ListRoomDBTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ListRoomDBTheme {
        Greeting("Android")
    }
}