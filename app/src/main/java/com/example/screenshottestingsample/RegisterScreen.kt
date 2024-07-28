package com.example.screenshottestingsample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.screenshottestingsample.ui.theme.ScreenshotTestingSampleTheme

@Composable
fun RegisterScreen() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Greeting()
                Spacer(modifier = Modifier.size(16.dp))
                Forms(
                    name = "Leila",
                    onNameChange = {},
                    password = "123",
                    onPasswordChange = {}
                )
                Spacer(modifier = Modifier.size(16.dp))
                SaveInfo(
                    needToSave = true,
                    onChangeSaveInfo = { }
                )
                Spacer(modifier = Modifier.weight(1f))
                Register(isEnable = false, onRegisterClick = {})
            }
        }
    }
}

@Composable
private fun Greeting() {
    Text(
        text = "Welcome!",
        style = MaterialTheme.typography.displayMedium
    )
    Text(
        text = "Set username and password to register!",
        style = MaterialTheme.typography.bodyLarge
    )
}

@Composable
private fun Forms(
    name: String,
    onNameChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit,
) {
    TextField(
        value = name,
        onValueChange = onNameChange,
        modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.size(8.dp))
    TextField(
        value = password,
        onValueChange = onPasswordChange,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
private fun SaveInfo(
    needToSave: Boolean,
    onChangeSaveInfo: (Boolean) -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Save your login info?",
            style = MaterialTheme.typography.bodyLarge
        )
        Switch(
            checked = needToSave,
            onCheckedChange = {
                onChangeSaveInfo(it)
            }
        )
    }
}

@Composable
private fun Register(
    isEnable: Boolean,
    onRegisterClick: () -> Unit,
) {
    Button(
        onClick = onRegisterClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        enabled = isEnable
    ) {
        Text(text = "Register")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ScreenshotTestingSampleTheme {
        RegisterScreen()
    }
}