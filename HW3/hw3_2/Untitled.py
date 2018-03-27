
# coding: utf-8

# In[5]:





# In[51]:

import sys
import numpy as np
import matplotlib.pyplot as plt
from scipy import optimize

# linear equation
def f_1(x, A, B):
    return A*x + B

# quadratic equation
def f_2(x, A, B, C):
    return A*x*x + B*x + C

# cubic equation
def f_3(x, A, B, C, D):
    return A*x*x*x + B*x*x + C*x + D

# gauss equation
def f_gauss(x, A, B, C, sigma):
    return A*np.exp(-(x-B)**2/(2*sigma**2)) + C

def plot_test():

    #plt.figure()

    # Q2: y0: quickfind y1: quickunion y2: weightedunion
    y0 = []
    y1 = []
    y2 = []
    
    file = open("Output.txt") 
    while 1:
        line = file.readline()
        if not line:
            break
        word = line.split(",")
        y0.append(word[0])
        y1.append(word[1])
        y2.append(word[2])
    file.close()
    x0 = range(1, len(y0)+1, 1)
    x1 =x0
    x2 =x0


    
    # fit scatter diagram
    l1 = plt.plot(x0, y0, color='r', label='Log')
    l2 = plt.plot(x1, y1, color='g', label='Sorted')
    l3 = plt.plot(x2, y2, color='b', label='Random')
    
 
    plt.xlabel('N')
    plt.ylabel('Path Length')
    # show labels
    #plt.legend([l1, l2, l3], loc='upper left')   
    plt.legend(loc='upper left')  

    plt.show()
    return

plot_test()

