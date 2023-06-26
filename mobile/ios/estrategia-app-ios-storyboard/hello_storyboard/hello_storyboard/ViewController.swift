//
//  ViewController.swift
//  hello_storyboard
//
//  Created by Raphael Lacerda on 01/03/23.
//

import UIKit

class ViewController: UIViewController {
    var imageView = UIImageView(image: UIImage(named: "canetaspretas.png")!)
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }

    override func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(animated)
        findPhoto()
    }
    
    private func findPhoto(){
        
        guard let path = Bundle.main.path(forResource: "canetaspretas", ofType: "png") else {
            debugPrint("Photo not found")
            return
        }
        
        imageView.contentMode = UIView.ContentMode.scaleAspectFit
        imageView.frame.size.width = 200
        imageView.frame.size.height = 200
        imageView.center = self.view.center
        super.view.addSubview(imageView)
        
        //pick view
//        let imageController = UIImagePickerController()
//        present(imageController, animated: true)
        
        let t = Teste()
        var nome = "lacerda"
        
        debugPrint(t.nome + nome)
        
        nome = 10
        
        debugPrint(t.nome + nome)
        
    }

}

