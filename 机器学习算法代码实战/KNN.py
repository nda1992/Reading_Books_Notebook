import numpy as np
import operator
#创建数据集数据
def createDatasSet():
    group = np.array([[1,101],[5,89],[108,5],[115,8]])
    labels = ['爱情片','爱情片','动作片','动作片']
    return group,labels





#k-邻近算法实现
'''
1.计算已知类别数据集中的点与当前点之间的距离
2.按照距离递增次序排序
3.选取与当前点距离最小的k个点
4.确定前k个点所在类别的出现频率
5.返回前k个点所出现频率最高的类别作为当前点的预测分类
'''
def KNN(inX,dataSet,labels,k):
    '''
    :param inX:用于分类的数据(测试集)
    :param dataSet:用于分类的数据(测试集)
    :param labels:用于分类的数据(测试集)
    :param k:用于分类的数据(测试集)
    :return:用于分类的数据(测试集)
    '''

    #返回dataSet的行数
    datasetSize = dataSet.shape[0]

    # 在列向量方向上重复inX共1次(横向)，行向量方向上重复inX共dataSetSize次(纵向)
    difMat = np.tile(inX,(datasetSize,1))-dataSet

    # 二维特征相减后平方
    sqDiffMat = difMat**2

    #sum()所有元素相加
    sqDistance = sqDiffMat.sum(axis=1)

    #开放，求距离
    distances = sqDistance**0.5

    # 返回distances中元素从小到大排序后的索引值
    sortedDistance = distances.argsort()
    classCount={}
    for i in range(k):
        # 取出前k个元素的类别
        votelabel = labels[sortedDistance[i]]
        # 计算类别次数
        classCount[votelabel] = classCount.get(votelabel,0)+1
    # key=operator.itemgetter(1)根据字典的值进行排序
    # key=operator.itemgetter(0)根据字典的键进行排序
    # reverse降序排序字典
    sortedClassCount = sorted(classCount.items(),key=operator.itemgetter(1),reverse=True)
    return sortedClassCount[0][0]

if __name__ == '__main__':
    group,labels = createDatasSet()
    test=[101,20]
    test_class=KNN(test,group,labels,3)
    print(test_class)
