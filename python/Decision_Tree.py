# coding=utf-8
# ~/anaconda3/bin/python3.6
'''
Author:NDA
E-mail:nongdingan@126.com
github:https://github.com/nda1992/Reading_Books_Notebook
'''
from math import log

#####决策树的构建#####
'''
概括为3个步骤：特征选择、决策树的生成和决策树的修剪。

-  特征选择在于选取对训练数据具有分类能力的特征
'''

'''
以信贷数据作为数据集

其中：
年龄：0代表青年，1代表中年，2代表老年；
有工作：0代表否，1代表是；
有自己的房子：0代表否，1代表是；
信贷情况：0代表一般，1代表好，2代表非常好；
类别(是否给贷款)：no代表否，yes代表是。
'''

def CreateDataSet():
    dataSet=[[0, 0, 0, 0, 'no'],         #数据集
            [0, 0, 0, 1, 'no'],
            [0, 1, 0, 1, 'yes'],
            [0, 1, 1, 0, 'yes'],
            [0, 0, 0, 0, 'no'],
            [1, 0, 0, 0, 'no'],
            [1, 0, 0, 1, 'no'],
            [1, 1, 1, 1, 'yes'],
            [1, 0, 1, 2, 'yes'],
            [1, 0, 1, 2, 'yes'],
            [2, 0, 1, 2, 'yes'],
            [2, 0, 1, 1, 'yes'],
            [2, 1, 0, 1, 'yes'],
            [2, 1, 0, 2, 'yes'],
            [2, 0, 0, 0, 'no']]

    labels = ['年龄', '有工作', '有自己的房子', '信贷情况']		#分类属性

    return dataSet,labels

#计算数据集中的经验熵
def CalcShannonEnt(dataSet):
    numEntires = len(dataSet)   #数据集的行数
    labelCounts={}              #保存每个标签(Label)出现次数的字典
    for featVec in dataSet:
        currentLabel = featVec[-1]
        #计算出yes和no的数量分别为多少
        if currentLabel not in labelCounts.keys():  #如果标签(Label)没有放入统计次数的字典,添加进去
            labelCounts[currentLabel]=0
        labelCounts[currentLabel]+=1    #label计数器
    shannonEnt = 0.0            #经验熵
    for key in labelCounts:     #计算经验熵
        prob = float(labelCounts[key])/numEntires   #选择该标签(Label)的概率
        shannonEnt-=prob*log(prob,2)
    return shannonEnt

if __name__=="__main__":
    dataSet,features = CreateDataSet()
    print(dataSet)
    print(CalcShannonEnt(dataSet))















