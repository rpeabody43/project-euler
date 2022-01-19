import os
from os.path import dirname, realpath, join, isdir
import shutil
import re

path = dirname(realpath(__file__))
dirs = os.listdir(path)

for dir in dirs:
    if not isdir(join(path, dir)): continue
    if re.search('^[0-9][0-9]$', dir) != None:
        print(str(dir))
        os.rename(join(path, dir), join(path, '0' + dir))
