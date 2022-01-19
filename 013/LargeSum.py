import os
import math

path = os.path.join(os.path.dirname(os.path.abspath(__file__)), 'LargeSum.txt')

try:
    with open(path, 'r') as file:
        number = file.read().split('\n')
except FileNotFoundError:
    print("FnF")


sum = 0
for i in number:
    n = int(i)
    sum += n
sum /= math.pow(10, 40)
sum = int(sum)
print(sum)
