import logging

def Fibonacci(n):
    # write code here
    a = 0
    b = 1
    if n == 0:
        return 0
    elif n == 1 or n == 2:
        return 1
    else:
        count = 1
        while count != n:
            a, b = b, a + b
            count += 1
        return b
# print(Fibonacci(1))

def jumpFloor(number):
    if number==1 or number==2:
        return number
    else:
        return jumpFloor(number-1)+jumpFloor(number-2)

def test(n):
    if n==1:
        return 1
    else:
        return n*test(n-1)
# print(test(3))

def test2(num):
    count=0
    while num:
        count+=1
        num=(num-1)&num
    return count

# print(test2(-12))



def test3():
    num=999999
    n=0
    for i in range(0,num+1):
        if '3' not in str(i):
            n+=1
    return n

def test4():
    a,b = 1,1
    while True:
        yield a
        a,b = b,a+b

# a=test4()
# for i in range(10):
#     print(a.__next__(),end=" ")

def test5(num):
    if num==1:
        return 0
    elif num==2:
        return 1
    else:
        return test5(num-1)+test5(num-2)

def test6(arr):
    if arr is None:
        return None
    min = arr[0]
    k=0
    for i in range(1,len(arr)):
        if min>arr[i]:
            min,arr[i]=min,arr[i]
            k=i
    arr[k] = arr[len(arr)-1]
    new_arr=[]
    for j in range(len(arr)-1):
        new_arr.append(arr[j])
    return new_arr

# print(test6([2,4,3,5]))

def test7(arr):
    if arr is None:
        return None
    l = len(arr)/2
    l_arr = len(arr) - 1
    for i in range(int(l)):
        arr[i],arr[l_arr]=arr[l_arr],arr[i]
        l_arr-=1
    return arr

# print(test7([1,2,3,4,5,9]))

def test8(arr,num):
    if len(arr):
        logging.info("arr is not allow None")
    new_arr=[]
    temp1=arr[:num]
    temp2=arr[num:]
    new_arr.extend(temp2)
    for i in temp1:
        new_arr.append(i)
    return ''.join(new_arr)

def test9(arr,num):
    if num>=len(arr):
        return arr
    reverse(arr,0,num-1)
    reverse(arr,num,len(arr)-1)
    reverse(arr,0,len(arr)-1)
    return arr
def reverse(char,i,j):
    while i<j:
        swap(char,i,j)
        i+=1
        j-=1
def swap(char,i,j):
    temp=char[i]
    char[i]=char[j]
    char[j]=temp

# print(test9("abcdefg",3))
class TreeLinkNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
        self.next = None
class Solution:
    def GetNext(self, pNode):
        if pNode is None:
            return
        pNext = None
        if pNode.right:
            pNode=pNode.right
            while pNode.left:
                pNode=pNode.left
            pNext=pNode
        else:
            if pNode.next and pNode.next.left==pNode:
                pNext=pNode.next
            elif pNode.next and pNode.next.right==pNode:
                pNode=pNode.next
                while pNode.next and pNode.next.right ==pNode:
                    pNode=pNode.next
                if pNode.next:
                    pNext=pNode.next
        return pNext

def test10(arr1,arr2):
    if len(arr1)==0 or len(arr2)==0:
        print("交集为空")
    new_arr=[]
    if len(arr1)>=len(arr2):
        for i in range(len(arr1)):
            for j in range(len(arr2)):
                if arr1[i]==arr2[j]:
                    new_arr.append(arr2[j])
    else:
        for i in range(len(arr2)):
            for j in range(len(arr1)):
                if arr2[i]==arr1[j]:
                    new_arr.append(arr1[j])
    return list(set(new_arr))


# print(test10([1,2,3,4,5],[1,1,2,3,6,7,5]))
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
class Solution1:
    def __init__(self):
        self.flag = -1

    def Serialize(self, root):
        # write code here
        if not root:
            return '#,'
        return str(root.val) + ',' + self.Serialize(root.left) + self.Serialize(root.right)

    def Deserialize(self, s):
        # write code here
        self.flag += 1
        l = s.split(',')

        if self.flag >= len(s):
            return None
        root = None

        if l[self.flag] != '#':
            root = TreeNode(int(l[self.flag]))
            root.left = self.Serialize(s)
            root.right = self.Serialize(s)
        return root