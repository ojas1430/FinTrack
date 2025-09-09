import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ojasx.FinTrack.TopAppBar.AppBarButtons
import com.ojasx.FinTrack.TopAppBar.AppBarCode

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun TopBarScreen() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)

    Column(modifier = Modifier.fillMaxSize()) {
        AppBarCode(drawerState)
        AppBarButtons()
    }
}
