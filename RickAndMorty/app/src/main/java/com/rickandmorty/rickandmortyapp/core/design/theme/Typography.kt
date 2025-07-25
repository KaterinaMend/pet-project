
package com.rickandmorty.rickandmortyapp.core.design.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.rickandmorty.rickandmortyapp.R


private val mochiyPopOneFamily = FontFamily(
    Font(R.font.mochiy_pop_one_regular)
)

private val popinsFamily = FontFamily(
    Font(
        resId = R.font.poppins_semi_bold, weight = FontWeight.W600
    ),
    Font(
        resId = R.font.poppins_regular, weight = FontWeight.W400
    ),
)

private val alphaSlabOneFamily = FontFamily(
    Font(R.font.alfa_slab_one_regular)
)


val typography = Typography(
    headlineLarge = TextStyle(
        fontSize = 36.sp,
        fontFamily = mochiyPopOneFamily
    ),
    headlineMedium = TextStyle(
        fontSize = 32.sp,
        lineHeight = 32.sp,
        fontFamily = popinsFamily,
        fontWeight = FontWeight.W600
    ),
    titleSmall = TextStyle(
        fontSize = 17.sp,
        fontFamily = popinsFamily,
        fontWeight = FontWeight.W600,
        ),
    labelLarge = TextStyle(
        fontSize = 20.sp,
        fontFamily = popinsFamily,
        fontWeight = FontWeight.W600),
    labelMedium = TextStyle(
        fontSize = 14.sp,
        lineHeight = 17.36.sp,
        fontFamily = popinsFamily,
        fontWeight = FontWeight.W600),
    bodyLarge = TextStyle(
        fontSize = 15.sp,
        fontFamily = popinsFamily,
        fontWeight = FontWeight.W400),
    bodySmall = TextStyle(
        fontSize = 10.sp,
        fontFamily = popinsFamily,
        fontWeight = FontWeight.W400)

)

val bodyPromo = TextStyle(
    fontSize = 15.sp,
    fontFamily = alphaSlabOneFamily,
    fontWeight = FontWeight.W400)

val bodyLargeBold = TextStyle(
    fontSize = 15.sp,
    fontFamily = popinsFamily,
    fontWeight = FontWeight.W600)

val highlightSpanStyle = SpanStyle(
    fontSize = 36.sp,
    fontFamily = mochiyPopOneFamily,
    fontWeight = FontWeight(400),
    color = CadmiumYellow,
)

val defaultCapsSpanStyle = SpanStyle(
    fontSize = 36.sp,
    fontFamily = mochiyPopOneFamily,
    fontWeight = FontWeight(400),
    color = White,
)
