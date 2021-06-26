import Foundation
import Combine
import shared

final class RecipeRowViewModel: ObservableObject {
    @Published private(set) var recipe: Recipe
    
    init(recipe: Recipe) {
        self.recipe = recipe
    }
}
