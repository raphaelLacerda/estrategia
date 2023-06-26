//
//  ContentView.swift
//  Shared
//
//  Created by Raphael Lacerda on 25/07/21.
//

import SwiftUI

struct ContentView: View {
    var numero = 10
     
    var body: some View {
        
        Text("rafa => idade: \(numero)")
            .padding()
    }
    
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
