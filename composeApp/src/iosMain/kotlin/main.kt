import androidx.compose.ui.window.ComposeUIViewController
import com.kashif.expense.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController { App() }
