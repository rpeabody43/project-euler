import math as m

largest_prime = 1
target_value = 600851475143

def is_prime(num):
    for x in range(2, int(m.sqrt(num))):
        if num%x == 0:
            return False
    return True

print("here we go")
for x in range(2, target_value):
    if (target_value % x == 0) and is_prime(x):
        largest_prime = x
        print(largest_prime)