import os
from os.path import dirname, realpath, join
import shutil
import re

path = dirname(realpath(__file__))
files = os.listdir(path)

for d in files:
    if re.search("RRP_Euler", d) != None:
        name = d.split('.')[0]
        num = name[9:]
        # os.mkdir(join(path, num))
        shutil.copytree(join(path, d), join(path, num, d))
        print("made " + join(path, num) + " from " + name)
        shutil.rmtree(join(path, d))
