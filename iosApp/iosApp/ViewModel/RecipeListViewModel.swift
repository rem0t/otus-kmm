import Combine
import shared

final class RecipeListViewModel: ObservableObject {
    @Published var recipes = [Recipe]()
    @Published var term: String = String()
    
    private var requests = Set<AnyCancellable>()
    
    init() {
        $term
            .debounce(for: .milliseconds(300), scheduler: RunLoop.main)
            .removeDuplicates()
            .map { item -> String? in
                if item.isEmpty || item.count <= 2 {
                    self.recipes = []
                    return nil
                }
                return item
            }
            .compactMap { $0 }
            .sink { query in
                self.searchRecipesBy(query: query)
            }
            .store(in: &requests)
    }
    
    private func searchRecipesBy(query: String) {
        recipes.removeAll()
        searchBy(query: query, withPics: true)
    }
    
    
    private lazy var presenter: RecipesPresenter? = {
        let presenter = RecipesPresenterImpl()
        presenter.attachView(view: self)
        return presenter
    }()
    
    func updateRecipes(list: [Recipe]) {
        recipes.removeAll()
        list.forEach { recipes.append($0) }
    }
    
    func fetchData() {
        recipes.removeAll()
        presenter?.attachView(view: self)
    }
    
    func searchBy(query: String, withPics: Bool) {
        presenter?.searchRecipes(query: query, withPics: withPics)
    }
    
    func detach() {
        presenter?.detachView()
    }
}

extension RecipeListViewModel: RecipesListView {
    func setItemsFrom(list: [Recipe]) {
        recipes.removeAll()
        updateRecipes(list: list)
    }
}
