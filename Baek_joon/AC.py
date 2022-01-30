# 백준 5430번 AC (골드5)
import sys

T = int(input())
for _ in range(T):
    p = list(sys.stdin.readline().rstrip())
    n = int(input())
    if n == 0:
        x = []
        if 'D' in p:
            print('error')
        else:
            print("[]")
    else:
        x = list(sys.stdin.readline().rstrip()[1: -1].split(","))
        left, right, is_odd = 0, 0, False

        for func in p:
            if func == 'R':
                is_odd = not is_odd
            elif func == 'D':
                if is_odd:
                    right +=1
                else:
                    left +=1

        if right + left > n:
            print('error')
        else:
            r = x[left: n - right]
            if is_odd:
                r.reverse()
            print('[' + ','.join(r) + ']')