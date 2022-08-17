# -*- coding: utf-8 -*-
"""
Created on Tue Jul 12 13:33:06 2022

@author: 김도은
"""
from modules import feature_module as FM

import pandas as pd
from datetime import datetime

#데이터 가져오기
fashion_df = pd.read_csv("data/fashion.csv")
apparel_boys = fashion_df[fashion_df["Gender"]=="Boys"]
apparel_girls = fashion_df[fashion_df["Gender"]=="Girls"]
footwear_men = fashion_df[fashion_df["Gender"]=="Men"]
footwear_women = fashion_df[fashion_df["Gender"]=="Women"]

#남자아이템
train_data_dir = "data/Footwear/Men/Images/"
nb_train_samples = footwear_men.shape[0]
#정보추출    
a = datetime.now()
FM.extract_genderfeatures(train_data_dir,nb_train_samples,'Men')
print("Time taken in feature extraction", datetime.now()-a) 

#여자아이템
train_data_dir = "data/Footwear/Women/Images/"
nb_train_samples = footwear_women.shape[0]
#정보추출    
a = datetime.now()
FM.extract_genderfeatures(train_data_dir,nb_train_samples,'Women')
print("Time taken in feature extraction", datetime.now()-a) 


#소년아이템
train_data_dir = "data/Apparel/Boys/Images"
nb_train_samples = apparel_boys.shape[0]
#정보추출    
a = datetime.now()
FM.extract_genderfeatures(train_data_dir,nb_train_samples,'Boys')
print("Time taken in feature extraction", datetime.now()-a) 

#소녀아이템
train_data_dir = "data/Apparel/Girls/Images"
nb_train_samples = apparel_girls.shape[0]
#정보추출    
a = datetime.now()
FM.extract_genderfeatures(train_data_dir,nb_train_samples,'Girls')
print("Time taken in feature extraction", datetime.now()-a) 