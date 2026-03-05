package com.snapp.android.ui.widget

import androidx.compose.runtime.Composable

/** Registry: type String → @Composable renderer. See ARCHITECTURE ui/widget/. */
object WidgetRegistry {
    private val builders = mutableMapOf<String, @Composable (WidgetRenderContext) -> Unit>()

    fun register(type: String, builder: @Composable (WidgetRenderContext) -> Unit) {
        builders[type] = builder
    }

    fun get(type: String): (@Composable (WidgetRenderContext) -> Unit)? = builders[type]
}
