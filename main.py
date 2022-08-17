# -*- coding: utf-8 -*-
"""
Created on Tue Jul 12 13:23:47 2022

@author: 김도은
"""

import streamlit as st
from pages import project0 as p0
from pages import project1 as p1
from pages import project2 as p2

st.title('Fashion_data')

class MultiPage:
    def __init__(self):
        self.pages=[]
        
    def add_page(self,title,func):
        self.pages.append({
            "title":title,
            "function":func
            })
    def run(self):
        page=st.sidebar.selectbox(
            'App Navigation',
            self.pages,
            format_func = lambda page:page['title']
            )
        
        page['function']()

app=MultiPage()

app.add_page('Intro', p0.contents)
app.add_page('Product selection', p1.contents)
app.add_page('Product recommendation', p2.contents)
app.run()