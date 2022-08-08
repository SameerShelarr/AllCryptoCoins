//
//  PreviewProvider.swift
//  iosApp
//
//  Created by Sameer Shelar on 05/08/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import SwiftUI
import shared

extension PreviewProvider {
    static var dev: DeveloperPreview {
        return DeveloperPreview.instance
    }
}

class DeveloperPreview {
    static let instance = DeveloperPreview()
    private init() {}
    
    let coin = CryptoCoin(id: "btc-bitcoin", name: "Bitcoin", symbol: "BTC", rank: 1, isNew: false, isActive: true, type: "coin")
}
