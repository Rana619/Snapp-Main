package com.snapp.android.ui.widget

import com.snapp.data.model.page.PageWidget

/** Context passed to widget renderers. See ARCHITECTURE ui/widget/. */
data class WidgetRenderContext(
    val widget: PageWidget,
    val widgetData: Any? = null,
    val onAction: (WidgetAction) -> Unit = {}
)
