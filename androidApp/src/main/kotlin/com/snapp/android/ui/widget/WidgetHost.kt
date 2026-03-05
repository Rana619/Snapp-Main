package com.snapp.android.ui.widget

import androidx.compose.runtime.Composable
import com.snapp.data.model.page.PageWidget

/** Recursive widget renderer. See ARCHITECTURE ui/widget/. */
@Composable
fun WidgetHost(
    widget: PageWidget,
    widgetData: Any? = null,
    onAction: (WidgetAction) -> Unit = {}
) {
    val context = WidgetRenderContext(widget, widgetData, onAction)
    val renderer = WidgetRegistry.get(widget.type)
    renderer?.invoke(context)
}
