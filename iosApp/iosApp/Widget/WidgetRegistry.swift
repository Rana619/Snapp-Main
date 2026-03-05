import SwiftUI

/// Registry: type String → (WidgetRenderContext) → AnyView. See ARCHITECTURE Widget/.
final class WidgetRegistry {
    static let shared = WidgetRegistry()
    private var builders: [String: (WidgetRenderContext) -> AnyView] = [:]

    func register(_ type: String, builder: @escaping (WidgetRenderContext) -> AnyView) {
        builders[type] = builder
    }

    func get(_ type: String) -> ((WidgetRenderContext) -> AnyView)? {
        builders[type]
    }
}
