import numpy as np
import time


if __name__ == "__main__":

    total = 100
    a = np.arange(total)
    start_time = time.time()
    for _ in range(total): a *=2
    print( time.time() - start_time)

    b = range(total)
    c = []
    start_time = time.time()
    for x in range(100):
        c = []
        for i in b:
            c.append(i*2)
    print(time.time() - start_time)