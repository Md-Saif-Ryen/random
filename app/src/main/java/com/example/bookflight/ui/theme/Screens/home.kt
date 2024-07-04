@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.bookflight.ui.theme.Screens

import android.content.Context
import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.compose.rememberNavController
import com.example.bookflight.R
import com.example.bookflight.ui.theme.black
import com.example.bookflight.ui.theme.components.FlightDetailTextField
import com.example.bookflight.ui.theme.currentText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun Home() {
    val color = if (isSystemInDarkTheme()) Color.White else black
    val inversecolor = if (!isSystemInDarkTheme()) Color.White else black
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val context = LocalContext.current.applicationContext
    var isSelected = false
    var isSelected1 = true
    var isSelected2 = false

    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = {
            ModalDrawerSheet {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .padding(4.dp)
                ) {

                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.SpaceBetween,
                        horizontalAlignment = Alignment.Start
                    ) {
                        IconButton(onClick = { scope.launch { drawerState.close() } }) {
                            Icon(
                                Icons.Default.Close,
                                contentDescription = null,
                                Modifier.size(24.dp)
                            )
                        }
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(10.dp),
                            modifier = Modifier.padding(end = 10.dp)
                        ) {
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(
                                    painter = painterResource(id = R.drawable.user),
                                    contentDescription = null,
                                    Modifier.size(100.dp)
                                )
                            }
                            Column(
                                verticalArrangement = Arrangement.spacedBy(10.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(text = "Hello", fontSize = 15.sp, color = color)
                                Text(
                                    text = "John Doe",
                                    fontSize = 15.sp,
                                    color = color,
                                    fontWeight = FontWeight.W400
                                )
                            }
                        }

                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                Divider(
                    thickness = 1.dp,
                    color = color,
                    modifier = Modifier
                        .padding(4.dp)
                        .alpha(.5f)
                )
                NavDrawerItem(
                    label = "My Bookings",
                    scope = scope,
                    drawerState = drawerState,
                    context = context,
                    icon = R.drawable.bookings,
                    color = color
                )
                NavDrawerItem(
                    label = "Boarding Pass",
                    scope = scope,
                    drawerState = drawerState,
                    context = context,
                    icon = R.drawable.ticket,
                    color = color
                )
                NavDrawerItem(
                    label = "Support",
                    scope = scope,
                    drawerState = drawerState,
                    context = context,
                    icon = R.drawable.support,
                    color = color
                )
                NavDrawerItem(
                    label = "Rate us",
                    scope = scope,
                    drawerState = drawerState,
                    context = context,
                    icon = R.drawable.rate,
                    color = color
                )
                Spacer(modifier = Modifier.height(10.dp))
                Divider(
                    thickness = 1.dp,
                    color = color,
                    modifier = Modifier
                        .padding(4.dp)
                        .alpha(.5f)
                )
                Spacer(modifier = Modifier.height(10.dp))
                NavDrawerItem(
                    label = "Flight",
                    scope = scope,
                    drawerState = drawerState,
                    context = context,
                    icon = R.drawable.airplane,
                    color = color
                )

                NavDrawerItem(
                    label = "Hotel",
                    scope = scope,
                    drawerState = drawerState,
                    context = context,
                    icon = R.drawable.hotel,
                    color = color
                )

                NavDrawerItem(
                    label = "Bus",
                    scope = scope,
                    drawerState = drawerState,
                    context = context,
                    icon = R.drawable.bus,
                    color = color
                )
                NavDrawerItem(
                    label = "Tour",
                    scope = scope,
                    drawerState = drawerState,
                    context = context,
                    icon = R.drawable.travel,
                    color = color
                )
                NavDrawerItem(
                    label = "Travel Loan",
                    scope = scope,
                    drawerState = drawerState,
                    context = context,
                    icon = R.drawable.bank,
                    color = color
                )
                Spacer(modifier = Modifier.height(10.dp))
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "App version 1.0.1", color = color, fontSize = 15.sp)
                }
            }
        }) {
        Scaffold(modifier = Modifier.background(inversecolor),
            topBar = {
                TopAppBar(title = {
                    Text(
                        text = "Book Flight",
                        color = color,
                        fontSize = 20.sp,
                        modifier = Modifier.fillMaxWidth(),
                    )
                }, modifier = Modifier.padding(start = 10.dp, end = 15.dp, top = 10.dp),
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                drawerState.open()
                            }
                            toast(context = context)
                        }) {
                            Icon(Icons.Default.Menu, contentDescription = null, tint = color)
                        }
                    })
            })

        { i ->
            Box(
                modifier = Modifier
                    .padding(i)
                    .background(inversecolor)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 15.dp, vertical = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Card(
                        shape = CircleShape,
                        elevation = CardDefaults.elevatedCardElevation(
                            15.dp
                        ), modifier = Modifier
                            .background(inversecolor)
                            .fillMaxWidth()
                            .height(35.dp)
                            .padding(horizontal = 15.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(inversecolor)
                        ) {
                            Button(
                                onClick = { isSelected = true },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = if (isSelected1) currentText else inversecolor,
                                ), modifier = Modifier
                                    .weight(1f)
                                    .background(inversecolor)
                            ) {
                                Text(
                                    text = "One Way",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Medium,
                                    color = if (isSystemInDarkTheme()) Color.White else black,

                                    )
                            }

                            Button(
                                onClick = { isSelected = true },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = if (isSelected) currentText else inversecolor,
                                ), modifier = Modifier
                                    .weight(1f)
                                    .background(inversecolor)
                            ) {
                                Text(
                                    text = "One Way",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Medium,
                                    color = if (isSystemInDarkTheme()) Color.White else black,
                                )
                            }
                            Button(
                                onClick = { isSelected = true },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = if (isSelected) currentText else inversecolor,
                                ), modifier = Modifier
                                    .weight(1f)
                                    .background(inversecolor)
                            ) {
                                Text(
                                    text = "One Way",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Medium,
                                    color = if (isSystemInDarkTheme()) Color.White else black

                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(40.dp))
                    FlightDetailTextField(
                        "From",
                        R.drawable.airplane_take_off,
                        "Delhi",
                        "DEL",
                        "Indira Gandhi International Airport", Modifier.zIndex(11f)
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .alpha(.7f)
                            .align(Alignment.End)
                            .offset(280.dp, 5.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .zIndex(2f)
                                .border(1.dp, color, CircleShape)
                        ) {
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(
                                    painter = painterResource(id = R.drawable.arrows_down_up),
                                    contentDescription = null,
                                    tint = color, modifier = Modifier.size(30.dp)
                                )
                            }
                        }
                    }
                    FlightDetailTextField(
                        "To",
                        R.drawable.airplane_land,
                        "Kolkata",
                        "CCU",
                        "Subhash Chandra International Airport",
                        Modifier
                            .zIndex(1f)
                            .absoluteOffset(0.dp, 0.dp)
                    )

                }

            }
        }
    }
}

@Preview
@Composable
private fun Prey() {
    Home()
}

fun toast(context: Context) {
    android.widget.Toast.makeText(context, "Working Properly", android.widget.Toast.LENGTH_SHORT)
        .show()
}

@Composable
fun NavDrawerItem(
    label: String,
    scope: CoroutineScope,
    drawerState: DrawerState,
    context: Context,
    icon: Int,
    color: Color
) {
    NavigationDrawerItem(
        label = { Text(text = label) },
        selected = false,
        onClick = {
            scope.launch {
                drawerState.close()
            }
            toast(context)
        },
        icon = {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = label, Modifier.size(28.dp),
                tint = color
            )
        })
}


@Composable
fun FlightInfoCard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.White, shape = RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {
        FlightInfoRow("From", "Delhi", "DEL", "Indira Gandhi International Airport")
        Spacer(modifier = Modifier.height(16.dp))
        Icon(
            painter = painterResource(id = R.drawable.airplane_take_off),
            contentDescription = "Arrow Down",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(16.dp))
        FlightInfoRow("To", "Kolkata", "CCU", "Subhash Chandra International Airport")
    }
}

@Composable
fun FlightInfoRow(
    label: String,
    city: String,
    code: String,
    airport: String
) {
    Column {
        Text(
            text = label,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(4.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.airplane_take_off),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = city,

                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold

                )
                Text(
                    text = code,

                    fontSize = 16.sp,
                    color = Color.Gray

                )
                Text(
                    text = airport,

                    fontSize = 14.sp,
                    color = Color.Gray

                )
            }
        }
    }
}
