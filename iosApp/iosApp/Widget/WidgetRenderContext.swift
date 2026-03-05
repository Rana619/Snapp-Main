import SwiftUI
import shared

/// Context passed to widget renderers. See ARCHITECTURE Widget/.
struct WidgetRenderContext {
    let widget: PageWidget
    let widgetData: Any?
    let onAction: (WidgetAction) -> Void
}
