import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.screenshottestingsample.RegisterScreen
import com.example.screenshottestingsample.ui.theme.ScreenshotTestingSampleTheme

@Preview(showBackground = true)
@Composable
private fun GreetingPreview() {
    ScreenshotTestingSampleTheme {
        RegisterScreen()
    }
}