//
//  CryptoCoinListItemView.swift
//  iosApp
//
//  Created by Sameer Shelar on 05/08/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared

struct CryptoCoinListItemView: View {
    
    let coin: CryptoCoin
    
    var body: some View {
        HStack(spacing: 0) {
            Text(coin.symbol)
                .font(.system(size: 16, weight: .bold, design: .default))
                .background(
                    Circle().frame(width: 85, height: 85).foregroundColor(Color.theme.cryptoOrangeLighter)
                )
            VStack(alignment: .leading, spacing: 4) {
                Text(coin.name)
                    .font(.system(size: 24, weight: .bold, design: .default))
                HStack(spacing: 4) {
                    Text("Rank: \(coin.rank)")
                        .foregroundColor(Color.theme.cryptoOrangeLight)
                        .padding(4)
                        .overlay(
                            RoundedRectangle(cornerRadius: 15)
                                .stroke(Color.theme.cryptoOrange, lineWidth: 1)
                        )
                    Spacer()
                        .frame(width: 2)
                    Text(coin.type)
                        .foregroundColor(Color.theme.cryptoOrangeLight)
                        .padding(4)
                        .overlay(
                            RoundedRectangle(cornerRadius: 15)
                                .stroke(Color.theme.cryptoOrange, lineWidth: 1)
                        )
                }
            }
            .padding(.leading, 50)
            Spacer()
            if coin.isActive {
                Text("Active")
                    .foregroundColor(Color.green)
                    .padding(4)
                    .border(Color.green, width: 1)
            } else {
                Text("InActive")
                    .foregroundColor(Color.red)
                    .padding(4)
                    .border(Color.red, width: 1)
            }
        }
        .padding(EdgeInsets(top: 40, leading: 40, bottom: 40, trailing: 20))
    }
}

struct CryptoCoinListItemView_Previews: PreviewProvider {
    static var previews: some View {
        Group {
            CryptoCoinListItemView(coin: dev.coin)
                .previewDevice("iPhone 11")
                .previewLayout(.sizeThatFits)
            
            CryptoCoinListItemView(coin: dev.coin)
                .previewDevice("iPhone 11")
                .previewLayout(.sizeThatFits)
                .preferredColorScheme(.dark)
        }
    }
}
