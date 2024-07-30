package com.example.screenshottestingsample

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.unit.dp
import androidx.test.runner.AndroidJUnit4
import com.example.screenshottestingsample.ui.theme.ScreenshotTestingSampleTheme
import com.github.takahirom.roborazzi.RobolectricDeviceQualifiers
import com.github.takahirom.roborazzi.RoborazziOptions
import com.github.takahirom.roborazzi.captureRoboImage
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import org.robolectric.annotation.GraphicsMode

@RunWith(AndroidJUnit4::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
@Config(sdk = [33], qualifiers = RobolectricDeviceQualifiers.Pixel5)
class RegisterScreenKtTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()
    val directoryName = "RegisterScreenKtTest"

    @Test
    fun testGreeting() {
        composeTestRule.setContent {
            ScreenshotTestingSampleTheme {
                RegisterScreen()
            }
        }

        composeTestRule.onRoot().captureRoboImage(
            filePath = "src/test/screenshots/$directoryName/greeting.png",
            roborazziOptions = RoborazziOptions(
                recordOptions =
                RoborazziOptions.RecordOptions(resizeScale = 0.5)
            )
        )
    }
}