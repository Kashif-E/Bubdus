package com.kashif.expense

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import com.kashif.expense.di.ExpenseModule
import com.kashif.expense.presentation.home.Home
import com.kashif.expense.theme.AppTheme
import org.koin.compose.KoinApplication
import org.koin.ksp.generated.module


@Composable
internal fun App() {
    AppTheme {
        KoinApplication(application = {
            modules(ExpenseModule().module)
        }) {
            Home()
        }
    }

}
