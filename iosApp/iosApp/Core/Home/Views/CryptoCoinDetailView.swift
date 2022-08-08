//
//  CryptoCoinDetailView.swift
//  iosApp
//
//  Created by Sameer Shelar on 08/08/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared
import WrappingHStack

struct CryptoCoinDetailView: View {
    
    let coinDetail: CryptoCoinDetail
    
    var body: some View {
        ScrollView {
            VStack(alignment: .leading, spacing: 20) {
                HStack{
                    Text("\(coinDetail.rank). \(coinDetail.name) (\(coinDetail.symbol))")
                        .font(.system(size: 54, weight: .bold, design: .default))
                    Spacer()
                    if coinDetail.isActive {
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
                Text(coinDetail.description_)
                if let tags = coinDetail.tags, !tags.isEmpty {
                    Text("Tags")
                        .font(.system(size: 54, weight: .medium, design: .default))
                    WrappingHStack (tags, id: \.self) { tag in
                        Text(tag.name)
                            .foregroundColor(Color.theme.cryptoOrangeLight)
                            .padding(8)
                            .overlay(
                                RoundedRectangle(cornerRadius: 25)
                                    .stroke(Color.theme.cryptoOrangeLight, lineWidth: 1)
                            )
                            .padding(4)
                    }
                    .padding(.top, 0)
                }
                if let team = coinDetail.team, !team.isEmpty {
                    Text("Team")
                        .font(.system(size: 54, weight: .medium, design: .default))
                    VStack {
                        ForEach(coinDetail.team, id: \.self) {teamMember in
                            VStack(alignment: .leading) {
                                Text (teamMember.name)
                                    .font(.system(size: 24, weight: .bold, design: .default))
                                Text (teamMember.position)
                                    .italic()
                                Divider()
                            }
                        }
                    }
                    .listStyle(PlainListStyle())
                    .padding(EdgeInsets(top: 0, leading: 10, bottom: 0, trailing: 0))
                }
                Spacer()
            }
        }
        .padding(EdgeInsets(top: 0, leading: 10, bottom: 0, trailing: 10))
        .navigationBarTitle("\(coinDetail.name) (\(coinDetail.symbol))")
    }
}

struct CryptoCoinDetailView_Previews: PreviewProvider {
    static var previews: some View {
        Group {
            CryptoCoinDetailView(coinDetail: dev.coinDetail)
                .previewDevice("iPhone 11")
            
            CryptoCoinDetailView(coinDetail: dev.coinDetail)
                .previewDevice("iPhone 11")
                .preferredColorScheme(.dark)
        }
    }
}
