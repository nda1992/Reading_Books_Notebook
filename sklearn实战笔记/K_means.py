# coding=utf-8
# ~/anaconda3/bin/python3.6
'''
Author:NDA
E-mail:nongdingan@126.com
github:https://github.com/nda1992/Reading_Books_Notebook
'''
###K_means聚类算法
import numpy as np
import matplotlib.pyplot as plt
from sklearn.cluster import KMeans

filepath="/root/桌面/data.txt"


n_clusters=5
def getData(filepath):
    with open(filepath,'r',encoding='utf8') as f:
        lines = f.readlines()
    X=[]
    for line in lines:
        X.append([float(line.strip('\n').split(',')[1]),float(line.strip('\n').split(",")[2])])
    X=np.array(X)
    return X

def cluster(dataset):
    cls=KMeans(n_clusters).fit(dataset)
    return cls.labels_

def pyplot_():
    markers = ['^','x','o','*','+']
    for i in range(n_clusters):
        dataset = getData(filepath)
        members = cluster(dataset)==i
        plt.scatter(dataset[members,0],dataset[members,1],s=60,marker=markers[i],c='b',alpha=0.5)
    plt.title('')
    plt.show()

if __name__=="__main__":
    pyplot_()