# -*- coding: utf-8 -*-
"""
Created on Tue Jul 12 13:18:26 2022

@author: 김도은
"""

import pandas as pd
import streamlit as st

def contents() :
    #데이터 가져오기
    fashion_df = pd.read_csv("data/fashion.csv")
    
    option1=list(fashion_df.drop(['ProductId','Image','ImageURL','ProductTitle'],axis=1))
    category1 = st.sidebar.radio(label = 'first category',options= option1)
    option2 = fashion_df[category1].unique()
    category2 = st.sidebar.radio(label = 'second category',options= option2)
    
    
    
    st.subheader('<< optional products >>')
    optional_df = fashion_df[fashion_df[category1]==category2]
    st.info("_Total number of optional products_ : {}".format(optional_df.shape[0]))
    if st.checkbox('optional_fashion_df'):
        st.write(optional_df)
    
    for i in optional_df.index[:5]:
        st.markdown("**{}**".format(optional_df.ProductTitle[i]))
        st.image(f'data/{optional_df.Category[i]}/{optional_df.Gender[i]}/Images/images_with_product_ids/{optional_df.Image[i]}', width = 200)