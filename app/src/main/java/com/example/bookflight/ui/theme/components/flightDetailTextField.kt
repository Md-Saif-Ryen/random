package com.example.bookflight.ui.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsEndWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.bookflight.R
import com.example.bookflight.ui.theme.black


@Composable
fun FlightDetailTextField(fromOrToText:String,takeOffOrLandingIcon:Int, state:String, stateCode:String,stateAirport:String, modifier: Modifier) {
    val color = if (isSystemInDarkTheme()) Color.White else black
    val inversecolor = if (!isSystemInDarkTheme()) black else Color.White
    Box(
        modifier = Modifier
            .fillMaxWidth().zIndex(11f)
            .absoluteOffset(10.dp, 10.dp)
    ) {
        Box(
            modifier = Modifier
                .size(60.dp, 25.dp)
                .background(if(isSystemInDarkTheme()) black else Color.White)
                .alpha(.7f).absoluteOffset(5.dp, 3.dp)
        ) {
            Text(
                text = fromOrToText,
                maxLines = 1,
                fontSize = 13.sp,
                textAlign = TextAlign.Center,
                color = inversecolor,
                modifier = Modifier
                    .padding(horizontal = 10.dp)
            )
        }

    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp).zIndex(2f)
            .border(1.dp, color, RoundedCornerShape(9.dp))
            .alpha(.7f)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            Icon(
                painter = painterResource(id = takeOffOrLandingIcon),
                contentDescription = null,
                modifier = Modifier
                    .size(20.dp)
                    .weight(1f),
                tint = if (!isSystemInDarkTheme()) black else Color.White
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(5f),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.Start
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {

                    Text(
                        text = state,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight.Bold,
                        color = color,
                    )
                    Text(
                        text = stateCode,
                        fontSize = 13.sp,
                        textAlign = TextAlign.Start,
                        color = color,
                        modifier = Modifier
                            .padding(horizontal = 4.dp)
                            .alpha(.8f)
                    )
                }
                Text(
                    text = stateAirport,
                    fontSize = 13.sp,
                    textAlign = TextAlign.Start,
                    color = color,
                    modifier = Modifier
                        .alpha(.8f)
                )
            }
        }
    }
}
