
# coding: utf-8

# In[1]:


import sklearn
import csv
import sys
import numpy
import matplotlib.pyplot as plt
import random
import pandas as pd
from pandas.tools.plotting import radviz
import warnings # current version of seaborn generates a bunch of warnings that we'll ignore
warnings.filterwarnings("ignore")
import seaborn as sns


# In[102]:


csv_reader = csv.reader(open('wine.data'))
X = []
y = []
for row in csv_reader:
    #print(row)
    X.append([float(row[1]),float(row[2]), float(row[3]),float(row[4]),float(row[5]),float(row[6]), float(row[7]),float(row[8]),float(row[9]),float(row[10]),float(row[11]),float(row[12]),float(row[13])])
    #X.append([float(row[2]), float(row[3])])
    y.append(row[0])
#print(X)
#print(y)


# In[103]:


from sklearn.cluster import SpectralClustering
y_pred = SpectralClustering(n_clusters = 3, affinity = 'poly',degree=2,gamma=0.0000955).fit_predict(X)
from sklearn import metrics
print "Adjusted Rand index", metrics.adjusted_rand_score(y, y_pred)
print "Mutual Information based scores", metrics.adjusted_mutual_info_score(y, y_pred)
print "V-measure", metrics.v_measure_score(y, y_pred)
print "Calinski-Harabasz Score", metrics.calinski_harabaz_score(X, y_pred)

result = y_pred
print(y_pred)


# In[96]:


colors = []
colors.append('red')
colors.append('green')
colors.append('blue')
colors.append((random.randint(0, 255) / 255.0,
            random.randint(0, 255) / 255.0,
            random.randint(0, 255) / 255.0))


# In[83]:


i=0
for vertex in X:
    plt.plot(vertex[0],vertex[1],'o',color=colors[y_pred[i]])
    i+=1
plt.show()


# In[13]:


data=pd.DataFrame(X)
data.columns=['Alcohol','Malic acid','Ash','Alcalinity of ash','Magnesium','Total phenols','Flavanoids',
              'Nonflavanoid phenols','Proanthocyanins','Color intensity','Hue','OD280/OD315 of diluted wines','Proline']
data.insert(13,'class',y_pred)


#print(data)
radviz(data, 'class',color=['red','green','blue'])


# In[14]:


from sklearn.cluster import SpectralClustering
y_pred = SpectralClustering(n_clusters = 3, affinity = 'nearest_neighbors').fit_predict(X)
from sklearn import metrics
print "Adjusted Rand index", metrics.adjusted_rand_score(y, y_pred)
print "Mutual Information based scores", metrics.adjusted_mutual_info_score(y, y_pred)
print "V-measure", metrics.v_measure_score(y, y_pred)
print "Calinski-Harabasz Score", metrics.calinski_harabaz_score(X, y_pred)

result = y_pred
print(y_pred)

data=pd.DataFrame(X)
data.columns=['Alcohol','Malic acid','Ash','Alcalinity of ash','Magnesium','Total phenols','Flavanoids',
              'Nonflavanoid phenols','Proanthocyanins','Color intensity','Hue','OD280/OD315 of diluted wines','Proline']
data.insert(13,'class',y_pred)


#print(data)
radviz(data, 'class',color=['red','green','blue'])

