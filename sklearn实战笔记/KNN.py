

'''
使用sklearn实现KNN算法
'''
from sklearn import datasets
from sklearn.model_selection import train_test_split
from sklearn.neighbors import KNeighborsClassifier
from sklearn import metrics
import numpy as np

dataSet = datasets.load_iris()      #鸢尾花数据集
data_x=dataSet.data
data_y=dataSet.target

x_train,x_test,y_train,y_test=train_test_split(data_x,data_y,test_size=0.3)
knn = KNeighborsClassifier(n_neighbors=3)   #定义KNN分类器
knn.fit(x_train,y_train)         #调用KNN分类对象
y_pre = knn.predict(x_test)     #调用训练方法
print(metrics.accuracy_score(y_pre,y_test))