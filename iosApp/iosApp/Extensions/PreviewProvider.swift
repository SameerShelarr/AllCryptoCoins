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
    
    let coinDetail = CryptoCoinDetail(id: "btc-bitcoin", name: "Bitcoin", symbol: "BTC", rank: 1, isNew: false, isActive: true, type: "coin", tags: [
        Tag(id: "segwit", name: "Segwit", coinCounter: 10, icoCounter: 0),
        Tag(id: "segwit", name: "Segwit", coinCounter: 10, icoCounter: 0),
        Tag(id: "segwit", name: "Segwit", coinCounter: 10, icoCounter: 0),
        Tag(id: "segwit", name: "Segwit", coinCounter: 10, icoCounter: 0),
        Tag(id: "segwit", name: "Segwit", coinCounter: 10, icoCounter: 0),
        Tag(id: "segwit", name: "Segwit", coinCounter: 10, icoCounter: 0),
        Tag(id: "segwit", name: "Segwit", coinCounter: 10, icoCounter: 0)
    ], team: [
        TeamMember(id: "satoshi-nakamoto", name: "Satoshi Nakamoto", position: "Founder"),
        TeamMember(id: "satoshi-nakamoto", name: "Satoshi Nakamoto", position: "Founder"),
        TeamMember(id: "satoshi-nakamoto", name: "Satoshi Nakamoto", position: "Founder"),
        TeamMember(id: "satoshi-nakamoto", name: "Satoshi Nakamoto", position: "Founder"),
        TeamMember(id: "satoshi-nakamoto", name: "Satoshi Nakamoto", position: "Founder"),
    ], description: "Bitcoin is a cryptocurrency and worldwide payment system. It is the first decentralized digital currency, as the system works without a central bank or single administrator.", message: "", startedAt: "2009-01-03T00:00:00Z")
}
