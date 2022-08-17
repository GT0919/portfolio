# -*- coding: utf-8 -*-
"""
Created on Mon Jul 11 18:10:40 2022

@author: 김도은
"""
from modules import similarity_module as SM
import os
import numpy as np
import pandas as pd
from datetime import datetime

#모델생성
from keras.models import Sequential
from keras.layers import Dropout, Flatten, Dense
from keras import applications

from sklearn.metrics import pairwise_distances
import requests

import matplotlib.pyplot as plt
import seaborn as sns
import streamlit as st

def draw_chart(df,title, value):
    st.subheader(title)
    plt.figure(figsize=(10,6))
    #plt.xticks(rotation = - 45 )
    plot = sns.countplot(df[value])
    plt.title(f"Distribution of articles {value}-wise")
    plt.xlabel(f"{value} type")
    plt.ylabel("Number of products")
    plot.set_xticklabels(plot.get_xticklabels())
    if not os.path.isdir('chart'):
        os.mkdir('chart')
    plt.savefig(f'chart/{value}-product.png')
    st.image(f'chart/{value}-product.png', use_column_width=True)
    
def get_similar_products_cnn(Productids, extracted_features,gender_df,product_id, num_results):
    doc_id = Productids.index(product_id)
    #추천시스템 _ 유클리디안 거리(from sklearn.metrics import pairwise_distances)
    pairwise_dist = pairwise_distances(extracted_features, extracted_features[doc_id].reshape(1,-1))#거리계산 행렬
    indices = np.argsort(pairwise_dist.flatten())[0:num_results]
    pdists  = np.sort(pairwise_dist.flatten())[0:num_results]
    
    silimarlity_df = gender_df.drop('ImageURL', axis=1)
    silimarlity_df = SM.encode_features(silimarlity_df)
    #st.write(silimarlity_df)
    
    #검색아이템 표시
    st.markdown('---')
    st.markdown("<h3 style='text-align: center;'>input product image</h3>", unsafe_allow_html=True)
    st.markdown('---')
    #st.write("="*20, "input product image", "="*20)
    
    ip_row = gender_df.loc[gender_df['ProductId']==int(Productids[indices[0]])]
    
    search_item = silimarlity_df.loc[silimarlity_df['ProductId']==int(Productids[indices[0]])]
    search_item=search_item.values.tolist()[0]
    #st.write(search_item)
    
    #print(ip_row.head())
    for indx, row in ip_row.iterrows():
        st.markdown("**{}**".format(ip_row.ProductTitle[indx]))
        #st.subheader(f'Product Title: {row["ProductTitle"]}')          
        st.write(ip_row)
                   
        st.image(row['ImageURL'], width = 200)
        
    
    
    #유사도측정방법(import silimarlity_module as SM) : 검색아이템과 추천아이템 간의 유사도 검사 실시
    st.markdown('---')
    st.markdown("<h3 style='text-align: center;'>Recommended products</h3>", unsafe_allow_html=True)
    st.markdown('---')
    #st.write("\n","="*20, "Recommended products", "="*20)
    
    for i in range(1,len(indices)):
        rows = gender_df.loc[gender_df['ProductId']==int(Productids[indices[i]])]
        
        recommend_item = silimarlity_df.loc[silimarlity_df['ProductId']==int(Productids[indices[i]])]
        recommend_item=recommend_item.values.tolist()[0]
        for indx, row in rows.iterrows():
            st.markdown("**{}**".format(row.ProductTitle))
            #st.subheader(f'Product Title: {row["ProductTitle"]}')
            st.write(rows)
            st.image(row['ImageURL'], width = 200)
            #추천시스템 알고리즘
            st.write('Euclidean Distance from input image:', pdists[i])
            
            #유사도검증            
            st.write('jaccard_similarity from input image:',SM.jaccard_similarity(search_item,recommend_item)*100,'%')
            st.write('cosine_similarity from input image:',SM.cosine_similarity(search_item,recommend_item)*100,'%')
            st.write('pearson_similarity from input image:',SM.pearson_similarity(search_item,recommend_item)*100,'%')
            
            st.markdown('---')