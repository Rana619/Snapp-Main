import SwiftUI
import shared

/// Recursive widget renderer. See ARCHITECTURE Widget/.
struct WidgetHost: View {
    let widget: PageWidget
    let widgetData: Any?
    let onAction: (WidgetAction) -> Void

    var body: some View {
        let context = WidgetRenderContext(widget: widget, widgetData: widgetData, onAction: onAction)
        if let renderer = WidgetRegistry.shared.get(widget.type) {
            renderer(context)
        } else {
            EmptyView()
        }
    }
}
