import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.playerinstances.VideoPlayerScreen

@Composable
fun VideosColumn() {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp)) {
        var count by rememberSaveable { mutableIntStateOf(0) }
        var resolution by rememberSaveable { mutableStateOf("1080p") }

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.TopCenter
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Counter: $count | $resolution", fontSize = 20.sp)

                Spacer(modifier = Modifier.height(16.dp))

                Button(onClick = { count++ }) {
                    Text("Add Player")
                }

                Spacer(modifier = Modifier.height(8.dp))

                Button(onClick = {
                    resolution = if (resolution == "1080p") "4K" else "1080p"
                }) {
                    Text("Change Resolution")
                }
            }
        }


        Column(
            Modifier.verticalScroll(rememberScrollState())
        ) {
            repeat(count) {
                VideoPlayerScreen(resolution)
            }
        }
    }
}
