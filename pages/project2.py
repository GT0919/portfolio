# -*- coding: utf-8 -*-
"""
Created on Tue Jul 12 17:15:14 2022

@author: 김도은
"""

from modules import project_module as PM

import numpy as np
import pandas as pd
import streamlit as st

def contents() :
    #데이터 가져오기
    fashion_df = pd.read_csv("data/fashion.csv")
    
    #아이템 선택
    genderList=fashion_df['Gender'].unique()
    gender=st.sidebar.radio(label = 'Gender',options= genderList)
    fashion_gender_df = fashion_df[fashion_df["Gender"]==gender]
    skip='''
    itemList = fashion_gender_df['ProductId'].to_list()
    itemList = sorted(itemList)
    item = st.sidebar.radio(label ='item',options= itemList)
    '''
    #데이터복사
    gender_df = fashion_gender_df.copy()
    
    #추출했던 정보 가져오기
    extracted_features = np.load(f'features/{gender}_ResNet_features.npy')#특성
    Productids = np.load(f'features/{gender}_ResNet_feature_product_ids.npy')#제품코드
    Productids = list(Productids)
    
    #제품선택
    item_id = st.selectbox('제품id를 선택하세요',Productids)
    PM.get_similar_products_cnn(Productids, extracted_features,gender_df,item_id, 5)