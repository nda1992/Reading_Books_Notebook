# coding=utf-8
# ~/anaconda3/bin/python3.6
'''
Author:NDA
E-mail:nongdingan@126.com
github:https://github.com/nda1992/Reading_Books_Notebook
'''

###使用sklearn实现决策树
from sklearn import tree
from sklearn.model_selection import train_test_split
from sklearn import datasets

dataSet = datasets.load_iris()      #鸢尾花数据集
data_x=dataSet.data
data_y=dataSet.target
x_train,x_test,y_train,y_test=train_test_split(data_x,data_y,test_size=0.3)

clf = tree.DecisionTreeClassifier(criterion="entropy")
slf = clf.fit(x_train,y_test)
score = clf.score(x_test,y_test)
print(score)