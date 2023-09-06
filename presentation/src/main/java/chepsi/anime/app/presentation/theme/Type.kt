package chepsi.anime.app.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = ralewayFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 14.sp,
        letterSpacing = 0.5.sp,
        color = PrimaryDark
    ),
    bodyMedium = TextStyle(
        fontFamily = ralewayFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        lineHeight = 14.sp,
        letterSpacing = 0.5.sp,
        color = PrimaryDark
    ),
    bodySmall = TextStyle(
        fontFamily = ralewayFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 14.sp,
        letterSpacing = 0.5.sp,
        color = PrimaryDark
    ),
    titleMedium = TextStyle(
        fontFamily = ralewayFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        lineHeight = 14.sp,
        letterSpacing = 0.5.sp,
        color = PrimaryDark
    ),
    titleSmall = TextStyle(
        fontFamily = ralewayFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        lineHeight = 14.sp,
        letterSpacing = 0.5.sp,
        color = PrimaryDark
    )
)
