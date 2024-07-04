package com.example.bookflight.ui.theme.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookflight.R
import com.example.bookflight.R.color.purple_700
import com.example.bookflight.ui.theme.black
import com.example.bookflight.ui.theme.buttonBG
import com.example.bookflight.ui.theme.darkGray
import java.util.Locale

@Preview
@Composable
fun Trial() {
    Scaffold() { i ->
        Column(
            modifier = Modifier
                .padding(i)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val userSearched = remember {
                mutableStateOf(TextFieldValue(""))
            }
            searchview(userSearched = userSearched)
            searchView(userSearched = userSearched)

        }
    }
}

@Composable
fun searchview(userSearched: MutableState<TextFieldValue>) {
    val whiteColor = Color.White
    OutlinedTextField(
        value = userSearched.value,
        onValueChange = { userSearched.value = it },
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .height(60.dp)
            ,
        trailingIcon = {
            if (userSearched.value != TextFieldValue("")) {
                IconButton(onClick = {
                    userSearched.value = TextFieldValue("")
                }) {
                    Icon(
                        Icons.Default.Close,
                        contentDescription = null,
                        tint = black,
                        modifier = Modifier
                            .padding(end = 5.dp)
                            .size(18.dp)
                    )
                }
            } else {
                IconButton(onClick = {}) {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = null,
                        tint = black,
                        modifier = Modifier
                            .padding(end = 5.dp)
                            .size(18.dp)
                    )
                }
            }
        },
        shape = RoundedCornerShape(15.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = whiteColor,
            cursorColor = whiteColor,
            unfocusedContainerColor = darkGray,
            focusedContainerColor = darkGray,
        ),
        singleLine = true,
    )
}

@Composable
fun searchView(userSearched: MutableState<TextFieldValue>) {

    val countryAvailable by remember {
        mutableStateOf(
            listOf(
                "Delhi",
                "Kolkata",
                "Mumbai",
                "Chennai",
                "Hyderabad",
                "Banglore",
                "Patna"
            )
        )
    }
    val temp by remember {
        mutableStateOf(listOf(""))
    }
    var filteredItems: List<String>
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        val searchedText = userSearched.value.text
//        filteredItems = if (searchedText.isEmpty()) {
//            countryAvailable
//        } else {
//            val resultText = ArrayList<String>()
//            for (items in countryAvailable) {
//                if (items.lowercase(Locale.getDefault())
//                        .contains(searchedText.lowercase(Locale.getDefault()))
//                )
//                    resultText.add(items)
//            }
//            resultText
//        }
        filteredItems = if (searchedText.isNotEmpty()) {
            val resultText = ArrayList<String>()
            for (items in countryAvailable) {
                if (items.lowercase(Locale.getDefault())
                        .contains(searchedText.lowercase(Locale.getDefault()))
                )
                    resultText.add(items)
            }
            resultText
        } else{
            temp
        }
        items(filteredItems) { filteredItems ->
            showItems(
                ItemText = filteredItems,
                onClick = { /*Click event code needs to be implement*/
                    
                }
            )
        }
    }


}

@Composable
fun showItems(ItemText: String, onClick: (String) -> Unit) {
    Row(
        modifier = Modifier
            .clickable(onClick = { onClick(ItemText) })
            .height(57.dp)
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 16.dp)
    ) {
        Text(text = ItemText, fontSize = 18.sp, color = Color.Black)
    }
}