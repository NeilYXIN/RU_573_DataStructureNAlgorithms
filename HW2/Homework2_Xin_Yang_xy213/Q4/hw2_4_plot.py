
# coding: utf-8

# In[40]:


import numpy as np
import matplotlib.pyplot as plt
from scipy import optimize
import math
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
    
    # Q1: 3-sum: y0: naive 3-sum, y1: binary 3-sum
    x0 = [1024,2048,4096,8192,16384,32768]
   
    y0 = [5120,11264,24576,53248,114688,245760]
    y1 = [8954,19934,43944,96074,208695,450132]
   
    
    
    # fit scatter diagram
    plt.scatter(x0[:], y0[:], 25, "red")
    plt.scatter(x0[:], y1[:], 25, "green")
    #plt.scatter(x0[:], y2[:], 25, "blue")
    '''
    # fit and plot linear curve
    xlog = []
    ylog = []
    for n in xn:
        xlog.append(math.log(n))
    for j in yn0:
        ylog.append(math.log(j))
    A1, B1 = optimize.curve_fit(f_1, xlog, ylog)[0]
    x1 = np.arange(min(xlog), max(xlog), 0.01)
    y1 = A1*x1 + B1
    plt.plot(x1, y1, "blue")
    print(A1)
    
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
    
    '''
    # fit and plot quadratic curve
    A4, B4, C4 = optimize.curve_fit(f_2, x0, y2)[0]
    x4 = np.arange(min(x0), max(x0), 0.01)
    y2 = A4*x4*x4 + B4*x4 + C4
    line3 = plt.plot(x4, y2, "blue")
    
    # fit and plot cubic curve
    A3, B3, C3, D3= optimize.curve_fit(f_3, x0, y0)[0]
    x3 = np.arange(min(x0), max(x0), 0.01)
    y3 = A3*x3*x3*x3 + B3*x3*x3 + C3*x3 + D3
    line1 = plt.plot(x3, y3, "red")
    '''
    # set labels
    label = ["Ordered", "Unordered"]
    plt.title("Question4")
    plt.xlabel('input_data')
    plt.ylabel('Comparison')
    # show labels
    plt.legend(label, loc = 0, ncol = 1) 
    plt.show()
    return

plot_test()

