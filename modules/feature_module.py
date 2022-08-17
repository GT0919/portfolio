# -*- coding: utf-8 -*-
"""
Created on Tue Jul 12 16:45:43 2022

@author: 김도은
"""
import os
import numpy as np
from keras.preprocessing.image import ImageDataGenerator
from tensorflow.keras.applications.resnet50 import ResNet50,preprocess_input, decode_predictions

img_width, img_height = 224, 224
#top_model_weights_path = 'resnet50_weights_tf_dim_ordering_tf_kernels_notop.h5'
epochs = 50
batch_size = 1

def extract_genderfeatures(train_data_dir,nb_train_samples,gender):
    Itemcodes = []
    datagen = ImageDataGenerator(rescale=1. / 255)
    model = ResNet50(include_top=False, weights='imagenet')
    generator = datagen.flow_from_directory(#이미지 파일을 기준으로 생성자 결정
        train_data_dir,
        target_size=(img_width, img_height),
        batch_size=batch_size,
        class_mode=None,
        shuffle=False)
    for i in generator.filenames:
        Itemcodes.append(i[(i.rfind("\\")+1):i.find(".")])#제품코드저장
    extracted_features = model.predict_generator(generator, nb_train_samples // batch_size)#추출특성저장
    extracted_features = extracted_features.reshape((nb_train_samples, 100352))

    if not os.path.isdir('features'): 
        os.mkdir('features')
    #numpy배열에 코드, 추출특성 저장 후 파일화
    np.save(open(f'features/{gender}_ResNet_features.npy', 'wb'), extracted_features)
    np.save(open(f'features/{gender}_ResNet_feature_product_ids.npy', 'wb'), np.array(Itemcodes))