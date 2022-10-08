import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
import tensorflow as tf

with open('text.txt', 'r',encoding='utf-8') as f1:
    lines = f1.readlines()

    new_llnes = []

    for line in lines:
        if (len(line.strip())):
            new_llnes.append(line)
            print(new_llnes)
    for i in range(len(new_llnes)):
        print(new_llnes[i])
        new_llnes[i] = new_llnes[i][0:len(new_llnes[i])-2]
        print(new_llnes)

    with open('text1.txt', 'w',encoding='utf-8') as f2:
        f2.writelines(new_llnes)