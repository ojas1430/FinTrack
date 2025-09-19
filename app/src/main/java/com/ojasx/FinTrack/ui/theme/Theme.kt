// Theme.kt
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme.shapes
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import com.ojasx.FinTrack.ui.theme.Typography
import com.ojasx.FinTrack.ui.theme.orange
import com.ojasx.FinTrack.ui.theme.royalblue
import com.ojasx.FinTrack.ui.theme.walletblue
import com.ojasx.FinTrack.ui.theme.walletgreen

private val LightColors = lightColorScheme(
    primary = walletblue,
    secondary = walletgreen, // topappbar
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black
)

private val DarkColors = darkColorScheme(
    primary = orange,
    secondary = royalblue,  // topappbar
    background =  Color(0xFF121212), // background
    surface = Color(0xFF1E1E1E),     // cards,etc
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White
)

@Composable
fun FinTrackTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val colors = if(darkTheme){
        DarkColors
    }else{
        LightColors
    }

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}