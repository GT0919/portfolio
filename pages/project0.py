# -*- coding: utf-8 -*-
"""
Created on Tue Jul 12 13:22:26 2022

@author: 김도은
"""

from modules import project_module as PM

import pandas as pd
import streamlit as st

def contents() :
    #데이터 가져오기
    fashion_df = pd.read_csv("data/fashion.csv")
    
    st.write("Total number of products : ", fashion_df.shape[0])
    st.write("Total number of unique subcategories : ", fashion_df["SubCategory"].nunique())    
    st.markdown('''               
             ```plaintext
             Topwear, Bottomwear, Dress, Innerwear, Socks, Apparel Set, Shoes, Flip Flops, Sandal
             ``` 
             ''')
             
    st.write("Total number of unique gender types : ", fashion_df["Gender"].nunique())
    st.markdown('''               
             ```plaintext
             Girls, Boys, Men, Women
             ``` 
             ''')
             
    st.markdown('---')
    
    if st.checkbox('rawdata_fashion'):
        st.write(fashion_df)    
    
    if st.checkbox('chart_fashion'):
        PM.draw_chart(fashion_df,'gender-product', 'Gender')
        PM.draw_chart(fashion_df,'SubCategory-prouct','SubCategory')
        #PM.draw_chart2(fashion_df, 'gender,category-product', 'SubCategory', 'Gender')
