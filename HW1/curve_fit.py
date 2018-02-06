
# coding: utf-8

# In[51]:


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

    plt.figure()

    # fit points
    '''
    # Q1: 3-sum: y0: naive 3-sum, y1: binary 3-sum
    x0 = [8,32,128,512,1024,4096,4192,8192]
    y0 = [0,2,21,74,425,24180,25338,193000]
    y1 = [0,0,11,52,54,271,285,1243]
    '''
    # Q2: y0: quickfind y1: quickunion y2: weightedunion
    x0 = [8,32,128,512,1024,4096,8192]
    y0 = [2,5,10,13,11,26,43]
    y1 = [1,2,1,1,2,4,11]
    y2 = [1,1,1,1,1,2,6]

    # fit scatter diagram
    plt.scatter(x0[:], y0[:], 25, "red")
    plt.scatter(x0[:], y1[:], 25, "green")
    plt.scatter(x0[:], y2[:], 25, "blue")
    '''
    # fit and plot linear curve
    A1, B1 = optimize.curve_fit(f_1, x0, y0)[0]
    x1 = np.arange(min(x0), max(x0), 0.01)
    y1 = A1*x1 + B1
    plt.plot(x1, y1, "blue")
    '''
    
    # fit and plot quadratic curve
    A2, B2, C2 = optimize.curve_fit(f_2, x0, y0)[0]
    x2 = np.arange(min(x0), max(x0), 0.01)
    y0 = A2*x2*x2 + B2*x2 + C2
    line1 = plt.plot(x2, y0, "red")
    
    # fit and plot quadratic curve
    A3, B3, C3 = optimize.curve_fit(f_2, x0, y1)[0]
    x3 = np.arange(min(x0), max(x0), 0.01)
    y1 = A3*x3*x3 + B3*x3 + C3
    line2 = plt.plot(x3, y1, "green")
    
    # fit and plot quadratic curve
    A4, B4, C4 = optimize.curve_fit(f_2, x0, y2)[0]
    x4 = np.arange(min(x0), max(x0), 0.01)
    y2 = A4*x4*x4 + B4*x4 + C4
    line3 = plt.plot(x4, y2, "blue")
    '''
    # fit and plot cubic curve
    A3, B3, C3, D3= optimize.curve_fit(f_3, x0, y0)[0]
    x3 = np.arange(min(x0), max(x0), 0.01)
    y3 = A3*x3*x3*x3 + B3*x3*x3 + C3*x3 + D3
    line1 = plt.plot(x3, y3, "red")
    '''
    # set labels
    label = ["QuickFind", "QuickUnion", "WeightedUnion"]
    plt.title("Question2")
    plt.xlabel('input_data')
    plt.ylabel('time / ms')
    # show labels
    plt.legend(label, loc = 0, ncol = 1) 
    plt.show()
    return

plot_test()

