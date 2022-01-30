# 백준 5430번 AC (골드5)
import sys
from collections import deque

T = int(input())
for _ in range(T):
    p = sys.stdin.readline().rstrip()
    n = int(input())
    if n == 0:
        x = []
    else:
        x = deque(sys.stdin.readline().rstrip()[1: -1].split(","))
    is_error = False
    is_odd = 0

    for func in p:
        if func == 'R':
            is_odd += 1
        elif func == 'D':
            if len(x) == 0:
                is_error = True
                print('error')
                break
            else:
                if is_odd % 2:
                    x.pop()
                else:
                    x.popleft()

    if is_error == False:
        if is_odd % 2:
            x.reverse()
        print("[" + ",".join(x) + "]")