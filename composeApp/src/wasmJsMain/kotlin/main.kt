import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import com.kashif.expense.App

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    CanvasBasedWindow("BubDus") {
        App()
    }
}
