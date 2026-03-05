import SwiftUI

struct GenericPageView: View {
    @EnvironmentObject var router: AppNavigationStack
    @EnvironmentObject var authVM: AuthViewModel
    let title: String

    var body: some View {
        VStack(spacing: 20) {
            Text(title)
                .font(.largeTitle)
                .padding(.bottom, 8)

            Button("Go To Details (ID: 101)") {
                router.push(.record(id: "101"))
            }
            .buttonStyle(.borderedProminent)

            Button("Go To Reports") {
                router.push(.reports)
            }
            .buttonStyle(.bordered)

            Button("404 - Not Found") {
                router.push(.notFound)
            }
            .buttonStyle(.bordered)

            Spacer()

            Button("Logout") {
                authVM.logout()
            }
            .buttonStyle(.bordered)
            .tint(.red)
        }
        .padding()
        .frame(maxWidth: .infinity, maxHeight: .infinity)
    }
}
