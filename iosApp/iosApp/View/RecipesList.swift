import SwiftUI

struct RecipesList: View {
    @ObservedObject var dataSource = RecipeListViewModel()
    
    @State private var searchStr: String = ""
    
    var body: some View {
        NavigationView {
            
            VStack {
                self.search
                    .padding(.top, 8)
                List {
                    ForEach(dataSource.recipes, id: \.self) { recipe in
                        RecipeRow(viewModel: RecipeRowViewModel(recipe: recipe))
                    }
                }
            }
            .onAppear {
                dataSource.fetchData()
            }
            .onDisappear {
                dataSource.detach()
            }
            .navigationBarTitle("Puppy Recipes Search", displayMode: .inline)
        }
    }
    
    private var search: some View {
        VStack {
            HStack {
                CustomSearchView(query: $searchStr)
                    .onChange(of: searchStr) { str in
                        dataSource.term = str
                        if searchStr.isEmpty {
                            DispatchQueue.main.asyncAfter(deadline: .now() + 0.3) {
                                self.dataSource.recipes.removeAll()
                            }
                        }
                    }
            }
        }
    }
}


struct RecipesList_Previews: PreviewProvider {
    static var previews: some View {
        RecipesList()
    }
}
