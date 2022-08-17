# -*- coding: utf-8 -*-
"""
Created on Thu Jul 21 09:13:14 2022

@author: 김도은
"""
import streamlit as st

from sklearn.preprocessing import LabelEncoder
def encode_features(dataDF):  
  features=[]
  df_dtype = dataDF.dtypes
  
  for i in range(1,df_dtype.count()):
    column_=df_dtype.index[i]
    features.append(column_) 
  #st.write(features)      
  for feature in features:
    le = LabelEncoder()
    #칼럼지정
    le = le.fit(dataDF[feature])
    #칼럼변형
    dataDF[feature] = le.transform(dataDF[feature])
  return dataDF


from math import * 
def jaccard_similarity(search_item, recommend_item):
    #유사도계산
    intersection_cardinality = len(set.intersection(*[set(search_item), set(recommend_item)]))
    union_cardinality = len(set.union(*[set(search_item), set(recommend_item)]))
    return intersection_cardinality / float(union_cardinality)

    return intersection_cardinality / float(union_cardinality)

import numpy as np
from scipy.spatial.distance import cosine
def cosine_similarity(search_item, recommend_item):    
    return np.dot(search_item, recommend_item) / (np.linalg.norm(search_item) * (np.linalg.norm(recommend_item)))    
    
    

from scipy.stats import pearsonr
def pearson_similarity(search_item, recommend_item):
    return np.dot((search_item - np.mean(search_item)), (recommend_item - np.mean(recommend_item))) / ((np.linalg.norm(search_item - np.mean(search_item))) * (np.linalg.norm(recommend_item - np.mean(recommend_item))))